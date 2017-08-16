package chapter2_5;

import java.util.Arrays;

import com.util.ArrayGenerator;
import com.util.Print;

public class ParrellSort {
	public static <T extends Comparable<? super T>> int[] sort(T[] a) {
		int[] index = new int[a.length];
		for(int i = 0; i < index.length; i++) {
			index[i] = i;
		}
		
		for(int i = 1; i < a.length; i++) {
			int j = i - 1;
			for(; j >= 0 && less(a, index, j + 1, j); j--) {
				exch(index, j + 1, j);
			}
//			index[j + 1] = temp;
		}
		return index;
	}
	
	protected static <T extends Comparable<? super T>> boolean less(T[] a, int[] index, int i, int j) {
        return a[index[i]].compareTo(a[index[j]]) < 0;
    }
	
	protected static <T extends Comparable<? super T>> void exch(int[] index, int i, int j) {
        int swap = index[i];
        index[i] = index[j];
        index[j] = swap;
    }

	public static void main(String[] args) {
		Integer[] a = ArrayGenerator.generateInteger(10, 25);
		Print.println(Arrays.toString(a));
		System.out.println(Arrays.toString(sort(a)));
	}
}
