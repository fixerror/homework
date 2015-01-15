package com.sourceit.radchenko.hw4.impl;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sourceit.radchenko.hw4.IStringUtils;
import com.sourceit.radchenko.hw4.exception.CustomException;


public class StringUtilsImpl implements IStringUtils {

	@Override
	public double div(String number1, String number2)
			throws NullPointerException, NumberFormatException,
			ArithmeticException {
		if (number1==null || number2==null){
			throw new NullPointerException();
		}
		if (!number1.matches("[0-9]+[0-9]*") || !number2.matches("[0-9]+[0-9]*")){
			throw new NumberFormatException();
		}
		int num1 = Integer.parseInt(number1);
		int num2 = Integer.parseInt(number2);

		if (num2 == 0){
			throw new ArithmeticException();
		}
		return num1 / num2;
	}

	@Override
	public int[] findWord(String text, String word) throws NullPointerException {
		if (text.equals(null) || word.equals(null))
			throw new NullPointerException();
		int count = 0;
		int i = 0;
		int res;
		int[] arrayResult = new int[2]; 

		while (i < text.length()) {
			res = text.indexOf(word, i);
			arrayResult[count] = res;

			count++;
			i += text.indexOf(word, res) + word.length();

		}
		return arrayResult;

	}

	@Override
	public double[] findNumbers(String text) throws CustomException {
		double [] arrayResult = new double[5];
        if(text.matches("[^-0-9]"))
        	{
        	throw  new CustomException("Not found");
        	}
		String regexWithE = "[-]?[0-9]+(.[0-9]+)?";
        int i = 0;
        Pattern p = Pattern.compile(regexWithE);
        Matcher matcher = p.matcher(text);
        while (matcher.find()) {
            arrayResult[i] = Double.parseDouble(matcher.group());
            i++;
		
	}
        return arrayResult;
}
}
