package com.sourceit.radchenko.hw3.test;

import com.sourceit.radchenko.hw3.IMatrix;
import com.sourceit.radchenko.hw3.impl.MatrixImpl;

public class MainTest {

	public static void main(String[] args) {
		IMatrix f1 = new MatrixImpl(3, 3);
		for (int i = 0; i < f1.getRows(); i++) {
			for (int j = 0; j < f1.getColumns(); j++) {
				f1.setValueAt(i, j, Math.round(Math.random()*9));
			}
		}
		System.out.println("Conclusion matrix f1 accidentally filled:");
		f1.printToConsole();
/*==================================================================================================================*/		
		IMatrix f2 = new MatrixImpl(3, 3);
		for (int i = 0; i < f2.getRows(); i++) {
			for (int j = 0; j < f2.getColumns(); j++) {
				 f2.setValueAt(i, j, Math.round(Math.random()*9));
			}
		}
		System.out.println("Conclusion matrix f2 accidentally filled:");
		f2.printToConsole();
/*==================================================================================================================*/
		System.out.println("Returns the sum of the current matrix f1 and f2 matrix");
		f1.add(f2);
/*==================================================================================================================*/
		System.out.println("Returns the difference between the current matrix f1 and f2 matrix");
		f1.sub(f2);
/*==================================================================================================================*/		
		System.out.println("Returns the product of the current matrix f1 and f2 matrix");
		f1.mul(f2);
/*==================================================================================================================*/
		System.out.println("Returns the product of the current matrix f1 and numbers");
		f1.mul(3);
/*==================================================================================================================*/		
		System.out.println("Returns the transposed matrix with respect to the current");
		f1.transpose();
/*==================================================================================================================*/
		System.out.println("Calculate the determinant of the matrix");
		System.out.println(f1.determinant());
/*==================================================================================================================*/
		System.out.println("Checks whether the current zero matrix");
		System.out.println(f1.isNullMatrix());
/*==================================================================================================================*/
		System.out.println("Checks whether the current matrix unit");
		System.out.println(f1.isIdentityMatrix());
/*==================================================================================================================*/
		System.out.println("Checks whether the current matrix square");
		System.out.println(f1.isSquareMatrix());
	}

}
