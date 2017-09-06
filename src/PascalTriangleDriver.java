//==============================================
// Andrew Asquith
// COMP 1231
// Assignment 3
// PascalTriangleDriver Class 
//
// This is the PascalTriangleDriver class.
// It gets and prints the first 10 lines from pascal's
// triangle from both the PascalTriangle 
// and BetterPascalTriangle classes
// it does NOT attempt to format the output into a triangle shape
// since the PascalTriangle classes do not return the whole triangle

public class PascalTriangleDriver {

	public static void main(String[] args) {

		// the number of lines from the triangle we want
		final int NUM_LINES = 22;

		System.out.println("----------------------");
		System.out.println("Original Implementation");
		System.out.println("----------------------");
		
		// original implementation
		PascalTriangle triangleCalculator = new PascalTriangle();

		System.out.println("Invalid Argument Exception:");
		// Negative input - should generate exception
		try {
			printPascalLine(triangleCalculator.getLine(-1));
		} catch (IllegalArgumentException e) {
			System.out.println("Got Exception: " + e.getMessage());
		}
		// capture the lines into an array for printing
		long[][] triangleArray = new long[NUM_LINES][];

		System.out.println("Lines 1 - " + NUM_LINES + ":");
		// for each of the lines
		for (int i = 0; i < NUM_LINES; i++) {
			// generate the line and then print it
			// there's no state so doing this out of order doesn't "prove"
			// anything
			triangleArray[i] = triangleCalculator.getLine(i + 1);
			printPascalLine(triangleArray[i]);
		}

		System.out.println("----------------------");
		System.out.println("Better Implementation");
		System.out.println("----------------------");

		// more efficient implementation that re-uses calculations where
		// possible

		// provide the desired number of lines to the constructor
		BetterPascalTriangle betterTriangle = new BetterPascalTriangle(NUM_LINES);

		// get a line from the "middle" of the triangle
		// in this case we do actually want the result of integer division
		System.out.println("Line " + (NUM_LINES / 2) + ":");
		printPascalLine(betterTriangle.getLine(NUM_LINES / 2));

		System.out.println("Invalid argument exceptions: ");
		try {
			// this should cause an illegal argument exception
			betterTriangle.getLine(NUM_LINES + 5);
		} catch (IllegalArgumentException e) {
			System.out.println("Got Exception: " + e.getMessage());
		}

		try {
			// this should cause an illegal argument exception
			betterTriangle.getLine(-5);
		} catch (IllegalArgumentException e) {
			System.out.println("Got Exception: " + e.getMessage());
		}

		System.out.println("Lines 1 - " + NUM_LINES + ":");
		for (int i = 0; i < NUM_LINES; i++) {
			// for each of the desired lines, retrieve and print it
			printPascalLine(betterTriangle.getLine(i + 1));
		}
	}

	// helper method to print out the contents of an array
	private static void printPascalLine(long[] line) {
		for (int i = 0; i < line.length; i++) {
			System.out.print(line[i] + " ");
		}
		System.out.println();
	}

}
