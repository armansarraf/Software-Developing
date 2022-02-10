package MovieApp;
import java.io.IOException;
import java.util.Map;

import Controller.CentralController;
import Model.Admin;
import Model.RegisteredUser;
import Model.Coupon;
import Controller.DBController;
import Model.FinancialInsAdmin;
import Model.ReservationModel;
import View.MainGUI;
import View.UserView;
import View.LoginView;



/**
 * Class initializes the program and creates objects to run the program
 */
public class MovieTheaterApp {
	
	
	/**
	 * main() function
	 * @param args
	 */
    public static void main(String[] args) throws IOException {
    	
   	

    	ReservationModel reservationModel = DBController.loadBookingManager();
        
    	Map<Integer, Coupon> coupon = DBController.load_coupons();
        
    	Map<String, RegisteredUser> registeredUser = DBController.load_registered_users();
        
    	Admin admin = new Admin(registeredUser, coupon);

        FinancialInsAdmin financialInsAdmin = new FinancialInsAdmin(DBController.load_banks());

        CentralController centralController = new CentralController(new MainGUI(), reservationModel, admin, financialInsAdmin);
    }

}