package chapter5_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class LSD {
	public static void sort(String[] a, int w) {
		int R = 256;
		String[] aux = new String[a.length];
		
		for(int i = w - 1; i >= 0; i--) {
			int[] count = new int[R + 1];
			for(int j = 0; j < a.length; j++)
				count[a[j].charAt(i) + 1]++;
			
			for(int j = 0; j < R; j++)
				count[j + 1] += count[j];
			
			for(int j = 0; j < a.length; j++)
				aux[count[a[j].charAt(i)]++] = a[j];
			
			for(int j = 0; j < a.length; j++)
				a[j] = aux[j];
		}
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
		sort(s, 3);
		System.out.println(Arrays.toString(s));
	}
}
