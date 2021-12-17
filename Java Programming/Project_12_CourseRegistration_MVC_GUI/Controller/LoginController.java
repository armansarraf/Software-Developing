package Controller;

import Model.Model;
import View.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    View theView;
    Model theModel;

    public LoginController(View theView, Model theModel) {
        this.theModel = theModel;
        this.theView = theView;
        theView.addActionListener(new myListener());
    }

    class myListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub

            try {
                if (e.getSource() == theView.getEnter()) theModel.login(theView.getEnteredName().getText());
                if (e.getSource() == theView.getReset()) theView.setEnterName();
            } catch (NumberFormatException ex) {
                System.out.println(ex.fillInStackTrace());
            }

        }
    }
}
