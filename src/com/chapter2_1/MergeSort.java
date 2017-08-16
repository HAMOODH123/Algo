package com.chapter2_1;

public class MergeSort extends Sort {
	
/*	private static <T extends Comparable<? super T>> void merge(T[] a, T[] aux, int lo, int mid, int hi) {
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
	}  */
	
	//不需要检测某半边是否用尽,但排序结果是不稳定的
/*	private static <T extends Comparable<? super T>> void merge(T[] a, T[] aux, int lo, int mid, int hi) {
		int m = lo;
		for(int i = lo; i <= mid; i++) {
			aux[m++] = a[i];
		}
		for(int i = hi; i > mid; i--) {
			aux[m++] = a[i];
		}
		int j = lo;
		int k = hi;
		for(int i = lo; i <= hi; i++) {
			if(less(aux[j], aux[k])) a[i] = aux[j++];
			else a[i] = aux[k--];
		}		
	}  */
	
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
	
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<? super T>> void sort(T[] a) {
		T[] aux = (T[])new Comparable[a.length];
		sort(a, aux, 0, a.length - 1);
	}
	
	//3个改进
	private static <T extends Comparable<? super T>>  void sort(T[] a, T[] aux, int lo, int hi) {
//		if(lo >= hi) return;
		if((hi - lo) < 15) {
			insertSort(a, lo, hi);
			return;
		}
		int mid = lo + ((hi - lo) >> 1);
		sort(a, aux, lo, mid);
		sort(a, aux, mid + 1, hi);
		if(!less(a[mid + 1], a[mid])) return;
		merge(a, aux, lo, mid, hi);
	}
	
	public static <T extends Comparable<? super T>> void insertSort(T[] a, int lo, int hi) {
		for(int i = lo; i <= hi; i++) {
			int min = i;
			for(int j = i + 1; j < a.length; j++) {
				if(less(a[j], a[min])) min = j;
			}
			exch(a, i, min);
		}		
	}
}
