package com.chapter2_1;

public class MergeSortBTU extends Sort {
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<? super T>> void sort(T[] a) {
		int N = a.length;
		T[] aux = (T[])new Comparable[a.length];
		for(int sz = 1; sz < N; sz += sz) {
			for(int j = 0; j < N - sz; j += sz + sz) {
				merge(a, aux, j, j + sz - 1, Math.min(j + sz + sz - 1, N - 1));
			}
		}
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
}
