package chapter3_2;

import java.util.Random;

import edu.princeton.cs.algs4.RedBlackBST;

public class Set<T extends Comparable<T>> {
	private RedBlackBST<T, T> st;
	
	public Set() {
		st = new RedBlackBST<T, T>();
	}
	
	public int size() { return st.size(); }
	public boolean isEmpty() { return size() == 0; }
	
	public void add(T key) {
		if(!st.contains(key))
			st.put(key, key);
	}
	
	public void delete(T key) {
		st.delete(key);
	}
	
	public boolean contains(T key) {
		return st.contains(key);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(T key : st.keys()) {
			sb.append(key + " ");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Random r = new Random(47);
		Set<Integer> set = new Set<>();
		for(int i = 0; i < 10; i++) {
			set.add(r.nextInt(50));
		}
		System.out.println(set);
	}
}
