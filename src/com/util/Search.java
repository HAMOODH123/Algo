package com.util;

import java.util.Arrays;

public class Search {
	/**
	 * 二分查找,递归实现
	 * @param a
	 * @param key
	 * @param flag flag=1时返回第一个符合条件的索引，flag=0时返回符合雕件的最后一个索引
	 * @return
	 */
	@Deprecated
	public static int binarySearch(int[] a, int key, int flag) {
		if(a.length == 0) throw new ArrayIndexOutOfBoundsException();
		Arrays.sort(a);
		return binarySearch(a, key, flag , 0, a.length - 1);
	}
	
	private static int binarySearch(int[] a, int key, int flag, int start, int end) {
		if((start == end) && (a[start] == key)) return start;
		if(start < end) {
			int mid = start + (end - start) / 2;
			if(a[mid] == key && (end - start) == 1) {
				if(flag == 0 && a[end] == key) return end;
				else return mid;
			}
			if(a[mid] > key) return binarySearch(a, key, flag, start, mid - 1);
			if(a[mid] < key) return binarySearch(a, key, flag, mid + 1, end);
			if(a[mid] == key && flag == 1) return binarySearch(a, key, flag, start, mid);
			if(a[mid] == key && flag == 0) return binarySearch(a, key, flag, mid, end);
		} 
		throw new ArrayIndexOutOfBoundsException();
	}
	
	/**
	 * 二分查找
	 * @param a
	 * @param key
	 * @param flag flag=1时返回第一个符合条件的索引，flag=0时返回符合雕件的最后一个索引
	 * @return
	 */
	public static int binarySearchFlag(int[] a, int key, int flag) {
		int start = 0;
		int end = a.length - 1;
		if(flag == 1) {
			while(start <= end) {
				int mid = start + ((end - start) >> 2);
				if(a[mid] >= key) {
					end = mid - 1;
				} else if(a[mid] < key) {
					start = mid + 1;
				}
			}
			return (start < a.length) && (a[start] == key) ? start : -1;
		} else {
			while(start <= end) {
				int mid = start + ((end - start) >> 2);
				if(a[mid] > key) {
					end = mid - 1;
				} else if(a[mid] <= key) {
					start = mid + 1;
				}
			}
			return (end >= 0) && (a[end] == key) ? end : -1;
		}
	}
	
	public static int binarySearch(int[] a, int key) {
		int start = 0;
		int end = a.length - 1;
		while(start <= end) {
			int mid = start + ((end - start) >> 2);
			if(a[mid] > key) start = mid + 1;
			else if(a[mid] < key) end = mid - 1;
			else return mid;
		}
		return -1;
	}
	
	public static int[] fibonacciGenerator(int length) {
		int[] arr = new int[length];
		int i = 2;
		arr[0] = 1;
		arr[1] = 1;
		while(i <= length) {
			arr[i] = arr[i - 1] + arr[i - 2];
			i++;
		}
		return arr;
	}
	

	public static void main(String[] args) {
		int[] a = {2, 3, 4, 1, 1, 5, 5 ,3, 3, 6};
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		System.out.println(binarySearchFlag(a, 0, 1));
		int[] b = ArrayGenerator.generateInt(10, 100);
		Arrays.sort(b);
		System.out.println(Arrays.toString(b));
		System.out.println(binarySearchFlag(b, -1, 0));
	}
}
