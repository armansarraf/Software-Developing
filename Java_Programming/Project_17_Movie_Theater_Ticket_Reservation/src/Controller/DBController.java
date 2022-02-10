package Controller;



import Model.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBController {
    
	/**
     * data base controller class
     */
    private static MovieCatDBController movie_db = new MovieCatDBController();
    
    
    /**
     * user database and movie database
     */
    private static BankClientDBController user_db = new BankClientDBController();
   
    
    
    
    /**
     * Populates the catalogue for theater with the database
     * @param movies an object of MovieCatalogue
     */
    private static void populateTheaterCatalogue(TheaterCatalogue theaters, MovieCatalogue movies) {
   
        MovieCatDBController data_base = new MovieCatDBController();

        ArrayList<Theater> lst_theater = data_base.selectTheaters();
      
        for (int i = 0; i < lst_theater.size(); i++) {
        
        	theaters.addTheater(lst_theater.get(i));
        }

        for (int i = 0; i < theaters.viewTheaters().size(); i++) {
        
        	addDefaultTheaterRooms(theaters.viewTheaters().get(i));
        }

        data_base.selectAndAddShowTimes(theaters, movies);
    }
    
    

    /**
     * Populates the catalogue for movies
     * @param movies an object of MovieCatalogue
     */
    private static void populateMovieCatalogue(MovieCatalogue movies) {
     
        MovieCatDBController data_base = new MovieCatDBController();
        
        ArrayList<Movies> lst_movies = data_base.selectMovies();

        for (int i = 0; i < lst_movies.size(); i++) {
        
        	movies.addMovie(lst_movies.get(i));
        }
    }

    /**
     * Load reservation 
     */
    public static ReservationModel loadBookingManager() {
     
    	MovieCatalogue movies = new MovieCatalogue();
        
    	TheaterCatalogue theaters = new TheaterCatalogue();
        
    	HashMap<Integer, MovieTicket> reservations = new HashMap<>();

        
    	populateMovieCatalogue(movies);
        
    	populateTheaterCatalogue(theaters, movies);
        
    	populateAndRegisterReservations(reservations, theaters);

        ReservationModel manager = new ReservationModel(movies, theaters, reservations);
        
        return manager;
    }
    
    /**
     * Load databases in the format of map <key, value>
     */
    public static Map<String, FinancialInstitute> load_banks() {
      
    	ResultSet result_set = user_db.getBanks();
        
    	ArrayList<String> lst_banks = new ArrayList<>();

        
    	Map<String, FinancialInstitute> map_banks = new HashMap<>();
        
    	ArrayList<CreditCard> lst_credit_cards;

        try {

            do {
            
            	lst_banks.add(result_set.getString("Name"));
            
            } while (result_set.next());

            for (int i = 0; i < lst_banks.size(); i++) {

                String bank_name = lst_banks.get(i);
            
                result_set = user_db.getCreditCards(bank_name);

                lst_credit_cards = new ArrayList<>();
                
                do {
               
                	long credit_card_number = Long.parseLong(result_set.getString("Card_no"));
                    
                	int credit_card_cvv = result_set.getInt("Card_cvv");
                    
                	int credit_card_exp = result_set.getInt("Card_exp");
                    
                	lst_credit_cards.add(new CreditCard(credit_card_number, credit_card_exp, credit_card_cvv));
                
                } while (result_set.next());

                map_banks.put(bank_name, new FinancialInstitute(bank_name, lst_credit_cards));
            }

           
            return map_banks;
        
        } catch (SQLException e) {
        
        	e.printStackTrace();
        }
       
        return null;
    }


    /**
     * load coupons
     * @return
     */
    public static Map<Integer, Coupon> load_coupons() {
       
    	// get coupons
       ResultSet result_set = user_db.getCoupons();
        
    	Map<Integer, Coupon> map_coupons = new HashMap<>();
        
        
    	try {
        
    		do {
            
    			int coupon_id = result_set.getInt("voucherID");
            
    			double credit_card = result_set.getDouble("Credit");
                
    			Date expr_date = result_set.getDate("Expr_Date");
              
    			map_coupons.put(coupon_id, new Coupon(coupon_id, credit_card, expr_date));
            
    		} while (result_set.next());

            return map_coupons;
        
    	} catch (SQLException e) {
        
    		e.printStackTrace();
        }
       
    	return null;
    }


    public static Map<String, RegisteredUser> load_registered_users() {
    
    	ResultSet result_set = user_db.getRegisteredUsers();
        
    	Map<String, RegisteredUser> registered_users = new HashMap<>();

        try {
        
        	do {
            
        		String user_name = result_set.getString("Username");
                
        		String password = result_set.getString("Password");
                
        		Date renew_date = result_set.getDate("Fee_renew_date");
                
        		String name = result_set.getString("Name");
                
        		String address = result_set.getString("Address");
                
        		String bank = result_set.getString("Bank");
                
        		String email = result_set.getString("Email");
                
        		long credit_card_number = Long.parseLong(result_set.getString("Card_no"));
                
        		int credit_card_cvv = result_set.getInt("Card_cvv");
                
        		int credit_card__exp = result_set.getInt("Card_exp");
                
        		registered_users.put(user_name, new RegisteredUser(name, address, bank, credit_card_number, credit_card__exp, credit_card_cvv, email, user_name, password, renew_date));

            } while (result_set.next());


        	return registered_users;
        
        } catch (SQLException e) {
        
        	e.printStackTrace();
        }
       
        return null;
    }

      
    
    /**
     * Generates theater rooms for theater
     * @param theater object of theater
     */
    private static void addDefaultTheaterRooms(Theater theater) {
    
    	theater.addTheaterLocation(new TheaterRoom(1, new SeatLocation())); 
        
    	theater.addTheaterLocation(new TheaterRoom(2, new SeatLocation())); 
        
    	theater.addTheaterLocation(new TheaterRoom(3, new SeatLocation())); 
        
    	theater.addTheaterLocation(new TheaterRoom(4, new SeatLocation())); 
        
    	theater.addTheaterLocation(new TheaterRoom(5, new SeatLocation())); 
    }

   
    private static void populateAndRegisterReservations(HashMap<Integer, MovieTicket> reservation, TheaterCatalogue theaters) {
      
    	// add reservation into the seatmap and include in hashtable with reservation from data_base
        
    	MovieCatDBController data_base = new MovieCatDBController();
        
    	data_base.retrieveReservation(reservation, theaters);
    }
}