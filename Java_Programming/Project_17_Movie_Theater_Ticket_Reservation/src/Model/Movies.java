package Model;

public class Movies {
   
	private String title;
   
	
	/**
     * Constructor for setting the name of movies
     */
	public Movies(String MovieName) {
    
    	this.title = MovieName;
    }
   
    
    /**
     * Constructor for movies class
     */
    public Movies() {
      
    	this.title = "";
    }

    
    /**
     * Getter for return name of movies
     * @return name of movies
     */
    public String getTitle() {
        
    	return title;
    }

    @Override
    public String toString() {
    	
    	return "Movie: " + title + '\n';
    }

}