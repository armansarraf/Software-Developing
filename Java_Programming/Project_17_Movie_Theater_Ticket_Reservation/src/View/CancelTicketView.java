package View;


import java.awt.*;

import javax.swing.*;

public class CancelTicketView extends JFrame {
  
	private JTextField reservationID = new JTextField(20);
    
	private JButton cancelTicket = new JButton("CANCEL");
    
	private JTextArea display = new JTextArea("");
    
	private UserView userInfo;

    public CancelTicketView() {
    
    	Container contentPane = getContentPane();
        
    	getContentPane().setLayout(null);

        
    	JPanel firstPanel = new JPanel();
        
    	firstPanel.setBounds(0, 12, 484, 57);
        
    	JLabel titlePrompt = new JLabel("TICKET CANCELLATION");
        
    	titlePrompt.setFont(new Font("Poppins", Font.PLAIN, 31));
        
    	firstPanel.add(titlePrompt);
        
    	contentPane.add(firstPanel);

        
    	JPanel secondPanel = new JPanel();
        
    	secondPanel.setBounds(0, 98, 484, 30);
        
    	JLabel reservationPrompt = new JLabel("RESERVATION ID");
        
    	reservationPrompt.setFont(new Font("Poppins", Font.PLAIN, 12));
        
    	secondPanel.add(reservationPrompt);
        
    	secondPanel.add(reservationID);
        
    	contentPane.add(secondPanel);

        JPanel thirdPanel = new JPanel();
        
        thirdPanel.setBounds(0, 127, 484, 36);
        
        cancelTicket.setFont(new Font("Poppins", Font.PLAIN, 12));
        
        thirdPanel.add(cancelTicket);
        
        contentPane.add(thirdPanel);
        
        JPanel forthPanel = new JPanel();
        
        forthPanel.setBounds(0, 237, 484, 160);
        
        ScrollPane messageSp = new ScrollPane();
        
        forthPanel.add(messageSp);
        
		display.setLineWrap(true);
		
    	display.setLayout(new GridBagLayout());
		
    	display.setBackground(new Color(205,217,245));
        
        messageSp.add(display);
        
        messageSp.setSize(400, 150);
        
        contentPane.add(forthPanel);
        
        JPanel secondPanel_1 = new JPanel();
        
        secondPanel_1.setBounds(0, 204, 484, 30);
        
        getContentPane().add(secondPanel_1);
        
        JLabel messagePrompt = new JLabel("MESSAGE");
        
        secondPanel_1.add(messagePrompt);
        
        messagePrompt.setFont(new Font("Poppins", Font.PLAIN, 12));

        setTitle("CancelTicketView");

        setLocation(750, 250);
        
        setSize(500, 448);
        
        setVisible(true);
    }

    public JTextField getReservationID() {
        return reservationID;
    }

    public JTextArea getDisplay() {
        return display;
    }

    public UserView getUserInformation() {
        return userInfo;
    }

    public void setUserInformation(UserView user) {
        userInfo = user;
    }

    public void setUserMessage(String text) {
        userInfo.setDisplay(text);
    }

    public JButton getTicketCancel() {
        return cancelTicket;
    }

    public void clearDisplay() {
        display.setText("");
    }

    public void setDisplay(String text) {
        display.setText(text);
    }

    public String getUserName() {

        return userInfo.getUserName().getText();
    }

    public String getPassword() {
        return userInfo.getPassword().getText();
    }

    public void clearStatusDisplay() {
        userInfo.setStatus("");
    }

    public void setStatusDisplay(String text) {
        userInfo.setStatus(text);
    }

    public void clearReservationID() {
        reservationID.setText("");
    }

    public void clearUserMessage() {
        userInfo.setDisplay("");
    }


}