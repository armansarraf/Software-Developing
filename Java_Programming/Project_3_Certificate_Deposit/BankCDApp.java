import java.text.NumberFormat;

/**
 * Class Name: BankCDApp
 * Role: Representing command-line interface to compute yearly and daily compounded certificate of deposit.
 *  
 * Attributes: Instances from BankCD and KeyboardReader, three double variables
 * Behaviors: Constructor, run(), main()
 *  
 * @author Arman Sarraf
 */
public class BankCDApp {
	
	private BankCD bank;
	private KeyboardReader reader;
	
	public BankCDApp() {
		
		reader = new KeyboardReader(); // Making a new object from KeyboardReader
	} // Constructor
	
	public void run() {
		double p, r, y;
		reader.display("************************ OUTPUT ********************" + "\n");
		reader.display("Compare daily and annual compounding for a Bank CD." + "\n"); 
		reader.prompt(" Input CD initial principal, e.g.  1000.55 >"); // Giving instructions to user for getting principal
		p = reader.getKeyboardDouble(); // Reading user input and set it to 'p'
		
		reader.prompt(" Input CD interest rate, e.g.  6.5 >"); // Giving instructions to user for getting desired rate 
		r = (reader.getKeyboardDouble() / 100); // Reading user input and set it to 'r'
		
		reader.prompt(" Input the number of years to maturity, e.g., 10.5 >");// Giving instructions to user for getting year
		y = reader.getKeyboardDouble(); // Reading user input and set it to 'y'
		
		bank = new BankCD(p, r, y); // Building an object from BankCD class
	
		NumberFormat dollar = NumberFormat.getCurrencyInstance(); // Building a dollar object to show the currency symbol
		
		NumberFormat percentage = NumberFormat.getPercentInstance( ) ; // Building a percentage object to show the % symbol
		percentage.setMaximumFractionDigits(2) ; // Set percentage to show 2 Fraction digits
		
		
		reader.display("For Principal = " + dollar.format(p) + " Rate= " + percentage.format(r)+ " Years= " + y +"\n");
		reader.display(" The maturity value compounded yearly is " + dollar.format(bank.calcYearly()) + "\n");
		reader.display(" The maturity value compounded daily is " + dollar.format(bank.calcDaily())+ "\n");
		reader.display("************************ OUTPUT ********************" + "\n");
		
	/**
	 * Designing a command-line user interface to get data from user and show them the output result
	 */
	} 
	 
	
		

	public static void main(String[] args) {
		
		BankCDApp app = new BankCDApp();
		app.run();
		

	}

}
