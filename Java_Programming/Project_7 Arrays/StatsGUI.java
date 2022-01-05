import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 
 * Partial implementation of the Stats GUI
 *
 * @author Arman Sarraf
 */
public class StatsGUI extends JFrame implements ActionListener {
	private JLabel prompt = new JLabel("Next Grade (press ENTER)");
	private JTextField inField;
	private JTextArea display;
	private JButton reset, displayStats;
	// TODO: Add stats instance variable
	private Stats stats; // Adding stats instance variable
	String showNumber = ""; // Defining an empty string

	public StatsGUI(String title) { 
		
		//TODO: Instantiate stats object
		stats = new Stats();
		
		inField = new JTextField(4);
		inField.addActionListener(this);
		
		display = new JTextArea("", 5, 20);
		
		reset = new JButton("RESET");
		reset.addActionListener(this);
		
		displayStats = new JButton("STATS");
		displayStats.addActionListener(this);

		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(0, 2));
		inputPanel.add(prompt);
		inputPanel.add(inField);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(0, 2));
		buttonPanel.add(displayStats);
		buttonPanel.add(reset);

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add("North", inputPanel);
		contentPane.add("Center", display);
		contentPane.add("South", buttonPanel);

		setSize(500, 200);
		setTitle(title);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == inField) {
			int number = Integer.parseInt(inField.getText());
			// TODO: ADD THE GRADE TO stats
			stats.add(number); // Adding the number the user inputs into the array
			showNumber += " " + String.valueOf(number); // putting the input number into a string to show to the user
			inField.setText(""); // Clearing the field text for next input
			display.setText(showNumber); // Showing the numbers the user input in GUI
			
		} // Using if condition to do the mentioned things if enter button pressed by user.
		
		//TODO: Add handling of display button -  DISPLAY THE RESULTS
		if (e.getSource() == displayStats) {
			display.setText(showNumber + "\n" + stats.toString());
		} // If the stats button pressed by user, it shows the final result by calling toString() method from stats class
		
		// TODO: Add handling of reset button - CREATE A NEW stats
		if (e.getSource() == reset) {
			stats = new Stats();
			display.setText("");
			showNumber = "";
		} // If the reset button pressed by user, it creates a new stats instance and clears the screen and value of showNumber string
	}

	public static void main(String[] args) {
		new StatsGUI("Mean and median");
	}
}
