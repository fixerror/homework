package com.sourceit.radchenko.hw3.impl;

import com.sourceit.radchenko.hw3.IMatrix;

public class MatrixImpl implements IMatrix {
	private double[][] matrixrazmer;

	public double[][] getMatrixrazmer() {
		return matrixrazmer;
	}

	public MatrixImpl() {
		matrixrazmer = new double[DEFAULT_MATRIX_SIZE][DEFAULT_MATRIX_SIZE];
	}

	public MatrixImpl(int rows, int columns) {
		matrixrazmer = new double[rows][columns];
	}

	@Override
	public int getRows() {
		int rez = matrixrazmer.length;
		return rez;
	}

	@Override
	public int getColumns() {
		int rez = matrixrazmer[0].length;
		return rez;
	}

	@Override
	public double getValueAt(int rowIndex, int colIndex)
			throws IndexOutOfBoundsException {
		return matrixrazmer[rowIndex][colIndex];
	}

	@Override
	public void setValueAt(int rowIndex, int colIndex, double value)
			throws IndexOutOfBoundsException {
		matrixrazmer[rowIndex][colIndex] = value;
	}

	@Override
	public IMatrix add(IMatrix otherMatrix) throws IllegalArgumentException,
			NullPointerException {
		MatrixImpl addMatrix = new MatrixImpl(getRows(), getColumns());
		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j < getColumns(); j++) {
				double val = getValueAt(i, j) + otherMatrix.getValueAt(i, j);
				addMatrix.setValueAt(i, j, val);
			}
		}
		addMatrix.printToConsole();
		return addMatrix;
	}

	@Override
	public IMatrix sub(IMatrix otherMatrix) throws IllegalArgumentException,
			NullPointerException {
		MatrixImpl subMatrix = new MatrixImpl(getRows(), getColumns());
		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j < getColumns(); j++) {
				double val = getValueAt(i, j) - otherMatrix.getValueAt(i, j);
				subMatrix.setValueAt(i, j, val);
			}
		}
		subMatrix.printToConsole();
		return subMatrix;
	}

	@Override
	public IMatrix mul(IMatrix otherMatrix) throws IllegalArgumentException,
			NullPointerException {
		MatrixImpl mulMatrix = new MatrixImpl(getRows(), getColumns());
		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j < getColumns(); j++) {
				double val = getValueAt(i, j) * otherMatrix.getValueAt(i, j);
				mulMatrix.setValueAt(i, j, val);
			}
		}
		mulMatrix.printToConsole();
		return mulMatrix;
	}

	@Override
	public IMatrix mul(double value) {
		MatrixImpl mulvalueMatrix = new MatrixImpl(getRows(), getColumns());
		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j < getColumns(); j++) {
				double val = getValueAt(i, j) * value;
				mulvalueMatrix.setValueAt(i, j, val);
			}
		}
		mulvalueMatrix.printToConsole();
		return mulvalueMatrix;
	}

	@Override
	public IMatrix transpose() {
		MatrixImpl otherMatrix = new MatrixImpl(getColumns(), getRows());
		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j < getColumns(); j++)
				otherMatrix.setValueAt(j, i, getValueAt(i, j));

		}
		otherMatrix.printToConsole();
		return otherMatrix;
	}

	@Override
	public void fillMatrix(double value) {
		for (int i = 0; i < getRows(); i++)
			for (int j = 0; j < getColumns(); j++)
				matrixrazmer[i][j] = value;

	}

	@Override
	public double determinant() {
		int sum = 0;
		int s;
		if (this.getRows() == 1 && this.getColumns() == 1) {
			return (this.getValueAt(0, 0));
		} else if (!this.isSquareMatrix()) {
			sum = 0;
		}
		for (int i = 0; i < this.getRows(); i++) {
			MatrixImpl detmatrix = new MatrixImpl(this.getRows() - 1,
					this.getColumns() - 1);
			for (int a = 1; a < this.getRows(); a++) {
				for (int b = 0; b < this.getRows(); b++) {
					if (b < i) {
						detmatrix.setValueAt(a - 1, b, this.getValueAt(a, b));
					} else if (b > i) {
						detmatrix.setValueAt(a - 1, b - 1,
								this.getValueAt(a, b));
					}
				}
			}
			if (i % 2 == 0) {
				s = 1;
			} else {
				s = -1;
			}
			sum += s * matrixrazmer[0][i] * (detmatrix.determinant());
		}
		return sum;
	}

	@Override
	public boolean isNullMatrix() {
		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j < getColumns(); j++) {
				if (getValueAt(i, j) != 0) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public boolean isIdentityMatrix() {
		int p = 1;
		for (int i = 0; i < matrixrazmer.length; i++) {
			for (int j = 0; j < matrixrazmer.length; j++) {
				if ((i == j && getValueAt(i, j) == 1)
						&& (i != j && getValueAt(i, j) == 0)) {
					p = 0;
					break;
				}
			}
		}
		if (p == 0) {
			return true;
		}
		return false;

	}

	@Override
	public boolean isSquareMatrix() {
		if (getRows() == getColumns())
			return true;
		return false;
	}

	@Override
	public void printToConsole() {
		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j < getColumns(); j++)
				if (getValueAt(i, j) < 10) {
					System.out.print(getValueAt(i, j) + "    ");
				} else {
					System.out.print(getValueAt(i, j) + "   ");
				}
			System.out.println();
		}

	}

}
