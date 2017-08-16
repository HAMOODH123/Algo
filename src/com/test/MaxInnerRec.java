package com.test;

public class MaxInnerRec {
	public static int countArea(int[] A, int n) {
        int max = 0;
        for(int i = 0; i < n; i++) {
            int min = A[i];
            for(int j = i; j < n; j++) {
                if(min > A[j]) min = A[j];
                int temp = min * (j - i + 1);
                if(temp > max)
                    max = temp;
            }
        }
        return max;
    }

	public static void main(String[] args) {
		int[] a = {2,7,9,4,1};
		System.out.println(countArea(a, 5));
	}
}
