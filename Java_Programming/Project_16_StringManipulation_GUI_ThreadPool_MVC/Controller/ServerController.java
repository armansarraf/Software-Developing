package Controller;

import java.io.BufferedReader;
import java.io.PrintWriter;

import Model.ConcatenationModel;

public class ServerController {
    ConcatenationModel theModel;
    BufferedReader socketIn;
    PrintWriter socketOut;

    public ServerController(ConcatenationModel model, BufferedReader socketIn, PrintWriter socketOut) {
        this.theModel = model;
        this.socketIn = socketIn;
        this.socketOut = socketOut;
    }

    public String receiveMsg() {

        String receivedMsg = null;
        try {
            String input; // This will be the object that is read from the socket

            if ((input = socketIn.readLine()) != null) {
                receivedMsg = input;
            }

        } catch (Exception e) { // Could not get input from reading; notify sending player
            System.out.println("Client disconnected.");
        }

        return receivedMsg;
    }

    public void clientCommunicate() {

        String first = "";
        String sec = "";
        String input = "";

        int at;
        int result = 0;
        input = receiveMsg();
        at = input.indexOf(" ");
        for (int i = 0; i < at; i++) {
            first += input.charAt(i);
        }
        for (int i = at + 1; i < input.length(); i++) {
            sec += input.charAt(i);
        }
        theModel.concatenate(first, sec);
        sendMsg(theModel.getMyString());

    }

    public void sendMsg(String msg) {
        socketOut.println(msg);
    }
}