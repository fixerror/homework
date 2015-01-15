package com.sourceit.radchenko.hw2.impl;

import com.sourceit.radchenko.hw2.IFractionNumber;

/**
 * @author radchenko.as
 * @version 2.0 May/2014
 */

public class FractionNumberImpl implements IFractionNumber {

	private int dividend;
	private int divisor;

	public FractionNumberImpl() {
		this.divisor = DEFAULT_DIVISOR_VALUE;
	}

	@Override
	public void setDividend(int dividendParameter) {
		dividend = dividendParameter;

	}

	@Override
	public int getDividend() {
		return dividend;
	}

	@Override
	public void setDivisor(int divisorParameter)
			throws IllegalArgumentException {

		if (divisor <= 0) {
			throw new IllegalArgumentException("Can not divide by zero!!");
		} else {
			this.divisor = divisorParameter;
		}
	}

	@Override
	public int getDivisor() {
		return divisor;
	}

	@Override
	public Double value() {
		return ((double) dividend) / ((double) divisor);

	}

	@Override
	public String toString() {
		String FractionNumberString = dividend + "/" + divisor;
		return FractionNumberString;
	}

}
