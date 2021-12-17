import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private Socket aSocket;
    private ServerSocket serverSocket;
    private PrintWriter socketOut;
    private BufferedReader socketIn;

    public Server() {

        try {
            serverSocket = new ServerSocket(8099);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void isPalindrome() {
        String line = null;

        while (true) {
            try {
                line = socketIn.readLine();

                int length = line.length();
                String reverse = "";
                for (int i = length - 1; i >= 0; i--){
                    reverse += line.charAt(i);
                }

                if (line.equals(reverse))
                    socketOut.println(line+" is a palindrome.");
                else
                    socketOut.println(line+" is not a palindrome.");

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws IOException {

        Server myServer = new Server();

        //Establish a connection
        try {

            myServer.aSocket = myServer.serverSocket.accept();
            System.out.println("Server is now running...");
            myServer.socketIn = new BufferedReader(new InputStreamReader
                    (myServer.aSocket.getInputStream()));
            myServer.socketOut = new PrintWriter(myServer.aSocket.getOutputStream(), true);

            myServer.isPalindrome();

            myServer.socketIn.close();
            myServer.socketOut.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
