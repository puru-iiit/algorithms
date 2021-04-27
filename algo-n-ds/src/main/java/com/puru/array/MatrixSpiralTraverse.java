package com.puru.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Spirally traversing a matrix
 */
public class MatrixSpiralTraverse {

    public static void main(String[] args) {
        int n = 4;
        int m = 4;
        int[][] matrix = new int[m][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j]=i+j;
            }
        }
        List<Integer> traverse = new MatrixSpiralTraverse().traverse(matrix);
        System.out.println("Traversal str:->"+traverse);
    }

    private List<Integer> traverse(int[][] matrix) {

        List<Integer> list = new ArrayList<>();

        if (matrix == null || matrix.length==0 || matrix[0].length==0) {
            return Collections.emptyList();
        }

        int r1 = 0;
        int r2 = matrix.length - 1;
        int c1 = 0;
        int c2 = matrix[0].length - 1;

        while (c1 <= c2 && r1 <= r2) {
            //if (c1 <= c2) {
            for (int i = c1; i <= c2; i++) {
                list.add(matrix[r1][i]);
            }
            r1++;
           // System.out.println("one->"+list);
            // }
            // if (r1 <= r2) {
            for (int i = r1; i <= r2; i++) {
                list.add(matrix[i][c2]);
            }
            c2--;
           // System.out.println("two->"+list);
            // }

            if (r2 >= r1) {
                for (int i = c2; i >= c1; i--) {
                    list.add(matrix[r2][i]);
                }
                r2--;
            }
            //System.out.println("three->"+list);
            if (c2 >= c1) {
                for (int i = r2; i >= r1; i--) {
                    list.add(matrix[i][c1]);
                }
                c1++;
            }
           // System.out.println("four->"+list);
        }
        return list;
    }

}
