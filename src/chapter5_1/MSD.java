package chapter5_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MSD {
	private static String[] aux;
	private static final int R = 256;
	private static final int M = 15;
	
	public static void sort(String[] a) {
		aux = new String[a.length];
		sort(a, 0, a.length - 1, 0);
	}
	
	public static void sort(String[] a, int lo, int hi, int d) {
		int[] count = new int[R + 2];
		if(hi <= lo + M) {
			insertSort(a, lo, hi, d);
			return;
		}
		
		for(int i = lo; i <= hi; i++)
			count[charAt(a[i], d) + 2]++;
		
		for(int i = 0; i < R + 1; i++)
			count[i + 1] += count[i];
		
		for(int i = lo; i <= hi; i++)
			aux[count[charAt(a[i], d) + 1]++] = a[i];
		
		for(int i = lo; i <= hi; i++)
			a[i] = aux[i - lo];
		
		for(int i = 0; i < R; i++)
			sort(a, lo + count[i], lo + count[i + 1] - 1, d + 1);
	}
	
	private static int charAt(String s, int i) {
		if(i < s.length()) {
			return s.charAt(i);
		}
		return -1;
	}
	
	private static void insertSort(String[] a, int lo, int hi, int d) {
		for(int i = lo + 1; i <= hi; i++) {
			for(int j = i; j > lo && less(a[j], a[j - 1], d); j--) 
				exch(a, j - 1, j);
		}
	}
	
	private static void exch(String[] a, int i, int j) {
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private static boolean less(String v, String w, int d) {
		return v.substring(d).compareTo(w.substring(d)) < 0;
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
