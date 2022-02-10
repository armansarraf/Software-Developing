package Model;

public class User {

    private String name;
    private String address;
    private String financialInstitution;
    private String email;
    private long creditCardNumber;
    private int cvv;
    private int cardExpiration;

   
    
    public User() {
    }

    /**
     * Initialize a user object
     * @param cardNumber
     * @param expirationDate
     * @param cvv
     * @param email  
     * @param name  
     * @param address    
     * @param bank    
     */
    public User(long cardNumber, int expirationDate, int cvv, String email, String name, String address, String bank) {
        
    	this.creditCardNumber = cardNumber;
        
    	this.cardExpiration = expirationDate;
        
    	this.cvv = cvv;
        
    	this.email = email;
        
    	this.name = name;
        
    	this.address = address;
        
    	this.financialInstitution = bank;

    }
    
    //getter methods
    public long getCredit_card_no() {
   
    	return creditCardNumber;
    }

   
    
    public int getCard_exp() {
    
    	return cardExpiration;
    }

    
    public int getCard_cvv() {
   
    	return cvv;
    }

   
    public String getName() {
    
    	return name;
    }

    
    public String getAddress() {
    
    	return address;
    }

    
    
    public String getFinancialInstitution() {
    
    	return financialInstitution;
    }

    
    public String getEmail() {
    
    	return email;
    }
    
   
    public String printTicket(MovieTicket ticket) {
    
    	String confirmation = "Thank you " + name + " for your purchase,\n";
        
    	confirmation += "below is your ticket information and receipt:\n\n";
        
    	confirmation += ticket.toString();
        
    	return confirmation;
    }
    
    
    public String mailCoupon(String coupon) {
    
    	String confirmation = "Thank you " + name + "Please find below your coupon information:\n";
        
    	confirmation += coupon;
        
    	return confirmation;
    }
}