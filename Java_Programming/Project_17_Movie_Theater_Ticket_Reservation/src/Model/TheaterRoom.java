package Model;


public class TheaterRoom {
    
	private int number;
    
	private SeatLocation theaterSeats;

    /**
     * Constructor for the class TheaterRoom
     * @param number and integer to keep track of numbers
     * @param theaterSeats and object of seatLocation
     */
    public TheaterRoom(int number, SeatLocation theaterSeats) {
    
    	this.number = number;
        
    	this.theaterSeats = theaterSeats;
    }

    
        
    
    /**
     * gets the seatmap
     * @return seatmap
     */
    public SeatLocation getTheaterSeats() {
    
    	return this.theaterSeats;
    }
    
    
    
    /**
     * getter for the theater number
     * 
     */
    public int getNumber() {
    
    	return this.number;
    }
}