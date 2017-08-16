package chapter4_2;

import java.io.*;

import edu.princeton.cs.algs4.ST;

public class SymbolDigraph {
	private ST<String, Integer> st;
	private String[] keys;
	private Digraph G;
	
	public SymbolDigraph(String stream, String sp) {
		st = new ST<>();
		try(BufferedReader bi = new BufferedReader(new FileReader(new File(stream)))) {
			String line;
			while((line = bi.readLine()) != null) {
				String[] a = line.split(sp);
				for(int i = 0; i < a.length; i++) {
					if(!st.contains(a[i]))
						st.put(a[i], st.size());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		keys = new String[st.size()];
		for(String key : st.keys())
			keys[st.get(key)] = key;
		G = new Digraph(st.size());
		
		try(BufferedReader bi = new BufferedReader(new FileReader(new File(stream)))) {
			String line;
			while((line = bi.readLine()) != null) {
				String[] a = line.split(sp);
				int v = st.get(a[0]);
				for(int i = 1; i < a.length; i++) {
					G.addEdge(v, st.get(a[i]));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean contains(String s) {
        return st.contains(s);
    }
	
	public int indexOf(String s) {
        return st.get(s);
    }
	
	public String nameOf(int v) {
        return keys[v];
    }
	
	public Digraph digraph() {
        return G;
    }
}
