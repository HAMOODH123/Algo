package com.util;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdRandom;
import static com.util.Print.*;

public class TestInterval2D {

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		double min = Double.parseDouble(args[1]);
		double max = Double.parseDouble(args[2]);
		Interval2D[] temp = new Interval2D[N];
		int count1 = 0;
		int count2 = 0;
		
		for(int i = 0; i < N; i++) {
			double min1 = StdRandom.uniform(min, max);
			double max1 = StdRandom.uniform(min, max);
			double min2 = StdRandom.uniform(min, max);
			double max2 = StdRandom.uniform(min, max);
			Interval1D x = new Interval1D(min(min1, max1), max(min1, max1));
			Interval1D y = new Interval1D(min(min2, max2), max(min2, max2));
			temp[i] = new Interval2D(x, y);
			temp[i].draw();
		}
		
		for(int i = 0; i < N - 1; i++) {
			for(int j = i + 1; j < N; j++) {
				if(temp[i].intersects(temp[j]))
					count1++;
			}
		}
		println("intersected counter: " + count1);
		println("contained counter: " + count2);
	}
	
	public static double min(double a, double b) {
		if(a < b)
			return a;
		else return b;
	}
	
	public static double max(double a, double b) {
		if(a < b)
			return b;
		else return a;
	}
}
