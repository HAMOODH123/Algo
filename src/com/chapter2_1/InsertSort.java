package com.chapter2_1;

public class InsertSort extends Sort {
	public static <T extends Comparable<? super T>> void sort(T[] a) {
		for(int i = 1; i < a.length; i++) {
			T temp = a[i];
			int j = i - 1;
			for(; j >= 0 && less(temp, a[j]); j--) {
				a[j + 1] = a[j];
			}
			a[j + 1] = temp;
		}
	}
}
