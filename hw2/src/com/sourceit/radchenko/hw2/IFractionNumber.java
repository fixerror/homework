package com.sourceit.radchenko.hw2;

/**
 * Interface representing a number as a fraction. To display the error function can
 * throw IllegalArgumentException This interface can be used for
 * conventional storage fractions such as 1/2, 1/4, 3/7, etc.
 * 
 * @author source it
 * @version 1.0
 */
public interface IFractionNumber {

	/**
	 * throw IllegalArgumentException This interface can be used to
	 */
	int DEFAULT_DIVISOR_VALUE = 1;

	/**
	 * Set dividend
	 * 
	 * @param dividend
	 * 
	 */
	void setDividend(int dividendParameter);

	/**
	 * Get dividend
	 * 
	 * @return dividend
	 */
	int getDividend();

	/**
	 * Set the divisor
	 * 
	 * @param divisor
	 * 
	 * @throws IllegalArgumentException
	 *             if you are trying to establish a divider of 0
	 */
	void setDivisor(int divisorParameter) throws IllegalArgumentException;

	/**
	 * Get divider
	 * 
	 * @return divider
	 */
	int getDivisor();

	/**
	 * Get the value as a real number. For example, if the dividend is = 1,
	 * divisor = 4, then the real number for the fraction 1/4 = 0.25
	 * 
	 * @return real number for the back shot
	 */
	Double value();

	/**
	 * Get the symbolic representation of example, if the dividend is = 1,
	 * divisor = 4, then the symbolic representation of the number equal to 1/4
	 * 
	 * @return symbolic representation of the number
	 */
	String toString();

}
