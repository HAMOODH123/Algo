package chapter2_4;

import java.util.Arrays;

import com.util.ArrayGenerator;
import com.util.Print;

public class MaxPQ<T extends Comparable<T>> {
	private static final int DEFAULT_CAPACITY = 5;
	private T[] a;
	private int size;
	private T min;
	
	@SuppressWarnings("unchecked")
	public MaxPQ() {
		a = (T[])new Comparable[DEFAULT_CAPACITY];
		size = 0;
	}
	
	@SuppressWarnings("unchecked")
	public MaxPQ(int max) {
		a = (T[])new Comparable[max];
		size = 0;
	}
	
	@SuppressWarnings("unchecked")
	public MaxPQ(T[] a) {
		this.a = (T[])new Comparable[a.length + 1];
		for(int i = 0; i < a.length; i++) {
			insert(a[i]);
		}
		size = a.length;
	}
	
	public int size() { return size; }
	public boolean isEmpty() { return size == 0; }
	
	@SuppressWarnings("unchecked")
	private void resize(int length) {
		T[] newArr = (T[])new Comparable[length];
		for(int i = 1; i <= size; i++)
			newArr[i] = a[i];
		a = newArr;
	}
	
	public void insert(T value) {
		if(a.length <= size + 1) resize(2 * a.length);
		if(size == 0) min = value;
		else {
			if(min.compareTo(value) > 0)
				min = value;
		}
		a[size + 1] = value;
		swim(size + 1);
		size++;
	}
	
	public T delMax() {
		if(isEmpty()) throw new ArrayIndexOutOfBoundsException();
		exch(1, size);
		T max = a[size];
		a[size] = null;
		size--;
		sink(1);
		if((size  + 1) < (a.length >> 2)) resize(a.length >> 1);
		return max;
	}
	
	public T max() {
		return a[1];
	}
	
	public T min() {
		return min;
	}
	
	private void swim(int k) {
		while(k > 1 && less(k >> 1, k)) {
			exch(k, k >> 1);
			k = k >> 1;
		}
	}
	
	private void sink(int k) {
		while( 2 * k <= size) {
			int j = 2 * k;
			if(j < size && less(j, j + 1)) j++;
			if(!less(k, j)) break;
			exch(k , j);
			k = j;
		}
	}
	public boolean isMaxPQ() { return isMaxPQ(1); }
	
	private boolean isMaxPQ(int k) {
		if(k > size()) return true;
		int left = 2 * k;
		int right = 2 * k + 1;
		if(left <= size() && less(k, left)) return false;
		if(right <= size() && less(k, right)) return false;
		return isMaxPQ(left) && isMaxPQ(right);
	}
	
	public boolean less(int i, int j) {
		return a[i].compareTo(a[j]) < 0;
	}
		
	public void exch(int i, int j) {
		T temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void main(String[] args) {
    	Integer[] a = ArrayGenerator.generateInteger(20, 50);
		Print.println(Arrays.toString(a));
		MaxPQ<Integer> pq = new MaxPQ<>(a);
		for(int i = 0; i < 3; i++)
			pq.insert(i);
		System.out.println(pq.delMax());
		System.out.println(pq.delMax());
		for(int i = 0; i < 15; i++)
			System.out.println(pq.delMax());
		Print.println(pq.max());
		Print.println(pq.size());
		Print.println(pq.isMaxPQ());
		Print.println(Arrays.toString(pq.a));
		Print.println(pq.min());
    }
}
