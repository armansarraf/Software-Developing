package Model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private Socket aSocket;
    private ServerSocket serverSocket;
    private ExecutorService pool;
    private static int clientPairCount;

    public Server(int portNumber) throws IOException {

        serverSocket = new ServerSocket(portNumber);
        pool = Executors.newCachedThreadPool();
        clientPairCount = 0;
    }

    public void serverCommunicate() {

        try {

            while (true) {

                aSocket = serverSocket.accept();
                System.out.println("Client number " + clientPairCount + 1 + " connected ...");
                SendReq request = new SendReq(aSocket); /// Runnable
                pool.execute(request); // Pool Execution
                clientPairCount++;
            }

        } catch (Exception e) {
            System.err.println("Server error: Client connection lost.");
            // TODO: handle exception
        }
        pool.shutdown();

    }

    public static void main(String[] args) throws IOException {
        System.out.println("Server Side begin...");
        Server s = new Server(9119);
        s.serverCommunicate();
    }

}
