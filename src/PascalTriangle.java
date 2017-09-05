
public class PascalTriangle {
	
	public int[] getLine(int lineNumber) {

		int[] thisLine = new int[lineNumber];
		
		for (int column = 0; column<lineNumber; column++) {
			thisLine[column] = calculatePascalValue(lineNumber, column+1);
		}
		return thisLine;
	}

	// calculate any given value in pascal's triangle given it's position in terms of 
	// line number and column number - this computes large parts of the 
	// whole triangle for any given value
	protected int calculatePascalValue(int lineNumber, int columnNumber) {

		
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

}
