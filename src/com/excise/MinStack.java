package com.excise;

import java.util.*;
public class MinStack {
    class Node {
        int val;
        Node next;
        
        Node(int val) {
            this.val = val;
        }
        
        Node() { this(0); }
    }
    
    private int min;
    private Node head;

    /** initialize your data structure here. */
    public MinStack() {
        min = Integer.MAX_VALUE;
        head = new Node();
    }
    
    public void push(int x) {
        if(x < min) min = x;
        Node old = head.next;
        head.next = new Node(x);
        head.next.next = old;
    }
    
    public void pop() {
        if(head.next == null) return;
        int temp = head.next.val;
        if(min == temp) {
            Node current = head.next.next;
            if(current == null) min = Integer.MAX_VALUE;
            else {
                min = current.val;
                current = current.next;
                while(current != null) {
                    if(current.val < min) min = current.val;
                }
            }
        }
        head.next = head.next.next;
    }
    
    public int top() {
        if(head.next == null) throw new EmptyStackException();
        return head.next.val;
    }
    
    public int getMin() {
        return min;
    }
    
    public static void main(String[] args) {
    	MinStack s = new MinStack();
    	s.push(-2);
    	s.push(0);
    	s.push(-3);
    	System.out.println(s.getMin());
    	s.pop();
    	System.out.println(s.top());
    	System.out.println(s.getMin());
    }
}