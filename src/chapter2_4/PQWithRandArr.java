package chapter2_4;

import java.util.Arrays;

import com.util.ArrayGenerator;
import com.util.Print;

public class PQWithRandArr<T extends Comparable<T>> {
	private static final int ARR_SIZE = 5;
	private T[] a;
	private int size;
	
	@SuppressWarnings("unchecked")
	public PQWithRandArr() {
		a = (T[])new Comparable[ARR_SIZE];
		size = 0;
	}
	
	public void insert(T value) {
		if(size == a.length) resize();
		a[size++] = value;
	}
	
	public T deleteMax() {
		for(int i = 0; i < size; i++) {
			if(less(size - 1, i))
				exch(size - 1, i);
		}
		T max = a[size - 1];
		a[size - 1] = null;
		size--;
		return max;
	}
	
	@SuppressWarnings("unchecked")
	private void resize() {
		T[] newArr = (T[])new Comparable[a.length << 1];
		for(int i = 0; i < size; i++)
			newArr[i] = a[i];
		a = newArr;
	}
	
	private boolean less(int i, int j) {
        return a[i].compareTo(a[j]) < 0;
    }

    private void exch(int i, int j) {
        T swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    
    public static void main(String[] args) {
    	Integer[] a = ArrayGenerator.generateInteger(20, 50);
		Print.println(Arrays.toString(a));
		PQWithRandArr<Integer> pq = new PQWithRandArr<>();
		for(int i = 0; i < 3; i++)
			pq.insert(a[i]);
		System.out.println(pq.deleteMax());
		System.out.println(pq.deleteMax());
		for(int i = 0; i < 10; i++)
			pq.insert(a[i]);
		for(int i = 0; i < 10; i++)
			System.out.println(pq.deleteMax());
    }
}
