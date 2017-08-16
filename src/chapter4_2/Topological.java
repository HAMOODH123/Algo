package chapter4_2;

import chapter4_4.WeightedDigraph;
import edu.princeton.cs.algs4.StdOut;

public class Topological {
	private Iterable<Integer> order;
	private int[] rank;               // rank[v] = position of vertex v in topological order
	
	public Topological(Digraph G) {
		DirectedCycle cyclefinder = new DirectedCycle(G);
		if(!cyclefinder.hasCycle()) {
			DepthFirstOrder dfs = new DepthFirstOrder(G);
			order = dfs.reversePost();
			rank = new int[G.V()];
            int i = 0;
            for (int v : order)
                rank[v] = i++;
		}
	}
	
	public Topological(WeightedDigraph G) {
		DirectedCycle cyclefinder = new DirectedCycle(G);
		if(!cyclefinder.hasCycle()) {
			DepthFirstOrder dfs = new DepthFirstOrder(G);
			order = dfs.reversePost();
			rank = new int[G.V()];
            int i = 0;
            for (int v : order)
                rank[v] = i++;
		}
	}

	public Iterable<Integer> order() {
        return order;
    }
	
	public boolean hasOrder() {
	    return order != null;
	}
	
	public int rank(int v) {
        if (hasOrder()) return rank[v];
        else            return -1;
    }

	public static void main(String[] args) {
		String filename  = args[0];
        String delimiter = args[1];
        SymbolDigraph sg = new SymbolDigraph(filename, delimiter);
        Topological topological = new Topological(sg.digraph());
        for (int v : topological.order()) {
            StdOut.println(sg.nameOf(v));
        }

	}
}
