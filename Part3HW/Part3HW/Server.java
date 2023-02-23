package Part3HW.Part3HW;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Server {
    int port = 3001;
    // connected clients
    private List<ServerThread> clients = new ArrayList<ServerThread>();

    private void start(int port) {
        this.port = port;
        // server listening
        try (ServerSocket serverSocket = new ServerSocket(port);) {
            Socket incoming_client = null;
            System.out.println("Server is listening on port " + port);
            do {
                System.out.println("waiting for next client");
                if (incoming_client != null) {
                    System.out.println("Client connected");
                    ServerThread sClient = new ServerThread(incoming_client, this);
                    
                    clients.add(sClient);
                    sClient.start();
                    incoming_client = null;
                    
                }
            } while ((incoming_client = serverSocket.accept()) != null);
        } catch (IOException e) {
            System.err.println("Error accepting connection");
            e.printStackTrace();
        } finally {
            System.out.println("closing server socket");
        }
    }
    protected synchronized void disconnect(ServerThread client) {
		long id = client.getId();
        client.disconnect();
		broadcast("Disconnected", id);
	}
    
    protected synchronized void broadcast(String message, long id) {
        if(processCommand(message, id)){
            
            return;
        }
        // let's temporarily use the thread id as the client identifier to
        // show in all client's chat. This isn't good practice since it's subject to
        // change as clients connect/disconnect

        message = String.format("User[%d]: %s", id, message);
        // end temp identifier
        
        // loop over clients and send out the message
        Iterator<ServerThread> it = clients.iterator();
        while (it.hasNext()) {
            ServerThread client = it.next();
            boolean wasSuccessful = client.send(message);
            if (!wasSuccessful) {
                System.out.println(String.format("Removing disconnected client[%s] from list", client.getId()));
                it.remove();
                broadcast("Disconnected", id);
            }
        }
    }

    private boolean processCommand(String message, long clientId){
        System.out.println("Checking command: " + message);
        if(message.equalsIgnoreCase("disconnect")){
            Iterator<ServerThread> it = clients.iterator();
            while (it.hasNext()) {
                ServerThread client = it.next();
                if(client.getId() == clientId){
                    it.remove();
                    disconnect(client);
                    
                    break;
                }
            }
            return true;

        } 
// Dice roll command when user inputs roll with certain format which needs to be met inorder to execute, output results
// ss365
// Feb 22, 2023                    
if(message.toLowerCase().startsWith("roll")){
            
    String[] tokens = message.split(" ");

    if(tokens.length != 2 || !tokens[1].toLowerCase().matches("\\d+d\\d+")){
        return false;
    }
    String[]rollPar = tokens[1].split("d");

    int nDice = Integer.parseInt(rollPar[0]);

    int nSide = Integer.parseInt(rollPar[1]);

    int result = diceRoll(nDice, nSide);

    String s = String.format("Player %d rolled %dd%d Result: %d",clientId, nDice, nSide, result);

    broadcast(s, clientId);

System.out.println("diceRoll Result: " + result); // for debug can be removed later
return true;
}
// flip command executes when either flip or coin is inputted outputs results
// ss365
// Feb 22, 2023
   if (message.equalsIgnoreCase("flip") || message.equalsIgnoreCase("coin")) {
            String resultFlip = coinFlip();
            String t = String.format("Player %d flipped a coin and got %s", clientId, resultFlip);
            broadcast(t, clientId);
            return true;
    
    }
    return false;
} 
// diceRoll is called when roll is received
// ss365
// Feb 22, 2023
private int diceRoll(int nDice, int nSide) {

int total = 0;

for (int i = 0; i < nDice; i++) {

total += (int)(Math.random() * nSide) + 1;

}

return total;

}
// coinFlip is called when flip or coin is received
// ss365
// Feb 22, 2023
  private String coinFlip() {
    Random r = new Random();
    int chance = r.nextInt(2);
    if (chance == 1) {
       return"tails";
    } else {
       return"heads";
    }
}

    public static void main(String[] args) {
        System.out.println("Starting Server");
        Server server = new Server();
        int port = 3000;
        try {
            port = Integer.parseInt(args[0]);
        } catch (Exception e) {
            // can ignore, will either be index out of bounds or type mismatch
            // will default to the defined value prior to the try/catch
        }
        server.start(port);
        System.out.println("Server Stopped");
    }
}