package Milestone3.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;
import java.util.logging.Logger;

import Milestone3.client.Client;
import Milestone3.common.Constants;
import Milestone3.common.GeneralUtils;
import Milestone3.server.Server;

import java.util.Map.Entry;

public class Room implements AutoCloseable {
    // server is a singleton now so we don't need this
    // protected static Server server;// used to refer to accessible server
    // functions
    private String name;
    protected static List<ServerThread> clients = new ArrayList<ServerThread>();
    protected static List<ServerThread> mutedClients = new ArrayList<ServerThread>();

    private boolean isRunning = false;
    // Commands
    private final static String COMMAND_TRIGGER = "/";
    private final static String CREATE_ROOM = "createroom";
    private final static String JOIN_ROOM = "joinroom";
    private final static String DISCONNECT = "disconnect";
    private final static String LOGOUT = "logout";
    private final static String LOGOFF = "logoff";
    private final static String ROLL = "roll";
    private final static String FLIP = "flip";
    private final static String MUTE = "mute";
    private final static String UNMUTE = "unmute";


    private static Logger logger = Logger.getLogger(Room.class.getName());
    private HashMap<String, String> converter = null;


    public Room(String name) {
        this.name = name;
        isRunning = true;
    }

    public String getName() {
        return name;
    }

    public boolean isRunning() {
        return isRunning;
    }

    protected synchronized void addClient(ServerThread client) {
        logger.info("Room addClient called");
        if (!isRunning) {
            return;
        }
        client.setCurrentRoom(this);
        if (clients.indexOf(client) > -1) {
            logger.warning("Attempting to add client that already exists in room");
        } else {
            clients.add(client);
            client.sendResetUserList();
            syncCurrentUsers(client);
            sendConnectionStatus(client, true);
        }
    }

    protected synchronized void removeClient(ServerThread client) {
        if (!isRunning) {
            return;
        }
        // attempt to remove client from room
        try {
            clients.remove(client);
        } catch (Exception e) {
            logger.severe(String.format("Error removing client from room %s", e.getMessage()));
            e.printStackTrace();
        }
        // if there are still clients tell them this person left
        if (clients.size() > 0) {
            sendConnectionStatus(client, false);
        }
        checkClients();
    }

    private void syncCurrentUsers(ServerThread client) {
        Iterator<ServerThread> iter = clients.iterator();
        while (iter.hasNext()) {
            ServerThread existingClient = iter.next();
            if (existingClient.getClientId() == client.getClientId()) {
                continue;// don't sync ourselves
            }
            boolean messageSent = client.sendExistingClient(existingClient.getClientId(),
                    existingClient.getClientName());
            if (!messageSent) {
                handleDisconnect(iter, existingClient);
                break;// since it's only 1 client receiving all the data, break if any 1 send fails
            }
        }
    }

    /***
     * Checks the number of clients.
     * If zero, begins the cleanup process to dispose of the room
     */
    private void checkClients() {
        // Cleanup if room is empty and not lobby
        if (!name.equalsIgnoreCase(Constants.LOBBY) && (clients == null || clients.size() == 0)) {
            close();
        }
    }

    /***
     * Helper function to process messages to trigger different functionality.
     * 
     * @param message The original message being sent
     * @param client  The client of the message (since they'll be the ones
     *                triggering the actions)
     */
    private void unmuteClient(String target) {
        for (ServerThread client : mutedClients) {
            if (client.getClientName().equals(target)) {
                mutedClients.remove(client);
                break;
            }
        }
    }
    private void muteClient(String target) {
        for (ServerThread client : clients) {
            if (client.getClientName().equals(target)) {
                mutedClients.add(client);
                break;
            }
        }
    }
    
