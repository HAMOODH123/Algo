package com.chapter2_1_1;

import java.util.Arrays;

import com.chapter2_1.Sort;
import com.util.ArrayGenerator;
import com.util.Print;

public class NatureMerge extends Sort {
	public static <T extends Comparable<? super T>> int pass(T[] arr, int[] mark) {
		int j = 0;
		T temp = arr[0];
		mark[j++] = 0;
		for(int i = 1; i < arr.length; i++) {
			if(temp.compareTo(arr[i]) <= 0) temp = arr[i];
			else mark[j++] = i;
		}
		mark[j] = arr.length;
		return j;
	}
	
	public static <T extends Comparable<? super T>> void natureMerge(T[] arr, T[] aux, int[] mark) {
		int max = pass(arr, mark);
		
		for(int sz = 1; sz < max; sz += sz) {
			for(int i = 0; i < max - sz; i += sz + sz) {
				merge(arr, aux, mark[i], mark[i + sz] - 1, mark[Math.min(i + sz + sz, max)] - 1);
			}
		}
	}
	
	//要检查N<=2时的特殊境况
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<? super T>> void sort(T[] a) {
		int N = a.length;
		if(N <= 1) return ;
		if(N == 2) if(less(a[1], a[0])) exch(a, 0, 1);
		int[] mark = new int[N];
		T[] aux = (T[])new Comparable[N];
		natureMerge(a, aux, mark);
	}
	
	private static <T extends Comparable<? super T>> void merge(T[] a, T[] aux, int lo, int mid, int hi) {
		for(int i = lo; i <= hi; i++) {
			aux[i] = a[i];
		}
		int j = lo;
		int k = mid + 1;
		for(int i = lo; i <= hi; i++) {
			if(j > mid) a[i] = aux[k++]; 
			else if(k > hi) a[i] = aux[j++];
			else if(less(aux[j], aux[k])) a[i] = aux[j++];
			else a[i] = aux[k++];
		}		
	}
	
	protected static <T extends Comparable<? super T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }
	
	protected static <T extends Comparable<? super T>> void exch(T[] a, int i, int j) {
        T swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
	
	public static void main(String[] args) {
		 Integer[] a = ArrayGenerator.generateInteger(25, 23);
		 Print.println(Arrays.toString(a));
		 sort(a);
		 Print.println(Arrays.toString(a));
	 }
}
