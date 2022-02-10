package Model;


import java.util.HashMap;
import java.util.ArrayList;
import java.util.Date;

public class ReservationModel {
   
	private HashMap<Integer, MovieTicket> reservations;
    
	/**
     * an object of MovieCatalogue
     */
	private MovieCatalogue movies;
    
	/**
     * an object of TheaterCatalogue
     */
	private TheaterCatalogue theaters;


    /**
     * Constructor for ReservatioModel
     */
    public ReservationModel(MovieCatalogue movies, TheaterCatalogue theaters, HashMap<Integer, MovieTicket> reservations) {
    
    	this.movies = movies;
        
    	this.theaters = theaters;
        
    	this.reservations = reservations;
    }


    public ArrayList<Theater> viewTheaters() {
        
    	return theaters.viewTheaters();
    }

    public ArrayList<Movies> viewMovies() {
        
    	return movies.viewMovies();
    }

    public ArrayList<Theater> searchTheaters(Movies movie) {
        
    	return theaters.searchTheaterForMovie(movie);
    }


    public ArrayList<ShowTime> viewShowTime(Movies movie, Theater theater) {

        return theater.searchShowTimes(movie);
    }

    /**
     * @param an object of Movies
     * @param an object of Theater
     * @param an object of Date
     * @return for specific date and at particular theater it will return a show time
     */
    public ArrayList<ShowTime> viewShowTimesDate(Movies movie, Theater theater, Date date) {
        
    	return theater.searchShowTimesByDate(movie, date);
    }

    /**
     * @param an object of the ShowTime
     * @return the seats for a specific showtime
     */
    public Seat[][] showSeat(ShowTime showtime) {
        
    	return showtime.showSeats();
    }

    /**
     * @param an object of the ShowTime
     * @return ticket price for a show time
     */
    public double getTicketFee(ShowTime showtime) {
       
    	return showtime.getTicketFee();
    }

    /**
     * @param an integer
     * @return reservationID
     */
    public MovieTicket validateReservation(int reservationID) {
        
    	return reservations.get(reservationID); 
    }

    
    /**
     * @param an integer for capturing reservationID
     * @param an object of MovieTicket
     * @return reservationID and ticket
     */
    public void addReservation(int reservationID, MovieTicket ticket) {
        
    	reservations.put(reservationID, ticket);
    }

  
    public boolean cancellationConfirm(MovieTicket ticket) {
        
    	return ticket.verifyCancellation();
    }

    /**
     * Removes the ticket after canceling
     */
    public double ticketCanceled(MovieTicket ticket) {
        
    	reservations.remove(ticket.getReservationID());
        
    	double ticketprice = ticket.cancelSeat();
        
        
    	return ticketprice;
    }

    /**
     * @param an object of ShowTime
     * @param an integer to capture columns
     * @param an integer to capture rows
     * @param an integer to capture reservationID
     * @param an String to get type of user
     * @return ticket is returned based on row , column and category of user 
     */
    public MovieTicket chooseSeat(ShowTime showtime, int row, int column, int reservationID, String userCategory) {
        
    	return showtime.chooseSeat(reservationID, userCategory, row, column);
    }
}