
/**
 * Class Name: Temperature 
 * 
 * Role: Temperature class is designed to get a value as Fahrenheit degree ,convert it to
 * Celsius degree, and display the temperature in both Fahrenheit and Celsius. 
 * 
 * Attributes: One instance from double which keeps the Fahrenhiet degree.
 * 
 * Behaviors: Main(), two constructors, getFahrenheit(), getConvertToCelsius().
 * 
 * @author Arman Sarraf
 */

public class Temperature {
	
public static void main(String[] args) {
	
	Temperature thermometer1 = new Temperature(65.34); //making a new Obj from Temperature, and
	//giving 65.34 Fahrenheit degress to be set in degrees.
	
	System.out.println("The Fahrenheit temperature of thermometer 1 is" + " "
			+ thermometer1.getFahrenhiet() + " degrees."); //printing the Fahrenheit value for
	//thermometer 1.
	
	System.out.println("The Celsius temperature of thermometer 1 is" + " " +
			thermometer1.getConvertToCelsius() + " degrees."); //printing the Celsius value for
	//thermometer 1.
	
	Temperature thermometer2 = new Temperature(20); //making a new Obj from Temperature, setting
	//degrees as 20f.
	System.out.println("---------------"); //separate thermometer 1 and 2 from each other.
	
	System.out.println("The Fahrenheit temperature of thermometer 2 is" + " "
			+ thermometer2.getFahrenhiet() + " degrees."); //printing the Fahrenheit value.
	
	System.out.println("The Celsius temperature of thermometer 2 is" + " " +
	thermometer2.getConvertToCelsius() + " degrees."); //printing the Fahrenheit value.
	}
	
	
	private double degrees = 32; // an instance to keep Fahrenheit degree in memory.
	/**
	 * Class constructor (pre-defined)
	 */
	public Temperature() {
		
	}
	
	/**
	 * Class constructor
	 * @param directInput to be set in degrees
	 */
	public Temperature(double directInput) {
		this.degrees = directInput;
	} // This constuctor sets the given input value from user in main() to "degrees".
	
	/**
	 * This method returns the value of degrees in Fahrenheit
	 * @return degrees in Fahrenheit
	 */
	public double getFahrenhiet(){
	
		return Math.round(degrees * 100.0) / 100.0; //Using Math.round... to roundoff the number
		//to 2 decimal places as shown in the output example.
	}
	
	/**
	 * This method converts the value of degree to Celsius and then, retunrs it.
	 * @return degrees in Celsius
	 */
	public double getConvertToCelsius() {
		double celsius = 5 *(degrees -32) /9; //setting celsius instance as celsius degree.
		
		return Math.round(celsius * 100.0) / 100.0;//Using Math.round... to roundoff the number
		//to 2 decimal places as shown in the output example.
	}
	

	

}
