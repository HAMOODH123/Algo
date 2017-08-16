package chapter3_1;

import edu.princeton.cs.algs4.Queue;

public class SeparateChainingHashST<Key, Value> {
	private int N;
	private int M;
	private SequentialSearchST<Key, Value>[] st;
	
	@SuppressWarnings("unchecked")
	public SeparateChainingHashST(int cap) {
		N = 0;
		M = cap;
		st = (SequentialSearchST<Key, Value>[])new SequentialSearchST[cap];
		for(int i = 0; i < cap; i++) {
			st[i] = new SequentialSearchST<Key, Value>();
		}
	}
	
	public SeparateChainingHashST() {
		this(3301);
	}
	
    public int size() {
        return N;
    } 
    
    public boolean isEmpty() {
        return size() == 0;
    }
    
	public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            delete(key);
            return;
        }
        
		int hashValue = hash(key);
		if (!st[hashValue].contains(key)) N++;
		st[hashValue].put(key, val);
	}
	
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    } 
	
	public Value get(Key key) {
		if (key == null) throw new IllegalArgumentException("argument to get() is null");
		int hashValue = hash(key);
		return st[hashValue].get(key);
	}
	
	private int hash(Key x) {
		return (x.hashCode() & 0x7fffffff) % M;
	}
	
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");

        int i = hash(key);
        if (st[i].contains(key)) N--;
        st[i].delete(key);
    } 
	
	public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < M; i++) {
            for (Key key : st[i].keys())
                queue.enqueue(key);
        }
        return queue;
	}
}
