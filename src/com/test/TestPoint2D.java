package com.test;


import java.util.Arrays;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import static com.util.Print.*;

public class TestPoint2D {

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		StdDraw.setScale(0, 1);
		StdDraw.setPenRadius(0.005);
		Point[] p = new Point[N];
		for(int i = 0; i < N; i++) {
			double x = StdRandom.uniform();
			double y = StdRandom.uniform();
			StdDraw.point(x, y);
			p[i] = new Point(x, y);
		}
		
		double minDistance = Double.POSITIVE_INFINITY;
		double temp = 0.0;
		for(int i = 0; i < p.length - 1; i++) {  //穷举法计算任意点对中的最短距离
			for(int j = i + 1; j < p.length; j++) {
				temp = p[i].distanceTo(p[j]);
				if(minDistance > temp)
					minDistance = temp;
			}
		}
		println(Arrays.toString(p));
		println(minDistance);
	}
}

class Point {
	private double x;
	private double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double distanceTo(Point p) {
		return Math.sqrt(Math.pow((x - p.x), 2) + Math.pow((y - p.y), 2));
	}
	
	public String toString() {
		return String.format("(%6.5f, %6.5f)", x, y);
	}
}