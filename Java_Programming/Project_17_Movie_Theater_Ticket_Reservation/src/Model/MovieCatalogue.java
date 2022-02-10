package Model;

import java.util.ArrayList;


public class MovieCatalogue {
    
	private ArrayList<Movies> movies;

    /**
     * constructor for the MovieCatalogue
     *
     * @param movies
     */
    public MovieCatalogue(ArrayList<Movies> movies) {
        
    	this.movies = movies;
    }

    /**
     * Constructor for MovieCatalogue
     */
    public MovieCatalogue() {
        this.movies = new ArrayList<Movies>();
    }

 

    /**
     * Setter to the arraylist of movie catalogues
     */
    public void addMovie(Movies movie) {
        this.movies.add(movie);
    }

    /**
     * getter for the arraylist of movies in catalogue
     */
    public ArrayList<Movies> viewMovies() {
        return movies;
    }
}