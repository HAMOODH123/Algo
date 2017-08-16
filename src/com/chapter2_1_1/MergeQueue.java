package com.chapter2_1_1;

import edu.princeton.cs.algs4.Queue;

public class MergeQueue {
	public static <T extends Comparable<? super T>> Queue<T> merge(Queue<T> q1, Queue<T> q2) {
		Queue<T> result = new Queue<>();

		while(!q1.isEmpty() || !q2.isEmpty()) {
			if(q1.isEmpty())  result.enqueue(q2.dequeue());
			else if(q2.isEmpty()) result.enqueue(q1.dequeue());
			else if(q1.peek().compareTo(q2.peek()) < 0) 
				result.enqueue(q1.dequeue());
			else
				result.enqueue(q2.dequeue());
		}
		return result;
	}

	public static void main(String[] args) {
		Queue<Integer> q1 = new Queue<Integer>();
		Queue<Integer> q2 = new Queue<Integer>();
//		Random r1 = new Random(37);
//		Random r2 = new Random(47);
		for(int i = 0; i < 50; i++) {
			q1.enqueue(i);
			q2.enqueue(i * i);
		}
		System.out.println(q1);
		System.out.println(q2);
		System.out.println(merge(q1, q2));
	}
}
