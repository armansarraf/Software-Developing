package Model;


import java.util.ArrayList;

public class TheaterCatalogue {
   
	private ArrayList<Theater> theaters;

	
	
	//populate the theater catalogue
    public TheaterCatalogue(ArrayList<Theater> theaters) {
    
    	this.theaters = theaters;
    }

    /**
     * create an arraylist of theater catalogues
     */
    public TheaterCatalogue() {
        
    	this.theaters = new ArrayList<Theater>();
    }

   
    /**
     * add theater to the catalogue
     */
    public void addTheater(Theater theater) {
        
    	this.theaters.add(theater);
    }

    
    /**
     * getter for the theater catalogue
     */
    public ArrayList<Theater> viewTheaters() {
        
    	return this.theaters;
    }

    /**
     * getter for list of theaters
     */
    public ArrayList<Theater> searchTheaterForMovie(Movies movie) {
   
    	ArrayList<Theater> output = new ArrayList<Theater>();

        
    	for (int i = 0; i < theaters.size(); i++) {
            
    		if (theaters.get(i).searchShowTimes(movie).size() > 0) 
        
            	output.add(theaters.get(i));
        }
        
        return output;
    }
}