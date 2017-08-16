package com.excise;

public class LinkedList<T> {
	public Node first;
	public Node last;
	public int size;

    public LinkedList() {}
//
//    public IntList(Node first, int size) {
//        this.first = first;
//        this.size = size;
//        Node current = first;
//        for(int i = 0; i < this.size - 1; i++) {
//            current = current.next;
//        }
//        last = current;
//    }
    
    public LinkedList(T[] arr) {
    	for(int i = 0; i < arr.length; i++) {
    		add(arr[i]);
    	}
    }
    
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void add(T value) {
        if(isEmpty()) {
            first = new Node(value);
            last = first;
        } else {
            last.next = new Node(value);
            last = last.next;
        }
        size++;
    }

    public void deleteLast() {
        if(isEmpty())
            throw new ArrayIndexOutOfBoundsException();
        if(size() == 1) {
            first = last = null;
        } else {
            Node current = first;
            for(int i = 0; i < size() - 1; i++) {
                current = current.next;
            }
            last = current;
            last.next = null;
        }
        size--;
    }

    public void delete(int index) {
        if(index >= size())
            throw new ArrayIndexOutOfBoundsException();
        if(index == size() - 1)
            deleteLast();
        else if(size() == 1) {
            first = null;
            last = null;
        } else {
            Node current = first;
            for(int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
    }

    public Node getFirst() {
        return first;
    }
    
    public Node getLast() {
        return last;
    }

    public Node revomeFirst() {
        if(size == 0)
            throw new ArrayIndexOutOfBoundsException();
        if(size == 1) {
            first = last = null;
            return first;
        }
        size--;
        Node temp = first.next;
        first.next = null;
        Node result = first;
        first = temp;
        return result;
    }

    public String toString() {
        if(first == null) return "[]";
        StringBuilder sb = new StringBuilder("[" + first.data);
        Node current = first.next;
        while(current != null) {
        	sb.append(", " + current.data);
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public class Node {
        public T data;
        public Node next;

        public Node(T data) {
            this.data = data;
            next = null;
        }
    }
}
