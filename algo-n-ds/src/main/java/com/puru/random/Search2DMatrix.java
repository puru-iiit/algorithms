package com.puru.random;

/**
 * 74. Search a 2D Matrix
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0){
            return  false;
        }
        int l= 0, h= matrix.length * matrix[0].length-1;
        while(l<=h){
            int mid = (l+h)/2;
            int r = mid/matrix[0].length;
            int c = mid % matrix[0].length;
            if(matrix[r][c]==target){
                return true;
            }else if(matrix[r][c]<target){
                l=mid+1;
            }else{
              h=mid-1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        boolean found = new Search2DMatrix().searchMatrix(matrix, target);
        System.out.println("found-->"+found);
    }
}
