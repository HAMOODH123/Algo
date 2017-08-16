package chapter2_3;

import com.chapter2_1.Sort;

import edu.princeton.cs.algs4.StdRandom;

public class Quick3Way extends Sort {
	private static <T extends Comparable<? super T>> void sort(T[] a, int lo, int hi) {
		if(hi <= lo) return;
		int lt = lo;
		int gt = hi;
		int i = lo + 1;
		T v = a[lo];
		while(i <= gt) {
			if(a[i].compareTo(v) < 0) exch(a, i++, lt++);
			else if(a[i].compareTo(v) > 0) exch(a, i, gt--);
			else i++;
		}
		sort(a, lo, lt - 1);
		sort(a, gt + 1, hi); 
	}
	
	public static <T extends Comparable<? super T>> void sort(T[] a) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}
}
