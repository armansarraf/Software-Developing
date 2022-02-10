package View;

import java.awt.*;
import javax.swing.*;

public class ReservationView extends JFrame{
	
	private JButton viewAllMovie = new JButton("VIEW ALL MOVIES");
	
	private JComboBox<String> movieList = new JComboBox<String>();
	
	private JButton searchTheater = new JButton("SEARCH THEATER");
	
	private JComboBox<String> theaterList = new JComboBox<String>();
	
	private JComboBox<String> date = new JComboBox<String>();
	
	private JComboBox<String> timeOfDate = new JComboBox<String>();
		
	private JButton searchShowTimes = new JButton("VIEW SHOW TIMES");	
	
	private JButton selectSeat = new JButton("VIEW SEAT");
	
	private JButton[][] seatMap = new JButton[6][6];	
	
	private JButton getPrice = new JButton("GET PRICE");
	
	private JTextField price = new JTextField(7);
	
	private JButton processPayment = new JButton("PROCESS PAYMENT");
	
	private JTextArea display = new JTextArea("");
		
	private UserView userInfo;
	
	public ReservationView() {
	
		setLocation(325, 125);
		
		setResizable(true);
		
		setTitle("Reservation Menu");
		
		setSize(800, 962);  
		
		setLocation(600, 40);
		
		setVisible(true);
				
		Container contentPane = getContentPane();
		
		getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		
		panel_1.setBounds(0, 5, 784, 50);
		
		getContentPane().add(panel_1);
		
		JLabel lblNewLabel = new JLabel("MOVIE TIME AND SEAT SELECTION");
		
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 26));
		
		panel_1.add(lblNewLabel);
		
		JPanel Panel_2=new JPanel();
		
		Panel_2.setBounds(0, 60, 784, 50);
		
		JLabel moviePrompt = new JLabel("SELECT MOVIE");
		
		moviePrompt.setFont(new Font("Poppins", Font.PLAIN, 11));
		
		Panel_2.add(moviePrompt);
		
		ScrollPane movieListScroll = new ScrollPane();
		
		Panel_2.add(movieListScroll);
		
		movieListScroll.add(movieList);
		
		movieListScroll.setSize(428,40);
		
		viewAllMovie.setFont(new Font("Poppins", Font.PLAIN, 11));
		
		Panel_2.add(viewAllMovie);
		
		contentPane.add(Panel_2);

		
		JPanel Panel_3=new JPanel();

		Panel_3.setBounds(0, 115, 784, 50);
		
		JLabel theaterPrompt = new JLabel("SELECT THEATER");
		
		theaterPrompt.setFont(new Font("Poppins", Font.PLAIN, 11));
		
		Panel_3.add(theaterPrompt);
		
		ScrollPane theaterScrollList = new ScrollPane();
		
		Panel_3.add(theaterScrollList);
		
		theaterScrollList.add(theaterList);
		
		theaterScrollList.setSize(428,40);
		
		searchTheater.setFont(new Font("Poppins", Font.PLAIN, 11));
		
		Panel_3.add(searchTheater);
		
		contentPane.add(Panel_3);
		
		
		
		JPanel Panel_4=new JPanel();
		
		Panel_4.setBounds(0, 170, 784, 50);
		
		JLabel datePrompt = new JLabel("Select Date:");
		
		datePrompt.setFont(new Font("Poppins", Font.PLAIN, 11));
		
		Panel_4.add(datePrompt);
		
		date.addItem("2021-12-10");
		
		date.addItem("2021-12-11");
		
		date.addItem("2021-12-12");
		
		date.addItem("2021-12-13");
		
		ScrollPane dateSp=new ScrollPane();
		
		Panel_4.add(dateSp);
		
		dateSp.add(date);
		
		dateSp.setSize(100,40);	
		
		ScrollPane timeSp=new ScrollPane();
		
		Panel_4.add(timeSp);
		
		timeSp.add(timeOfDate);
		
		timeSp.setSize(100,40);			
		
		searchShowTimes.setFont(new Font("Poppins", Font.PLAIN, 11));
		
		Panel_4.add(searchShowTimes);
		
		selectSeat.setFont(new Font("Poppins", Font.PLAIN, 11));
		
		Panel_4.add(selectSeat);
		
		contentPane.add(Panel_4);	
		
		
		JPanel Panel_5=new JPanel();
		
		Panel_5.setBounds(108, 264, 560, 214);
		
		Panel_5.setLayout(new GridLayout(seatMap.length, seatMap[0].length));	
		
		Panel_5.setPreferredSize(new Dimension(500, 200));
		
		for(int i = 0; i < seatMap.length; i++)
		
			for(int j = 0; j < seatMap[i].length; j++)
			{
			
				seatMap[i][j] = new JButton(); 
				
				seatMap[i][j].setEnabled(false);
				
				Panel_5.add(seatMap[i][j]);
			}		
		contentPane.add(Panel_5);				
		
		JPanel Panel_6=new JPanel();
		
		Panel_6.setBounds(0, 490, 784, 36);
		
		Panel_6.add(price);
		
		contentPane.add(Panel_6);	
		
		getPrice.setFont(new Font("Poppins", Font.PLAIN, 11));
		
		Panel_6.add(getPrice);
		
		JPanel Panel_7=new JPanel();
		
		Panel_7.setBounds(0, 612, 784, 337);
		
		ScrollPane ticketScroll=new ScrollPane();
		
		Panel_7.add(ticketScroll);
		
		
		display.setLineWrap(true);
		
    	display.setLayout(new GridBagLayout());
		
    	display.setBackground(new Color(205,217,245));
		
    	ticketScroll.add(display);
		
    	ticketScroll.setSize(320,290);			
		
    	contentPane.add(Panel_7);
		
		JPanel Panel_6_1_1 = new JPanel();
		
		Panel_6_1_1.setBounds(0, 526, 784, 36);
		
		getContentPane().add(Panel_6_1_1);
		
		processPayment.setFont(new Font("Poppins", Font.PLAIN, 11));
		
		Panel_6_1_1.add(processPayment);
		
		JPanel Panel_6_1 = new JPanel();
		
		Panel_6_1.setBounds(0, 238, 784, 26);
		
		getContentPane().add(Panel_6_1);
		
		JLabel lblNewLabel_1 = new JLabel("---MOVIE SCREEN---");
		
		lblNewLabel_1.setFont(new Font("Poppins", Font.BOLD, 13));
		
		Panel_6_1.add(lblNewLabel_1);
		
		JPanel Panel_6_1_1_1 = new JPanel();
		
		Panel_6_1_1_1.setBounds(0, 574, 784, 26);
		
		getContentPane().add(Panel_6_1_1_1);
		
		JLabel ticketPrompt = new JLabel("TICKET AND RECEIPT");
		
		ticketPrompt.setFont(new Font("Poppins", Font.PLAIN, 12));
		
		Panel_6_1_1_1.add(ticketPrompt);
	}

	
	public JButton getViewAllMovie() {
		return viewAllMovie;
	}	

	
	public JComboBox<String> getMovieList() {
		return movieList;
	}

	public JComboBox<String> getTheaterList() {
		return theaterList;
	}		

	public JButton getSearchTheater() {
		return searchTheater;
	}
	
	public JButton getSearchShowTimes() {
		return searchShowTimes;
	}	
		
	public JButton getSelectSeat() {
		return selectSeat;
	}		

	public JButton[][] getSeatMap(){
		return seatMap;
	}
	
	public JButton getGetPrice() {
		return getPrice;
	}	
	
	public JTextField getPrice() {
		return price;
	}	
	
	public JButton getProcessPayment() {
		return processPayment;
	}
	
	public UserView getUserInfo() {
		return userInfo;
	}
	
	public void setUserInfo(UserView user) {
		userInfo = user;
	}
	
	public JComboBox getDate() {
		return date;
	}
	
	public JComboBox getTimeOfDate() {
		return timeOfDate;
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

	public void clearUserDisplay() {
		userInfo.setDisplay("");
	}

	public void setUserDisplay(String text) {
		userInfo.setDisplay(text);
	}

	public void clearStatusDisplay() {
		userInfo.setStatus("");
	}

	public void setStatusDisplay(String text) {
		userInfo.setStatus(text);
	}
	

}