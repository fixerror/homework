package com.sourceit.radchenko.hw2;

/**
 * Interface operations with numbers FractionNumber. To display the error function can
 * throw ArithmeticException
 * 
 * @author source it
 * @version 1.0
 */
public interface IFractionNumberOperation {

	/**
	 * Addition of two numbers FractionNumber
	 * 
	 * @param a
	 *            first term
	 * @param b
	 *            second term
	 * @return Results as of FractionNumber
	 * @throws NullPointerException
	 *             If a or b are null
	 */
	IFractionNumber add(IFractionNumber a, IFractionNumber b)
			throws NullPointerException;

	/**
	 * Subtract two numbers FractionNumber
	 * 
	 * @param a
	 *            minuend
	 * @param b
	 *            subtrahend
	 * @return Results as of FractionNumber
	 * @throws NullPointerException
	 *             If a or b are null
	 */
	IFractionNumber sub(IFractionNumber a, IFractionNumber b)
			throws NullPointerException;

	/**
	 * Multiplication of two numbers Fraction Number
	 * 
	 * @param a
	 *            the first factor
	 * @param b
	 *            the second factor
	 * @return Results as of Fraction Number
	 * @throws NullPointerException
	 *             If a or b are null
	 */
	IFractionNumber mul(IFractionNumber a, IFractionNumber b)
			throws NullPointerException;

	/**
	 * Division of two numbers Fraction Number
	 * 
	 * @param a
	 *            dividend
	 * @param b
	 *            divider
	 * @return Results as of Fraction Number
	 * @throws NullPointerException
	 *             If a or b are null
	 * @throws ArithmeticException
	 *             if division by 0
	 */
	IFractionNumber div(IFractionNumber a, IFractionNumber b)
			throws NullPointerException;

}
