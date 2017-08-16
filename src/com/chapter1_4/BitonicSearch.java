package com.chapter1_4;
/**
 * 双调查找 ~3lgN
 * @author Administrator
 *
 */
public class BitonicSearch {
	private static int bitonicMax(int[] a, int start, int end) {
		if(start == end) return start;
		int mid = (start + end) / 2;  //可能溢出
		if(a[mid] > a[mid + 1]) return bitonicMax(a, start, mid);
		else if(a[mid] < a[mid + 1]) return bitonicMax(a, mid + 1, end);
		else return mid;
	}
	
	public static boolean bitonicSearch(int[] a, int key) {
		int maxIndex = bitonicMax(a, 0, a.length);  //找出数组中最大元素
		return binarySearch(a, 0, maxIndex, key) || binarySearch(a, maxIndex + 1, a.length - 1, key);
	}  
	
	//正常二分查找
	@Deprecated
	static boolean  binarySearch(int[] a, int start, int end, int key) {
		if(start <= end) {
			int mid = (start + end) / 2;
			if(a[mid] > key) return binarySearch(a, start, mid - 1, key);
			else if(a[mid] < key) return binarySearch(a, mid + 1, end, key);
			else return true;
		} else 
			return false;
	}
	
	//逆二分查找
	@Deprecated
	static boolean binarySearchReverse(int[] a, int start, int end, int key) {
		if(start <= end) {
			int mid = (start + end) / 2;
			if(a[mid] < key) return binarySearch(a, start, mid - 1, key);
			else if(a[mid] > key) return binarySearch(a, mid + 1, end, key);
			else return true;
		} else 
			return false;
	}

	public static void main(String[] args) {
		int[] a = {1, 2, 4, 5, 6, 5, 4, 3, 1};
		System.out.println(bitonicSearch(a, 3));
	}
}
