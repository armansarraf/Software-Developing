/**
 * Class: DaysTester
 * Roll: Runs through all the months 1 - 12 and prints the number of days.
 * 
 * @author Arman Sarraf
 */

public class DaysTester {

	public static void main(String[] args) {
		for (int i= 1; i<= 12; i++) {
			System.out.println("The " + i + "th month has " + Days.howManyDays(i)+ " days." );
		} // For loop to print number of days in month 1 to 12
		

	}

}
