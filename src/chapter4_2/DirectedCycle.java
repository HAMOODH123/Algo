package chapter4_2;

import chapter4_4.WeightedDigraph;
import chapter4_4.DirectedEdge;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class DirectedCycle {
	private boolean[] marked;
	private boolean[] onstack;
	private int[] edgeTo;
	private Stack<Integer> cycle;
	
	public DirectedCycle(Digraph G) {
		marked = new boolean[G.V()];
		onstack = new boolean[G.V()];
		edgeTo = new int[G.V()];
		
		for(int v = 0; v < G.V(); v++)
			if(!marked[v] && cycle == null) dfs(G, v);
	}
	
	public DirectedCycle(WeightedDigraph G) {
		marked = new boolean[G.V()];
		onstack = new boolean[G.V()];
		edgeTo = new int[G.V()];
		
		for(int v = 0; v < G.V(); v++)
			if(!marked[v] && cycle == null) dfs(G, v);
	}
	
	public void dfs(Digraph G, int v) {
		marked[v] = true;
		onstack[v] = true;
		for(int w : G.adj(v)) {
			if(this.hasCycle()) return;
			if(!marked[w]) {
				edgeTo[w] = v;
				dfs(G, w);
			} else if(onstack[w]) {
				cycle = new Stack<>();
				for(int x = v; x != w; x = edgeTo[x]) {
					cycle.push(x);
				}
				cycle.push(w);
				cycle.push(v);
			}
		}
		onstack[v] = false;
	}
	
	public void dfs(WeightedDigraph G, int v) {
		marked[v] = true;
		onstack[v] = true;
		for(DirectedEdge e : G.adj(v)) {
			int w = e.to();
			if(this.hasCycle()) return;
			if(!marked[w]) {
				edgeTo[w] = v;
				dfs(G, w);
			} else if(onstack[w]) {
				cycle = new Stack<>();
				for(int x = v; x != w; x = edgeTo[x]) {
					cycle.push(x);
				}
				cycle.push(w);
				cycle.push(v);
			}
		}
		onstack[v] = false;
	}
	
	public Iterable<Integer> cycle() {
		return cycle;
	}
	
	public boolean hasCycle() {
		return cycle != null;
	}

	public static void main(String[] args) {
		In in = new In(args[0]);
        Digraph G = new Digraph(in);

        DirectedCycle finder = new DirectedCycle(G);
        if (finder.hasCycle()) {
            StdOut.print("Directed cycle: ");
            for (int v : finder.cycle()) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }

        else {
            StdOut.println("No directed cycle");
        }
        StdOut.println();
	}
}
