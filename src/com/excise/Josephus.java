package com.excise;

import java.util.Arrays;
import java.util.Scanner;
import static com.util.Print.*;

public class Josephus {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		in.close();
		
		Queue q = new Queue();
		int[] out = new int[N];
		for(int i = 0; i < N; i++)
			q.enqueue(i);
		int j = 0;
		
		while(j < N) {
			for(int i = 0; i < M - 1; i++) {
				q.enqueue(q.dequeue());
			}
			out[j++] = q.dequeue();
		}
		println(Arrays.toString(out));
	}
}
