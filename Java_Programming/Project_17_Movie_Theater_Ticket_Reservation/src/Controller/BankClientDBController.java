package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankClientDBController {

   
	// connection of JDBC driver and database address
    private final String db_jdbc = "com.mysql.cj.jdbc.Driver";
    
    private final String db_address = "jdbc:mysql://localhost";

    // Database username, password
    // Please CHANGE password because this one will give you error
    private final String username = "root";
    
    private final String password = "9788";


    // Database Attributes
    protected Connection connection; // Connection object to establish a connection with our database
    
    protected PreparedStatement statement; //Statement object to run the query
    
    protected ResultSet result_set;// ResultSet object to keep the result of query

    
    
    
    /**
     * Method for initializing and establishing connection
     *  
     * */
    public BankClientDBController() {
    
    	try {
                    
    		connection = DriverManager.getConnection(db_address, username, password); // connection initialized
            
    		String query = "USE MOVIETHEATERUSER";
            
    		statement = connection.prepareStatement(query);
            
    		statement.executeUpdate();
       
    	} catch (SQLException e) {
        
    		System.out.println("There is an issue with connecting to database");
            
    		e.printStackTrace();
        }
    }

    
    
    /**
     * Method to fetch information of user from the database
     * returns user information for registered users or returns null
     * 
     * */
    public ResultSet getRegisteredUsers() {
    
    	String query = "SELECT * FROM REGISTERED;";
        
    	try {
        
    		statement = connection.prepareStatement(query);
            
    		result_set = statement.executeQuery();
            
    		if (result_set.next())
            
    			return result_set;

        
    	} catch (SQLException e) {
        
    		e.printStackTrace();
        }
       
    	return null;
    }

   
    
    
    /**
     * fetch information of coupons from database
     */
    public ResultSet getCoupons() {
      
    	String query = "SELECT * FROM VOUCHER;";
        
    	try {
        
    		statement = connection.prepareStatement(query);
            
    		result_set = statement.executeQuery();
            
    		if (result_set.next())
            
    			return result_set;

        } catch (SQLException e) {
      
        	e.printStackTrace();
        }
        return null;
    }

    
    /**
     * fetch financial information from the database
     * 
     */
    public ResultSet getBanks() {
    
    	String query = "SELECT * FROM BANK;";
        
    	try {
        
    		statement = connection.prepareStatement(query);
            
    		result_set = statement.executeQuery();
            
    		if (result_set.next())
            
    			return result_set;
        
    	} catch (SQLException e) {
        
    		e.printStackTrace();
        }
       
    	return null;
    }

    
    
    /**
     * fetch credit card information of user from the database
     * 
     * */
    public ResultSet getCreditCards(String bank) {
    
    	String query = "SELECT * FROM CREDITCARD WHERE BankName=?;";
        
    	try {
        
    		statement = connection.prepareStatement(query);
            
    		statement.setString(1, bank);
            
    		result_set = statement.executeQuery();
            if (result_set.next())
            
            	return result_set;

        } catch (SQLException e) {
      
        	e.printStackTrace();
        }
    
    	return null;
    }
}