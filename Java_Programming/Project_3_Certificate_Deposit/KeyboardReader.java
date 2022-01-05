import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class: KeyboardReader
 * Roll: Reading from standard in through a BufferedReader.
 * 
 * Attributes: reader
 * Behaviors: getKeyboardInput(), getKeyboardInteger(), getKeyboardDouble(), prompt(), display(), readKeyboard()
 * 
 * @author Arman Sarraf
 */
public class KeyboardReader {

	private BufferedReader reader; // Building an instance object from BufferedReader 
	
	public KeyboardReader() {
		reader = new BufferedReader(
					new InputStreamReader(System.in));
				
	} // Constructor, setting reader instance to InputStreamReader(System.in) to get input from user 

	public String getKeyboardInput(){ 
		return readKeyboard(); 
		/**
		 * getKeyboardInput() method returns the input value that has been read by reader 
		 * @return string
		 */	
	}
	
	public int getKeyboardInteger(){ 
		return Integer.parseInt(readKeyboard()); 
	} // Returns integer value of the user input
	
	public double getKeyboardDouble(){ 
		return Double.parseDouble(readKeyboard()); 
	} // Returns double value of the user input
	
	public void prompt(String s){ 
		System.out.print(s);
		/**
		 * This method is used to print the value of s which is string. Prompt method is used when we want to get value from user
		 * @param string s
		 */
	}
	
	public void display(String s){ 
		System.out.print(s);
		/**
		 * This method is used to show the result to the user
		 * @param string s
		 */
	}
	
	private String readKeyboard(){ 
		String line = "";
		try{ 
			line = reader.readLine(); 
		} catch (IOException e){ 
			e.printStackTrace();
		}
		return line; 
		/**
		 * This method is used to try to read the input from user by reader.readline() method. Then it returns the input string
		 * @return string line
		 */
	}
}

