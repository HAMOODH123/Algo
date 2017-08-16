package chapter3_1;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.Queue;

public class BST<K extends Comparable<K>, V> {
	private Node root;
	
	private class Node {
		K key;
		V val;
		Node right, left;
		int size;
		
		Node(K key, V val, int N) {
			this.key = key;
			this.val = val;
			this.size = N;
		}
	}
	
	public int size() {
		return size(root);
	}
	
	private int size(Node node) {
		if(node == null) return 0;
		return node.size;
	}
	
    public boolean isEmpty() {
        return size() == 0;
    }
	
	public boolean contains(K key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }
	
	public V get(K key) {
		if (key == null) throw new IllegalArgumentException("called get() with a null key");
		Node x = root;
		while(x != null) {
			int cmp = key.compareTo(x.key);
			if(cmp > 0) x = x.right;
			else if(cmp < 0) x = x.left;
			else return x.val;
		}
		return null;
	} 
	
/*	public V get(Node node, K key) {
        if (key == null) throw new IllegalArgumentException("called get() with a null key");
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if      (cmp < 0) return get(node.left, key);
        else if (cmp > 0) return get(node.right, key);
        else              return node.val;
	} */
	
	public void put(K key, V val) {
		Node z = new Node(key, val, 1);
		if(root == null) {
			root = z;
			return;
		}
		
        Node x = root, parent = null;
        while(x != null) {
        	parent = x;
        	int cmp = key.compareTo(x.key);
        	if(cmp > 0) {
        		x = x.right;
        	} else if(cmp < 0) {
        		x = x.left;
        	} else {
        		x.val = val;
        		return;
        	}        	
        }
        int cmp = key.compareTo(parent.key);
        if(cmp > 0) parent.right = z;
        else parent.left = z;
	} 
	
/*	public void put(K key, V val) {
		if (key == null) throw new IllegalArgumentException("calledput() with a null key");
        if (val == null) {
            delete(key);
            return;
        }
        root = put(root, key, val);
	}
	
	private Node put(Node x, K key, V val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }   */
	
	public void deleteMin() {
		if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
		root = deleteMin(root);
	}
	
	private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
	}
	
	public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMax(root);
	}
	
    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
	
	public void delete(K key) {
        if (key == null) throw new IllegalArgumentException("called delete() with a null key");
        root = delete(root, key);
	}
	
    private Node delete(Node x, K key) {
        if (x == null) return null;

        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = delete(x.left,  key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else { 
            if (x.right == null) return x.left;
            if (x.left  == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        } 
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    } 
	
	public K min() {
		if (isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");
		return min(root).key;
	}
	
	private Node min(Node node) {
		if(node.left == null) return node;
		return min(node.left);
	}
	
	public K max() {
        if (isEmpty()) throw new NoSuchElementException("called max() with empty symbol table");
        return max(root).key;
	}
	

    private Node max(Node x) {
        if (x.right == null) return x; 
        else                 return max(x.right); 
    }
    
	
	public K select(int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException("called select() with invalid argument: " + k);
        }
        Node x = select(root, k);
        return x.key;
	}
	
    private Node select(Node x, int k) {
        if (x == null) return null; 
        int t = size(x.left); 
        if      (t > k) return select(x.left,  k); 
        else if (t < k) return select(x.right, k-t-1); 
        else            return x; 
    }
    
	public int rank(K key) {
        if (key == null) throw new IllegalArgumentException("argument to rank() is null");
        return rank(key, root);
	}
	
    private int rank(K key, Node x) {
        if (x == null) return 0; 
        int cmp = key.compareTo(x.key); 
        if      (cmp < 0) return rank(key, x.left); 
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right); 
        else              return size(x.left); 
    } 
	
	public Iterable<K> keys() {
		 return keys(min(), max());
	}
	
    public Iterable<K> keys(K lo, K hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");

        Queue<K> queue = new Queue<K>();
        keys(root, queue, lo, hi);
        return queue;
    } 

    private void keys(Node x, Queue<K> queue, K lo, K hi) { 
        if (x == null) return; 
        int cmplo = lo.compareTo(x.key); 
        int cmphi = hi.compareTo(x.key); 
        if (cmplo < 0) keys(x.left, queue, lo, hi); 
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key); 
        if (cmphi > 0) keys(x.right, queue, lo, hi); 
    } 
	
	public int height() {
		return height(root);
	}
	
	private int height(Node x) {
		if(x == null) return 0;
		return 1 + Math.max(height(x.left), height(x.right));
	}
	
	@SuppressWarnings("unused")
	public static void main() {
		Map<String, String> map = new HashMap<String, String>();
	}
}
