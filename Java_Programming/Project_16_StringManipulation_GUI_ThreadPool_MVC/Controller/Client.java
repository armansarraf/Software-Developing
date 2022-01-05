package Controller;

import View.ConcatView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    private static PrintWriter socketOut;
    private Socket cSocket;
    private BufferedReader stdIn;
    private static BufferedReader socketIn;

    public Client(String serverName, int portNumber) throws IOException {

        cSocket = new Socket(serverName, portNumber);
        stdIn = new BufferedReader(new InputStreamReader(System.in));
        socketIn = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
        socketOut = new PrintWriter(cSocket.getOutputStream(), true);

    }

    public void clientCommunication() {

        ConcatView calcView = new ConcatView();
        ClientController calcController = new ClientController(calcView);
        calcView.setVisible(true);
    }

    public static void sendMsg(String input1) {
        socketOut.println(input1);

    }

    public static String getMsg() {
        String input = "";

        try {
            input = socketIn.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    public static void main(String[] args) throws UnknownHostException, IOException {

        System.out.println("Client Side Begin...");
        Client c = new Client("localhost", 9119);
        c.clientCommunication();

    }
}