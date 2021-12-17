import java.lang.reflect.Array;
/**
 * Stats class is designed to do some computations on array. It gets numbers, put them into an array, sort the array,
 * calculate the Mean, and Median of the numbers exist in the array. 
 * 
 * @author Arman Sarraf
 */
public class Stats {

	private int grades[]; // Defining an array named grades
	private int count; // Defining a counter named count
	
	/**
	 * Default constructor. Setting the value of the count to 0, and the length of the array to 100.
	 */
	public Stats() {
		grades = new int[100];
		count = 0;
	}
	
	/**
	 * add() method gets a number as an input, puts it in the next position in array and increments the counter. 
	 * @param number
	 */
	public void add(int number) {
		
			grades[count] = number;
			count++;
		
	}
	/**
	 * INSERTION SORT OF THE FIRST n ELEMENTS OF ARRAY arr 
	 * SEE PAGE 407 TO PAGE 410
	 * FOR A DISCUSSION
	 * 
	 * @param grades
	 * @param count
	 */
	public void sort(int[] grades, int count) {
		int temp, j, k;
		for (j = 1; j < count; j++) {
			temp = grades[j];
			for (k = j - 1; (k >= 0) && (grades[k] > temp); k--) {
				grades[k + 1] = grades[k];
			}
			grades[k + 1] = temp;
		}
	}
	
	
	/**
	 * getMean() method calculates the average of the numbers that we have put into the array, and then returns it.
	 * @return mean
	 */
	public double getMean() {
		double total = 0;
		int i = 0;
		for(i = 0; i<count; i++) {
			total += grades[i];
		} // A for-loop is used to sum up the grades we put into array 
		return (total / i); // It then subtracts the sum by the number of grades we have put into array and returns it
		}
	
	/**
	 * 	This method is defined to return the Median value of the grades we put into the array. So we should sort the array so that we could count the Median.
	 * We have to scenario for that: 1- if the length of the grades be odd, it returns the  number in between them, if the length be even,
	 * it returns the average of (length-1/2 + length/2) / 2
	 * @return median
	 */
	public double getMedian() {
		sort(grades, count); // Sorting the array 
		double length = count ;
		double median = 0;
		if (length % 2 != 0) {
			median = (double)(grades[count / 2]);
		} // Counting the median for numbers with length odd
		else {
			median = ((double)( grades[(count-1)/2] + grades[count/2] ) / 2);
		}// Counting the median for numbers with length even
		return median;
		}
	
	/**
	 * toString() method has been overrode to return the final result as a string. This method first use sort() method to sort the array, then puts the sorted number into a string,
	 * and then, returns the sorted numbers, average, and median.
	 * @return string
	 */
	@Override
	public String toString() {
		String sortedList = "";
		sort(grades, count); // Sorting the numbers we have put into list
		for (int i = 0; i<count; i++) {
			sortedList += " " + grades[i];
		} // Using a for-loop to get the sorted numbers from the array
		
		return "The sorted list of grades is: " + sortedList + "\n" + "The average of numbers is: " + getMean() +
				"\n" + "The Median of numbers is: " + getMedian(); // Returning the number-list, its average, and its median
	}
}
