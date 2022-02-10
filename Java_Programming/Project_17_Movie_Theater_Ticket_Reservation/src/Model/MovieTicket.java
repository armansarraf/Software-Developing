package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class MovieTicket {
 

	  /**
     * an object of ShowTime class
     */
	private ShowTime showtime;
    
	
	  /**
     *  integer to capture rows
     */
	private int row;
    
	
	  /**
     * integer to capture columns
     */
	private int column;
    
	
	  /**
     * an String for storing the type of user
     */
	private String userCategory;
    
	
	
	  /**
     * an integer to capture the reservation IDs
     */
	private int reservationID;

   
	/**
     * Constructor for MovieTicket that initializes its class variables
     */
    public MovieTicket(ShowTime showtime, int reservationID, String userCategory, int row, int column) {
        
    	this.showtime = showtime;
        
    	this.row = row;
        
    	this.column = column;
        
    	this.reservationID = reservationID;
        
    	this.userCategory = userCategory;
    }

    /**
     * Method for canceling the ticket for a specific user at give row/column
     */
    public double cancelSeat() {
        return showtime.cancelSeat(this.row, this.column, userCategory);
    }

    /**
     * Getter for show time
     */
    public ShowTime getShowTime() {
        return this.showtime;
    }

   
    
    /**
     * Getter for rows
     */
    public int getRow() {
        return this.row;
    }

    
    
    /**
     * Getter for columns
     */
    public int getColumn() {
        return this.column;
    }

    
    
    /**
     * Getter for reservationID
     */
    public int getReservationID() {
        return this.reservationID;
    }

    
    /**
     * Getter for use type
     */
    public String getUserCategory() {
        return this.userCategory;
    }

    @Override
    public String toString() {
        String info = "Reservation ID: " + reservationID + "\n";
        info += showtime;
        info += "Seat: \n\tRow: " + (row +1) + "\n\tColumn: " + (column+1);
        return info;
    }

   
    /**
     * checks for the 72 hrs for return period
     */
    public boolean verifyCancellation() {
       
    	LocalDate date = LocalDate.parse(showtime.getDate().toString());
        
    	LocalTime time = LocalTime.parse(showtime.getTime().toString());
        
    	LocalDateTime dt = LocalDateTime.of(date, time);
        
    	return LocalDateTime.now().plusHours(72).compareTo(dt) <= 0;
    }
}