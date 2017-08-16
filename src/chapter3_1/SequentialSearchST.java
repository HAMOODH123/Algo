package chapter3_1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import edu.princeton.cs.algs4.Queue;

public class SequentialSearchST<Key, Value> {
	private int n;
	private Node first;      // the linked list of key-value pairs

    // a helper linked list data type
    private class Node {
        private Key key;
        private Value val;
        private Node next;

        public Node(Key key, Value val, Node next)  {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }
    
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null"); 
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key))
                return x.val;
        }
        return null;
    }

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null"); 
        if (val == null) {
            delete(key);
            return;
        }

        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        n++;
    }
    
    public void delete(Key key) {
    	if (key == null) throw new IllegalArgumentException("argument to delete() is null");
    	first = delete(first, key);
    }
    
    private Node delete(Node node, Key key) {
    	if(node == null) return null;
    	if(node.key.equals(key)) {
    		n--;
    		return node.next;
    	}
    	node.next = delete(node.next, key);
    	return node;
    }
    
    public int size() {
    	return n;
    }
    
    public boolean isEmpty() {
        return size() == 0;
    }
    
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }
    
    public Iterable<Key> keys()  {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
    }


	public static void main(String[] args) throws IOException {
		SequentialSearchST<String, Double> st = new SequentialSearchST<>();
		Scanner in = new Scanner(new File(args[0]));
		while(in.hasNext()) {
			st.put(in.next(), in.nextDouble());
		}
		in.close();
		
		in = new Scanner(System.in);
		double sum = 0.0;
		int count = 0;
		while(in.hasNext()) {
			sum += st.get(in.next());
			count++;
		}
		System.out.printf("%.2f", sum / count);
		
		in.close();				
	}
}
