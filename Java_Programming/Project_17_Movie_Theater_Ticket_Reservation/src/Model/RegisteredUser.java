package Model;

import java.time.LocalDate;
import java.sql.Date;


public class RegisteredUser extends User {
    
	private String username;
    
	private String password;
    
	private Date subsRenew;

   
	
	/**
     * Constructor for initializing the user and pass
     */
	public RegisteredUser(String user, String pass) {
       
		this.username = user;
        
		this.password = pass;
    }

    
	
	/**
     * Initializing user information for guest category of users
     */
	public RegisteredUser(String name, String address, String bank, long cardNumber, int expirationDate, int cvv, String email, String username, String pass) {
     
		super(cardNumber, expirationDate, cvv, email, name, address, bank);
        
		this.username = username;
        
		this.password = pass;
    }

    public RegisteredUser(String name, String address, String bank, long cardNumber, int expirationDate, int cvv, String email, String username, String pass, Date renewDate) {
       
    	super(cardNumber, expirationDate, cvv, email, name, address, bank);
        
    	this.username = username;
        
    	this.password = pass;
        
    	subsRenew = renewDate;
    }

    /**
     * Boolean to check if annual fee paid
     *
     * @return true or false
     */
    public boolean checkAnnualFee() {
      
    	if (subsRenew == null || subsRenew.compareTo(Date.valueOf(LocalDate.now())) < 0)
        
    		return false;
        else
            return true;
    }

  
    
    /**
     * Boolean to check if password is valid
     *
     * @return true or false
     */
    boolean confirmPass(String pass) {
        
    	return password.equals(pass);
    }
    
    
    /**
     * Boolean to check if account is active or not
     *
     * @return true or false
     */
    public void confirmAnnualFee() {
        
    	subsRenew = Date.valueOf(LocalDate.now().plusDays(365));
    }

   
    
 
    public Date getAnnualPaymentDate() {
       
    	return subsRenew;
    }
}