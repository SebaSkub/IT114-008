package Milestone3.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Logger;

import Milestone3.client.Client;
import Milestone3.common.Constants;

import java.util.*;

public enum Server {
    INSTANCE;

    int port = 3000;
    protected static List<ServerThread> clients = new ArrayList<ServerThread>();

    public static List<String> mutedClients = new ArrayList<String>();

    private static Logger logger = Logger.getLogger(Server.class.getName());
    private static List<Room> rooms = new ArrayList<Room>();
    private Room lobby = null;// default room
    private long nextClientId = 1;

    private Queue<ServerThread> incomingClients = new LinkedList<ServerThread>();
    // https://www.geeksforgeeks.org/killing-threads-in-java/
    private volatile boolean isRunning = false;

    private void start(int port) {
        this.port = port;
        // server listening
        try (ServerSocket serverSocket = new ServerSocket(port);) {
            Socket incoming_client = null;
            logger.info(String.format("Server is listening on port %s", port));
            isRunning = true;
            // Room.server = this;//since server is a singleton now we don't need this
            startQueueManager();
            // create a lobby on start
            lobby = new Room(Constants.LOBBY);
            rooms.add(lobby);
            do {
                logger.info("Waiting for next message");
                if (incoming_client != null) {
                    logger.info("Client connected");
                    ServerThread sClient = new ServerThread(incoming_client, lobby);
                    sClient.start();
                    incomingClients.add(sClient);
                    incoming_client = null;

                }
            } while ((incoming_client = serverSocket.accept()) != null);
        } catch (IOException e) {
            logger.severe("Error accepting connection");
            e.printStackTrace();
        } finally {
            logger.info("Closing Server Socket");
        }
    }
    

    void startQueueManager() {
        // Queue manager thread to wait for the ServerThread thread to start
        // before officially handing them off to a room and opening them for
        // communication
        new Thread() {
            @Override
            public void run() {
                while (isRunning) {
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (incomingClients.size() > 0) {
                        ServerThread ic = incomingClients.peek();
                        if (ic != null) {
                            // wait for the thread to start and for the message to send the message name
                            // (username)
                            if (ic.isRunning() && ic.getClientName() != null) {
                                handleIncomingClient(ic);
                                incomingClients.poll();
                            }
                        }
                    }
                }
            }
        }.start();
    }

    void handleIncomingClient(ServerThread message) {
        message.setClientId(nextClientId);// server reference
        message.sendClientId(nextClientId);// message reference
        nextClientId++;
        if (nextClientId < 0) {// will use overflow to reset our counter
            nextClientId = 1;
        }
        joinRoom(Constants.LOBBY, message);
    }

    /***
     * Helper function to check if room exists by case insensitive name
     * 
     * @param roomName The name of the room to look for
     * @return matched Room or null if not found
     */
    private Room getRoom(String roomName) {
        for (int i = 0, l = rooms.size(); i < l; i++) {
            if (rooms.get(i).getName().equalsIgnoreCase(roomName)) {
                return rooms.get(i);
            }
        }
        return null;
    }
   
    /***
     * Attempts to join a room by name. Will remove message from old room and add
     * them to the new room.
     * 
     * @param roomName The desired room to join
     * @param message   The message moving rooms
     * @return true if reassign worked; false if new room doesn't exist
     */
    protected synchronized boolean joinRoom(String roomName, ServerThread message) {
        Room newRoom = roomName.equalsIgnoreCase(Constants.LOBBY) ? lobby : getRoom(roomName);
        Room oldRoom = message.getCurrentRoom();
        if (newRoom != null && roomName != null) {
            if (oldRoom != null && oldRoom != newRoom) {
                logger.info(String.format("Client %s leaving old room %s", message.getClientName(), oldRoom.getName()));
               
                } else {
                    oldRoom.removeClient(message);
                
            }
            logger.info(String.format("Client %s joining new room %s", message.getClientName(), newRoom.getName()));
            newRoom.addClient(message);
            return true;
        }
        return false;
    }

    /***
     * Attempts to create a room with given name if it doesn't exist already.
     * 
     * @param roomName The desired room to create
     * @return true if it was created and false if it exists
     */
    protected synchronized boolean createNewRoom(String roomName) {
        if (getRoom(roomName) != null) {
            //  Room exists; can't create room
            logger.info(String.format("Room %s already exists", roomName));
            return false;
        } else {
            // , all non-lobby rooms will be games
            Room room = new Room(roomName); //chatroom project can just use regular rooms
            rooms.add(room);
            logger.info(String.format("Created new room %s", roomName));
            return true;
        }
    }
   
