package Model;


public class Seat {
    
	/**
     * an integer to capture reservationID
     */
	private int reservationID;


   	
	/**
     * Constructor for the class Seat
     */
	public Seat() {
    
    	this.reservationID = 0;
    }

    /**
     * @return true or false based on seats being reserved
     */
    public boolean checkSeatAvailability() {
     
    	if (this.reservationID == 0)
        
    		return true;

        return false;
    }

    
    /**
     * When seat canceled reservationID gets cleared
     */
    public void cancelSeat() {
       
    	this.reservationID = 0;
    }

    /**
     * setter for reservationID
     *
     * @param an integer to capture reservationID
     */
    public void SeatReservation(int reservationID) {
        this.reservationID = reservationID;
    }


    /**
     * getter for reservationID
     *
     */
    public int getReservationID() {
        return this.reservationID;
    }
}