//==============================================
// Andrew Asquith
// COMP 1231
// Assignment 3
// IntegerAverager Class 
//
// This is the IntegerAverager class.
// It has a private member to store a running total
// as well as the number of submissions that make
// up that total and an a method to compute the
// average of the numbers submitted

// import the decimal formatter so we can limit the output to 4 decimal places
import java.text.DecimalFormat;

public class IntegerAverager {

	
	// private members for the number of submissions and total
	private int numberOfSubmissions = 0, total = 0;
	
	
	// public accessor for the current total
	public int getTotal() {
		return total;
	}
	
	// public accessor for the number of submissions
	public int getNumberOfSubmissions() {
		return numberOfSubmissions;
	}

	// method for adding another number to the total, increases the submission count
	public void addNumberToTotal(int number) {
		total += number;
		numberOfSubmissions++;
	}
	
	// returns the average of the numbers submitted
	public double getAverage() {
		return (double) total / numberOfSubmissions;
	}
	
	// toString implementation describing the current state
	public String toString() {
		
		//number formatter for four decimal places
		DecimalFormat formatter = new DecimalFormat("#0.0000");
		
		return numberOfSubmissions + " numbers totalling " + total + " with an average of " + formatter.format(getAverage()); 
	}

}