    @Deprecated // not used in my project as of this lesson, keeping it here in case things
                // change
    private synchronized boolean processCommands(String message, ServerThread client) {
        boolean wasCommand = false;
        try {
            if (message.startsWith(COMMAND_TRIGGER)) {
                String[] comm = message.split(COMMAND_TRIGGER);
                String part1 = comm[1];
                String[] comm2 = part1.split(" ");
                String command = comm2[0];
                String roomName;
                wasCommand = true;
                switch (command) {
                    
                    case MUTE:
                        Server.processCommand(message);
                         
                        break;
                    case UNMUTE:
                         Server.processCommand(message);
                            break;

                    case ROLL:
                    
                    Server.processCommand(message);

                    break;
            
                    case FLIP:
                        Server.processCommand(message);
                        break;
                    case CREATE_ROOM:
                        roomName = comm2[1];
                        Room.createRoom(roomName, client);
                        break;
                    case JOIN_ROOM:
                        roomName = comm2[1];
                        Room.joinRoom(roomName, client);
                        break;
                    case DISCONNECT:
                    case LOGOUT:
                    case LOGOFF:
                        Room.disconnectClient(client, this);
                        break;
                    default:
                        wasCommand = false;
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wasCommand;
    }
    

    // Command helper methods
    protected static void getRooms(String query, ServerThread client) {
        String[] rooms = Server.INSTANCE.getRooms(query).toArray(new String[0]);
        client.sendRoomsList(rooms,
                (rooms != null && rooms.length == 0) ? "No rooms found containing your query string" : null);
    }

    protected static void createRoom(String roomName, ServerThread client) {
        if (Server.INSTANCE.createNewRoom(roomName)) {
            Room.joinRoom(roomName, client);
        } else {
            client.sendMessage(Constants.DEFAULT_CLIENT_ID, String.format("Room %s already exists", roomName));
        }
    }

    /**
     * Will cause the client to leave the current room and be moved to the new room
     * if applicable
     * 
     * @param roomName
     * @param client
     */
    protected static void joinRoom(String roomName, ServerThread client) {
        if (!Server.INSTANCE.joinRoom(roomName, client)) {
            client.sendMessage(Constants.DEFAULT_CLIENT_ID, String.format("Room %s doesn't exist", roomName));
        }
    }

    protected static void disconnectClient(ServerThread client, Room room) {
        client.disconnect();
        room.removeClient(client);
    }
    // end command helper methods

    /***
     * Takes a client and a message and broadcasts the message to all clients in
     * this room. Client is mostly passed for command purposes but we can also use
     * it to extract other client info.
     * 
     * @param client  The client sending the message
     * @param message The message to broadcast inside the room
     */
    
     protected synchronized void sendMessage(ServerThread sender, String message) {
        if (!isRunning) {
            return;
        }
        logger.info("Sending message to " + clients.size() + " clients");
        if (sender != null && processCommands(message, sender)) {
            // it was a command, don't broadcast
            return;
        }
        message = formatMessage(message);
        long from = (sender == null) ? Constants.DEFAULT_CLIENT_ID : sender.getClientId();
        
        // Check if the message is a private message
        if (message.startsWith("@")) {
            int spaceIndex = message.indexOf(" ");
            if (spaceIndex != -1) {
                String clientName = message.substring(1, spaceIndex);
                String privateMessage = message.substring(spaceIndex + 1);
                for (ServerThread client : clients) {
                    if (client.getClientName().equals(clientName)) {
                        boolean messageSent = client.sendMessage(from, "(Private message): " + privateMessage);
                        if (messageSent) {
                            handleDisconnect(null, client);
                        }
                        // Only send to the client, so break the loop
                        break;
                    }
                }
            }
        } else {
            // Broadcast the message to all clients except muted ones
            for (ServerThread client : clients) {
                if (!mutedClients.contains(client)) {
                    client.sendMessage(from, message);
                }
            }
        }
    }

    protected String formatMessage(String message) {
		String alteredMessage = message;
		
		// expect pairs ** -- __
		if(converter == null){
			converter = new HashMap<String, String>();
			// user symbol => output text separated by |
			converter.put("\\*{2}", "<b>|</b>");
			converter.put("~~", "<i>|</i>");
			converter.put("__", "<u>|</u>");
			converter.put("#r#", "<font color=\"red\">|</font>");
			converter.put("#g#", "<font color=\"green\">|</font>");
			converter.put("#b#", "<font color=\"blue\">|</font>");

		}
		for (Entry<String, String> kvp : converter.entrySet()) {
			if (GeneralUtils.countOccurencesInString(alteredMessage, kvp.getKey().toLowerCase()) >= 2) {
				String[] s1 = alteredMessage.split(kvp.getKey().toLowerCase());
				String m = "";
				for (int i = 0; i < s1.length; i++) {
					if (i % 2 == 0) {
						m += s1[i];
					} else {
						String[] wrapper = kvp.getValue().split("\\|");
						m += String.format("%s%s%s", wrapper[0], s1[i], wrapper[1]);
					}
				}
				alteredMessage = m;
			}
		}

		return alteredMessage;
	}
        
           

    protected synchronized void sendConnectionStatus(ServerThread client, boolean isConnected) {
        Iterator<ServerThread> iter = clients.iterator();
        while (iter.hasNext()) {
            ServerThread receivingClient = iter.next();
            boolean messageSent = receivingClient.sendConnectionStatus(
                    client.getClientId(),
                    client.getClientName(),
                    isConnected);
            if (!messageSent) {
                handleDisconnect(iter, receivingClient);
            }
        }
    }

    protected void handleDisconnect(Iterator<ServerThread> iter, ServerThread client) {
        if (iter != null) {
            iter.remove();
        } else {
            Iterator<ServerThread> iter2 = clients.iterator();
            while (iter2.hasNext()) {
                ServerThread th = iter2.next();
                if (th.getClientId() == client.getClientId()) {
                    iter2.remove();
                    break;
                }
            }
        }
        logger.info(String.format("Removed client %s", client.getClientName()));
        sendMessage(null, client.getClientName() + " disconnected");
        checkClients();
    }

@Override
    public void close() {
        Server.INSTANCE.removeRoom(this);
        isRunning = false;
        clients.clear();
    }
}