    /**
     * Returns Rooms with names having a partial match with query.
     * Hard coded to a limit of 10.
     * 
     * @param query
     * @return
     */
    protected synchronized List<String> getRooms(String query) {
        return getRooms(query, 10);
    }

    /**
     * Returns Rooms with names having a partial match with query.
     * 
     * @param query
     * @param limit The maximum records to return
     * @return
     */
    protected synchronized List<String> getRooms(String query, int limit) {
        List<String> matchedRooms = new ArrayList<String>();
        synchronized (rooms) {
            Iterator<Room> iter = rooms.iterator();
            while (iter.hasNext()) {
                Room r = iter.next();
                if (r.isRunning() && r.getName().toLowerCase().contains(query.toLowerCase())) {
                    matchedRooms.add(r.getName());
                    if (matchedRooms.size() >= limit) {
                        break;
                    }
                }
            }
        }
        return matchedRooms;
    }

    protected synchronized void removeRoom(Room r) {
        if (rooms.removeIf(room -> room == r)) {
            logger.info(String.format("Removed empty room %s", r.getName()));
        }
    }

    /**
     * Send message to all rooms
     * 
     * @param message
     */
    protected static void broadcast(String message) {
        if (processCommand(message)) {
            return;
        }
        
        // loop over rooms and send out the message
        Iterator<Room> it = rooms.iterator();
        while (it.hasNext()) {
            Room room = it.next();
            if (room != null) {
                room.sendMessage(null, message);
            }
        }
    }

    
    
    public synchronized  void unmuteClient(String clientName, List<ServerThread>mutedClients) {
        ServerThread client = findMutedClientByName(clientName, mutedClients);
        if (client != null) {
            mutedClients.remove(client);
            clients.add(client);
        }
    }
    
    private synchronized  ServerThread getClientName(String clientName, List<String>mutedClients) {
        for (ServerThread client : clients) {
            if (client.getClientName().equals(clientName)) {
                return client;
            }
        }
        return null;
    }
    
    private ServerThread findMutedClientByName(String clientName, List<ServerThread>mutedClients) {
        for (ServerThread client : mutedClients) {
            if (client.getClientName().equals(clientName)) {
                return client;
            }
        }
        return null;
    }




    public synchronized static boolean processCommand(String message) {
        System.out.println("Checking command: " + message);
        String[] parts = message.split(" ");

        if (message.startsWith("/mute ")) {
            String m = message.substring("/mute ".length());
            mutedClients.add(m);
            broadcast(m + " has been muted.");
            return true;
        }
        if (message.startsWith("/unmute ")) {
            String m = message.substring("/unmute ".length());
            mutedClients.remove(m);
            broadcast(m + " has been unmuted.");
            return true;
        }
        if (message.startsWith("/roll")) {
            if (parts.length >= 2 && parts[1].contains("d")) { 
    
                String[] rollPar = parts[1].split("d");
                int nDice = Integer.parseInt(rollPar[0]);
                int nSide = Integer.parseInt(rollPar[1]);
                int result = diceRoll(nDice, nSide);
                String s = String.format("<b>Player rolled %dd%d Result: %d</b>", nDice, nSide, result);
                broadcast(s);
                return true;

            } else if (parts.length == 2) {
                int max = Integer.parseInt(parts[1]);
                if (max > 0) {
                    int result = (int) (Math.random() * max) + 1;
                    String response = "<b>Rolling a " + max + " sided die..." + result + " </b>";
                    broadcast(response);
                    return true;
                }
            }
        } else if (message.startsWith("/flip")) {
            int result = (int) (Math.random() * 2);
            if (result == 0) {
                broadcast("<b>Flipping a coin... heads!</b>");
            } else {
                broadcast("<b>Flipping a coin... tails!</b>");
            }
            return true;
            
      
        }
        return false;
    }
    
    



    public static int diceRoll(int nDice, int nSide) {
        int result = 0;
        for (int i = 0; i < nDice; i++) {
            result += (int) (Math.random() * nSide) + 1;
        }
        return result;
    }
    public static void main(String[] args) {
        Server.logger.info("Starting server");
        int port = Server.INSTANCE.port;
        try {
            port = Integer.parseInt(args[0]);
        } catch (Exception e) {
            // can ignore, will either be index out of bounds or type mismatch
            // will default to the defined value prior to the try/catch
        }
        Server.INSTANCE.start(port);
        Server.logger.info("Server stopped");
    }


    public Milestone3.server.ServerThread getClientByName(String receiver) {
        return null;
    }


    public synchronized List<String> mutedClients() {
        return mutedClients;
    }

}


