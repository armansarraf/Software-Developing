package Controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidParameterException;
import java.util.Date;
import java.sql.Time;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;

import Model.*;
import Model.FinancialInsAdmin;
import View.ReservationView;
import View.CancelTicketView;
import View.MainGUI;
import View.UserView;

public class CentralController implements ActionListener {
    
	
	/**
	 *  mainGui an object of MainGUI
	 */
	private MainGUI mainGui;
   
	/**
	 *  an object of reservationModel
	 */
	private ReservationModel reservationModel;
    
	
	/**
	 *  an object of class Admin
	 */
	private Admin admin;
    
	/**
	 *  an object of ShowTime
	 */
	private ShowTime showtimeSelected;
    
	/**
	 *  integer for holding rows
	 */
	private int rowSelected;
	
	
	
	/**
	 *  integer for holding columns
	 */
	private int columnSelected;
	
	
	
   
	/**
	 *  double to store ticket price
	 */
	private double ticketPrice;
    
	
	/**
	 *  an object of RegisteredUser
	 */
	private RegisteredUser regUser;
    
	
	/**
	 *  an object of User
	 */
	private User thisUser;
   
	
	
	/**
	 *  an object of myTicket
	 */
	private MovieTicket myTicket;
    
	
	/**
	 *  integer for holding the size reservations
	 */
	static int reservationID = 1024;    
    
	
	/**
	 *  an object of FinancialInsAdmin
	 */
	private FinancialInsAdmin financialInsAdmin;
    
	
	/**
	 *  an object of Movies
	 */
	private Movies movieSelected;
   
	
	
	/**
	 *  an object of Theater
	 */
	private Theater theaterSelected;
    
	
	
	/**
	 *  an object of Date
	 */
	private Date dateSelected;
    
	
	/**
	 *  an object of Time
	 */
	private Time chosenTime;
  

    /**
     * 
     * CentralController constructor
     * @param mainGui
     * @param reservationModel
     * @param admin
     * @param financialInsAdmin
     */
    public CentralController(MainGUI mainGui, ReservationModel reservationModel, Admin admin, FinancialInsAdmin financialInsAdmin) {
       
    	this.mainGui = mainGui;
        
    	this.mainGui.getReservation().addActionListener(this);
        
    	this.mainGui.getCancellation().addActionListener(this);
        
    	this.reservationModel = reservationModel;
        
    	this.admin = admin;
        
    	this.financialInsAdmin = financialInsAdmin;
    }

   

    /**
     * searchTheater() shows all theater that has that specific movie chosen in previous stage
     */
    private void searchTheater() {
        
    	mainGui.getReservationPage().getTheaterList().removeAllItems(); // Empty the theater list

        String chosenMovie = (String) (mainGui.getReservationPage().getMovieList().getSelectedItem());

        if (chosenMovie != null) {

        for (Movies movie : reservationModel.viewMovies()) {
             
        if (movie.getTitle().equals(chosenMovie))
                
        movieSelected = movie;
            }

            for (Theater theater : reservationModel.searchTheaters(movieSelected)) {
             
          	mainGui.getReservationPage().getTheaterList().addItem(theater.getName());
            }
        }
    }

    /**
     * viewShowTimes() shows all available showTimes to the user
     */
    private void viewShowTimes() {
        mainGui.getReservationPage().getTimeOfDate().removeAllItems();

        // get the name of theater
        
        String chosenTheaterName = (String) (mainGui.getReservationPage().getTheaterList().getSelectedItem());
      
        for (Theater theater : reservationModel.searchTheaters(movieSelected)) {
        
       	if (theater.getName() == chosenTheaterName) {
        
       theaterSelected = theater;
       
       break;
        
        	}
        }

        //Creates a Date time with chosen user's date 
        
        String chosenDate = (String) (mainGui.getReservationPage().getDate().getSelectedItem());
        
        String dateFormat = "yyyy-MM-dd";
        
        SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat); // Using an object of SimpleDateFormat to creates a time with desired format
        
        ParsePosition pos_date = new ParsePosition(0);
        
        dateSelected = (Date) (dateFormatter.parse(chosenDate, pos_date));

