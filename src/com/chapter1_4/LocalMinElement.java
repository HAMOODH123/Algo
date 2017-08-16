package com.chapter1_4;

public class LocalMinElement {
	public static int localMinElement(int[] a) {
		if(a.length == 1) return 0;
		return localMinElement(a, 0, a.length - 1);
	}
	
	private static int localMinElement(int[] a, int start, int end) {
		if(a[start] < a[start + 1]) return start;
		if(a[end - 1] > a[end]) return end;
		int mid = end / 2;
		if(a[mid] < a[mid - 1] && a[mid] < a[mid + 1]) return mid;
		else {
			if(a[mid - 1] < a[mid + 1])
				return localMinElement(a, start, mid - 1);
			else
				return localMinElement(a, mid + 1, end);
		}
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int[] a = {};
		
	}
}
