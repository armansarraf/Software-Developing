package View;

import java.awt.Container;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.Map;

import javax.swing.*;

import Controller.CentralController;
import Controller.DBController;
import Model.Admin;
import Model.Coupon;
import Model.FinancialInsAdmin;
import Model.RegisteredUser;
import Model.ReservationModel;

public class LoginView extends JFrame{
   	
	private JButton login = new JButton("Login");
   
	private JTextField username = new JTextField(20);
    
	private JTextField password = new JTextField(20);

    public LoginView() {

 
   	Container content_pane = getContentPane();
        
        content_pane.setLayout(new GridLayout(20, 33));
        
        content_pane.setSize(200, 200);
        
        JPanel Panel_2 = new JPanel();
    
        JLabel passwordPrompt = new JLabel("Password:");
        
        Panel_2.add(passwordPrompt);
        
        Panel_2.add(password);
        
        Panel_2.add(login);
        
        Panel_2.add(username);
                        
        JLabel spacePrompt_2 = new JLabel("");
        
        Panel_2.add(spacePrompt_2);
        
        content_pane.add(Panel_2);
        
        setVisible(true);
        
    }

	public JButton getLogin() {
		return login;
	}

	public void setLogin(JButton login) {
		this.login = login;
	}

	public JTextField getUsername() {
		return username;
	}

	public void setUsername(JTextField username) {
		this.username = username;
	}

	public JTextField getPassword() {
		return password;
	}

	public void setPassword(JTextField password) {
		this.password = password;
	}

}