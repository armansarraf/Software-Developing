package Controller;

import View.ConcatView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientController {

    ConcatView theView;
    //

    public ClientController(ConcatView theView) {

        this.theView = theView;
        theView.addStringListener(new CalculateListener());
    }

    class CalculateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                String firstNumber, secondNumber, msg, receiveMsg;

                firstNumber = theView.getFirstString();
                secondNumber = theView.getSecString();
                msg = (firstNumber) + " " + (secondNumber);
                Client.sendMsg(msg);
                receiveMsg = Client.getMsg();
                theView.setResult(receiveMsg);

            } catch (NumberFormatException ex) {
                theView.displayErrorMessage("Error! Enter another word!");
            }
        }

    }

}


