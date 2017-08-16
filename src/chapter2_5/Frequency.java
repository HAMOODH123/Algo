package chapter2_5;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;

public class Frequency {
	public static void main(String[] args) {
		String[] a = StdIn.readAllStrings();
        int n = a.length;
        Arrays.sort(a);
        Record[] r = new Record[n];
        int m = 0;
        int f = 1;
        String word = a[0];
        for(int i = 1; i < n; i++) {
        	if(!a[i].equals(word)) {
        		r[m++] = new Record(word, f);
        		word = a[i];
        		f = 0;
        	}
        	f++;
        }
        r[m] = new Record(word, f);
        Arrays.sort(r, 0, m);
        System.out.println();
        for(int i = m - 1; i >= 0; i--)
        	System.out.println(r[i]);
	}
}

class Record implements Comparable<Record>{
	String word;
	int count;
	
	Record(String word, int count) {
		this.word = word;
		this.count = count;
	}

	@Override
	public int compareTo(Record o) {
		if(this.count > o.count) return 1;
		else if(this.count < o.count) return -1;
		else return 0;
	}
	
	public String toString() {
		return word + " " + count;
	}
}
