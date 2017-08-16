package com.util;

import java.util.Random;

public class ArrayGenerator {
	/**
	 * 
	 * @param length 数组长度
	 * @param limit 数组元素最大值
	 * @return
	 */
	public static int[] generateInt(int length, int limit) {
		if(length == 0) return new int[]{};
		Random rand = new Random(47);
		int[] arr = new int[length];
		for(int i = 0; i < arr.length; i++)
			arr[i] = rand.nextInt(limit);
		return arr;
	}
	
	public static Integer[] generateInteger(int length, int limit) {
		if(length == 0) return new Integer[]{};
		Random rand = new Random(47);
		Integer[] arr = new Integer[length];
		for(int i = 0; i < arr.length; i++)
			arr[i] = rand.nextInt(limit);
		return arr;
	}
	
	public static Integer[][] generateInteger(int width, int height, int limit) {
		if(width == 0 && height == 0) return new Integer[][]{};
		Random rand = new Random(47);
		Integer[][] arr = new Integer[width][height];
		for(int i = 0; i < width; i++)
			for(int j = 0; j < height; j++) 
				arr[i][j] = rand.nextInt(limit);
		return arr;
	}
	
	public static int[][] generateTwo(int width, int height, int limit) {
		if(width == 0 && height == 0) return new int[][]{};
		Random rand = new Random(47);
		int[][] arr = new int[width][height];
		for(int i = 0; i < width; i++)
			for(int j = 0; j < height; j++) 
				arr[i][j] = rand.nextInt(limit);
		return arr;
	}
}
