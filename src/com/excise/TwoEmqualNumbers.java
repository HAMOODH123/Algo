package com.excise;

import java.util.Arrays;

public class TwoEmqualNumbers {

	public static void main(String[] args) {
		int[] a = {2, 1, 3, 2, 2, 2};
		Arrays.sort(a);
		int i = 0, j = 0;
		int count = 0;
		
		for(; i < a.length; i++) {
			j = i+ 1;
			while(j < a.length && a[i] == a[j++])
				count++;
		}
		System.out.println(count);
	}
}
