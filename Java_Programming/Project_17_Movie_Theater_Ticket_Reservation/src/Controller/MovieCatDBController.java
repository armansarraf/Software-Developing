package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import Model.MovieCatalogue;
import Model.MovieTicket;
import Model.Movies;
import Model.SeatLocation;
import Model.ShowTime;
import Model.Theater;
import Model.TheaterCatalogue;
import Model.TheaterRoom;

public class MovieCatDBController {
    public Connection jdbc_connection;
    public PreparedStatement statement;
    public String databaseName = "RESERVATIONMODEL";

    
    
    
    
    /**
     * String for capturing log in information
     * @return no return
     */
    public String connectionInfo = "jdbc:mysql://localhost:3306/RESERVATIONMODEL",
            login = "root",
            password = "9788";

   
    /**
     * connecting to DB
     * @return no return
     */
    public MovieCatDBController() {
        
    	try {
        
    		Class.forName("com.mysql.cj.jdbc.Driver");

            jdbc_connection = DriverManager.getConnection(connectionInfo, login, password);
            System.out.println("Successfully connected to DataBase ...");
        
    	} catch (SQLException e) {e.printStackTrace();
        
    	} catch (Exception e) {	e.printStackTrace();
        }
    }

    /**
     * class to pull list of movies to populate the catalogue
     * @return output an arraylist of movies
     */
    public ArrayList<Movies> selectMovies() {
      
    	ArrayList<Movies> output = new ArrayList<Movies>();
        
    	try {
        
    		String query = "SELECT * FROM MOVIES";
            
    		statement = jdbc_connection.prepareStatement(query);

            ResultSet movies = statement.executeQuery();
            
            while (movies.next()) {
            
            	output.add(new Movies(movies.getString("Name")));
            }
           
            movies.close();
        
    	} catch (SQLException e) {e.printStackTrace();
        }

        return output;
    }

    /**
     * populates list of theaters to theater catalogue
     * @return output list of theaters 
     */
    public ArrayList<Theater> selectTheaters() {

        ArrayList<Theater> output = new ArrayList<Theater>();
     
        try {
        
        	String query = "SELECT * FROM THEATER";
            
        	statement = jdbc_connection.prepareStatement(query);

            
        	ResultSet theaters = statement.executeQuery();
           
        	while (theaters.next()) {
            
        		output.add(new Theater(theaters.getString("Name"), new ArrayList<ShowTime>(), new ArrayList<TheaterRoom>()));
            }
           
        	theaters.close();
        
        } catch (SQLException e) { 	e.printStackTrace();
        }
        return output;
    }

    /**
     * Based on the theater adds the show time to the theater
     *
     * @param movies an object of MovieCatalogue
     * @param theaters an object of TheaterCatalogue
     */
    public void selectAndAddShowTimes(TheaterCatalogue theaters, MovieCatalogue movies) {


        try {
         
        	String query = "SELECT * FROM SHOWTIME";
            
        	statement = jdbc_connection.prepareStatement(query);
            
        	ResultSet showtimes = statement.executeQuery();
           
            while (showtimes.next()) {
            
            	// looks into MovieCatalogue
                
            	Movies movie = new Movies();
               
            	for (int i = 0; i < movies.viewMovies().size(); i++) {
                
            		if (movies.viewMovies().get(i).getTitle().equals(showtimes.getString("MovieName"))) {
                    
            			movie = movies.viewMovies().get(i);
                    }
                }

                // looks into theater names in database to set their showtime accordingly
                  	for (int i = 0; i < theaters.viewTheaters().size(); i++) {
                  
                  		if (theaters.viewTheaters().get(i).getName().equals(showtimes.getString("TheaterName"))) {
               
                    	for (int j = 0; j < theaters.viewTheaters().get(i).getTheaterLocation().size(); j++) {
                        
                    		if (theaters.viewTheaters().get(i).getTheaterLocation().get(j).getNumber() == showtimes.getInt("TheaterNumber")) {
                            
                                
                    			theaters.viewTheaters().get(i).addShowTime(new ShowTime(showtimes.getInt("TheaterNumber"), showtimes.getDate("ShowDate") , showtimes.getTime("ShowTime") 
                                        , new SeatLocation(theaters.viewTheaters().get(i).getTheaterLocation().get(j).getTheaterSeats())
                                        , showtimes.getDouble("price"), movie, showtimes.getString("TheaterName")));
                                break;  }
                        } 
                        break;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Looking into database populates the reserved seats
     */
    public void retrieveReservation(HashMap<Integer, MovieTicket> list, TheaterCatalogue theaters) {
     
    	try {
        
    		String query = "SELECT * FROM RESERVATION";
            
    		statement = jdbc_connection.prepareStatement(query);
            
    		ResultSet reservations = statement.executeQuery();

            while (reservations.next()) {
 
 
            	int showTimeIndex = reservations.getInt("ShowTimeID");
                
            	int showTimeCount = 0;
               
                
            	for (int i = 0; i < theaters.viewTheaters().size(); i++) {
                for (int j = 0; j < theaters.viewTheaters().get(i).getShowtimes().size(); j++) {
                showTimeCount += 1; // Show time Counter increases by one 
                if (showTimeIndex == showTimeCount) {
               
                	// seats populated based on reservation status
                    
                	MovieTicket ticket = theaters.viewTheaters().get(i).getShowtimes().get(j).chooseSeat(reservations.getInt("reservationId"), reservations.getString("userType"), reservations.getInt("SeatRow"), reservations.getInt("SeatColumn"));
                    
                	// movie ticket displayed
                    
                	list.put(reservations.getInt("reservationId"), ticket);
                        }
                    }
                }
            }

        } catch (SQLException e) {
        	
            e.printStackTrace();
        }
    }
}