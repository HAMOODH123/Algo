package computing;

import java.util.*;

public class Test {
    public static void main(String[] args) {
      /*  int SIDES = 6;
        double[] dist = new double[2 * SIDES + 1];
        for(int i = 1; i <= SIDES; i++)
        	for(int j = 1; j <= SIDES; j++)
        		dist[i + j] += 1.0;
        
        for(int k = 2; k <= 2 * SIDES; k++)
        	dist[k] /= 36.0;
        
        System.out.println(Arrays.toString(dist));  */
    	
    	
    	List<List<Integer>> res = new ArrayList<>();
    //    res.add(new ArrayList<Integer>());
        System.out.println(res);
        List<List<Integer>> tmp = new ArrayList<>();
    //    tmp.add(Arrays.asList(2));
        for(List<Integer> sub : res) {
            List<Integer> a = new ArrayList<>(sub);
            a.add(1);
            tmp.add(a);
        }
        System.out.println(tmp);
    }
    
}
