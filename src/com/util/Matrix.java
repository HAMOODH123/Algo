package com.util;

import java.util.Arrays;

public class Matrix {
	/*
	 * �������
	 */
	public static double dot(double[] x, double[] y) {
		if(x.length != y.length)
			throw new IllegalArgumentException();
		double result = 0.0;
		for(int i = 0; i < x.length; i++)
			result += x[i] * y[i];
		return result;
	}
	
	/*
	 * ������˻�
	 */
	public static double[][] mult(double[][] a, double[][] b) {
		double[][] result = new double[a.length][b[0].length];
		double[][] temp = transpose(b);
		for(int i = 0; i < result.length; i++)
			for(int j = 0; j < result[0].length; j++) {
				result[i][j] = dot(a[i], temp[j]);
			}
		return result;
	}
	
	/*
	 * ת�þ���
	 */
	public static double[][] transpose(double[][] a) {
		double[][] result = new double[a[0].length][a.length];
		for(int i = 0; i < result.length; i++)
			for(int j = 0; j < result[0].length; j++) {
				result[i][j] = a[j][i];
			}
		return result;
	}
	
	/*
	 * ����������֮��
	 */
	public static double[] mult(double[][] a, double[] x) {
		double[] result = new double[a.length];
		for(int i = 0; i < result.length; i++)
			result[i] = dot(a[i], x);
		return result;
	}
	
	/*
	 * ���������֮��
	 */
	public static double[] mult(double[] y, double[][] a) {
		double[][] temp = transpose(a);
		double[] result = new double[a[0].length];
		for(int i = 0; i < result.length; i++)
			result[i] = dot(y, temp[i]);
		return result;
	}

	public static void main(String[] args) {
		double[][] a = {{1, 1, 1}, {1, 2, 3}, {3, 3, 3}};
		double[][] b = {{2, 2, 2}, {1, 2, 3}, {2, 4, 6}};
		double[] x= {1, 2, 3, 4};
		double[] y = {2, 3, 4, 5};
		double[] x1= {1, 2, 3};
		double[] y1 = {2, 3, 4};
		System.out.println(dot(x, y));
		System.out.println(Arrays.deepToString(mult(a, b)));
		System.out.println(Arrays.deepToString(transpose(a)));
		System.out.println(Arrays.toString(mult(a, x1)));
		System.out.println(Arrays.toString(mult(y1, a)));
	}
}
