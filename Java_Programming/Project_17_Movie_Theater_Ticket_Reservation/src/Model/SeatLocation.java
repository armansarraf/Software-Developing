package Model;


public class SeatLocation {
  
	/**
     * 2D array for seat locations
     */
	private Seat[][] seats;

    /**
     * seats are initialized
     */
    public SeatLocation() {
       
    	this.seats = new Seat[6][6]; 
        for (int i = 0; i < this.seats.length; i++) {
       	for (int j = 0; j < this.seats[i].length; j++) {
      	this.seats[i][j] = new Seat();
           }
        }
    }

   
    public SeatLocation(SeatLocation newSeat) {
      
    	int rows = newSeat.showSeats().length;
        
    	int cols = newSeat.showSeats()[0].length;

        this.seats = new Seat[rows][cols];
        
        for (int i = 0; i < this.seats.length; i++) {
        
        for (int j = 0; j < this.seats[i].length; j++) {
            
        this.seats[i][j] = new Seat();
            }    }
    }

    /**
     * getter for the seats
     */
    public Seat[][] showSeats() {
        return seats;
    }

    
    /**
     * At give row and columns checks if seat available
     *@param row an integer to capture rows
     *@param column an integer to capture columns
     * @return true if the seat is available
     */
    public boolean checkSeatAvailability(int row, int column) {
      
    	return this.seats[row][column].checkSeatAvailability();
    }

    
    
    /**
     * 
     * At a given column and row attaches the reservationID
     * @param row an integer to capture the row
     * @param column an integer to capture the column
     */
    public void reserveSeat(int row, int column, int reservationID) {
    
    	this.seats[row][column].SeatReservation(reservationID);
    }

    
    
    /**
     * If ticket is canceled the seat becomes available
     * @param integer to capture row
     * @param integer to capture column
     */
    public void cancelSeat(int row, int column) {
      
    	this.seats[row][column].cancelSeat();
    }
    
    public static void main(String[] args) {
    	SeatLocation seats = new SeatLocation();       

        System.out.println(seats.checkSeatAvailability(5,5));
        seats.reserveSeat(5,5,1000);
        System.out.println(seats.checkSeatAvailability(5,5));
        seats.cancelSeat(5,5);
        System.out.println(seats.checkSeatAvailability(5,5));
    }

}