package com.chapter1_5;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import com.util.Print;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;


@SuppressWarnings("unused")
public abstract class UnionFind {
	int[] id;
	int count;
	
	public UnionFind(int N) {
		count = N;
		id = new int[N];
		for(int i = 0; i < id.length; i++) {
			id[i] = i;
		}
	}
	
	public int count() { return count; }
	public boolean isConnected(int p, int q) { return find(p) == find(q);}
	
	public abstract int find(int p);
	public abstract void union(int p, int q);
	
	public static int linkCount(int N) {
		int cnt = 0;
		Random rand = new Random();
		WeightedQuickUnion uf = new WeightedQuickUnion(N);
		
		while(uf.count() != 1) {
			int a = rand.nextInt(N);
			int b = rand.nextInt(N);
			uf.union(a, b);
			cnt++;
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException{
//		Scanner in = new Scanner(new File(args[0]));
//		int N = in.nextInt();
////		QuickFind uf = new QuickFind(N);
////		QuickUnion uf = new QuickUnion(N);
////		WeightedQuickUnion uf = new WeightedQuickUnion(N);
//		HWeightedQU uf = new HWeightedQU(N);
//		while(in.hasNext()) {
//			int p = in.nextInt();
//			int q = in.nextInt();
//			if(uf.isConnected(p, q)) continue;
//			uf.union(p, q);
//			Print.println(p + " " + q);
//		}
//		in.close();
//		Print.println(uf.count() + " component");
		
		
		int n = Integer.parseInt(args[0]);          // number of vertices
        int trials = Integer.parseInt(args[1]);     // number of trials
        int[] edges = new int[trials];

        // repeat the experiment trials times
        for (int t = 0; t < trials; t++) {
            edges[t] = linkCount(n);
        }

        // report statistics
        StdOut.println("1/2 n ln n = " + 0.5 * n * Math.log(n));
        StdOut.println("mean       = " + StdStats.mean(edges));
        StdOut.println("stddev     = " + StdStats.stddev(edges));
    
	}
}
