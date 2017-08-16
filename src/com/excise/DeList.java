package com.excise;

import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeList<T> {
	private Node first;
	private Node last;
	private int size;
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	public void insertFirst(T value) {
		Node node = new Node(value);
		if(isEmpty()) {
			first = last = node;
			size++;
		} else {
			Node second = first;
			first = node;
			first.next = second;
			second.prev = first;
			size++;
		}
	}
	
	public void insertLast(T value) {
		Node node = new Node(value);
		if(isEmpty()) {
			first = last = node;
			size++;
		} else {
			last.next = node;
			node.prev = last;
			last = last.next;
			size++;
		}
	}
	
	public void insert(T value, int index) {
		Node node = new Node(value);
		if(index > size() - 1 || index < 0)
			throw new ArrayIndexOutOfBoundsException();
		if(index == 0) 
			insertFirst(value);
		else if(index == size() - 1)
			insertLast(value);
		else {
			Node current = first;
			for(int i = 0; i < index - 1; i++) {
				current = current.next;
			} 
			Node temp = current.next;
			current.next = node;
			node.prev = current;
			node.next = temp;
			temp.prev = node;
			size++;
		}
	}
	
	public T deleteFirst() {
		if(isEmpty()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		if(size() == 1) {
			Node oldFirst = first;
			first = last = null;
			size--;
			return oldFirst.data;
		} else {
			Node oldFirst = first;
			first = first.next;
			first.prev = null;
			oldFirst.next = null;
			size--;
			return oldFirst.data;
		}
	}
	
	public T deleteLast() {
		if(isEmpty() || size() == 1)
			return deleteFirst();
		else {
			Node oldLast = last;
			last = last.prev;
			last.next = null;
			oldLast.prev = null;
			size--;
			return oldLast.data;
		}
	}
	
	public T delete(int index) {
		if(index > size() - 1 || index < 0)
			throw new ArrayIndexOutOfBoundsException();
		if(index == 0) 
			return deleteFirst();
		else if(index == size() - 1)
			return deleteLast();
		else {
			Node current = first;
			for(int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			Node node = current.next;
			current.next = current.next.next;
			current.next.prev = current;
			size--;
			return node.data;
		}
	}
	
	public String toString() {
		if(isEmpty()) 
			return null;
		StringBuilder sb = new StringBuilder("[" + first.data);
		Node current = first;
		for(int i = 0; i < size() - 1; i++) {
			current = current.next;
			sb.append(", " + current.data);
		}
		sb.append("]");
		return sb.toString();
	}
	
	private class Node {
		T data;
		Node prev;
		Node next;
		
		Node(T data, Node prev, Node next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
		
		Node(T data) {
			this(data, null, null);
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
//		DeList<Integer> dl = new DeList<>();
//		for(int i = 0; i < 10; i++) {
//			dl.insertLast(i);
//		}
//		println(dl);
//		dl.deleteFirst();
//		dl.deleteLast();
//		println(dl);
//		dl.insertFirst(0);
//		dl.insertLast(10);
//		println(dl);
//		dl.insert(55, 4);
//		println(dl);
//		dl.delete(4);
//		println(dl);
		
		String regex = "(C|c)(O|o)(D|d)(E|e)(R|r)";
		String s = "dvfowcoderfencoderqekcoderbtmcoderehcoderriyjdcodermocoder";
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(s);
		int count = 0;
		while(m.find()) count++;
		System.out.println(count);
		TreeSet<String> ss;
	}
}


