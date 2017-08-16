package com.chapter1_5;

public class QuickUnion extends UnionFind {

	public QuickUnion(int N) {
		super(N);
	}

	@Override
	public int find(int p) {
		while(p != id[p]) p = id[p];
		return p;
	}

	@Override
	public void union(int p, int q) {
		int rootq = find(q);
		int rootp = find(p);
		if(rootq == rootp) return;
		id[rootp] = find(q);
		count--;
	}
}
