/**
 * Class Name: NewtonTester
 * Role: Calculating the root of a number using Newton method. This class gives the number, the guess of the root number,
 * 	and the tolerance which is the maximum allowed value of difference between two consecutive Newton computations.
 *  
 * Attributes: count for iterating the number of computations, number, guess, max_error 
 * Behaviors: Constructor, sqrt()
 *  
 * @author Arman Sarraf
 */

public class NewtonTester {
	private int count = 1;
	private double number;
	private double guess;
	private double max_error;
	
	public NewtonTester(double n, double guess, double max_error) {
		this.number = n;
		this.guess = guess;
		this.max_error = max_error;
	} // Constructor
	
	/**
	 * sqrt() method calculates the real root of the number with guessed number. It uses a while loop to determine if the difference between two consecutive new guesses is less than max_error.
	 * It also keeps track of iteration was required to get to real root from initial guess. Note that the iteration starts from 1! Because while loop calculates at least once to see 
	 * if the guess matches the real root.
	 * 
	 * @return guess (original root)
	 */
	public double sqrt() {
		while (true) {
			double previous_root = guess; // keep the previous computed guess
			guess = (( number / guess) + guess) / 2; // Newton Method
			if (Math.abs(guess - previous_root) < max_error) {
				break;
			} // if statement checks if the value of difference between two consecutive Newton computation is less than max_error. If true, we have the real root and loop is finished.
				// otherwise, previous_root's value changes to guess value, and the loops repeat again.
			else {
				previous_root = guess;
			}
			count++;
			}	
			return guess;
	}
	
	public int getCount() {
		return count;
	} // returns the value of count (iterations)
	
}
