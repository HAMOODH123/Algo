package com.chapter1_5;

public class WeightedQuickUnion extends UnionFind {
	private int[] size;

	public WeightedQuickUnion(int N) {
		super(N);
		size = new int[N];
		for(int i = 0; i < size.length; i++)
			size[i] = 1;
	}

	@Override
/*	public int find(int p) {
		while(p != id[p]) p = id[p];
		return p;
	}  */
	
	//路径压缩的find
	public int find(int p) {
		int root = p;
		int position;
		while(root != id[root]) {	
			root = id[root];
		}
		while(id[p] != root) {
			position = id[p];
			id[p] = root;
			p = position;
		}
		return root;
	} 
	
	//路径压缩的find,递归实现
/*	public int find(int p) {
		if(id[p] == p) return p;
		else return id[p] = find(id[p]);
	} */

	@Override
	public void union(int p, int q) {
		int rootq = find(q);
		int rootp = find(p);
		if(rootq == rootp) return;
		if(size[rootq] > size[rootp]) {
			id[rootp] = rootq;
			size[rootq] += size[rootp];
		} else {
			id[rootq] = rootp;
			size[rootp] += size[rootq];
		}
		count--;
	}
}
