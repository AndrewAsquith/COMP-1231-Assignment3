//==============================================
// Andrew Asquith
// COMP 1231
// Assignment 3
// PascalTriangle Class 
//
// This is the PascalTriangle class.
// It will return an array of longs for whatever the 
// requested line number of Pascal's triangle is
// This class doesn't have any state, but there is
// an implementation that inherits it which does, so
// it is not implemented statically
public class PascalTriangle {
	
	// returns an array of integers representing
	// the requested line number of pascal's triangle
	public long[] getLine(int lineNumber) {

		if (lineNumber < 1) {
			throw new IllegalArgumentException("Requested Line Number must be greater than zero, " 
												+ lineNumber + " is not");
		}
		
		long[] thisLine = new long[lineNumber];
		
		for (int column = 0; column<lineNumber; column++) {
			thisLine[column] = calculatePascalValue(lineNumber, column+1);
		}
		return thisLine;
	}

	// calculate any given value in pascal's triangle given it's position in terms of 
	// line number and column number - this computes large parts of the 
	// whole triangle for any given value
	protected long calculatePascalValue(int lineNumber, int columnNumber) {

		
		// base case - first and last values in a row are 1 (which holds true for the first row)
		if (columnNumber == 1 || columnNumber == lineNumber) {
			return 1;
			
		} else {
			
			//return the sum of the previous line, previous column and previous line, this column 
			// the two values above this one if you were to draw the triangle
			return calculatePascalValue(lineNumber -1, columnNumber - 1) 
					+ calculatePascalValue(lineNumber -1, columnNumber); 
		}
	}

	// there's no state, so just print a friendly version of the class name
	public String toString() {
		return "Pascal's Triangle Generator";
	}
}
