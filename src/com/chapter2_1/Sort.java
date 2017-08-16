package com.chapter2_1;

import java.util.Arrays;

import com.util.ArrayGenerator;
import com.util.Print;

import edu.princeton.cs.algs4.StdOut;

public class Sort {
	protected static <T extends Comparable<? super T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }
	
	protected static <T extends Comparable<? super T>> void exch(T[] a, int i, int j) {
        T swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
	
	 static <T extends Comparable<? super T>> boolean isSorted(T[] a, int lo, int hi) {
	        for (int i = lo+1; i < hi; i++)
	            if (less(a[i], a[i-1])) return false;
	        return true;
	 }
	 
	 static <T extends Comparable<? super T>> void show(T[] a) {
		 for (int i = 0; i < a.length; i++) {
			 StdOut.println(a[i]);
	     }
	 }
	 
	 public static void main(String[] args) {
		 Integer[] a = ArrayGenerator.generateInteger(15, 25);
		 Print.println(Arrays.toString(a));
//		 SelectSort.sort(a);
//		 Print.println(Arrays.toString(a));
//		 InsertSort.sort(a);
//		 Print.println(Arrays.toString(a));
//		 ShellSort.sort(a);
//		 Print.println(Arrays.toString(a));
		 MergeSort.sort(a);
		 Print.println(Arrays.toString(a));
		 
//		 MergeSortBTU.sort(a);
//		 Print.println(Arrays.toString(a));
	 }
}
