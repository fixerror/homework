package com.sourceit.radchenko.hw2.impl;

import com.sourceit.radchenko.hw2.IFractionNumber;
import com.sourceit.radchenko.hw2.IFractionNumberOperation;

/**
 * @author radchenko.as
 * @version 2.0 May/2014
 */

public class FractionNumberOperationImpl implements IFractionNumberOperation {

	@Override
	public IFractionNumber add(IFractionNumber a, IFractionNumber b)
			throws NullPointerException {
		if (a.getDividend() == 0 || a.getDivisor() == 0 || b.getDividend() == 0
				|| b.getDivisor() == 0) {
			throw new NullPointerException("Error is one of the objects 0");
		} else {
			int dividend1 = a.getDividend();
			int divisor1 = a.getDivisor();
			int dividend2 = b.getDividend();
			int divisor2 = b.getDivisor();
			int dividend3 = dividend1 * divisor2 + dividend2 * divisor1;
			int divisor3 = divisor1 * divisor2;
			IFractionNumber c = new FractionNumberImpl();
			c.setDividend(dividend3);
			c.setDivisor(divisor3);
			return c;
		}
	}

	@Override
	public IFractionNumber sub(IFractionNumber a, IFractionNumber b)
			throws NullPointerException {
		if (a.getDividend() == 0 || a.getDivisor() == 0 || b.getDividend() == 0
				|| b.getDivisor() == 0) {
			throw new NullPointerException("Error is one of the objects 0");
		} else {
			int dividend1 = a.getDividend();
			int divisor1 = a.getDivisor();
			int dividend2 = b.getDividend();
			int divisor2 = b.getDivisor();
			int dividend3 = dividend1 * divisor2 - dividend2 * divisor1;
			int divisor3 = divisor1 * divisor2;
			IFractionNumber c = new FractionNumberImpl();
			c.setDividend(dividend3);
			c.setDivisor(divisor3);
			return c;
		}
	}

	@Override
	public IFractionNumber mul(IFractionNumber a, IFractionNumber b)
			throws NullPointerException {
		if (a.getDividend() == 0 || a.getDivisor() == 0 || b.getDividend() == 0
				|| b.getDivisor() == 0) {
			throw new NullPointerException("Error is one of the objects 0");
		} else {
			int dividend1 = a.getDividend();
			int divisor1 = a.getDivisor();
			int dividend2 = b.getDividend();
			int divisor2 = b.getDivisor();
			int dividend3 = dividend1 * dividend2;
			int divisor3 = divisor1 * divisor2;
			IFractionNumber c = new FractionNumberImpl();
			c.setDividend(dividend3);
			c.setDivisor(divisor3);
			return c;
		}
	}

	@Override
	public IFractionNumber div(IFractionNumber a, IFractionNumber b)
			throws NullPointerException {
		if (a.getDividend() == 0 || a.getDivisor() == 0 || b.getDividend() == 0
				|| b.getDivisor() == 0) {
			throw new NullPointerException("Error is one of the objects 0");
		} else {
			int dividend1 = a.getDividend();
			int divisor1 = a.getDivisor();
			int dividend2 = b.getDividend();
			int divisor2 = b.getDivisor();

			int dividend3 = dividend1 * divisor2;
			int divisor3 = divisor1 * dividend2;
			IFractionNumber c = new FractionNumberImpl();
			c.setDividend(dividend3);
			c.setDivisor(divisor3);
			return c;

		}
	}
}
