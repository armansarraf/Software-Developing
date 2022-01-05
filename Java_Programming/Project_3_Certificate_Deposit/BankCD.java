/**
 * Class Name: BankCD 
 * Role: Calculating a certificate of deposit.
 * 
 * Attributes: Three instances from double
 * Behaviors: Constructors, calcYearly(), calcDaily()
 * 
 * @author Arman Sarraf
 */
public class BankCD {

		private double principal; 
		private double rate;
		private double year;
		
		
		public BankCD(double p, double r, double y) {
			this.principal = p;
			this.rate = r;
			this.year = y;
		} // Constructor of BankCD class. gets three double variable to set to the defined instance variables.

		public double calcYearly() {
			double a;
			a = principal * Math.pow(1 + rate, year);
			return a;
			/**
			 * This method calculates yearly maturity value of a CD.
			 * @return  yearly value of CD
			 */
		}
		
		public double calcDaily() {
			double a;
			a = principal * Math.pow(1 + rate/365, 365*year);
			return a;
			/**
			 * This method calculates daily maturity value of a CD.
			 * @return daily value of CD
			 */
		}
		
}
