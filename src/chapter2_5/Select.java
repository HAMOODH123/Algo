package chapter2_5;

import java.util.Arrays;

import com.util.ArrayGenerator;

import edu.princeton.cs.algs4.StdRandom;

public class Select {
	public static <T extends Comparable<T>> T select(T[] a, int k) {
		StdRandom.shuffle(a);
		int lo = 0;
		int hi = a.length - 1;
		while(lo <= hi) {
			int j = partition(a, lo, hi);
			if(j < k - 1) lo = j  + 1;
			else if(j > k - 1) hi = j - 1;
			else return a[j];
		}
		return null;
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
	
	public static <T extends Comparable<? super T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
     }
	
	 public static <T extends Comparable<? super T>> void exch(T[] a, int i, int j) {
        T swap = a[i];
        a[i] = a[j];
        a[j] = swap;
     }

	public static void main(String[] args) {
		Integer[] a = ArrayGenerator.generateInteger(20, 50);
		System.out.println(select(a, 4));
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
	}
}
