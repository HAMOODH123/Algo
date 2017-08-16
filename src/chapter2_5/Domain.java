package chapter2_5;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;

public class Domain implements Comparable<Domain> {
	private final String[] domainName;
	private final int size;
	
	public Domain(String name) {
		domainName = name.split("\\.");
		size = domainName.length;
	}

	@Override
	public int compareTo(Domain o) {
		for(int i = 1; i <= Math.min(this.size, o.size); i++) {
			String s1 = this.domainName[this.size - i];
			String s2 = o.domainName[o.size - i];
			if(s1.compareTo(s2) > 0) return 1;
			else if(s1.compareTo(s2) < 0) return -1;
		}
		return this.size - o.size;
	}
	
	public String toString() {
		 if (size == 0) return "";
	        String s = domainName[0];
	        for (int i = 1; i < size; i++)
	            s = domainName[i] + "." + s;
	        return s;
	}
	
	public static void main(String[] args) {
		String[] domains = StdIn.readAllStrings();
		Domain[] d = new Domain[domains.length];
		int i = 0;
		for(String s : domains) {
			d[i++] = new Domain(s);
		}
		
		Arrays.sort(d);
		System.out.println(Arrays.toString(d));
	}
}
