package com.sourceit.radchenko.hw3;

/**
 * The interface works with matrices
 * 
 * @author source it
 * @version 1.0
 */
public interface IMatrix {
	
	/**
	 * Size of the matrix to the constructor without parameters
	 */
	int DEFAULT_MATRIX_SIZE = 1;
	
	/**
	 * Returns the number of rows of the matrix
	 * 
	 * @return the number of rows of the matrix
	 */
	int getRows ();
	
	/**
	 * Returns the number of columns of the matrix
	 * 
	 * @return number of columns
	 */
	int getColumns ();
	
	/**
	 * Returns the element matrix Index
	 * 
	 * @param rowIndex 
	 * @param colIndex 
	 * @return matrix element Index
	 * @throws IndexOutOfBoundsException if the row index is less than zero or greater than (or equal to) the number of rows of the matrix
	 * 			or column index is less than zero or greater than (or equal to) the number of columns of the matrix
	 */
	double getValueAt (int rowIndex, int colIndex) throws IndexOutOfBoundsException;
	
	/**
	 * Sets the matrix element in the indices
	 * 
	 * @param rowIndex
	 * @param colIndex
	 * @param value the new value of the item
	 * @throws IndexOutOfBoundsException if the row index is less than zero or greater than (or equal to) the number of rows of the matrix
	 * 			or column index is less than zero or greater than (or equal to) the number of columns of the matrix
	 */
	void setValueAt (int rowIndex, int colIndex, double value) throws IndexOutOfBoundsException;
	
	/**
	 * Returns the sum of the current matrix and the second argument. <br/>
	 * <b><i>(After the current matrix functions must not be changed! The result of the operation - the new object of the matrix)</i></b>
	 * 
	 * @param otherMatrix the second argument (the matrix)
	 * @return the sum of matrices<b><i>(new object matrix)</i></b>
	 * @throws IllegalArgumentException if the current matrix and the second argument is the number of rows are incompatible and (or) column
	 * @throws NullPointerException if the second argument is null
	 */
	IMatrix add (IMatrix otherMatrix) throws IllegalArgumentException, NullPointerException;
	
	/**
	 * Returns the difference between the current matrix and the second argument.<br/>
	 * <b><i>(After the current matrix functions must not be changed! The result of the operation - the new object of the matrix)</i></b> 
	 * 
	 * @param otherMatrix the second argument (the matrix)
	 * @return difference matrices<b><i>(new object matrix)</i></b>
	 * @throws IllegalArgumentException if the current matrix and the second argument is the number of rows are incompatible and (or) column
	 * @throws NullPointerException if the second argument is null
	 */
	IMatrix sub (IMatrix otherMatrix) throws IllegalArgumentException, NullPointerException;
	
	/**
	 * Returns the product of the current matrix and the second argument.<br/>
	 * <b><i>(After the current matrix functions must not be changed! The result of the operation - the new object of the matrix) </i></b> 
	 * 
	 * @param otherMatrix the second argument (the matrix)
	 * @return matrix product<b><i>(new object matrix)</i></b>
	 * @throws IllegalArgumentException if the current matrix and the second argument is the number of rows are incompatible and (or) column
	 * @throws NullPointerException if the second argument is null
	 */
	IMatrix mul (IMatrix otherMatrix) throws IllegalArgumentException, NullPointerException;
	
	/**
	 * Returns the product of the current matrix by a number.<br/>
	 * <b><i>(After the current matrix functions must not be changed! The result of the operation - the new object of the matrix)</i></b>
	 * 
	 * @param value number
	 * @return composition <b><i>(new object matrix)</i></b>
	 */
	IMatrix mul (double value);
	
	/**
	 * Returns the transposed matrix with respect to the current
	 * 
	 * @return the transposed matrix with respect to the current
	 */
	IMatrix transpose();
	
	/**
	 * Fills the back of the current matrix value
	 * 
	 * @param value value
	 */
	void fillMatrix (double value);
	
