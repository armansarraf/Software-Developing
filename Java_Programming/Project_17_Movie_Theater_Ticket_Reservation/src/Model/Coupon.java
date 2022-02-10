package Model;

import java.time.LocalDate;
import java.sql.Date;
import java.util.Random;

public class Coupon {

	private int couponID;
    
	private double couponValue;
    
	private Date expirationDate;
    
	
    public Coupon(int coupon_id, double credit) {
    
    	this.couponID = coupon_id;
    	
    	this.couponValue = credit;
		
    	expirationDate = Date.valueOf(LocalDate.now().plusDays(365));        // expiration date

    }

   
    public Coupon(int coupon_id, double credit, Date expirationDate) {
    	
    	this.couponID = coupon_id;
    	
    	this.couponValue = credit;
    	
    	this.expirationDate = expirationDate;
    }

	
    
    
    public double getCouponValue() {
		
		return couponValue;
	}

    
	
	
	public boolean isValid() {
    	
    	return expirationDate.compareTo(Date.valueOf(LocalDate.now())) > 0;
    }

        
    
    public double useCoupon(double fee) {
    
    	if (couponValue >= fee) {
		
    		couponValue -= fee;
        	
    		
    		return 0;
    	
    	} else {
    	
    		double remaining = fee - couponValue;
			
    		couponValue = 0;
    		
    		return remaining;
    	}
    }

    
    
//	printing information of coupons
    public String toString() {
    
    	String info = "\n***\n*** Coupon\n***\n";
    	
    	info += "Coupon ID: " + couponID + "\n";
    	
    	info += "Credit: " + couponValue + "\n";
    	
    	info += "Expiration Date: " + expirationDate + "\n";
    	return info;
    }
}