package com.test;

import static com.util.Print.*;

public class TestString {

	public static void main(String[] args) {
		String s1 = "hello";
		println(reversal(s1));
	}
	
	public static String reversal(String s) {
		int N = s.length();
		if(N <= 1)
			return s;
		String a = s.substring(0, N/2);
		String b = s.substring(N/2, N);
		return reversal(b) + reversal(a);
	}
}
