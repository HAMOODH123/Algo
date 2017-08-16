package computing;

import java.util.Arrays;

import edu.princeton.cs.algs4.*;

public class ShuffleTest {

	public static void main(String[] args) {
		int M = Integer.parseInt(args[0]);
		int N = Integer.parseInt(args[1]);
		int[] a = new int[M];
		int[][] count = new int[M][M];
		for(int j = 0; j < N; j++) {
			for(int i = 0; i < M; i++)
				a[i] = i;
			StdRandom.shuffle(a);
			for(int i = 0; i < M; i++) {
				count[a[i]][i]++;
			}
		}	
		System.out.println(Arrays.deepToString(count));
	}
}
