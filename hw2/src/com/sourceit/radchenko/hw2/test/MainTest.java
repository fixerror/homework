package com.sourceit.radchenko.hw2.test;

import com.sourceit.radchenko.hw2.IFractionNumber;
import com.sourceit.radchenko.hw2.IFractionNumberOperation;
import com.sourceit.radchenko.hw2.impl.FractionNumberImpl;
import com.sourceit.radchenko.hw2.impl.FractionNumberOperationImpl;

public class MainTest {

	public static void main(String[] args) throws IllegalAccessException {
		IFractionNumber a = new FractionNumberImpl();
		IFractionNumber b = new FractionNumberImpl();
		IFractionNumberOperation c = new FractionNumberOperationImpl();
		// Set dividend а;
		a.setDividend(1);
		// Set the divisor а;
		a.setDivisor(1);
		// Set dividend b;
		b.setDividend(1);
		// Set the divisor b;
		b.setDivisor(1);
		// output FractionNumber add(FractionNumber a, FractionNumber b)
		System.out
				.println("FractionNumber add(FractionNumber a, FractionNumber b)");
		System.out.println(a.toString() + "  +  " + b.toString() + "  =  "
				+ c.add(a, b).toString() + "  =  " + c.add(a, b).value());
		// output FractionNumber sub(FractionNumber a, FractionNumber b)
		System.out
				.println("FractionNumber sub(FractionNumber a, FractionNumber b)");
		if (c.sub(a, b).value() < 1) {
			System.out.println(a.toString() + "  -  " + b.toString() + "  =  "
					+ c.sub(a, b).value());
		} else {
			System.out.println(a.toString() + "  -  " + b.toString() + "  =  "
					+ c.sub(a, b).toString() + "  =  " + c.sub(a, b).value());
		}
		// output FractionNumber mul(FractionNumber a, FractionNumber b)
		System.out
				.println("FractionNumber mul(FractionNumber a, FractionNumber b)");
		System.out.println(a.toString() + "  *  " + b.toString() + "  =  "
				+ c.mul(a, b).toString() + "  =  " + c.mul(a, b).value());
		// output FractionNumber div(FractionNumber a, FractionNumber b)
		System.out
				.println("FractionNumber div(FractionNumber a, FractionNumber b)");
		System.out.println(a.toString() + "  /  " + b.toString() + "  =  "
				+ c.div(a, b).toString() + "  =  " + c.div(a, b).value());

	}

}
