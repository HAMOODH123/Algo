package chapter3_1;

public class Solution {

	public int calculateMax(int[] prices) {
		Tuple t1 = getProfit(prices, 0, prices.length - 1);
        int i = 0;
        for(i = t1.left; i < t1.right; i++) {
            prices[i] = prices[i + 1];
		}
        for(int j = t1.right + 1; j < prices.length; j++) {
            prices[i++] = prices[j]; 
        }
        Tuple t2 = getProfit(prices, 0, prices.length - 3);
        return t1.pf + t2.pf;
    }
    
	//分治算法计算
    public Tuple getProfit(int[] a, int lo, int hi) {
        if(lo >= hi) return new Tuple(lo, hi, 0);
        	int left = lo, right = hi;
            int mid = lo + (hi - lo) / 2;
            Tuple l1 = getProfit(a, lo, mid);
            Tuple l2 = getProfit(a, mid + 1, hi);
            int tempMax1 = Integer.MIN_VALUE, tempMax2 = Integer.MIN_VALUE;
            for(int i = lo; i <= mid; i++) {
                if((a[mid] - a[i]) > tempMax1) {
                    left = i;
                    tempMax1 = a[mid] - a[i];
				}
			}
            for(int i = mid; i <= hi; i++) { 
                if((a[i] - a[mid]) > tempMax2) {
                    right = i;
                    tempMax2 = a[i] - a[mid];
            	}
			}
            int tempMax = tempMax1 + tempMax2;
            if(tempMax >= l1.pf && tempMax >= l2.pf) {
                return new Tuple(left, right, tempMax);
            } else if(l1.pf >= tempMax && l1.pf >= l2.pf)
                return l1;
            else {
            	return l2;
            }
    }
    
    class Tuple {
        int left;
        int right;
        int pf;
        
        Tuple(int left, int right, int pf) {
            this.left = left;
            this.right = right;
            this.pf = pf;
        }
    }
    
    //动态规划计算最大子序列
    public int getMax(int[] a, int lo, int hi) {
    	if(lo >= hi) return 0;
    	int min = a[lo];
    	int max = 0;
    	for(int i = lo + 1; i <= hi; i++) {
    		min = Math.min(min, a[i]);
    		max = Math.max(max, a[i] - min);
    	}
    	return max;
    }
    
    public int calculateMax1(int[] prices) {
    	if(prices.length == 0) return 0;
    	int max = 0;
    	for(int i = 1; i < prices.length - 1; i++) {
    		int left = getMax(prices, 0, i);
    		int right = getMax(prices, i + 1, prices.length - 1);
    		if(left + right > max)
    			max = left + right;
    	}
    	return max;
    }
    
    
    public static void main(String[] args) {
    	int[] a = {1, 10, 2, 12};
    	Solution s = new Solution();
    	System.out.println(s.calculateMax1(a));
    }
}
