package Model;

import java.util.Date;
import java.sql.Time;

public class ShowTime implements Comparable<ShowTime> {
    

	private Date date;
    
	private Time time;
    
	private SeatLocation seat;
    
	private Movies movie;
    
	private String theaterLocation;
    
	private double ticketprice;
    
	private int theaterRoom;


    /**
     * Initializes all variables for ShowTime object
     *
     * @param movie an object of Movies
     * @param theaterLocation and object of theaterLocation
     * @param theaterRoom an integer
     * @param date is of type Date to capture the date
     * @param time an object of type Time
     * @param seat is an object of Seat location
     */
    public ShowTime(int theaterRoom, Date date, Time time, SeatLocation seat, double ticketprice, Movies movie, String theaterLocation) {
       
    	this.date = date;
        
    	this.time = time;
        
    	this.seat = seat;
        
    	this.ticketprice = ticketprice;
        
    	this.movie = movie;
        
    	this.theaterLocation = theaterLocation;
        
    	this.theaterRoom = theaterRoom;

    }

    /**
     * getter for the seatmap of showtime
     */
    public Seat[][] showSeats() {
   
    	return this.seat.showSeats();
    }

   
    /**
     * returns null or seat position for the user
     *
     * @param row for the seat
     * @param column for the seat
     */
    public MovieTicket chooseSeat(int reservationID, String userCategory, int row, int column) {
      
    	if (seat.checkSeatAvailability(row, column)) {
        
    		seat.reserveSeat(row, column, reservationID);
            
    		return new MovieTicket(this, reservationID, userCategory, row, column);
        }
    
        return null;
    }

    
    /**
     * at given row and column cancel the seat
     */
    public double cancelSeat(int row, int column, String userType) {
     
    	seat.cancelSeat(row, column);
        
    	if (userType.equals("Registered")) 
        
    		return ticketprice;
        
    	else 
       
    		return ticketprice * 0.85;
    }

    
    public Movies getMovie() {
    
    	return this.movie;
    }

    
    
    public String getTheaterLocation() {
   
    	return this.theaterLocation;
    }

    
    
    public int getTheaterRoom() {	
        
    	return this.theaterRoom;
    }

    
    
    public Date getDate() {
        
    	return this.date;
    }

   
    
    public Time getTime() {
        
    	return this.time;
    }

    
    
    public double getTicketFee() {
        
    	return this.ticketprice;
    }

 
    
    @Override
    public String toString() {
        
    	String info = movie + "at Theater Location: " + theaterLocation + "\n";
        
    	info += "Theater room: " + theaterRoom + "\n";
        
    	info += "Here is the Date: " + date + "\n";
        
    	info += "Show Time: " + time + "\n";
        
    	return info;
    }

  
    @Override
    public int compareTo(ShowTime showtime) {
      
    	return this.getDate().compareTo(showtime.getDate());

    }
}