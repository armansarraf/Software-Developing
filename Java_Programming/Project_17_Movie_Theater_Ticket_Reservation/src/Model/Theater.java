package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Collections;

public class Theater {
  
	private String name;
    
	private ArrayList<ShowTime> showtime;
    
	private ArrayList<TheaterRoom> location;

    
	/**
     * Initialize the theater
     * @param an arraylist of theater rooms
     * @param an arraylist of showtimes
     */
    public Theater(String name, ArrayList<ShowTime> showtime, ArrayList<TheaterRoom> location) {
    
    	this.name = name;
        
    	this.showtime = showtime;
        
    	this.location = location;
    }

    
    /**
     * Return available showtimes for a movie
     *
     * @param movie and object of movies
     * @return output available showtimes
     */
    public ArrayList<ShowTime> searchShowTimes(Movies movie) {
    
    	ArrayList<ShowTime> output = new ArrayList<ShowTime>();

        for (int i = 0; i < showtime.size(); i++) {
        
        	if (showtime.get(i).getMovie().getTitle() == movie.getTitle()) {
            
        		output.add(showtime.get(i));
            }
        }
        return output;
    }

   
    /**
     * Return show times for a movie in sorted manner
     *
     * @param movie and object of Movies
     * @param date and object of Date
     * @return sorted showtime for a movie
     */
    public ArrayList<ShowTime> searchShowTimesByDate(Movies movie, Date date) {
       
    	ArrayList<ShowTime> output = new ArrayList<ShowTime>();

        for (int i = 0; i < showtime.size(); i++) {
        
        	if (showtime.get(i).getMovie().getTitle() == movie.getTitle()) {
            
                    
        			output.add(showtime.get(i));
            }
        }

        
        Collections.sort(output);

        return output;

    }

    
    
    public String getName() {
    
    	return this.name;
    }

    
    
    public ArrayList<ShowTime> getShowtimes() {
    
    	return this.showtime;
    }

    
    public ArrayList<TheaterRoom> getTheaterLocation() {
   
    	return this.location;
    }

   
    /**
     * For a movie theater add showtime
     * @param showtime an object of ShowTime
     */
    public void addShowTime(ShowTime showtime) {
    
    	this.showtime.add(showtime);
        
    	return;
    }

    
    /**
     * for a theater add its room
     * @param theater an object of TheaterRoom
     */
    public void addTheaterLocation(TheaterRoom theater) {
    
    	location.add(theater);
        
    	return;
    }
}