package Model;

import java.util.ArrayList;


public class FinancialInstitute {
    private ArrayList<CreditCard> cardInformation;
    private String name;


    public FinancialInstitute(String name, ArrayList<CreditCard> cardInfo) {
        
    	this.name = name;
      
        this.cardInformation = cardInfo;
    }

    /**
     * Validates card info
     * @param an integer to hold cvv
     * @param a double to capture payment
     * @param an integer to capture card number
     * @param expirationDate to capture expire date
     */
    public boolean paymentStep(int cvv, double payment, long cardNumber, int expirationDate) {
      
    	for (CreditCard card : cardInformation) {
        
    		if (card.getCardNumber() == cardNumber &&
            
    				card.getExpirationDate() == expirationDate &&
                    
    				card.getCvv() == cvv) {
                
    			card.paymentPhase(payment);
               
    			return true;
            }
        }
        return false;
    }

}