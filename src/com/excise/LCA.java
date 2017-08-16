package com.excise;

public class LCA {
	public static int getFather(String[] matrix, int indexA, int indexB) {
		int[] a = new int[matrix.length];
        a[0] = matrix.length;
        for(int i = 1; i < matrix.length; i++) a[i] = -1;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                if(matrix[i].charAt(j) == '1') {
                    if(a[j] < 0) a[j] = i;
                    else if(a[i] < 0) a[i] = j;
                }
            }
		}
        
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        s1.push(indexA);
        s2.push(indexB);
        for(indexA = a[indexA]; indexA != matrix.length; indexA = a[indexA])
            s1.push(indexA);
        s1.push(0);
        
        for(indexB = a[indexB]; indexB != matrix.length; indexB = a[indexB])
            s2.push(indexB);
        s2.push(0);
        
        int lca = 0;
        while(!s1.isEmpty() && !s2.isEmpty()) {
            int temp1 = s1.pop();
            int temp2 = s2.pop();
            if(temp1 == temp2) lca = temp1;
            else if(temp1 == indexA) {
            	lca = temp1;
            	break;
            } else if(temp2 == indexB) {
            	lca = temp2;
            	break;
            }
        }
        return lca;
	}
	
	public static void main(String[] args) {
		String[] a = {"01", "10"};
		System.out.println(getFather(a, 0, 0));
	}
}
