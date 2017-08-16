package com.excise;

import edu.princeton.cs.algs4.Queue;

public class StackWithTwoQueue<T> {
	private Queue<T> q1;
	private Queue<T> q2;
	private int size;
	
	public StackWithTwoQueue() {
		q1 = new Queue<>();
		q2 = new Queue<>();
		size = 0;
	}
	
	public int size() {return size; }
	public boolean isEmpty() {return size == 0; }
	
	public void push(T value) {
		if(!q1.isEmpty() || (q1.isEmpty() && q2.isEmpty())) {
			q1.enqueue(value);
			size++;
		}
		else {
			q2.enqueue(value);
			size++;
		}
	}
	
	public T pop() {
		if(isEmpty())
			throw new ArrayIndexOutOfBoundsException();
		if(!q1.isEmpty()) {
			while(q1.size() > 1)
				q2.enqueue(q1.dequeue());
			size--;
			return q1.dequeue();
		} else {
			while(q2.size() > 1)
				q1.enqueue(q2.dequeue());
			size--;
			return q2.dequeue();
		}
	}
	
	public T peek() {
		if(isEmpty())
			throw new ArrayIndexOutOfBoundsException();
		if(!q1.isEmpty()) {
			while(q1.size() > 1)
				q2.enqueue(q1.dequeue());
			T result = q1.dequeue();
			q2.enqueue(result);
			return result;
		} else {
			while(q2.size() > 1)
				q1.enqueue(q2.dequeue());
			T result = q2.dequeue();
			q1.enqueue(result);
			return result;
		}
		
	}
	
	public String toString() {
		if(!q1.isEmpty())
			return q1.toString();
		else 
			return q2.toString();
	}

	public static void main(String[] args) {
		StackWithTwoQueue<Integer> sq = new StackWithTwoQueue<>();
		for(int i = 0; i < 10; i++) 
			sq.push(i);
		System.out.println(sq);
		sq.pop();
		sq.pop();
		System.out.println(sq);
		sq.push(25);
		System.out.println(sq);
		sq.pop();
		System.out.println(sq);
		sq.peek();
		System.out.println(sq);
	}
}
