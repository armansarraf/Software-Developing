package Model;

import java.util.Map;
import java.util.Random;

public class Admin {
  
	
	private Map<Integer, Coupon> coupon;
    
	
	private Map<String, RegisteredUser> registered_users;
   
	
	
	
	/**
     * Constructor for Admin class
     * 
     */ 
	public Admin(Map<String, RegisteredUser> registered_users, Map<Integer, Coupon> coupon) {
    
    	this.registered_users = registered_users;
        
    	this.coupon = coupon;
    }
    
	/**
     * Method is used for registered users to log in and if credintials is wrong it throws error
     * @param username string for capturing username
     * @param password an string to capture the password
     *  
     */ 
    public RegisteredUser login(String username, String password) throws WrongUsername,
    
    WrongPassword {
    
    	RegisteredUser theUser = registered_users.get(username);
        
    	if (theUser == null) throw new WrongUsername();
        
    	else {
        
    		if (theUser.confirmPass(password)) return theUser;
            
    		else throw new WrongPassword();
        }
    }

   
    
    
  
    public User newUser(long card_number, int expirartion_date, int cvv, String email, String name, String address, String bank_name) {
    
    	return new User(card_number, expirartion_date, cvv, email, name, address, bank_name);
    }


    /**
     * Method to register a new user 
     * 
     */ 
    public RegisteredUser registerUser(String name, String address, String bank, long card_number, int expiration_date, int cvv, String email, String username, String pass)
        
    	throws WrongUsername {
        
    	RegisteredUser newUser = new RegisteredUser(name, address, bank, card_number, expiration_date, cvv, email, username, pass);
        
    	newUser.confirmAnnualFee();
        
    	System.out.println(registered_users.keySet());
        
    	if (registered_users.containsKey(username)) throw new WrongUsername();
        
    	registered_users.put(username, newUser);
        
    	return newUser;
    }
   
    
    
    /**
     * Method to generate a coupon based on random numbers
     * 
     */   
    public String createCoupon(double credit) {
    
    	int coupon_id = 10000 + new Random().nextInt(90000);
        
    	while (coupon.containsKey(coupon_id)) coupon_id = 10000 + new Random().nextInt(90000);
    	        
    	Coupon myCoupon = new Coupon(coupon_id, credit);
        
    	coupon.put(coupon_id, myCoupon);
        
    	return myCoupon.toString();
    }

   
    
    public double useCoupon(int couponID, double price) throws InvalidCoupon,
     
    CouponTimeOut {
    
    	Coupon my_coupon = coupon.get(couponID);
        
    	if (my_coupon == null) throw new InvalidCoupon();
        
    	// remove coupon if balance invalid
        
    	else {
        
    		if (!my_coupon.isValid()) throw new CouponTimeOut();
       
    		double remainingBalance = my_coupon.useCoupon(price);
            
            if (remainingBalance > 0) coupon.remove(couponID);
            
            return remainingBalance;
        }
    }

   
    public double get_coupon(int couponID) throws InvalidCoupon {
    
    	Coupon myCoupon = coupon.get(couponID);
        
    	if (myCoupon == null) throw new InvalidCoupon();
        
    	return myCoupon.getCouponValue();
    }

   
  
    
    
    public String printTicket(User user, MovieTicket ticket) {
    
    	return user.printTicket(ticket);
    }

    
    
    
    public boolean checkFeeReturn(RegisteredUser regUser) {
   
    	return regUser.checkAnnualFee();
    }
}