	/**
	 * Calculates the determinant of the matrix.<br/>
	 * Description of the algorithm for any matrix here: <a target="_blank" href="http://ru.wikipedia.org/wiki/LU-%D1%80%D0%B0%D0%B7%D0%BB%D0%BE%D0%B6%D0%B5%D0%BD%D0%B8%D0%B5">LU-expansion</a>
	 * 
	 * @return determinant
	 */
	double determinant();
	
	/**
	 * Checks whether the current zero matrix<br/>
	 * Zero matrix - a matrix in which all elements are zeros:
	 * 
	 * <table>
	 * <tr><td>&nbsp;&nbsp;0&nbsp;&nbsp;</td><td>&nbsp;&nbsp;0&nbsp;&nbsp;</td><td>&nbsp;&nbsp;0&nbsp;&nbsp;</td><td>&nbsp;&nbsp;0&nbsp;&nbsp;</td></tr>
	 * <tr><td>&nbsp;&nbsp;0&nbsp;&nbsp;</td><td>&nbsp;&nbsp;0&nbsp;&nbsp;</td><td>&nbsp;&nbsp;0&nbsp;&nbsp;</td><td>&nbsp;&nbsp;0&nbsp;&nbsp;</td></tr>
	 * <tr><td>&nbsp;&nbsp;0&nbsp;&nbsp;</td><td>&nbsp;&nbsp;0&nbsp;&nbsp;</td><td>&nbsp;&nbsp;0&nbsp;&nbsp;</td><td>&nbsp;&nbsp;0&nbsp;&nbsp;</td></tr>
	 * <tr><td>&nbsp;&nbsp;0&nbsp;&nbsp;</td><td>&nbsp;&nbsp;0&nbsp;&nbsp;</td><td>&nbsp;&nbsp;0&nbsp;&nbsp;</td><td>&nbsp;&nbsp;0&nbsp;&nbsp;</td></tr>
	 * </table>
	 * 
	 * @return <b>true</b> if the current is zero matrix
	 */
	boolean isNullMatrix();
	
	/**
	 * Checks whether the current matrix unit<br/>
	 * The identity matrix - the matrix in which the main diagonal units, and other elements of zeros:
	 * 
	 * <table>
	 * <tr><td>&nbsp;&nbsp;1&nbsp;&nbsp;</td><td>&nbsp;&nbsp;0&nbsp;&nbsp;</td><td>&nbsp;&nbsp;0&nbsp;&nbsp;</td><td>&nbsp;&nbsp;0&nbsp;&nbsp;</td></tr>
	 * <tr><td>&nbsp;&nbsp;0&nbsp;&nbsp;</td><td>&nbsp;&nbsp;1&nbsp;&nbsp;</td><td>&nbsp;&nbsp;0&nbsp;&nbsp;</td><td>&nbsp;&nbsp;0&nbsp;&nbsp;</td></tr>
	 * <tr><td>&nbsp;&nbsp;0&nbsp;&nbsp;</td><td>&nbsp;&nbsp;0&nbsp;&nbsp;</td><td>&nbsp;&nbsp;1&nbsp;&nbsp;</td><td>&nbsp;&nbsp;0&nbsp;&nbsp;</td></tr>
	 * <tr><td>&nbsp;&nbsp;0&nbsp;&nbsp;</td><td>&nbsp;&nbsp;0&nbsp;&nbsp;</td><td>&nbsp;&nbsp;0&nbsp;&nbsp;</td><td>&nbsp;&nbsp;1&nbsp;&nbsp;</td></tr>
	 * </table>
	 * 
	 * @return <b>true</b> if the current matrix identity
	 */
	boolean isIdentityMatrix();
	
	/**
	 * Checks whether the current matrix square.<br/>
	 * Ie matrix whose number of rows equals the number of columns<br/>
	 * 
	 * @return <b>true</b> if the current square matrix
	 */
	boolean isSquareMatrix ();
	
	/**
	 * Conclusion matrix to the console
	 * @see System.out.println()
	 */
	void printToConsole ();

	


}
