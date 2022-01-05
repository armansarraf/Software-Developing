import javax.swing.*; 
import java.awt.*;
import java .awt. event .*;
/**
 * Class Name: SecretWordGUI
 * Role: This classes is defined to prompt the user to guess a char. It then, determines if the input char is in the secret word, if yes, it will show the updated word to user,
 * and if the char guessed by user was not in the secret word, it returns a message containing the guess was wrong.
 *  
 * Attributes: inputField, display, inputString, secret
 * Behaviors: Constructor, actionPerformed(), main()
 *  
 * @author Arman Sarraf
 */
public class SecretWordGUI extends JFrame implements ActionListener{

	private JTextField inputField; 
	private JTextArea display;
    private String inputString;
    private SecretWord secret;

	public SecretWordGUI(String title)  {
		secret = new SecretWord("downtown"); // Building an instance of SecretWord and defining "downtown" as the secret word
		
		JLabel prompt = new JLabel("Input a single character to guess the secret word (hit ENTER):");

		inputField = new JTextField(5); 
		inputField.setText("");
		inputField.addActionListener( this ); 

		display = new JTextArea (10 ,30);
		display.append("The secret word: " + secret.getDisplayedWord() +"\n");

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2));
		panel.add(prompt);
		panel.add(inputField);

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		contentPane.add("Center", panel);
		contentPane.add("South", display);

		setTitle(title);             
		pack();
		setVisible(true);

	}
	/**
	 * This method, when the user types a char and presses enter, gets the char, pass it through the makeGuess() method to determine if the character exist in the secret word or not. 
	 */
	public void actionPerformed(ActionEvent evt)  { 
		if ( evt.getSource() == inputField) { 
			inputString = inputField.getText();
	        inputField.setText("");
	        boolean guess = secret.makeGuess(inputString.charAt(0));

	                            // Process the user's guess
	        if (guess == true) 
	            display.append ("That Guess Was Right " + secret.getDisplayedWord() + "\n"); // if the input char exists in the secret word this line will be executed. 
	        else 
	            display.append ("That Guess Was Wrong " + secret.getDisplayedWord() + "\n"); // if the input char does not exist in the secret word this line will be executed.

		}
	}

	public static void main(String[] args) {

		//Starting the GUI application
		new SecretWordGUI("Guess the secret word");

	}

}

