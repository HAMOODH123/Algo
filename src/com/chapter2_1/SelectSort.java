package com.chapter2_1;

public class SelectSort extends Sort {

	public static <T extends Comparable<? super T>> void sort(T[] a) {
		for(int i = 0; i < a.length; i++) {
			int min = i;
			for(int j = i + 1; j < a.length; j++) {
				if(less((T)a[j], (T)a[min])) min = j;
			}
			exch(a, i, min);
		}		
	}
}
