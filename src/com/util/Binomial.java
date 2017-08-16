package com.util;

public class Binomial {
	public static double binomial1(int N, int k, double p) {
		if(N == 0 && k == 0)
			return 1.0;
		if(N < 0 || k < 0)
			return 0.0;
		return (1.0 - p)*binomial1(N - 1, k, p) + p*binomial1(N - 1, k - 1, p);
	}
	
	public static double binomial(int N, int k, double p) {  //利用动态规划求解二项分布
		double[][] result = new double[N + 1][k + 1];
		for(int i = 0; i <= N; i++)
			for(int j = 0; j <= k; j++)
				result[i][j] = -1;
		return binomial(N, k, p, result);		
	}
	
	private static double binomial(int N, int k, double p, double[][] result) {
		if(N == 0 && k == 0)
			return 1.0;
		if(N < 0 || k < 0)
			return 0.0;
		if(result[N][k] >= 0)
			return result[N][k];
		result[N][k] = (1.0 - p)*binomial(N - 1, k, p, result) + p*binomial(N - 1, k - 1, p, result);
		return result[N][k];
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(binomial1(85, 5, 0.25));
		long end1 = System.currentTimeMillis();
		System.out.println(binomial(85, 5, 0.25));
		long end2 = System.currentTimeMillis();
		System.out.println(end1 - start);
		System.out.println(end2 - end1);
	}
}
