//==============================================
// Andrew Asquith
// COMP 1231
// Assignment 3
// IntegerAveragerDriver Class 
//
// This is the IntegerAveragerDriver class.
// It prompts for 10 integers and passes them to the
// IntegerAverager class for processing.
// It will handle invalid input by echoing it back to
// the user with an error message and then re-prompting 
// for another valid integer to be entered
// There is no option for the user to quit early or try again
//

// import the DecimalFormat class for the average
import java.text.DecimalFormat;
//import the scanner class to read the user input
import java.util.Scanner;

public class IntegerAveragerDriver {

	public static void main(String[] args) {

		// the total number of numbers to read
		final int NUMBER_REQUIRED = 10;

		//temporary storage of the user input
		String userInput;

		// the IntegerAverager instance that will do the math
		IntegerAverager averager = new IntegerAverager();
		
		// setup to read the input from system.in
		Scanner inputScanner = new Scanner(System.in);
		
		// prompt for input
		do {
			System.out.print("Enter integer " 
						+ (averager.getNumberOfSubmissions() + 1) 
						+ " of " +  NUMBER_REQUIRED +": ");
			
			// read the users input as a string
			userInput = inputScanner.next();
			try {
				
				// try and parse the input into an integer and add it total
				averager.addNumberToTotal(Integer.parseInt(userInput));

			//parsing the string failed
			} catch (NumberFormatException ex) {
				
				// echo input back with a message about it not being valid
				System.out.println("\"" + userInput + "\" is not a valid integer!");
			}

			// for simple debugging, uncomment to see state after each input
			// System.out.println(averager);
			
			// need to collect NUMBER_REQUIRED integers, loop until we have them
		} while (averager.getNumberOfSubmissions() < NUMBER_REQUIRED);
		
		
		//number formatter for 1 decimal place in case we don't stick with 10 numbers
		DecimalFormat formatter = new DecimalFormat("#0.0");
		
		// and print it out to 1 decimal place
		System.out.println("Average of submitted numbers was: " 
					+ formatter.format(averager.getAverage()));
		
		
		// say goodbye, user must re-run if another round is desired
		System.out.println("All done!");
	}
}