package chapter2_4;

import java.util.Arrays;
import java.util.NoSuchElementException;

import com.util.Print;

public class IndexMinPQ<T extends Comparable<T>> {
	private T[] a;	
	private int[] pq;      //保存索引
	private int[] qp;	   //pq的逆
	private int size;
	
	@SuppressWarnings("unchecked")
	public IndexMinPQ(int N) {
		a = (T[])new Comparable[N + 1];
		pq = new int[N + 1];
		qp = new int[N + 1];
		for(int i = 0; i < qp.length; i++)
			qp[i] = -1;
		size = 0;
	}
	
	public int size() { return size; }
	public boolean isEmpty() { return size == 0; }
	public boolean contains(int i) {
        return qp[i] != -1;
    }
	
	public void insert(int k, T value) {
		if (contains(k)) throw new IllegalArgumentException("index is already in the priority queue");
        size++;
        qp[k] = size;
        pq[size] = k;
        a[k] = value;
        swim(size);
	}
	
	public void change(int k, T value) {
		if (!contains(k)) throw new NoSuchElementException("index is not in the priority queue");
		a[k] = value;
		swim(k);
		sink(k);
	}
	
	public void delete(int k) {
		if (!contains(k)) throw new NoSuchElementException("index is not in the priority queue");
		int index = qp[k];
		exch(size--, index);
		swim(index);
		sink(index);
		a[k] = null;
		qp[k] = -1;
	}
	
	public int delMin() {
		if (size == 0) throw new NoSuchElementException("Priority queue underflow");
		int min = pq[1];
		exch(1, size--);
		sink(1);
		qp[min] = -1;
		pq[size + 1] = -1;
		a[min] = null;	
		return min;
	}
	
	public int minIndex() {
		return pq[1];
	}
	
	public T min() {
		return a[pq[1]];
	}
	
	private void swim(int k) {
		while(k > 1 && less(k, k / 2)) {
			exch(k, k >> 1);
			k = k >> 1;
		}
	}
	
	private void sink(int k) {
		while( 2 * k <= size) {
			int j = 2 * k;
			if(j < size && less(j + 1, j)) j++;
			if(!less(j, k)) break;
			exch(k , j);
			k = j;
		}
	}
	
	public boolean less(int i, int j) {
		return a[pq[i]].compareTo(a[pq[j]]) < 0;
	}
		
	public void exch(int i, int j) {
		int temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
		qp[pq[i]] = i;
		qp[pq[j]] = j;
	}
	
	public static void main(String[] args) {
		IndexMinPQ<Character> pq = new IndexMinPQ<>(5);
		pq.insert(5, 'g');
		pq.insert(1, 'b');
		pq.insert(3, 'a');
		pq.insert(2, 'c');
		pq.insert(4, 'e');
		Print.println(Arrays.toString(pq.a));
		Print.println(Arrays.toString(pq.pq));
		Print.println(Arrays.toString(pq.qp));
		Print.println(pq.delMin());
		Print.println(Arrays.toString(pq.a));
		Print.println(Arrays.toString(pq.pq));
		Print.println(Arrays.toString(pq.qp));
		Print.println(pq.delMin());
    }
}
