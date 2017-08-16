package com.chapter1_4;

public class EqualElemnets {
	public static void equalElements(int[] a, int[] b) {
		int i = 0, j = 0;
		for(int k = 0; k < (a.length + b.length); k++) {
			while(i < a.length- 1 && a[i] < b[j]) i++;
			while(j < b.length- 1 && a[i] > b[j]) j++;
			if(i < a.length && j < b.length &&a[i] == b[j]) {
				System.out.print(a[i] + " ");
				i++;
				j++;
			}
		}
	}

	public static void main(String[] args) {
		int[] a = {0, 1, 3, 5, 6, 7, 9, 10, 11, 12, 14};
		int[] b = {0, 1, 2, 4, 6, 8, 10, 14};
		equalElements(a, b);
	}
}
