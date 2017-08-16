package chapter3_1;

import edu.princeton.cs.algs4.Queue;

public class LinearProbingHashST<Key, Value> {
	private static final int INIT_CAPACITY = 4;
	
	private Key[] keys;
	private Value[] vals;
	private int N;
	private int M;
	
	@SuppressWarnings("unchecked")
	public LinearProbingHashST(int cap) {
		keys = (Key[])new Object[cap];
		vals = (Value[])new Object[cap];
		M = cap;
		N = 0;
	}
	
	public LinearProbingHashST() {
		this(INIT_CAPACITY);
	}
	
    public int size() {
        return N;
    }
    
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }
	
	public void resize(int cap) {
		LinearProbingHashST<Key, Value> temp = new LinearProbingHashST<Key, Value>(cap);
		for(int i = 0; i < M; i++) {
			if(keys[i] != null)
				temp.put(keys[i], get(keys[i]));
		}
		keys = temp.keys;
		vals = temp.vals;
		M = temp.M;
	}
	
	public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");

        if (val == null) {
            delete(key);
            return;
        }
        
        if (N >= M/2) resize(2*M);
        
		int hashVal = hash(key);
		while(keys[hashVal] != null) {
			if(keys[hashVal].equals(key)) {
				vals[hashVal] = val;
				return;
			}
			hashVal = (hashVal + 1) % M;
		}
		keys[hashVal] = key;
		vals[hashVal] = val;
		N++;
	}
	
	public Value get(Key key) {
		if (key == null) throw new IllegalArgumentException("argument to get() is null");
		int hashVal = hash(key);
		while(keys[hashVal] != null) {
            if (keys[hashVal].equals(key))
                return vals[hashVal];
            hashVal = (hashVal + 1) % M;
		}
        return null;
	}
	
	public void delete(Key key) {
		if (key == null) throw new IllegalArgumentException("argument to delete() is null");
		if (!contains(key)) return;
		
		int hashVal = hash(key);
		while(!keys[hashVal].equals(key)) {
			hashVal = (hashVal + 1) % M;
		}
		keys[hashVal] = null;
		vals[hashVal] = null;
		hashVal = (hashVal + 1) % M;
		while(keys[hashVal] != null) {
			Key keyNext = keys[hashVal];
			Value valNext = vals[hashVal];			
			keys[hashVal] = null;
			vals[hashVal] = null;
			N--;
			put(keyNext, valNext);
			hashVal = (hashVal + 1) % M;
		}
		N--;
		if (N > 0 && N <= M/8) resize(M/2);
	}
	
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < M; i++)
            if (keys[i] != null) queue.enqueue(keys[i]);
        return queue;
    }
	
	private int hash(Key x) {
		return (x.hashCode() & 0x7fffffff) % M;
	}
}
