package chapter4_1;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

import com.util.ArrayGenerator;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Stack;

public class Graph {
	private static final String NEWLINE = System.getProperty("line.separator");
	
	private int V;
	private int E;
	private Bag<Integer>[] adj; 
	
	@SuppressWarnings("unchecked")
	public Graph(int V) {
		if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[])new Bag[V];
		for(int i = 0; i < V; i++)
			adj[i] = new Bag<>();
	}
	
	@SuppressWarnings("unchecked")
	public Graph(InputStream in) {
		BufferedInputStream bi = new BufferedInputStream(in);
		Scanner scan = new Scanner(bi);
		this.V = scan.nextInt();
		if (V < 0) {
			scan.close();
			throw new IllegalArgumentException("Number of vertices must be nonnegative");
		}
		adj = (Bag<Integer>[])new Bag[V];
		for(int i = 0; i < V; i++)
			adj[i] = new Bag<>();
		this.E = scan.nextInt();
		if (E < 0) {
			scan.close();
			throw new IllegalArgumentException("number of edges in a Graph must be nonnegative");
		}
		while(scan.hasNext()) {
			int v = scan.nextInt();
			int w = scan.nextInt();
//			System.out.println(v + ", " + w + "\n");
			addEdge(v, w);
		}
		scan.close();
	}
	
	public Graph(Graph G) {
        this(G.V());
        this.E = G.E();
        for (int v = 0; v < G.V(); v++) {
            // reverse so that adjacency list is in same order as original
            Stack<Integer> reverse = new Stack<Integer>();
            for (int w : G.adj[v]) {
                reverse.push(w);
            }
            for (int w : reverse) {
                adj[v].add(w);
            }
        }
    }
	
	public int V() { return V; }
	public int E() { return E; }
	
	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	
	public int degree(int v) {
        return adj[v].size();
    }
	
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            sb.append(v + ": ");
            for (int w : adj[v]) {
                sb.append(w + " ");
            }
            sb.append(NEWLINE);
        }
        return sb.toString();
	}
	
	public static void main(String[] args) {
		int[] a = ArrayGenerator.generateInt(10, 15);
		int[] b = Arrays.copyOfRange(a, 10, 10);
		System.out.println(Arrays.toString(b));
	}
}
