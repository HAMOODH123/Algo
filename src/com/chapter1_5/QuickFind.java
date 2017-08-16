package com.chapter1_5;

public class QuickFind extends UnionFind{

	public QuickFind(int N) {
		super(N);
	}

	@Override
	public int find(int p) {
		return id[p];
	}

	@Override
	public void union(int p, int q) {
		if(isConnected(p, q)) return;
		int pid = id[p];
		int qid = id[q];
		for(int i = 0; i < id.length; i++) {
			if(id[i] == pid)
				id[i] = qid;
		}
		count--;
	}
}
