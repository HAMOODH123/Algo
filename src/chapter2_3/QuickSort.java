package chapter2_3;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSort extends Sort{
	public static <T extends Comparable<? super T>> void sort(T[] a) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}
	
	private static <T extends Comparable<? super T>> void sort(T[] a, int lo, int hi) {
		if(hi <= lo) return;
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}
	
	private static <T extends Comparable<? super T>> int partition(T[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		T v = a[lo];
		while(true) {
			while(less(a[++i], v)) if(i >= hi) break;
			while(less(v, a[--j])) ;
			if(i >= j) break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}
}
