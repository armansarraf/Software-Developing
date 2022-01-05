/**
 * Class Name: Days 
 * Role: Calculating the total number of days in a specific month
 * 
 * Attributes: integer day
 * Behaviors: Constructors, howManyDays()
 * 
 * @author Arman Sarraf
 */
public final class Days {
	
	private Days() {
		
	} // Private constructor 
	
	public static int howManyDays(int month) {
		int days=0;
		if(month == 2) {
			days = 28;
		}
		if (1 <= month && month < 8 && month != 2) {
				if (month % 2 == 1) {
					days = 31;
				}
				else if (month % 2 == 0) {
					days = 30;
				}
		}
		if (8 <= month && month <= 12) {
			if (month % 2 == 0) {
				days = 31;
			}
			else if (month % 2 == 1) {
				days = 30;
			}	
	}
		return days;
		/**
		 * howManyDays method gets the number of the month, and with the help of if statements determines the number of days
		 * that month has. 
		 * @param int month
		 * @param int day
		 * @return days
		 */
	}
}