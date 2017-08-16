package com.excise;

public class CircularRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isRound(String s, String t) {
		return (s.length() == t.length()) && (s.concat(s).indexOf(t) >= 0);
	}
}
