/**
 * Class Name: Tile
 *  
 *  Role: This program is designed to compare if the value of two objects are equal or not.
 *  
 *  Attributes: We have instance from char which contains the letter, integer instance for keeping the value
 *  of the mentioned letter, and counter for counting the number of object being created from tile.
 *  
 *  Behaviors: toString(), equals(), main()
 *
 *	@author Arman Sarraf
 */
public class Tile extends Object {
	
	public static void main(String[] args) {
		// Testing constructors and toString() method
		Tile tile1 = new Tile(); // Build an object from Tile (use pre-defined values).
		System.out.println(tile1.toString()); // Print tile1 values.
		Object tile2 = new Tile('A',1); // Build an object from Tile with desired values.
		System.out.println(tile2.toString()); // Print tile2 values.
		Object tile3 = new Tile('d',5); // Build an object from Tile with desired values.
		System.out.println(tile3.toString()); // Print tile3 values.
		
		// Testing equals() method
		System.out.println("Tile 1 is equal to Tile 2 is : " + tile1.equals(tile2)); // Compare value Tile[1] with Tile[2].
		System.out.println("Tile 2 is equal to Tile 3 is : "+ tile2.equals(tile3)); // Compare value Tile[2] with Tile[3].
		
	}

	static int counter = 0; // Defining a counter to count the number of objects built.
	private int value = 1; // Defining integer value.
	private char letter = 'A'; // // Defining character value.
	
	{
		counter++; // Every time an object is built from Tile, counter is increased one unit.
	} 
	
	/**
	 *  Class constructor (pre-defined)
	 */
	public Tile() {
	
	}
	
	/**
	 * Class constructor
	 * @param inputLetter set the entered value (Char) in main, to letter. 
	 * @param inputValue set the entered value (integer) in main, to value.
	 */
	public Tile(char inputLetter, int inputValue) { // Constructor gets char, int as values to set the variables.
		
	this.letter = inputLetter;
	this.value = inputValue;
	}
	
	/**
	 * toString() method has been over-ride.
	 * @return the string which includes the value of counter,char, and the value of integer when the method is called.
	 */
	@Override
	public String toString() {
		return ("Tile "+Tile.counter+": " + this.letter + "[" + this.value + "]"); // returns the value of counter,
		//char, and the value of integer
	}
	
	/**
	 * equals() method has been over-ride.
	 * @return to return the boolean value (True / False) of comparison of two objects.
	 */
	@Override
	public boolean equals(Object object) {
		
		if (object == null) {
			return false;
		}
		
		if(this.getClass() != object.getClass()) {
			return false;
		}
		
		final Tile inputFromUser = (Tile)object; // Set the 'object' as Tile object in order to be compared with another object.
		
		if (this.letter != inputFromUser.letter | this.value != inputFromUser.value) {
			return false;
		}
		
		return true; // Compare value of characters and return True if they are the same, else False.
		
	}

}
