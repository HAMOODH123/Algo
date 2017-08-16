package com.test;

import com.util.VisualAccumulator;
import static com.util.Print.*;
import edu.princeton.cs.algs4.StdRandom;

public class TestVisualAccumulator {

	public static void main(String[] args) {
		int T = Integer.parseInt(args[0]);
		VisualAccumulator a = new VisualAccumulator(T, 1.0);
		for(int i = 0; i < T; i++)
			a.addDataValue(StdRandom.uniform());
		println(a);
	}
}
