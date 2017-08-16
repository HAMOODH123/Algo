package com.chapter1_4;

public class FourSumFast {
	public static int fourSum(int[] a) {
		int[] newArr = new int[a.length * (a.length - 1) / 2];
		int k = 0;
		for(int i = 0; i < a.length; i++)
			for(int j = i + 1; j < a.length; j++)
				newArr[k++] = a[i] + a[j];
		
		return TwoSumFaster.twoSum(a);
	}

	public static void main(String[] args) {
		int[] a = {1, 2, -1, -2,  4, -4, 5, 6};
		System.out.println(fourSum(a));
	}
}
