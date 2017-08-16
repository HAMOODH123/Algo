package com.chapter1_4;
/**
 * 线性时间的twosum
 */
import java.util.*;

public class TwoSumFaster {
	public static int twoSum(int[] a) {
		int count = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < a.length; i++) {
			if(map.containsKey(-a[i]))
				count++;
			map.put(a[i], i);
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] a = {1, 2, -1, -2, 2, 4, -4, 5, 6};
		System.out.println(twoSum(a));
	}
}
