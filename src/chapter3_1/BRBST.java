package chapter3_1;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class BRBST<Key extends Comparable<Key>, Value> {
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private Node root;
	
	private boolean isRed(Node x) {
		if(x == null) return BLACK;
		return x.color == RED;
	}
	
	private Node rotateLeft(Node x) {
		Node h = x.right;
		x.right = h.left;
		h.left = x;
		h.color = h.left.color;
		h.left.color = RED;
		h.N = x.N;
		x.N = 1 + size(x.left) + size(x.right);
		return h;
	}
	
	private Node rotateRight(Node x) {
		if(x == null) return null;
		Node h = x.left;
		x.left = h.right;
		h.right = x;
		h.color = h.right.color;
		h.right.color = RED;
		h.N = x.N;
		x.N = 1 + size(x.left) + size(x.right);
		return h;
	}
	
	private void flipColors(Node x) {
		x.color = RED;
		x.left.color = BLACK;
		x.right.color = RED;
	}
	
	public int size() {
		return size(root);
	}
	
	private int size(Node x) {
		if(x == null) return 0;
		return x.N;
	}
	
	public boolean isEmpty() {
        return root == null;
    }
	
/*	public void put(Key key, Value val) {
		root = put(root, key, val);
		root.color = BLACK;
	}
	
	private Node put(Node node, Key key, Value val) {
		if(node == null)
			return new Node(key, val, 1, RED);
		int cmp = key.compareTo(node.key);
		if(cmp > 0) node.right = put(node.right, key, val);
		else if(cmp < 0) node.left = put(node.left, key, val);
		else {
			node.val = val;
		}
		
		if(isRed(node.right) && !isRed(node.left)) node = rotateLeft(node);
		if(isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
		if(isRed(node.right) && isRed(node.left)) flipColors(node);
		node.N = 1 + size(node.left) + size(node.right);
		return node;
	} */
	
	public void put(Key key, Value val) {
		Node z = new Node(key, val, 1, RED);
		if(root == null) {
			root = z;
			root.color = BLACK;
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
        
    	if(isRed(parent.right) && !isRed(parent.left)) parent = rotateLeft(parent);
		if(isRed(parent.left) && isRed(parent.left.left)) parent = rotateRight(parent);
		if(isRed(parent.right) && isRed(parent.left)) flipColors(parent); 
	}

	public Value get(Key key) {
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
	
	@SuppressWarnings("unused")
	private boolean isBST() {
        return isBST(root, null, null);
    }
	
	private boolean isBST(Node x, Key min, Key max) {
        if (x == null) return true;
        if (min != null && x.key.compareTo(min) <= 0) return false;
        if (max != null && x.key.compareTo(max) >= 0) return false;
        return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
    } 
	
    @SuppressWarnings("unused")
	private boolean is23() { return is23(root); }
    private boolean is23(Node x) {
        if (x == null) return true;
        if (isRed(x.right)) return false;
        if (x != root && isRed(x) && isRed(x.left))
            return false;
        return is23(x.left) && is23(x.right);
    } 
    
    @SuppressWarnings("unused")
	private boolean isBalanced() { 
        int black = 0;     // number of black links on path from root to min
        Node x = root;
        while (x != null) {
            if (!isRed(x)) black++;
            x = x.left;
        }
        return isBalanced(root, black);
    }
    
    private boolean isBalanced(Node x, int black) {
        if (x == null) return black == 0;
        if (!isRed(x)) black--;
        return isBalanced(x.left, black) && isBalanced(x.right, black);
    } 
	
	class Node {
		Key key;
		Value val;
		Node left, right;
		int N;
		boolean color;
		
		Node(Key key, Value val, int N, boolean color) {
			this.key = key;
			this.val = val;
			this.N = N;
			this.color = color;
		}
	}
	
	public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue) { 
        if (x == null) return; 
        keys(x.left, queue); 
        queue.enqueue(x.key); 
        keys(x.right, queue); 
    } 
    
    public int height() { return height(root); }
    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }

    // return the smallest key; null if no such key
    public Key min() { return min(root); }
    private Key min(Node x) {
        Key key = null;
        while (x != null) {
            key = x.key;
            x = x.left;
        }
        return key;
    }

    // return the largest key; null if no such key
    public Key max() { return max(root); }
    private Key max(Node x) {
        Key key = null;
        while (x != null) {
            key = x.key;
            x = x.right;
        }
        return key;
    }
    
    public boolean contains(Key key) {
    	return get(key) != null;
    }
	
	public static void main(String[] args) {
		String test = "S E A R C H E X A M P L E"; 
        String[] keys = test.split(" "); 
        BRBST<String, Integer> st = new BRBST<String, Integer>();
        for (int i = 0; i < keys.length; i++) 
            st.put(keys[i], i); 

        StdOut.println("size = " + st.size());
        StdOut.println("min  = " + st.min());
        StdOut.println("max  = " + st.max());
        StdOut.println();


        // print keys in order using allKeys()
        StdOut.println("Testing keys()");
        StdOut.println("--------------------------------");
        for (String s : st.keys()) 
            StdOut.println(s + " " + st.get(s)); 
        StdOut.println();

        // insert N elements in order if one command-line argument supplied
        if (args.length == 0) return;
        int n = Integer.parseInt(args[0]);
        BRBST<Integer, Integer> st2 = new BRBST<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            st2.put(i, i);
            int h = st2.height();
            StdOut.println("i = " + i + ", height = " + h + ", size = " + st2.size());
        }


        StdOut.println("size = " + st2.size());
	}
}
