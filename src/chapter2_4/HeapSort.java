package chapter2_4;

import java.util.Arrays;

import com.util.ArrayGenerator;
import com.util.Print;

public class HeapSort {
	public static <T extends Comparable<T>> void sort(T[] a) {
		if(a.length <= 1) return;
		int N = a.length;
		for(int i = N / 2; i >= 1; i--) {
			sink(a, i, N);
		}
		while(N > 1) {
			exch(a, 1, N--);
			sink(a, 1, N);
		}
	}
	
	private static <T extends Comparable<T>> void sink(T[] a, int k, int N) {
		while( 2 * k <= N) {
			int j = 2 * k;
			if(j < N && less(a, j, j + 1)) j++;
			if(!less(a, k, j)) break;
			exch(a, k , j);
			k = j;
		}
	}
	
	public static <T extends Comparable<T>> boolean less(T[] a, int i, int j) {
		return a[i - 1].compareTo(a[j - 1]) < 0;
	}
		
	public static <T extends Comparable<T>> void exch(T[] a, int i, int j) {
		T temp = a[i - 1];
		a[i - 1] = a[j - 1];
		a[j - 1] = temp;
	}
	
	public static void main(String[] args) {
    	Integer[] a = ArrayGenerator.generateInteger(20, 50);
		Print.println(Arrays.toString(a));
		sort(a);
		Print.println(Arrays.toString(a));
    }
}
