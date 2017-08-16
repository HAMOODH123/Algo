package chapter3_1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import edu.princeton.cs.algs4.Queue;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
	private static final int INIT_CAPACITY = 2;
    Key[] keys;
    private Value[] vals;
    private int n = 0;

    /**
     * Initializes an empty symbol table.
     */
    public BinarySearchST() {
        this(INIT_CAPACITY);
    }

    /**
     * Initializes an empty symbol table with the specified initial capacity.
     * @param capacity the maximum capacity
     */
    @SuppressWarnings("unchecked")
	public BinarySearchST(int capacity) { 
        keys = (Key[]) new Comparable[capacity]; 
        vals = (Value[]) new Object[capacity]; 
    }   

    // resize the underlying arrays
    @SuppressWarnings("unchecked")
	private void resize(int capacity) {
        assert capacity >= n;
        Key[]   tempk = (Key[])   new Comparable[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            tempk[i] = keys[i];
            tempv[i] = vals[i];
        }
        vals = tempv;
        keys = tempk;
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return n;
    }

    /**
     * Returns true if this symbol table is empty.
     *
     * @return {@code true} if this symbol table is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }


    /**
     * Does this symbol table contain the given key?
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }
    
    public int rank(Key key) {
    	if (key == null) throw new IllegalArgumentException("argument to rank() is null");
    	int lo = 0;
    	int hi = n - 1;
    	while(lo <= hi) {
    		int mid = lo + (hi - lo) / 2;
    		if(key.compareTo(keys[mid]) < 0) hi = mid - 1;
    		else if(key.compareTo(keys[mid]) > 0) lo = mid + 1;
    		else  return mid;
    	}
    	return lo;
    }
    
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null"); 
        if (isEmpty()) return;

        // compute rank
        int i = rank(key);

        // key not in table
        if (i == n || keys[i].compareTo(key) != 0) {
            return;
        }

        for (int j = i; j < n-1; j++)  {
            keys[j] = keys[j+1];
            vals[j] = vals[j+1];
        }

        n--;
        keys[n] = null;  // to avoid loitering
        vals[n] = null;

        // resize if 1/4 full
        if (n > 0 && n == keys.length/4) resize(keys.length/2);

    } 
    
    public Value get(Key key) {
    	if (key == null) throw new IllegalArgumentException("argument to get() is null");
    	if(isEmpty()) return null;
    	int j = rank(key);
    	if(j < n && key.compareTo(keys[j]) == 0) return vals[j];
    	return null;
    }
    
    public void put(Key key, Value value) {
    	if (key == null) throw new IllegalArgumentException("first argument to put() is null");
    	
    	if (value == null) {
            delete(key);
            return;
        }
    	
    	if(n == keys.length) resize(2 * keys.length);
    	int j = rank(key);
    	if(j < n && keys[j].compareTo(key) == 0) {
    		vals[j] = value;
    		return;
    	}
    	n++;
    	int i = n - 1;
    	for(; i > j; i--) {
    		keys[i] = keys[i - 1];
    		vals[i] = vals[i - 1];
    	}
    	keys[i] = key;
    	vals[i] = value;
    }
    
    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to keys() is null"); 
        if (hi == null) throw new IllegalArgumentException("second argument to keys() is null"); 

        Queue<Key> queue = new Queue<Key>(); 
        if (lo.compareTo(hi) > 0) return queue;
        for (int i = rank(lo); i < rank(hi); i++) 
            queue.enqueue(keys[i]);
        if (contains(hi)) queue.enqueue(keys[rank(hi)]);
        return queue; 
    }
    
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>(); 
        for(int i = 0; i < n; i++) {
        	queue.enqueue(keys[i]);
        }
        return queue; 
    }
    
    public static void main(String[] args) throws IOException {
    	BinarySearchST<String, Double> st = new BinarySearchST<>();
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
