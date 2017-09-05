
public class PascalTriangleDriver {

	public static void main(String[] args) {

		final int NUM_LINES = 10;

		// original implementation
		PascalTriangle triangleCalculator = new PascalTriangle();

		// capture the lines into an array for printing
		int[][] triangleArray = new int[NUM_LINES][];

		// for each of the 10 lines
		for (int i = 0; i < NUM_LINES; i++) {
			// generate the line and then print it
			triangleArray[i] = triangleCalculator.getLine(i + 1);
			printPascalLine(triangleArray[i]);
		}
		
		System.out.println("----------------------");
		
		// more efficient implementation that re-uses calculations where
		// possible
		// provide the desired number of lines to the constructor
		BetterPascalTriangle betterTriangle = new BetterPascalTriangle(NUM_LINES);

		for (int i = 0; i < NUM_LINES; i++) {
			// for each of the desired lines, retrieve and print it
			printPascalLine(betterTriangle.getLine(i + 1));
		}
		
		

	}

	// helper method to print out the contents of an array
	private static void printPascalLine(int[] line) {
		for (int i = 0; i < line.length; i++) {
			System.out.print(line[i] + " ");
		}
		System.out.println();
	}

}
