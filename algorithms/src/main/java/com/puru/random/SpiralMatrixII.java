package com.puru.random;

import java.util.Arrays;

public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] A = new int[n][n];
        int c1 = 0;
        int cn = n;
        int r1 = 0;
        int rn = n;
        int k = 1;
        while (c1 < cn && r1 < rn) {
            for (int i = c1; i < cn; i++) {
                A[r1][i] = k++;
            }
            r1++;

            for (int i = r1; i < rn; i++) {
                A[i][cn - 1] = k++;
            }
            cn--;

            if (r1 < rn) {
                for (int i = cn - 1; i >= c1; i--) {
                    A[rn - 1][i] = k++;
                }
                rn--;
            }

            if (c1 < cn) {
                for (int i = rn - 1; i >= r1; i--) {
                    A[i][c1] = k++;
                }
                c1++;
            }
        }
        return A;
    }

    public static void main(String[] args) {

        int[][] ints = new SpiralMatrixII().generateMatrix(3);

        System.out.println(Arrays.toString(ints[0]));
        System.out.println(Arrays.toString(ints[1]));
        System.out.println(Arrays.toString(ints[2]));
    }
}
