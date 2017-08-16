package com.excise;

import static com.util.Print.*;

public class Deque<T> {
	private int size;
	private Node leftHead;
	private Node rightHead;
	
	public Deque() {
		size = 0;
		leftHead = rightHead = null;
	}
	
	public boolean isEmpty() { return size == 0; }	
	public int size() { return size; }
	
	public void pushLeft(T value) {
		if(isEmpty()) {
			leftHead = rightHead = new Node(value);
			size++;
		} else {
			Node node = new Node(value);
			leftHead.prev = node;
			node.next = leftHead;
			leftHead = leftHead.prev;
			size++;
		}
			
	}
	
	public void pushRight(T value) {
		if(isEmpty()) {
			leftHead = rightHead = new Node(value);
			size++;
		} else {
			Node node = new Node(value);
			rightHead.next = node;
			node.prev = rightHead;
			rightHead = rightHead.next;
			size++;
		}
	}
	
	public T popLeft() {
		if(isEmpty())
			throw new ArrayIndexOutOfBoundsException();
		if(size() == 1) {
			Node oldLeftHead = leftHead;
			leftHead = rightHead = null;
			size--;
			return oldLeftHead.data;
		} else {
			Node oldLeftHead = leftHead;
			leftHead = leftHead.next;
			leftHead.prev = null;
			size--;
			return oldLeftHead.data;
		}
	}
	
	public T popRight() {
		if(isEmpty())
			throw new ArrayIndexOutOfBoundsException();
		if(size() == 1) {
			Node oldLeftHead = leftHead;
			leftHead = rightHead = null;
			size--;
			return oldLeftHead.data;
		} else {
			Node oldRightHead = rightHead;
			rightHead = rightHead.prev;
			rightHead.next = null;
			size--;
			return oldRightHead.data;
		}
	}
	
	private class Node {
		T data;
		Node prev;
		Node next;
		
		public Node(T data, Node prev, Node next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
		
		public Node(T data) {
			this(data, null, null);
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("[" + leftHead.data);
		Node current = leftHead;
		for(int i = 0; i < size() - 1; i++) {
			current = current.next;
			sb.append(", " + current.data);
		}
		sb.append("]");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Deque<Integer> q = new Deque<>();
		for(int i = 0; i < 5; i++)
			q.pushLeft(1);
		q.pushLeft(9);
		q.pushLeft(9);
		println(q);
		q.pushRight(10);
		q.pushRight(10);
		println(q);
		q.pushRight(10);
		println(q);
		q.popLeft();
		q.popLeft();
		println(q);
		q.popRight();
		println(q);
	}
}
