package com.sourceit.radchenko.hw4.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.sourceit.radchenko.hw4.IStringUtils;
import com.sourceit.radchenko.hw4.exception.CustomException;
import com.sourceit.radchenko.hw4.impl.StringUtilsImpl;

public class MainTest {

	public static void main(String[] args) throws FileNotFoundException, IOException, CustomException {
		String number1="10";
		String number2="2";
		String text="fjspipfjspip";
		String word="pip";
        String find="1.2563qwe6.34ffs3jhffss74.2dfhfdsf5.2";
		IStringUtils rez = new StringUtilsImpl();
/*==================================================================================================================*/
		try{
			System.out.println("div(String number1, String number2)  Returns the result of dividing the number 1 to number2");
			System.out.println("div  =  "+rez.div(number1, number2));
		}catch (NullPointerException e){
			e.getStackTrace();
		}catch(NumberFormatException e){
			e.getStackTrace();
		}catch(ArithmeticException e){
			e.getStackTrace();
		}

/*==================================================================================================================*/
		
		try{
			System.out.println("int[] findWord(String text, String word)  Search for all "
					+ "occurrences of the word <b>word</b> in the text <b>text</b> and returns an array of indexes of words");
		int[] rezult = rez.findWord(text, word);
		int k1=0;
           for(int i=0;0<rezult.length;i++){
        	   try{
			System.out.println("["+k1+"]"+ "start character=" +rezult[i]);
			k1++;
        	   }catch(ArrayIndexOutOfBoundsException e){
        		   break;
        	   }
           }
		}catch(NullPointerException e){
			e.getStackTrace();
		}

/*==================================================================================================================*/
		try{
			System.out.println("double[] findNumbers(String text)  finds "
					+ "double the number of all the text and returns them as an array.");
		double[] arr = rez.findNumbers(find);
		int k2=0;
           for(int i=0;0<arr.length;i++){
        	if(k2>4)break;
			System.out.println("["+k2+"]"+ "=" +arr[i]);
			k2++;
           }
		}catch(CustomException e){
			e.getStackTrace();
		}

	}
}
