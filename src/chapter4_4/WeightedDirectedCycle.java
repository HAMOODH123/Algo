package chapter4_4;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class WeightedDirectedCycle {
	private boolean[] marked;
	private boolean[] onStack;
	private DirectedEdge[] edgeTo;
	private Stack<DirectedEdge> cycle;
	
	public WeightedDirectedCycle(WeightedDigraph G) {
		marked = new boolean[G.V()];
		onStack = new boolean[G.V()];
		edgeTo = new DirectedEdge[G.V()];
		
		for(int v = 0; v < G.V(); v++)
			if(!marked[v]) dfs(G, v);
		
		assert check();
	}

	private void dfs(WeightedDigraph G, int v) {
		onStack[v] = true;
		marked[v] = true;
		for(DirectedEdge e : G.adj(v)) {
			if(this.hasCycle()) return;
			int w = e.to();
			if(!marked[w]) {
				edgeTo[w] = e;
				dfs(G, w);
			} else if(onStack[w]) {
				cycle = new Stack<DirectedEdge>();
				DirectedEdge f = e;
				while(f.from() != w) {
					cycle.push(f);
					f = edgeTo[f.from()];
				}
				cycle.push(f);
			}
		}
		onStack[v] = false;
	}
	
	public boolean hasCycle() {
		return cycle != null;
	}
	
	public Iterable<DirectedEdge> cycle() {
        return cycle;
    }

	// certify that digraph is either acyclic or has a directed cycle
    private boolean check() {

        // edge-weighted digraph is cyclic
        if (hasCycle()) {
            // verify cycle
            DirectedEdge first = null, last = null;
            for (DirectedEdge e : cycle()) {
                if (first == null) first = e;
                if (last != null) {
                    if (last.to() != e.from()) {
                        System.err.printf("cycle edges %s and %s not incident\n", last, e);
                        return false;
                    }
                }
                last = e;
            }

            if (last.to() != first.from()) {
                System.err.printf("cycle edges %s and %s not incident\n", last, first);
                return false;
            }
        }


        return true;
    }

    /**
     * Unit tests the {@code EdgeWeightedDirectedCycle} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {

        // create random DAG with V vertices and E edges; then add F random edges
        int V = Integer.parseInt(args[0]);
        int E = Integer.parseInt(args[1]);
        int F = Integer.parseInt(args[2]);
        WeightedDigraph G = new WeightedDigraph(V);
        int[] vertices = new int[V];
        for (int i = 0; i < V; i++)
            vertices[i] = i;
        StdRandom.shuffle(vertices);
        for (int i = 0; i < E; i++) {
            int v, w;
            do {
                v = StdRandom.uniform(V);
                w = StdRandom.uniform(V);
            } while (v >= w);
            double weight = StdRandom.uniform();
            G.addEdge(new DirectedEdge(v, w, weight));
        }

        // add F extra edges
        for (int i = 0; i < F; i++) {
            int v = StdRandom.uniform(V);
            int w = StdRandom.uniform(V);
            double weight = StdRandom.uniform(0.0, 1.0);
            G.addEdge(new DirectedEdge(v, w, weight));
        }

        StdOut.println(G);

        // find a directed cycle
        WeightedDirectedCycle finder = new WeightedDirectedCycle(G);
        if (finder.hasCycle()) {
            StdOut.print("Cycle: ");
            for (DirectedEdge e : finder.cycle()) {
                StdOut.print(e + " ");
            }
            StdOut.println();
        }

        // or give topologial sort
        else {
            StdOut.println("No directed cycle");
        }
    }
}
