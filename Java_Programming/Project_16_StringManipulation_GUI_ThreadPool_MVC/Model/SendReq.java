package Model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import Controller.ServerController;

public class SendReq implements Runnable {

    private Socket socket;
    private BufferedReader socketIn;
    private PrintWriter socketOut;

    public SendReq(Socket aSocket) {
        socket = aSocket;
    }

    @Override
    public void run() {
        try {
            socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            socketOut = new PrintWriter(socket.getOutputStream(), true);
        } catch (Exception e) {
            System.out.println("Problem in server connection ...");
        }
        ConcatenationModel CalcModel = new ConcatenationModel();
        ServerController calcController = new ServerController(CalcModel, socketIn, socketOut);
        calcController.clientCommunicate();
    }
}
