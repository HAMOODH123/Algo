package chapter2_3;

import java.util.Arrays;

import com.util.ArrayGenerator;
import com.util.Print;

import edu.princeton.cs.algs4.StdOut;

public class Sort {
	 public static <T extends Comparable<? super T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
     }
	
	 public static <T extends Comparable<? super T>> void exch(T[] a, int i, int j) {
        T swap = a[i];
        a[i] = a[j];
        a[j] = swap;
     }
	
	 public static <T extends Comparable<? super T>> boolean isSorted(T[] a, int lo, int hi) {
	        for (int i = lo+1; i < hi; i++)
	            if (less(a[i], a[i-1])) return false;
	        return true;
	 }
	 
	 public static <T extends Comparable<? super T>> void show(T[] a) {
		 for (int i = 0; i < a.length; i++) {
			 StdOut.println(a[i]);
	     }
	 }
	 
	 public static void main(String[] args) {
		 Integer[] a = ArrayGenerator.generateInteger(10, 50);
		 Print.println(Arrays.toString(a));
//		 QuickSort.sort(a);
//		 Print.println(Arrays.toString(a));
//		 Quick3Way.sort(a);
		 QuickSortNonR.sort(a);
		 Print.println(Arrays.toString(a));
	 }
}
