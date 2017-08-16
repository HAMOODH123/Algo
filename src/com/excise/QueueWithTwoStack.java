package com.excise;

import edu.princeton.cs.algs4.Stack;

public class QueueWithTwoStack<T> {
	private Stack<T> s1;
	private Stack<T> s2;
	
	public QueueWithTwoStack() {
		s1 = new Stack<>();
		s2 = new Stack<>();
	}
	
	private void moveFromS1ToS2() {
		while(!s1.isEmpty())
			s2.push(s1.pop());
	}
	
	public int size() { return s1.size() + s2.size(); }
	public boolean isEmpty() { return s1.isEmpty() && s2.isEmpty(); }
	
	public void enqueue(T value) {
		s1.push(value);
	}
	
	public T dequeue() {
		if(isEmpty()) { throw new ArrayIndexOutOfBoundsException(); }
		if(s2.isEmpty()) moveFromS1ToS2();
		return s2.pop();
	}
	
	public T peek() {
		if(isEmpty()) { throw new ArrayIndexOutOfBoundsException(); }
		if(s2.isEmpty()) moveFromS1ToS2();
		return s2.peek();
	}
	

	public static void main(String[] args) {
		QueueWithTwoStack<Integer> q = new QueueWithTwoStack<>();
		for(int i = 0; i < 10; i++)
			q.enqueue(i);
		System.out.println(q.size());
		q.dequeue();
		System.out.println(q.size());
		
	}
}
