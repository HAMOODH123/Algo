package com.chapter1_5;

public class HWeightedQU extends UnionFind {
	private int[] height;

	public HWeightedQU(int N) {
		super(N);
		height = new int[N];
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
		if(height[rootp] > height[rootq])
			id[rootq] = rootp;
		else if(height[rootp] < height[rootq])
			id[rootp] = rootq;
		else {
			id[rootq] = rootp;
			height[rootp] += 1;
		}
		count--;
	}
}
