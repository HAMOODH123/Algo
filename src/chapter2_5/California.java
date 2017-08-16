package chapter2_5;

import java.util.Arrays;
import java.util.Comparator;

import edu.princeton.cs.algs4.StdIn;

public class California {
	private static final Comparator<String> cmp = new MyComparator();
	
	private static class MyComparator implements Comparator<String> {
		private static final String order = "RWQOJMVAHBSGZXNTCIEKUPDYFL";
		
		@Override
		public int compare(String o1, String o2) {
			for(int i = 0; i < Math.min(o1.length(), o2.length()); i++) {
				int index1 = order.indexOf(o1.charAt(i));
				int index2 = order.indexOf(o2.charAt(i));
				if(index1 > index2) return 1;
				else if(index1 < index2) return -1;
			}
			return o1.length() - o2.length();
		}		
	}

	public static void main(String[] args) {
		String[] arr = StdIn.readAllStrings();
		Arrays.sort(arr, cmp);
		System.out.println(Arrays.toString(arr));
	}
}
