package com.chapter2_1;

public class ShellSort extends Sort {
	public static <T extends Comparable<? super T>> void sort(T[] a) {
		int N = a.length;
		int h = 1, j = 0;
		while(h < N / 3) h = 3 * h + 1;
		while(h >= 1) {
			for(int i = h; i < N; i++) {
				T temp = a[i];
				for(j = i - h; j >= 0 && less(temp, a[j]); j -= h) {
					a[j + h] = a[j];
				}
				a[j + h] = temp;
			}
			h /= 3;
		}
	}
}
