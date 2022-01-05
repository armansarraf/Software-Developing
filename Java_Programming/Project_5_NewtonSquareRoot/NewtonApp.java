/**
 * Class Name: NewtonApp
 * Role: prompt the user to enter their number, their guess, and the maximum tolerance that they would like. This class gives the instruction to user,
 * and gets the input value from user, make an instance from NewtonTester class and passes values to it in order to get back the real root and number of required iterations.
 *  
 * Attributes: Instances from KeyboardReader, NewtonTester
 * Behaviors: Constructor, run()
 *  
 * @author Arman Sarraf
 */
public class NewtonApp {

	private KeyboardReader reader;
	private NewtonTester newtontester;
	
	public NewtonApp() {
		reader = new KeyboardReader();
	} // Constructor
	
	/**
	 * Method run() asks the user to input number, guess, error. It then, reads the user input with the help of KeyboardReader.
	 * After that, this method makes a new instance variable from NewtonTester class to pass and set the values to it.
	 * Finally, it calls the methods exist in NewtonTester to do the calculation and returns the desired values.
	 * 
	 * @param (double)number
	 * @param (double)guess
	 * @param (double)error
	 */
	public void run(){
		double number;
		double guess;
		double error;
	reader.prompt("Please Enter Your Number (the number should be non-zero and positive): >");
	number = reader.getKeyboardDouble(); // Sets the number's value (double) to the input user value 
	reader.prompt("Please Enter Your Guess (the number should be non-zero and positive): >");
	guess = reader.getKeyboardDouble(); // Sets the guess's value (double) to the input user value
	reader.prompt("Please Enter Maximum Error (Preferred 0.001): >");
	error = reader.getKeyboardDouble(); // Sets the errors's value (double) to the input user value
	newtontester = new NewtonTester(number,guess, error);
	reader.display("The real root is: " + newtontester.sqrt() + " and the number of iterations are: "
					+newtontester.getCount()); // This line shows the result returned from sqrt()method and getCount() method. 
	}
	
public static void main(String[] args) {
		
	NewtonApp newtonapp = new NewtonApp();
	newtonapp.run();
}
}


