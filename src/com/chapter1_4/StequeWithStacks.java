package com.chapter1_4;

import java.util.Arrays;
import java.util.Iterator;

import com.util.ArrayGenerator;

import edu.princeton.cs.algs4.Stack;

/**
 * steque支持pop(), push()和enqueue()
 * @author Administrator
 *
 */
public class StequeWithStacks {
	private Stack<Integer> stack = new Stack<>();  //支持pophe push
	private Stack<Integer> queue = new Stack<>();  //只支持enqueue
	
	public boolean isEmpty() { return stack.isEmpty() && queue.isEmpty(); } 
	
	public int pop() {
		if(isEmpty()) throw new NullPointerException();
		if(stack.isEmpty()) {
			while(!queue.isEmpty()) 
				stack.push(queue.pop());
		}
		return stack.pop();
	}
	
	public void push(int item) {
		stack.push(item);
	}
	
	public void enqueue(int item) {
		queue.push(item);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		if(isEmpty()) return sb.append("]").toString();
		Iterator<Integer> iterator1 = stack.iterator();
		Iterator<Integer> iterator2 = queue.iterator();
		if(iterator1.hasNext())
			sb.append(iterator1.next());
		while(iterator1.hasNext()) {
			sb.append(", " + iterator1.next()); 
		}
		Stack<Integer> temp = new Stack<>();
		while(iterator2.hasNext()) {
			temp.push(iterator2.next());
		}
		Iterator<Integer> iterator3 = temp.iterator();
		while(iterator3.hasNext()) {
			sb.append(", " + iterator3.next());
		}
		sb.append("]");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		StequeWithStacks steque = new StequeWithStacks();
		int[] arr = ArrayGenerator.generateInt(15, 50);
		System.out.println(Arrays.toString(arr));
		for(int i = 0; i < 5; i++) {
			steque.push(arr[i]);
		}
		System.out.println(steque);
		for(int i = 5; i < 7; i++)
			steque.enqueue(arr[i]);
		System.out.println(steque);
		steque.pop();
		System.out.println(steque);
		steque.pop();
		System.out.println(steque);
		steque.pop();
		System.out.println(steque);
		steque.pop();
		System.out.println(steque);
		steque.pop();
		System.out.println(steque);
		steque.pop();
		System.out.println(steque);
		
	}
}
