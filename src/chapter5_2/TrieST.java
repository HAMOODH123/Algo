package chapter5_2;

import java.util.LinkedList;
import java.util.Queue;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class TrieST<V> {
	private static final int R = 256;
	private Node root;
	private int n;
	
	public int size() { return n; }
	
	public boolean isEmpty() {
        return size() == 0;
    }
	
	public boolean contains(String key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }
	
	@SuppressWarnings("unchecked")
	public V get(String key) {
		Node x = get(root, key, 0);
		if(x == null) return null;
		return (V)x.val;
	}
	
	private Node get(Node x, String key, int d) {
		if(x == null) return null;
		if(d == key.length()) return x;
		char c = key.charAt(d);
		return get(x.next[c], key, d + 1);
	}
	
	public void put(String key, V val) {
		if (key == null) throw new IllegalArgumentException("first argument to put() is null");
		if (val == null) delete(key);
		root = put(root, key, val, 0);
	}
	
	private Node put(Node x, String key, V val, int d) {
		if(x == null) x = new Node();
		if(d == key.length()) {
			if(x.val == null) n++;
			x.val = val;
			return x;
		}
		char c = key.charAt(d);
		x.next[c] = put(x.next[c], key, val, d + 1);
		return x;
	}
	
	public void delete(String key) {
		if (key == null) throw new IllegalArgumentException("argument to delete() is null");
		root = delete(root, key, 0);
	}
	
	private Node delete(Node x, String key, int d) {
		if(x == null) return null;
		if(d == key.length()) {
			x.val = null;
		} else {
			char c = key.charAt(d);
			x.next[c] = delete(x.next[c], key, d + 1);
		}
		
		if(x.val != null) return x;
		for(int i = 0; i < R; i++)
			if(x.next[i] != null) return x;
		return null;
	}
	
	public Iterable<String> keys() {
		return keysWithPrefix("");
	}
	
	public Iterable<String> keysWithPrefix(String pre) {
		Queue<String> q = new LinkedList<>();
		collect(get(root, pre, 0), pre, q);
		return q;
	}
	
	private void collect(Node x, String pre, Queue<String> q) {
		if(x == null) return ;
		if(x.val != null) q.add(pre);
		for(char c = 0; c < R; c++) {
			collect(x.next[c], pre + c, q);			
		}
	}
	
	public Iterable<String> keysThatMatch(String pat) {
		Queue<String> q = new LinkedList<>();
		collect(root, "", pat, q);
		return q;
	}
	
	private void collect(Node x, String pre, String pat, Queue<String> q) {
		if(x == null) return ;
		int d = pre.length();
		if(d == pat.length() && x.val != null) q.add(pre);
		if(d == pat.length()) return ;
		
		char next = pat.charAt(d);
		for(char c = 0; c < R; c++)
			if(next == '.' || next == c)
				collect(x.next[c], pre + c, pat, q);
	}
	
	public String longestPrefixOf(String s) {
		if (s == null) throw new IllegalArgumentException("argument to longestPrefixOf() is null");
		int length = search(root, s, 0, -1);
		if (length == -1) return null;
		else return s.substring(0, length);
	}
	
	private int search(Node x, String s, int d, int length) {
		if(x == null) return length;
		if(x.val != null) length = d;
		if(d == s.length()) return length;
		char c = s.charAt(d);
		return search(x.next[c], s, d + 1, length);
	}
	
	private static class Node {
		private Object val;
		private Node[] next = new Node[R];
	}
	
	public static void main(String[] args) {
		TrieST<Integer> st = new TrieST<Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        // print results
        if (st.size() < 100) {
            StdOut.println("keys(\"\"):");
            for (String key : st.keys()) {
                StdOut.println(key + " " + st.get(key));
            }
            StdOut.println();
        }

        StdOut.println("longestPrefixOf(\"shellso\"):");
        StdOut.println(st.longestPrefixOf("shellsort"));
        StdOut.println();

        StdOut.println("longestPrefixOf(\"quicksort\"):");
        StdOut.println(st.longestPrefixOf("quicksort"));
        StdOut.println();

        StdOut.println("keysWithPrefix(\"shor\"):");
        for (String s : st.keysWithPrefix("shor"))
            StdOut.println(s);
        StdOut.println();

        StdOut.println("keysThatMatch(\".he.l.\"):");
        for (String s : st.keysThatMatch(".he.l."))
            StdOut.println(s);
	}
}
