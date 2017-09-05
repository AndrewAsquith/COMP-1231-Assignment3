
public class BetterPascalTriangle extends PascalTriangle {

	// private representation of the triangle
	private int[][] triangle;

	// constructor determining the size of the triangle to create
	public BetterPascalTriangle(int lines) {
		
		// create the correct number of lines/rows, leaving the 2nd
		// dimension to be populated by the actual values 
		triangle = new int[lines][];
	}

	// accessor to get the upper bounds of this instance
	public int getNumberOfLines() {
		return triangle.length;
	}

	// overridden implementation of getLine that returns
	// the previously computed line if it exists
	public int[] getLine(int lineNumber) throws IllegalArgumentException {

		// make sure caller can't go out of bounds
		if (lineNumber > triangle.length || lineNumber < 1) {
			throw new IllegalArgumentException("Requested Line Number must be greater than zero"
					+ " and less than " + triangle.length);
		}

		// check to see if the requested line is already computed
		// because the array is zero-indexed we have to massage the
		// requested line number with a -1
		if (triangle[lineNumber - 1] == null) {
			// if not, compute it via the parent method
			triangle[lineNumber - 1] = super.getLine(lineNumber);
		}
		return triangle[lineNumber - 1];
	}

	// overloaded calculatePascalValue to check to see if we've already done the
	// computation - this uses the fact the method call in the parent class will
	// be bound at runtime to this class, so it repeatedly does the check
	protected int calculatePascalValue(int lineNumber, int columnNumber) {

		// check to see if calculation already complete
		// this is a little ugly with the -1s for array positioning
		// but on large triangles this will save many computations as the
		// base class implementation could be recalculating
		// many of the values in the triangle for any given call
		
		if (triangle[lineNumber - 1] != null && triangle[lineNumber - 1][columnNumber - 1] != 0) {
			
			// if the value already exists, use it
			return triangle[lineNumber - 1][columnNumber - 1];
			
		} else {
			
			// use the parent implementation to do the actual recursive
			// computation - this technically makes the recursion indirect
			return super.calculatePascalValue(lineNumber, columnNumber);
		}
	}
}
