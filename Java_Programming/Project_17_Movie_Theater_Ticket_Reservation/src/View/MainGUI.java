package View;

import java.awt.*;
import javax.swing.*;

public class MainGUI extends JFrame {
   
	

    private JLabel title = new JLabel ("MOVIE THEATER TICKET RESERVATION");
    
    private JButton reservation = new JButton("Reserve Ticket");
    
    private JButton cancellation = new JButton("Cancel Ticket");
    
    private JLabel backgroundIMG = new JLabel();
    
    private CancelTicketView cancellationView;
    
	private ReservationView reservationView;
    
    
    

    public MainGUI() {
	
    	setTitle("Movie Theater Ticket Reservation App");
		
    	setSize(800, 500);
		
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
    	setLocation(540, 230);
		
    	setResizable(false);
		
    	getContentPane().setLayout(null);
		
		title.setHorizontalAlignment(SwingConstants.CENTER);
		
		title.setBounds(0, 0, 794, 50);
		
		title.setFont(new Font("Dialog", Font.BOLD, 26));
		
		getContentPane().add(title); 
		
		reservation.setBounds(100, 410, 237, 43);
		
		getContentPane().add(reservation);

		cancellation.setBounds(450, 410, 237, 43);
		
		getContentPane().add(cancellation);
        
        Container contentPane = getContentPane();
        
        BorderLayout layout = new BorderLayout();
        
        contentPane.setLayout(layout);
        
        backgroundIMG.setHorizontalAlignment(SwingConstants.CENTER);
        
        backgroundIMG.setIcon(new ImageIcon(MainGUI.class.getResource("/View/MainGUIbg.png")));
        
        getContentPane().add(backgroundIMG);
        
        setVisible(true);
    }

    public void displayReservationPage() {
       
    	reservationView = new ReservationView();
    }

    public void displayCancellationPage() {
       
    	cancellationView = new CancelTicketView();
    }

    public CancelTicketView getCancellationPage() {
        
    	return cancellationView;
    }

    public void setCancellationPage(CancelTicketView cancellationView) {
        
    	this.cancellationView = cancellationView;
    }

    public ReservationView getReservationPage() {
        
    	return reservationView;
    }

    public void setReservationPage(ReservationView reservationView) {
        
    	this.reservationView = reservationView;
    }

    public JButton getReservation() {
     
    	return reservation;
    }

    public void setReservation(JButton reservation) {
        
    	this.reservation = reservation;
    }

    public JButton getCancellation() {
        
    	return cancellation;
    }

    public void setCancellation(JButton cancellation) {
        
    	this.cancellation = cancellation;
    }

    public JTextField getReservationID() {
        
    	return getCancellationPage().getReservationID();
    }

    public void setReservationDisplay(String text) {

    	getReservationPage().setDisplay(text);
    }

    public String getUsernameFromReservationPage() {
        
    	return getReservationPage().getUserName();
    }

    public String getPasswordFromReservationPage() {
        
    	return getReservationPage().getPassword();
    }

    public void setReservationUserDisplay(String text) {
        
    	getReservationPage().clearUserDisplay();
        
    	getReservationPage().setUserDisplay(text);
    }

    public void setReservationStatus(String text) {
        
    	getReservationPage().clearStatusDisplay();
        
    	getReservationPage().setStatusDisplay(text);
    }

    public UserView getUserInfoFromReservationPage() {
     
    	return getReservationPage().getUserInfo();
    }
    

    
    public void setCancellationToDisplayPage(String text) {
        
    	getCancellationPage().clearDisplay();
    
        getCancellationPage().setDisplay(text);
    }
    

    
    
    public String getUserInfoFromCancellationPage() {
    
    	return getCancellationPage().getUserName();
    }

    public void setCancellationForUser(String text) {
        
    	getCancellationPage().clearStatusDisplay();
        
    	getCancellationPage().setStatusDisplay(text);
    }

    public UserView getUserInformationForCancellation() {
        
    	return getCancellationPage().getUserInformation();
    }

    public String getPassFromCancel() {
      
    	return getCancellationPage().getPassword();
    }

    public void setCanceledUserInformation(String text) {
        
    	getCancellationPage().clearUserMessage();
        
    	getCancellationPage().setUserMessage(text);
    }

}