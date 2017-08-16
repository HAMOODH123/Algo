package chapter4_1;

import java.io.*;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class DepthFirstPaths {
	private boolean[] marked;
	private int[] edgesTo;
	private final int s;
	
	public DepthFirstPaths(Graph G, int s) {
		this.s = s;
		marked = new boolean[G.V()];
		edgesTo = new int[G.V()];
		dfs(G, s);
	}
	
	private void dfs(Graph G, int v) {
		marked[v] = true;
		for(int w : G.adj(v)) {
			if(!marked[w]) {
				edgesTo[w] = v;
				dfs(G, w);
			}
		}
	}
	
	public boolean hasPathTo(int w) {
		return marked[w];
	}
	
	public Iterable<Integer> pathTo(int v) {
		if(!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<>();
		for(int i = v; i != s; i = edgesTo[i]) {
			path.push(i);
		}
		path.push(s);
		return path;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
        InputStream in = new FileInputStream(new File(args[0]));
        Graph G = new Graph(in);
        int s = Integer.parseInt(args[1]);
        DepthFirstPaths dfs = new DepthFirstPaths(G, s);

        for (int v = 0; v < G.V(); v++) {
            if (dfs.hasPathTo(v)) {
                StdOut.printf("%d to %d:  ", s, v);
                for (int x : dfs.pathTo(v)) {
                    if (x == s) StdOut.print(x);
                    else        StdOut.print("-" + x);
                }
                StdOut.println();
            }

            else {
                StdOut.printf("%d to %d:  not connected\n", s, v);
            }

        }
    }
}
