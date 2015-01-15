package com.sourceit.radchenko.hw4;

import com.sourceit.radchenko.hw4.exception.CustomException;



/**
 * Utilitny class for working with strings
 * 
 * @author source-it
 * @version 1.0
 */
public interface IStringUtils {
	
	/**
	 * Returns the result of dividing the number1 number2 on
	 * 
	 * @param number1 dividend
	 * @param number2 divider
	 * @return the result of dividing the number 1 on number2
	 * @throws NullPointerException if number 1 or number2 are null
	 * @throws NumberFormatException if number 1 or number number2 not
	 * @throws ArithmeticException if number 2 is zero
	 */
	double div (String number1, String number2) throws NullPointerException, NumberFormatException, ArithmeticException;
	
	/**
	 * Search for all occurrences of the word<b>word</b> in the text <b>text</b> and returns an array of indexes of words
	 * 
	 * @param text source
	 * @param word search word
	 * @return an array of indices of each occurrence of the word
	 * @throws NullPointerException
	 */
	int[] findWord (String text, String word) throws NullPointerException;
	
	/**
	 * Is the text of all the double and returns them as an array. If the numbers are not found in the text must throw an exception CustomException with the message:
	 * <b>"Not found"</b>
	 * 
	 * @param text source
	 * @return an array of double numbers
	 * @throws CustomException if the number is not found in the text
	 */
	double[] findNumbers(String text) throws CustomException;
}
