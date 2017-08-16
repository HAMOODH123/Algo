package com.excise;

//import java.util.Arrays;
import static com.util.Print.*;

import computing.BinarySearch;

public class Test {

	public static void main(String[] args) {
		String s = "(1+((2 +3)* (4 * 5)))";
		String s1 = s.replaceAll("\\+|-|\\*|/|\\(+|\\)+|sqrt|\\d\\.\\d|\\d", " ");
		String s2 = s.replaceAll("\\d\\.\\d|\\d", " ");
//		String sc[] = s.trim().split("\\+|-|\\*|/|\\(+|\\)+");
		println(s1);
		println(s2);
		int[] a = {1, 3, 4, 4,  5, 5, 5};
		println(BinarySearch.indexOf(a, 4));
	}
}
