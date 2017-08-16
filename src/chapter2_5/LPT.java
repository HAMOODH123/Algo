package chapter2_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import edu.princeton.cs.algs4.MinPQ;

/**
 * 负载均衡
 * @author Administrator
 *
 */
public class LPT {
	public static void main(String[] args) {
		int M = Integer.parseInt(args[0]);
		Scanner in = new Scanner(System.in);
		MinPQ<Task> pq = new MinPQ<>(M);
		List<Task> list = new ArrayList<>();
		List<Task> result = new ArrayList<>();
		while(in.hasNext()) {
			Task t = new Task(in.next(), in.nextInt());
			list.add(t);
			in.nextLine();
		}
		in.close();
		
		Collections.sort(list);
		int j = list.size() - 1;
		for(int i = 0; i < M; i++) {
			if(j < 0) break;
			pq.insert(list.get(j--));
		}
		while(j >= 0) {
			Task min = pq.delMin();
			result.add(min);
			Task t = list.get(j--);
			pq.insert(t.setCount(min.count + t.count));
		}
		int length = pq.size();
		for(int i = 0; i < length; i++) {
			result.add(pq.delMin());
		}
		for(Task e : result) {
			System.out.println(e);
		}
	}
}

class Task implements Comparable<Task>{
	String word;
	int count;
	
	Task(String word, int count) {
		this.word = word;
		this.count = count;
	}
	
	Task setCount(int c) {
		count = c;
		return this;
	}
	
	int getCount() {
		return count;
	}

	@Override
	public int compareTo(Task o) {
		if(this.count > o.count) return 1;
		else if(this.count < o.count) return -1;
		else return 0;
	}
	
	public String toString() {
		return word + " " + count;
	}
}
