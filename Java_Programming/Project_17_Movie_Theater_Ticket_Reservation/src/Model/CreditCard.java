package Model;


public class CreditCard {


	private long cardNumber;
    
	private int expirationDate;
    
	private int cvv;
    
	private double balance;
    
	private double limit;

    public CreditCard(long cardNumber, int expirationDate, int cvv) {

    	this.cardNumber = cardNumber;
        
    	this.expirationDate = expirationDate;
        
    	this.cvv = cvv;
        
    	balance = 0;
        
    	limit = 3000;
    }

    /**
     * Setters and getters
     * @return
     */
    public long getCardNumber() {
        return cardNumber;
    }

    public int getExpirationDate() {
        return expirationDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void paymentPhase(double payment) {
        balance += payment;
    }
}