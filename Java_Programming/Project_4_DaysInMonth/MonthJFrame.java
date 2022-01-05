import javax.swing.*; 
import java.awt.*;
import java .awt. event .*;
/**
 * Class: MonthJFrame
 * Roll: Building a graphical user interface to get input value and show the result to the user
 * 
 * Attributes: inputField, display, enter
 * Behaviors: Constructor, ActionPerformed()
 * 
 * @author Arman Sarraf
 */
public class MonthJFrame extends JFrame implements ActionListener{
	
	private JTextField inputField; 
	private JTextArea display;
	private JButton enter;

	public MonthJFrame(String title)  {
		JLabel prompt = new JLabel("Input a month between 1 and 12 and press return:"); // Label shows a dialogue to the user
	
		inputField = new JTextField(10); 
		inputField.setText(""); // Text field shows nothing at beginning
		inputField.addActionListener( this ); 
		
		display = new JTextArea (1 ,30);
		
		enter = new JButton("Press to see the result"); // Defining what button should show to user
		enter.addActionListener( this );
		enter.setPreferredSize(new Dimension(20, 20));
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2));
		panel.add(prompt);
		panel.add(inputField);
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		contentPane.add("North", panel); // Set the panel to north side
		contentPane.add("Center", display); // Set the area to center 
		contentPane.add("South", enter); // Set the button to south side
		
		setTitle(title);
		setSize( 350, 150 );              
		pack();
		setVisible(true);
	/**
	 * MonthJFrame() method sets the area of field, panel, display, button,.. and builds the GUI
	 *   
	 */
	}
	
	public void actionPerformed(ActionEvent evt)  { 
		if ( evt.getSource() == inputField || evt.getSource() == enter ) { 
			//convert user input to an integer
			int number = Integer.parseInt(inputField.getText()); 
			display.setText("There are "+ Days.howManyDays(number) + " days in the chosen month!" ) ;
			//TODO: update display with number chosen and days calculated
			/**
			 * actionPerformed() method is used to get the input when the user press enter or pushes the button.
			 * Then passes the input data to the Days class hoManyDays method to get the number of the days and show it.
			 */
		}
	}
	
	public static void main(String[] args) {
		
		//Starting the GUI application
		new MonthJFrame("Days in month");

	}

}
