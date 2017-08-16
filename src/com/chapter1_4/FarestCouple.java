package com.chapter1_4;

public class FarestCouple {
	private static class TwoTurple {
		double min;
		double max;
		
		TwoTurple(double min, double max) {
			this.min = min;
			this.max = max;
		}

		public double getMin() {
			return min;
		}

		public double getMax() {
			return max;
		}		
	}
	
	/**
	 * 找出数组中两个最远的元素，线性时间
	 * @param a
	 */
	public static TwoTurple farestCouplePoints(double[] a) {
		double min, max;
		if(a.length < 2) throw new IllegalArgumentException();
		if(a.length % 2 == 0) {
			if(a[0] < a[1]) {
				min = a[0];
				max = a[1];
			} else {
				min = a[1];
				max = a[0];
			}
			return farestCouplePoints(a, 2, max, min);
		} else {
			min = max = a[0];
			return farestCouplePoints(a, 1, max, min);
		}
	}
	
	private static TwoTurple farestCouplePoints(double[] a, int index, double max, double min) {
		for(int i = index; i < a.length; i += 2) {
			if(a[i] < a[i+ 1]) {
				if(min > a[i])
					min = a[i];
				if(max < a[i + 1])
					max = a[i + 1];
			} else {
				if(min > a[i + 1])
					min = a[i + 1];
				if(max < a[i])
					max = a[i];
			}
		}
		return new TwoTurple(min, max);
	}

	public static void main(String[] args) {
		double[] a = {23.5, -0.2, 5, 10.2, -2.5, 50, -10.63};
		FarestCouple.TwoTurple twoTurple = farestCouplePoints(a);
		System.out.println(twoTurple.getMax());
		System.out.println(twoTurple.getMin());
	}
}
