package chapter4_4;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int N = in.nextInt();
            in.nextLine();
            String xline = in.nextLine();
            String yline = in.nextLine();
			String[] xs = xline.split(" ");
            String[] ys = yline.split(" ");
            int[][] adj = new int[N][N];
            Point[] ps = new Point[N];
            for(int i = 0; i < N; i++) {
                ps[i] = new Point(Integer.valueOf(xs[i]), Integer.valueOf(ys[i]));
            }
            
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    adj[i][j] = ps[i].distTo(ps[j]);
                }
                Arrays.sort(adj[i]);
            }
            
            int[] result = new int[N];
            for(int i = 1; i < N; i++) result[i] = Integer.MAX_VALUE;
            for(int i = 1; i < N; i++) {
                int dist = 0;
                for(int j = 0; j <= i; j++) dist += adj[i][j];
                if(result[i] > dist) result[i] = dist;
            }
            System.out.print(result[0]);
            for(int i = 1; i < N; i++) {
                System.out.print(" " + result[i]);
            }
        }
    }
    
    static class Point {
        int x;
        int y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        int distTo(Point that) {
            return Math.abs(x - that.x) + Math.abs(y - that.y);
        }
    }
}