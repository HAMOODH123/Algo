package com.test;

public class Atio {
	public static int myAtoi(String str) {
        String s = str.trim();
        if(s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        int result = 0;
        int sign = 1, i = 0;
        if(chars[0] == '-') {
            sign = -1;
            i = 1;
        } else if(chars[0] == '+') i = 1;
        for(; i < chars.length && chars[i] >= '0' && chars[i] <= '9'; i++) {
            while(chars[i] == ' ') i++;
            result = result * 10 + (chars[i] - 48);
        }
        if(result < 0) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return result * sign;
    }
	
	public static void main(String[] args) {
		System.out.println(myAtoi("    10522545459"));
	}
}
