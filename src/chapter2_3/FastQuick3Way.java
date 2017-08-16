package chapter2_3;

public class FastQuick3Way extends Sort{
	@SuppressWarnings("unused")
	private static <T extends Comparable<? super T>> void sort(T[] a, int lo, int hi) {
		int i = lo, j = hi + 1;
		int p = lo, q = hi + 1;
		T v = a[lo];
		
		while(true) {
			while(a[++i].compareTo(v) < 0) if(i == hi) break;
			while(a[--j].compareTo(v) > 0) if(j == lo) break;
			
			if(i == j && a[i].compareTo(v) == 0)
				exch(a, ++p, i);
			if(i >= j) break;
			
			exch(a, i , j);
			if(a[i].compareTo(v) == 0) exch(a, ++p, i);
			if(a[j].compareTo(v) == 0) exch(a, --q, j);
		}
		
		i = j + 1;
		for (int k = lo; k <= p; k++)
	         exch(a, k, j--);
	    for (int k = hi; k >= q; k--)
	         exch(a, k, i++);

	    sort(a, lo, j);
	    sort(a, i, hi);
	}
}