        // Showtime based on chosen movie and date
           for (ShowTime showTime : theaterSelected.searchShowTimesByDate(movieSelected, dateSelected)) {
        
           String timeFormat= "HH:mm:ss";
        	  
           SimpleDateFormat timeFormatter = new SimpleDateFormat(timeFormat); // Using an object of SimpleDateFormat to creates a time with desired format
            
           String time = timeFormatter.format(showTime.getTime());
           
           mainGui.getReservationPage().getTimeOfDate().addItem(time);
         }


    }
    

    /**
     * viewMovies() shows all the available movies as a list to the user
     */
    private void viewMovies() {
        
    	mainGui.getReservationPage().getMovieList().removeAllItems(); // Empty the movie list
        
    	for (Movies movie : reservationModel.viewMovies()) {
        
    		mainGui.getReservationPage().getMovieList().addItem(movie.getTitle());// if a movie is still available, it will be added to movie list
        }
    }
    
    

    /**
     * viewSeat() shows all seats to the user, it also bolds the available seats for the user
     */
    private void viewSeat() {

        for (ShowTime showtime : theaterSelected.getShowtimes()) {
            //get chosen time for chosen movie
          
        	String time = (String) (mainGui.getReservationPage().getTimeOfDate().getSelectedItem());
           
        	String timeFormatting = "HH:mm:ss";
        	SimpleDateFormat timeFormatter = new SimpleDateFormat(timeFormatting); // Using an object of SimpleDateFormat to creates a time with desired format
            
        	ParsePosition pos_time = new ParsePosition(0);
           
        	chosenTime = new java.sql.Time(((Date) (timeFormatter.parse(time, pos_time))).getTime());

            //compare chosen time with real showTime, if they match it will show the seats to the user
            if (showtime.getDate().equals(dateSelected) && showtime.getTime().equals(chosenTime)) {
            
            	showtimeSelected = showtime;
                
            	ticketPrice = showtime.getTicketFee();
                
            	Seat[][] seat = showtime.showSeats();

                for (int i = 0; i < seat.length; i++) {
                
                	for (int j = 0; j < seat[i].length; j++) {
                    
                		if (seat[i][j].checkSeatAvailability())
                        
                			mainGui.getReservationPage().getSeatMap()[i][j].setEnabled(true); // if the seat is available, highlights it
                        
                		else
                        
                			mainGui.getReservationPage().getSeatMap()[i][j].setEnabled(false);// if the seat is not available, leave it as its default color
                    }
                }
            }
            break;
        }
    }

    /**
     * getPrice() shows the price related to that movie as each ticket and movie as its own price
     */
    private void getPrice() {

        mainGui.getReservationPage().getPrice().setText(String.valueOf(ticketPrice));
    }

    /**
     * showUserInfoReservation() gets all information from the user when they want to register or buy a ticket as non-registered user
     */
    private void showUserInfoReservation() {
       
    	mainGui.getReservationPage().setUserInfo(new UserView());

        mainGui.getUserInfoFromReservationPage().getLogin().addActionListener(this);
        
        mainGui.getUserInfoFromReservationPage().getRegister().addActionListener(this);
        
        mainGui.getUserInfoFromReservationPage().getNoAccount().addActionListener(this);
        
        mainGui.getUserInfoFromReservationPage().getMakePayment().addActionListener(this);
        
        mainGui.getUserInfoFromReservationPage().getRenewFee().addActionListener(this);
        
        mainGui.getUserInfoFromReservationPage().getMakePaymentWithCoupon().addActionListener(this);

        mainGui.getUserInfoFromReservationPage().getBalance().setText("" + ticketPrice);
        
        mainGui.getUserInfoFromReservationPage().getMakePayment().setEnabled(false);
        
        mainGui.getUserInfoFromReservationPage().getMakePaymentWithCoupon().setEnabled(false);

        mainGui.getUserInfoFromReservationPage().getCancelSeat().setEnabled(true);
    }

    /**
     * login() logs in the users who are already registered and exist in the database
     * In this part, error checking will take place when they input wrong username or password
     *
     * @throws WrongPassword
     * @throws WrongUsername
     * @throws CardInformationNotValid
     */
    private boolean login(ActionEvent e) throws WrongUsername, WrongPassword {

        //shows all the user's information after successful login
        if (mainGui.getReservationPage() != null && mainGui.getUserInfoFromReservationPage() != null && e.getSource() == mainGui.getUserInfoFromReservationPage().getLogin()) {
        
        	return loginFromBooking(); }
        //shows all the user's information after successful login for cancellation page
       
        else {  return loginFromCancellation();
        
        }
    }


    /**
     * registerUser() registers new user and saves them to the database
     */
    private void registerUser() throws InvalidParameterException {
        {
          
        	String username = mainGui.getUserInfoFromReservationPage().getUserName().getText();
            
        	String password = mainGui.getUserInfoFromReservationPage().getPassword().getText();
            
        	if (username.equals("")) {
            
        		mainGui.setReservationUserDisplay("You missed entering username or password! Please try again!!");
                
        		return;
            }

           
        	String name = mainGui.getUserInfoFromReservationPage().getNameOfUser().getText();
            
        	String address = mainGui.getUserInfoFromReservationPage().getAddr().getText();
            
        	String bank = mainGui.getUserInfoFromReservationPage().getBank().getText();
            
        	long cardNumber = Long.valueOf(mainGui.getUserInfoFromReservationPage().getCard_no().getText());
            
        	int expirationDate = Integer.valueOf(mainGui.getUserInfoFromReservationPage().getExpr_date().getText());
            
        	int cvv = Integer.valueOf(mainGui.getUserInfoFromReservationPage().getCvv().getText());
            
        	String email = mainGui.getUserInfoFromReservationPage().getEmail().getText();
            
        	if (name.equals("") || address.equals("") || bank.equals("") || email.equals("")) {
              
        		throw new InvalidParameterException(); // Error Checking
            }

            try {            //registration of a new user

                regUser = admin.registerUser(name, address, bank, cardNumber, expirationDate, cvv, email, username, password);

                mainGui.getUserInfoFromReservationPage().getRegister().setEnabled(false);
               
                mainGui.getUserInfoFromReservationPage().getLogin().setEnabled(false);
                
                mainGui.getUserInfoFromReservationPage().getNoAccount().setEnabled(false);
                
                mainGui.getUserInfoFromReservationPage().getMakePayment().setEnabled(false);

                
                mainGui.setReservationStatus("Request Denied! You should renew your registration");
                
                mainGui.setReservationUserDisplay("20.0$ Activation Fee Should Be Paid\nPleas Click on 'Renew Fee' Button to Finalize Your Registration.");
                
                mainGui.getUserInfoFromReservationPage().getUserType().setText("Registered");
                
            } catch (WrongUsername e) {
              
            	mainGui.setReservationUserDisplay("Sry entered username already exist. Please enter another username!");
           
            } catch (InvalidParameterException e2) {
              
            	mainGui.setReservationUserDisplay("Invalid user information! Please try again!!");
            }

        }
    }

    /**
     * selectSeat() gives access to the user to select their desired seat among available ones.
     *
     * @return boolean
     */
    private boolean selectSeat() {
        
    	//checks availability of chosen seat        
    	int chosenSeatNumber = 0;
        
    	int row = 0;
        
    	int column = 0;
        
    	for (int i = 0; i < mainGui.getReservationPage().getSeatMap().length; i++) {
        
    		for (int j = 0; j < mainGui.getReservationPage().getSeatMap()[i].length; j++) {
            
    			if (mainGui.getReservationPage().getSeatMap()[i][j].getText() == "SELECTED") {
                
    				chosenSeatNumber++;
                    
    				row = i;
                    
    				column = j;
                }
            }
        }
       
    	//Registered User could only choose 10% of available seats.
        
    	if (chosenSeatNumber != 1) {
        
    		mainGui.setReservationDisplay("Seat can not be chosen, please try again");
            
    		clearBookingSelection();
            
    		return false;
        } else {
            
        	rowSelected = row;
            
        	columnSelected = column;
            
        	return true;
        }
    }

    /**
     * @throws CardInformationNotValid Error Checking takes place for payment process
     */
    private void processPayment() throws CardInformationNotValid {

        if (ticketPrice > 0) {
        
        	String institutionName = mainGui.getUserInfoFromReservationPage().getBank().getText();
            
        	long cardNumber = Long.valueOf(mainGui.getUserInfoFromReservationPage().getCard_no().getText());
            
        	int expirationDate = Integer.valueOf(mainGui.getUserInfoFromReservationPage().getExpr_date().getText());
            
        	int cvv = Integer.valueOf(mainGui.getUserInfoFromReservationPage().getCvv().getText());

            
            boolean payStat = financialInsAdmin.paymentProcess(institutionName, cardNumber, expirationDate, cvv, ticketPrice);

            //checks to see if payment was successful
            if (payStat) {
            
            	printTicket();
            } else {
             
            	mainGui.setReservationUserDisplay("Payment information is not valid! Please try again");
            }
        } else {
           
        	printTicket();
        }

    }

    private void printTicket() {
       
    	mainGui.setReservationUserDisplay("Payment Succeed!");

        String userCategory = mainGui.getUserInfoFromReservationPage().getUserType().getText();
        
        myTicket = showtimeSelected.chooseSeat(reservationID, userCategory, rowSelected, columnSelected);

        reservationID += 1; //reservationID will be changed if that seat was already booked.

        //show the ticket in booking view
        if (userCategory.equals("Registered")) {
        
        	mainGui.setReservationDisplay(regUser.printTicket(myTicket));
        
        } else {
        
        	mainGui.setReservationDisplay(thisUser.printTicket(myTicket));
        }

        // After completing the ticket registration, it would be added to Admin's registered tickets list
        
        reservationModel.addReservation(reservationID, myTicket);
        
        mainGui.getUserInfoFromReservationPage().dispose();
        
        clearBookingSelection();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    	if (e.getSource() == mainGui.getReservation()) {
        
    		mainGui.setReservationPage(new ReservationView());
            
    		mainGui.getReservationPage().getViewAllMovie().addActionListener(this);
            
    		mainGui.getReservationPage().getSearchTheater().addActionListener(this);
            
    		mainGui.getReservationPage().getSearchShowTimes().addActionListener(this);
            
    		mainGui.getReservationPage().getSelectSeat().addActionListener(this);
            
    		mainGui.getReservationPage().getGetPrice().addActionListener(this);
            
    		mainGui.getReservationPage().getProcessPayment().addActionListener(this);

            for (int i = 0; i < mainGui.getReservationPage().getSeatMap().length; i++)
             
            	for (int j = 0; j < mainGui.getReservationPage().getSeatMap()[i].length; j++)
                
            		mainGui.getReservationPage().getSeatMap()[i][j].addActionListener(this);
     
    	} else if (e.getSource() == mainGui.getCancellation()) {
           
        	mainGui.setCancellationPage(new CancelTicketView());
            
        	mainGui.getCancellationPage().getReservationID().addActionListener(this);
            
        	mainGui.getCancellationPage().getTicketCancel().addActionListener(this);
        
        
        
        } else if (mainGui.getReservationPage() != null && e.getSource() == mainGui.getReservationPage().getViewAllMovie()) {
        
        	viewMovies();
        
        } else if (mainGui.getReservationPage() != null && e.getSource() == mainGui.getReservationPage().getSearchTheater()) {
        
        	searchTheater();
        
        } else if (mainGui.getReservationPage() != null && e.getSource() == mainGui.getReservationPage().getSearchShowTimes()) {
        
        	viewShowTimes();
       
        } else if (mainGui.getReservationPage() != null && e.getSource() == mainGui.getReservationPage().getSelectSeat()) {
          
        	try {
            
        		viewSeat();

            } catch (NullPointerException e1) {

            }
       
        } else if (mainGui.getReservationPage() != null && e.getSource() == mainGui.getReservationPage().getGetPrice()) {
        
        	getPrice();
        
        } else if (mainGui.getReservationPage() != null && e.getSource() == mainGui.getReservationPage().getProcessPayment()) {
        
        	if (selectSeat()) showUserInfoReservation();
        
        } else if (mainGui.getCancellationPage() != null && e.getSource() == mainGui.getCancellationPage().getTicketCancel()) {
        
        	validateReservation();
            
        	if (myTicket != null) {
            
        		if (myTicket.getUserCategory().equals("Registered")) {
                
        			showUserInfoCancelReg();
                
        		} else {
                    showUserInfoCancelNoAccount();
                }
            }
        }
        //login from reservation page
        else if ((mainGui.getReservationPage() != null && mainGui.getUserInfoFromReservationPage() != null && e.getSource() == mainGui.getUserInfoFromReservationPage().getLogin())) {
       
        	try {
            
        		login(e);
            
        	} catch (WrongUsername e1) {
            
        		mainGui.setReservationUserDisplay("Invalid Username!");
            
        	} catch (WrongPassword e2) {
           
        		mainGui.setReservationUserDisplay("Invalid Password!");
            }
        }
        //login from ticket cancellation page
        else if ((mainGui.getCancellationPage() != null && mainGui.getUserInformationForCancellation() != null && e.getSource() == mainGui.getUserInformationForCancellation().getLogin())) {
       
        	try {
            
        		login(e);
            
        	} catch (WrongUsername e1) {
            
        		mainGui.setCanceledUserInformation("Invalid Username!");
            
        	} catch (WrongPassword e2) {
           
        		mainGui.setCanceledUserInformation("Invalid Password!");
            }
        }
        // Allows user to pay the annual fee when they are reserving a ticket
        else if ((mainGui.getReservationPage() != null && mainGui.getUserInfoFromReservationPage() != null && e.getSource() == mainGui.getUserInfoFromReservationPage().getRenewFee())) {
       
        	if (mainGui.getUserInfoFromReservationPage().getFeeRenewalStatus().getText().equals("Renewal required")) {
            
        		try {
                
        			boolean transactionStatus = financialInsAdmin.paymentProcess(regUser.getFinancialInstitution(), regUser.getCredit_card_no(),
                    
        					regUser.getCard_exp(), regUser.getCard_cvv(), 20.00);
                   
        			if (!transactionStatus) {
                        mainGui.setReservationUserDisplay("Payment information is not valid! Please try again");
                    } else {
                    
                    	mainGui.getUserInfoFromReservationPage().getMakePayment().setEnabled(true);
                        
                    	mainGui.getUserInfoFromReservationPage().getMakePaymentWithCoupon().setEnabled(true);
                        
                    	regUser.confirmAnnualFee();
                        
                    	Date renewDate = regUser.getAnnualPaymentDate();
                        
                    	mainGui.setReservationUserDisplay("Payment Succeed!\nYour registration will be valid until: " + renewDate);
                        
                    	mainGui.setReservationStatus("Account active");
                    }
               
        		} catch (CardInformationNotValid e2) {
                
        			mainGui.setReservationUserDisplay("Invalid institutionName name!");
                }
            }

        }
      
    	//pay annual fee from cancellation page
        
        else if ((mainGui.getCancellationPage() != null && mainGui.getUserInformationForCancellation() != null && e.getSource() == mainGui.getUserInformationForCancellation().getRenewFee())) {
        
        	if (mainGui.getUserInformationForCancellation().getFeeRenewalStatus().getText().equals("Renewal required")) {
            
        		try {
                
        			boolean transactionStatus = financialInsAdmin.paymentProcess(regUser.getFinancialInstitution(), regUser.getCredit_card_no(),
                      
        					regUser.getCard_exp(), regUser.getCard_cvv(), 20.00);
                    
        			if (!transactionStatus) {
                    
        				mainGui.setCanceledUserInformation("Payment information is not valid! Please try again");
                    
        			} else {
                    
        				mainGui.getUserInformationForCancellation().getCancelSeat().setEnabled(true);
                        
        				regUser.confirmAnnualFee();
                        
        				Date renewDate = regUser.getAnnualPaymentDate();
                        
        				mainGui.setCanceledUserInformation("Payment successfully processed!\nAccount valid until: " + renewDate);
                    }
                } catch (CardInformationNotValid e2) {
                
                	mainGui.setCanceledUserInformation("Invalid institutionName name!");
                }
            }

        }
        //register new user from reservation page
      
        else if (mainGui.getReservationPage() != null && mainGui.getUserInfoFromReservationPage() != null && e.getSource() == mainGui.getUserInfoFromReservationPage().getRegister()) {
        
        	registerUser();
        }
        //create guest user from reservation page
        
        else if (mainGui.getReservationPage() != null && mainGui.getUserInfoFromReservationPage() != null && e.getSource() == mainGui.getUserInfoFromReservationPage().getNoAccount()) {
        
        	try {
            
        		createTempUser(e);
          
        	} catch (Exception e1) {
            
        		mainGui.setReservationUserDisplay("Invalid user information! Please try again!!");
            }
        }
        //create temporary user from cancellation page
     
        else if (mainGui.getCancellationPage() != null && mainGui.getUserInformationForCancellation() != null && e.getSource() == mainGui.getCancellationPage().getUserInformation().getNoAccount()) {
        
        	try {
            
        		createTempUser(e);
            
        	} catch (Exception e1) {
            
        		mainGui.setCanceledUserInformation("Invalid user information! Please try again!!");
            }
        }
        //make payment from reservation page
      
        else if ((mainGui.getReservationPage() != null && mainGui.getUserInfoFromReservationPage() != null && e.getSource() == mainGui.getUserInfoFromReservationPage().getMakePayment())) {
        
        	try {
            
        		processPayment();
            
        	} catch (CardInformationNotValid e1) {
           
        		mainGui.setReservationUserDisplay("Invalid institutionName information!");
            }
        }
        //cancel ticket from cancellation page
        
        else if ((mainGui.getCancellationPage() != null && mainGui.getUserInformationForCancellation() != null && e.getSource() == mainGui.getUserInformationForCancellation().getCancelSeat())) {
        
        	mainGui.getUserInformationForCancellation().dispose();
            
        	cancelTicket();
            
        	mainGui.getCancellationPage().clearReservationID();
            
        	myTicket = null;
        }
        //pay with coupon
       
        else if ((mainGui.getReservationPage() != null && mainGui.getUserInfoFromReservationPage() != null && e.getSource() == mainGui.getUserInfoFromReservationPage().getMakePaymentWithCoupon())) {
        
        	try {
            
 		
        		useCoupon();

        	} catch (CardInformationNotValid e1) {
            
        		mainGui.setReservationUserDisplay("Invalid Coupon");
            }
        }
        //check for seat map button click
        else if (mainGui.getReservationPage() != null) {
     
        	for (int i = 0; i < mainGui.getReservationPage().getSeatMap().length; i++)
         
        		for (int j = 0; j < mainGui.getReservationPage().getSeatMap()[i].length; j++) {
          
        			if (e.getSource() == mainGui.getReservationPage().getSeatMap()[i][j]) {
           
        				if (mainGui.getReservationPage().getSeatMap()[i][j].getText() == "")
                       
        					mainGui.getReservationPage().getSeatMap()[i][j].setText("SELECTED");
                        
        				else if (mainGui.getReservationPage().getSeatMap()[i][j].getText() == "SELECTED")
                        
        					mainGui.getReservationPage().getSeatMap()[i][j].setText("");
                    }
                }
        }
    }


    /**
     * Checking validation of a ticket when a user wants to cancel it
     */
    private void validateReservation() {
        
    	String reservationID = mainGui.getReservationID().getText();
    
        if (!reservationID.matches("[0-9]{4}")) {
        
        	mainGui.setCancellationToDisplayPage("Invalid input! Please enter your 4-digit reservation ID!");
        
        } else {
        
        	MovieTicket ticket = reservationModel.validateReservation(Integer.parseInt(reservationID));
            
        	if (ticket == null) {
            
        		mainGui.setCancellationToDisplayPage("Entered Reservation ID is not Valid!");
            
        	} else {
            
        		if (reservationModel.cancellationConfirm(ticket)) {
                
        			mainGui.setCancellationToDisplayPage("Reservation Ticket ID found!");
                    
        			myTicket = ticket;
             
        		} else {
                    mainGui.setCancellationToDisplayPage("It is less than 72 hours to show time. You can not cancel your ticket!");
                }
            }
        }
    }

   
    private void getRegUser(String fromPage) throws WrongUsername, WrongPassword {
        String username = "";
        String password = "";

        //login process
        if (fromPage == "Booking") {
            username = mainGui.getUsernameFromReservationPage();
            password = mainGui.getPasswordFromReservationPage();
        } else if (fromPage == "Cancellation") {
            username = mainGui.getUserInfoFromCancellationPage();
            password = mainGui.getPassFromCancel();
        }

        regUser = admin.login(username, password);

    }

    private boolean loginFromBooking() throws WrongUsername,
            WrongPassword {

        getRegUser("Booking");

        if (regUser != null) {
           
        	mainGui.getUserInfoFromReservationPage().getUserType().setText("Registered");
            
        	mainGui.getUserInfoFromReservationPage().getNameOfUser().setText(regUser.getName());
            
        	mainGui.getUserInfoFromReservationPage().getAddr().setText(regUser.getName());
            
        	mainGui.getUserInfoFromReservationPage().getBank().setText(regUser.getFinancialInstitution());
            
        	mainGui.getUserInfoFromReservationPage().getCard_no().setText(String.valueOf(regUser.getCredit_card_no()));
            
        	mainGui.getUserInfoFromReservationPage().getExpr_date().setText(String.valueOf(regUser.getCard_exp()));
            
        	mainGui.getUserInfoFromReservationPage().getCvv().setText(String.valueOf(regUser.getCard_cvv()));
            
        	mainGui.getUserInfoFromReservationPage().getEmail().setText(regUser.getEmail());
            
        	mainGui.getUserInfoFromReservationPage().getDisplay().setText("Registered User logged in successfully!");

            //check checkFeeRenewal
            
        	if (!regUser.checkAnnualFee()) {//renewal is required

        		mainGui.setReservationStatus("Renewal required");
                
        		mainGui.setReservationUserDisplay("20.0$ Renewal Fee Payment Required! Please press Renew Fee to pay.");
                
        		mainGui.getUserInfoFromReservationPage().getMakePayment().setEnabled(false);
                
        		mainGui.getUserInfoFromReservationPage().getRegister().setEnabled(false);
                
        		mainGui.getUserInfoFromReservationPage().getNoAccount().setEnabled(false);
                
        		return false;
            } else {
             
            	mainGui.setReservationStatus("Account active");
                
            	mainGui.getUserInfoFromReservationPage().getRegister().setEnabled(false);
                
            	mainGui.getUserInfoFromReservationPage().getNoAccount().setEnabled(false);
                
            	mainGui.getUserInfoFromReservationPage().getMakePayment().setEnabled(true);
                
            	mainGui.getUserInfoFromReservationPage().getMakePaymentWithCoupon().setEnabled(true);
                
            	return true;
            }
        }
        return false;
    }

    private boolean loginFromCancellation() throws WrongUsername,
            WrongPassword {

        getRegUser("Cancellation");

        if (regUser != null) {
          
        	mainGui.getUserInformationForCancellation().getUserType().setText("Registered User");
            
        	mainGui.getUserInformationForCancellation().getNameOfUser().setText(regUser.getName());
            
        	mainGui.getUserInformationForCancellation().getAddr().setText(regUser.getName());
            
        	mainGui.getUserInformationForCancellation().getBank().setText(regUser.getFinancialInstitution());
            
        	mainGui.getUserInformationForCancellation().getCard_no().setText(String.valueOf(regUser.getCredit_card_no()));
            
        	mainGui.getUserInformationForCancellation().getExpr_date().setText(String.valueOf(regUser.getCard_exp()));
            
        	mainGui.getUserInformationForCancellation().getCvv().setText(String.valueOf(regUser.getCard_cvv()));
            
        	mainGui.getUserInformationForCancellation().getEmail().setText(regUser.getEmail());
            
        	mainGui.setCanceledUserInformation("Registered User logged in successfully!");

            //check renewal fee payment
            if (!regUser.checkAnnualFee()) {//renewal is required
            
            	mainGui.setCancellationForUser("Renewal required");
                
            	mainGui.setCanceledUserInformation("20.0$ Renewal Fee Payment Required! Please press Renew Fee to pay.");
                
            	mainGui.getUserInformationForCancellation().getCancelSeat().setEnabled(false);
                
            	return false;
            } else {
                mainGui.setCancellationForUser("Account active");
                return true;
            }
        }
        return false;
    }

    /**
     * cancelTicket() cancels user's ticket whether they are registered or not
     */
    private void cancelTicket() {

        // reservation already validated
        double credit = reservationModel.ticketCanceled(myTicket);
        String voucher = admin.createCoupon(credit);

        if (myTicket.getUserCategory().equals("Registered")) {
            mainGui.setCancellationToDisplayPage("Ticket Cancelled successfully!\n" + regUser.mailCoupon(voucher));
        } else {
            mainGui.setCancellationToDisplayPage("Ticket Cancelled successfully!\n" + thisUser.mailCoupon(voucher));
        }

    }

    /**
     * showUserInfoCancelReg() shows the registered user information for cancellation
     */
    private void showUserInfoCancelReg() {
        mainGui.getCancellationPage().setUserInformation(new UserView());

       
        mainGui.getUserInformationForCancellation().getLogin().addActionListener(this);
        
        mainGui.getUserInformationForCancellation().getCancelSeat().addActionListener(this);
        
        mainGui.getUserInformationForCancellation().getRenewFee().addActionListener(this);

        
        mainGui.getUserInformationForCancellation().getMakePayment().setEnabled(false);
        
        mainGui.getUserInformationForCancellation().getMakePaymentWithCoupon().setEnabled(false);
        
        mainGui.getUserInformationForCancellation().getRegister().setEnabled(false);
        
        mainGui.getUserInformationForCancellation().getNoAccount().setEnabled(false);

        mainGui.setCanceledUserInformation("Please login to continue");
    }

    /**
     * showUserInfoCancelNoAccount() shows the guest user information for cancellation
     */
    private void showUserInfoCancelNoAccount() {
        
    	mainGui.getCancellationPage().setUserInformation(new UserView());

    	
        
    	mainGui.getUserInformationForCancellation().getNoAccount().addActionListener(this);
        
    	mainGui.getUserInformationForCancellation().getCancelSeat().addActionListener(this);
        
    	mainGui.getUserInformationForCancellation().getRenewFee().addActionListener(this);

    	
        
    	mainGui.getUserInformationForCancellation().getMakePayment().setEnabled(false);
        
    	mainGui.getUserInformationForCancellation().getMakePaymentWithCoupon().setEnabled(false);
        
    	mainGui.getUserInformationForCancellation().getRegister().setEnabled(false);
        
    	mainGui.getUserInformationForCancellation().getLogin().setEnabled(false);
        
    	mainGui.getUserInformationForCancellation().getRenewFee().setEnabled(false);

        mainGui.setCanceledUserInformation("Please enter your information to continue");
    }

    /**
     * creating guest user to buy a ticket
     *
     * @param e
     */
    private User createTempUser(ActionEvent e) throws NumberFormatException, InvalidParameterException {
        //open userinfo view from booking
        if (mainGui.getReservationPage() != null && mainGui.getUserInfoFromReservationPage() != null && e.getSource() == mainGui.getUserInfoFromReservationPage().getNoAccount()) {
      
        	String name = mainGui.getUserInfoFromReservationPage().getNameOfUser().getText();
            
        	String address = mainGui.getUserInfoFromReservationPage().getAddr().getText();
            
        	String institutionName = mainGui.getUserInfoFromReservationPage().getBank().getText();
            
        	long cardNumber = Long.valueOf(mainGui.getUserInfoFromReservationPage().getCard_no().getText());
            
        	int expirationDate = Integer.valueOf(mainGui.getUserInfoFromReservationPage().getExpr_date().getText());
            
        	int cvv = Integer.valueOf(mainGui.getUserInfoFromReservationPage().getCvv().getText());
            
        	String email = mainGui.getUserInfoFromReservationPage().getEmail().getText();
            
        	if (name.equals("") || address.equals("") || institutionName.equals("") || email.equals("")) {
            
        		throw new InvalidParameterException();
            }

            
        	thisUser = admin.newUser(cardNumber, expirationDate, cvv, email, name, address, institutionName);
            
        
        	mainGui.getUserInfoFromReservationPage().getLogin().setEnabled(false);
            
        	mainGui.getUserInfoFromReservationPage().getRegister().setEnabled(false);
            
        	mainGui.getUserInfoFromReservationPage().getUserType().setText("Temporary User");
            
        	mainGui.getUserInfoFromReservationPage().getDisplay().setText("Guest User Created successfully!");

            mainGui.getUserInfoFromReservationPage().getMakePayment().setEnabled(true);

            mainGui.getUserInfoFromReservationPage().getMakePaymentWithCoupon().setEnabled(true);
        }
        //open userinfo view from cancellation page
        else {
         
        	String name = mainGui.getUserInformationForCancellation().getNameOfUser().getText();
            
        	String address = mainGui.getUserInformationForCancellation().getAddr().getText();
            
        	String institutionName = mainGui.getUserInformationForCancellation().getBank().getText();
            
        	long cardNumber = Long.valueOf(mainGui.getUserInformationForCancellation().getCard_no().getText());
            
        	int expirationDate = Integer.valueOf(mainGui.getUserInformationForCancellation().getExpr_date().getText());
            
        	int cvv = Integer.valueOf(mainGui.getUserInformationForCancellation().getCvv().getText());
            
        	String email = mainGui.getUserInformationForCancellation().getEmail().getText();
            
        	if (name.equals("") || address.equals("") || institutionName.equals("") || email.equals("")) {
            
        		throw new InvalidParameterException();
            }


        	thisUser = admin.newUser(cardNumber, expirationDate, cvv, email, name, address, institutionName);
            
        	mainGui.getUserInformationForCancellation().getUserType().setText("Temporary User");
            
        	mainGui.setCanceledUserInformation("Guest User Created successfully!");
        }
        return thisUser;
    }

    public void useCoupon() throws CardInformationNotValid {
        
    	String voucherID = mainGui.getUserInfoFromReservationPage().getCouponId().getText();
        
    	if (!voucherID.matches("[0-9]{5}")) {
        
    		mainGui.setReservationDisplay("Invalid input, please enter your 5-digit coupon ID again!");
        
    	} else {
        
    		int voucher = Integer.valueOf(voucherID);
            
    	
    		try {
            
    			String initBalance = "Initial balance on coupon is: " + admin.get_coupon(voucher);
                
    			ticketPrice = admin.useCoupon(voucher, ticketPrice);
                
    			String remainingPrice = String.format("%.2f", ticketPrice);
                
    			mainGui.getUserInfoFromReservationPage().getBalance().setText(remainingPrice);

                String finalBalance;
                
                if (ticketPrice == 0) {
                
                	String balance = String.format("%.2f", admin.get_coupon(voucher));
                    
                	finalBalance = "\nRemaining balance of coupon: $" + balance;
                } else
                
                	finalBalance = "\nRemaining balance on coupon: 0.00 $";
               
                String toContinue = "\nClick on Pay with card button to buy the ticket";
                
                mainGui.setReservationUserDisplay(initBalance + finalBalance + toContinue);

            } catch (InvalidCoupon e1) {
                e1.printStackTrace();
                mainGui.setReservationUserDisplay("Coupon not found!");
            } catch (CouponTimeOut e2) {
                mainGui.setReservationUserDisplay("Coupon is expired! You can not use it");
            }

        }
    }

    private void clearBookingSelection() {
      
        
    	mainGui.getReservationPage().getMovieList().removeAllItems();
        
    	mainGui.getReservationPage().getTheaterList().removeAllItems();

    	mainGui.getReservationPage().getDate().removeAllItems();
        
    	mainGui.getReservationPage().getDate().addItem("2021-12-10");
        
    	mainGui.getReservationPage().getDate().addItem("2021-12-11");
        
    	mainGui.getReservationPage().getDate().addItem("2021-12-12");
        
    	mainGui.getReservationPage().getDate().addItem("2021-12-13");
        
    	mainGui.getReservationPage().getDate().addItem("2021-12-14");
        
    	mainGui.getReservationPage().getDate().addItem("2021-12-15");
        
    	mainGui.getReservationPage().getDate().addItem("2021-12-16");
        
    	mainGui.getReservationPage().getTimeOfDate().removeAllItems();

        for (int i = 0; i < mainGui.getReservationPage().getSeatMap().length; i++)
        
      	for (int j = 0; j < mainGui.getReservationPage().getSeatMap()[i].length; j++) {
            
     	mainGui.getReservationPage().getSeatMap()[i][j].setText("");
        mainGui.getReservationPage().getSeatMap()[i][j].setEnabled(false);
            }
       mainGui.getReservationPage().getPrice().setText("");
    }
}