package chapter5_1;

import java.util.Arrays;

import com.util.ArrayGenerator;
import com.util.Print;

import edu.princeton.cs.algs4.Queue;

public class IndexSortWithQueue {
	@SuppressWarnings("unchecked")
	public static void sort(int[] a) {
		Queue<Integer>[] index = (Queue<Integer>[])new Queue[256];
		for(int i = 0; i < index.length; i++)
			index[i] = new Queue<>();
		
		for(int i = 0; i < a.length; i++)
			index[a[i]].enqueue(a[i]);
		
		int k = 0;
		for(int i = 0; i < index.length; i++) {
			if(index[i].size() != 0) {
				for(int e : index[i])
					a[k++] = e;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = ArrayGenerator.generateInt(10, 10);
		Print.println(Arrays.toString(a));
		sort(a);
		Print.println(Arrays.toString(a));
	}
}
