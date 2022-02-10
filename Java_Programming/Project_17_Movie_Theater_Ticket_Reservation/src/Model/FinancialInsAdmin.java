package Model;

import java.util.Map;

public class FinancialInsAdmin {
   
	private Map<String, FinancialInstitute> FinancialIns;

    public FinancialInsAdmin(Map<String, FinancialInstitute> FinancialIns) {
    
    	this.FinancialIns = FinancialIns;
    }

    
    
    public boolean paymentProcess(String bank, long cardNum, int expiaryDate, int cvv, double transaction) throws CardInformationNotValid {
        
    	FinancialInstitute theFinancialInstitute = getBank(bank);
        
    	if (theFinancialInstitute == null) throw new CardInformationNotValid(); // throws error if card information is wrong
        
    	return theFinancialInstitute.paymentStep(cvv, transaction, cardNum, expiaryDate);
    }

    private FinancialInstitute getBank(String bankName) {
      
    	return FinancialIns.get(bankName.toUpperCase());
    }

}