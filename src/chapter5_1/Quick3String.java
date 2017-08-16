package chapter5_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Quick3String {
	public static void sort(String[] a) {
		sort(a, 0, a.length - 1, 0);
	}
	
	public static void sort(String[] a, int lo, int hi, int d) {
		if(hi <= lo) return;
		int lt = lo, gt = hi;
		int v = charAt(a[lo], d);
		int i = lo + 1;
		while(i <= gt) {
			int c = charAt(a[i], d);
			if(c < v) exch(a, i++, lt++);
			else if(c > v) exch(a, i, gt--);
			else i++;
		}
		
		sort(a, lo, lt - 1, d);
		if(v >= 0) sort(a, lt, gt, d + 1);
		sort(a, gt + 1, hi, d);
	}
	
	private static int charAt(String s, int i) {
		if(i < s.length()) {
			return s.charAt(i);
		}
		return -1;
	}
	
	private static void exch(String[] a, int i, int j) {
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new FileInputStream(new File(args[0])));
		List<String> list = new ArrayList<>();
		while(in.hasNext()) {
			list.add(in.next());
		}
		in.close();
		String[] s = new String[list.size()];
		int i = 0;
		for(String str : list) {
			s[i++] = str;
		}
		sort(s);
		System.out.println(Arrays.toString(s));
	}
}
