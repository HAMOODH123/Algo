package com.chapter1_4;

import java.util.Scanner;

/**
 *
 * @author BatmanLost
 */
public class MatrixLocalMinElement {    
    
    private static class Input2DArrayGenerator{
        
        public static int[][] generate(int N){
            int[][] array2D = new int[N][N];
            for(int i=0;i<N ;i++){
                for(int j=0;j<N ;j++){
                    array2D[i][j] = (int)(Math.random()*(2*N));
                }
            }
            return array2D;
        }
    }
    
    public void printLocalMin(int[][] array){
        try{
            localMin(array,0,0,array.length-1,array.length);            
        }
        catch(LocalMininimumFoundException e){ 
            System.out.println("Found local minimum at  " + e +" : "+ array[e.localMinRowIndex][e.localMinColIndex]+"\n");
        }      
    } 
    
    /**
     * Exception class to detect if a local minimum is found
     */
    @SuppressWarnings("serial")
	private class LocalMininimumFoundException extends Exception {
        
        private int localMinRowIndex ;
        private int localMinColIndex ;
        
        public LocalMininimumFoundException(int rowIndex, int colIndex) {
            this.localMinRowIndex = rowIndex;
            this.localMinColIndex = colIndex;
        }
        
        public String toString(){ return "["+localMinRowIndex+","+localMinColIndex+"]";}
    }

    /**\
     * Divide the matrix into sub matrices until a 2x2 sub matrix is encountered
     * @param array
     * @param topLeftX
     * @param topLeftY
     * @param height
     * @param N
     * @throws nXn_Matrix_Local_Minimum.LocalMininimumFoundException 
     */
    private void localMin(int[][] array,int topLeftX, int topLeftY, int height,int N) throws LocalMininimumFoundException {
        if(height<=1){ 
            testForLocalMinimum(array,topLeftX,topLeftY,N);        
            return;
        }
        //System.out.println("topLeftX " + topLeftX+" topLeftY :" +topLeftY+ "height :" + height);
        localMin(array,topLeftX,topLeftY,height/2,N);
        localMin(array,topLeftX+(height/2)+1,topLeftY, height/2,N);
        localMin(array, topLeftX, topLeftY + (height/2) + 1, height/2, N);
        localMin(array, topLeftX+(height/2)+1, topLeftY +(height/2) + 1, height/2, N);        
    }
    
    /**
     * This is what the the sub array looks like after repeated division is complete
     *      [a,b]
     *      [c,d]
     * check if any one of a.b,c,d is a local minimum
     * @param array
     * @param topLeftX
     * @param topLeftY
     * @param N
     * @throws nXn_Matrix_Local_Minimum.LocalMininimumFoundException 
     */
    private void testForLocalMinimum(int[][] array, int topLeftX, int topLeftY,int N) throws LocalMininimumFoundException {        
        isLocalMinimum(array,topLeftX,topLeftY,N);
        isLocalMinimum(array,topLeftX+1,topLeftY,N);
        isLocalMinimum(array,topLeftX,topLeftY+1,N);
        isLocalMinimum(array,topLeftX+1,topLeftY+1,N);
    }
    
    /**
     * If a local minimum is found, throw LocalMininimumFoundException and exit the recursion stack
     * @param array
     * @param rowIndex
     * @param colIndex
     * @param N
     * @throws nXn_Matrix_Local_Minimum.LocalMininimumFoundException 
     */
    private void isLocalMinimum(int[][] array, int rowIndex, int colIndex,int N) throws LocalMininimumFoundException {
        int topRowIndex = rowIndex-1, bottomRowIndex = rowIndex+1, leftColIndex = colIndex-1, rightColIndex = colIndex+1;
        boolean foundLocalMinimum = true; 
        if( -1 < topRowIndex && topRowIndex < N){
            if( array[rowIndex][colIndex] >= array[topRowIndex][colIndex]){ foundLocalMinimum = false;}
        }
        if( -1 < bottomRowIndex && bottomRowIndex < N){
            if( array[rowIndex][colIndex] >= array[bottomRowIndex][colIndex]){ foundLocalMinimum = false;}
        }
        if( -1 < leftColIndex && leftColIndex < N){
            if( array[rowIndex][colIndex] >= array[rowIndex][leftColIndex]){ foundLocalMinimum = false;}
        }
        if( -1 < rightColIndex && rightColIndex < N){
            if( array[rowIndex][colIndex] >= array[rowIndex][rightColIndex]){ foundLocalMinimum = false;}
        }
        if(foundLocalMinimum){ throw new LocalMininimumFoundException(rowIndex,colIndex);}
    }
    
    public static void print2DArray(int[][] array){
        for(int i = 0; i<array.length; i++)
        {
            for(int j = 0; j<array.length; j++)
            {
                System.out.printf("%3d",array[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws Exception{
        System.out.println("Enter N:");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        MatrixLocalMinElement testObj = new MatrixLocalMinElement();
        int[][] array = Input2DArrayGenerator.generate(N);        
        testObj.printLocalMin(array);
        print2DArray(array);
    }
}