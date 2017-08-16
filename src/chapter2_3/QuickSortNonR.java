package chapter2_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdRandom;

public class QuickSortNonR extends Sort{
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
	
	public static <T extends Comparable<? super T>> void sort(T[] a) {
		if(a.length <= 1) return;
		StdRandom.shuffle(a);
		Stack<Integer> s = new Stack<>();
		s.push(0);
		s.push(a.length - 1);
		while(!s.isEmpty()) {
			int right = s.pop();
			int left = s.pop();
			int j = partition(a, left, right);
			if(left < j - 1) {
				s.push(left);
				s.push(j - 1);
			}
			if(j + 1 < right) {
				s.push(j + 1);
				s.push(right);
			}
		}
	}
}
