package com.test;

import java.io.IOException;
import java.util.Scanner;

import static com.util.Print.*;
import edu.princeton.cs.algs4.Interval1D;

public class TestInterval1D {

	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(args[0]);
		Scanner in = new Scanner(System.in);
		Interval1D[] input = new Interval1D[N];
		
		println("Please enter " + N + " real number:");
		int k = 0;
		while(in.hasNext()) {
			input[k++] = new Interval1D(in.nextDouble(), in.nextDouble());
			if(k == N)
				System.in.close();
		}
		in.close();
		
		for(int i = 0; i < N - 1; i++) {
			for(int j = i + 1; j < N; j++) {
				if(input[i].intersects(input[j]))
					println("[" + input[i] + ", " + input[j] + "]");
			}
		}
	}
}
