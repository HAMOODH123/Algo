package com.chapter1_4;

/**
 * 快速3-sum算法从头和尾一起寻找
 */

import java.util.Arrays;

public class ThreeSumFast {
	public static int threeSum(int[] a) {
		int count = 0;
		Arrays.sort(a);
		
		int j, k;
		for(int i = 0; i < a.length - 2; i++) {
			while(i > 0 && a[i] == a[i - 1]) continue;
			j = i + 1;
			k = a.length - 1;
			while(j < k) {
				if((a[j] + a[k]) == -a[i]) {
					count++;
					j++;
					k--;
					while(j < k && a[j] == a[j - 1]) j++;
					while(j < k && a[k] == a[k + 1]) k--;
				} else if((a[j] + a[k]) > -a[i]){
					k--;
				} else
					j++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] a = {1, 2, -1, -2, 2, 4, -4, 5, 6, 3, 6};
		System.out.println(threeSum(a));
	}
}
