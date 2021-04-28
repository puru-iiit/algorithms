package com.puru.random;//https://www.geeksforgeeks.org/maximum-profit-sale-wines/
//https://www.youtube.com/watch?v=f4jUEEzjEJw

import java.util.Arrays;

/**
 * Given n wines in a row, with integers denoting the cost of each wine respectively. Each year you can sale the
 * first or the last wine in the row. However, the price of wines increases over time.
 * Let the initial profits from the wines be P1, P2, P3…Pn. On the Yth year, the profit
 * from the ith wine will be Y*Pi. For each year, your task is to print “beg” or “end”
 * denoting whether first or last wine should be sold. Also, calculate the maximum profit from all the wines.
 *
 * Examples :
 *
 * Input: Price of wines: 2 4 6 2 5
 * Output: beg end end beg beg
 *         64
 */
public class MaximumProfitSaleWines {
    public static void main(String[] args) {
        //output : 64
        int price[] = { 2, 4, 6, 2, 5 };
        System.out.println("profit using recursive way:"+maxProfitRecur(price));
        System.out.println("profit using DP way:"+maxProfitDP(price));
    }
    public  static  int maxProfitRecur(int[] wines){
        if(wines==null || wines.length==0){
            return 0;
        }
        return maxProfitRecursive(wines,0,wines.length-1,1);
    }
    public  static  int maxProfitDP(int[] wines){
        if(wines==null || wines.length==0){
            return 0;
        }
        int[][] dp = new int[wines.length][wines.length];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return maxProfitDP(wines,0,wines.length-1,1, dp);
    }
    public static int maxProfitRecursive(int[] wines, int start, int end, int year){
        if(start==end){
            return wines[start]*year;
        }
        int leftProfit = wines[start]*year + maxProfitRecursive(wines,start+1,end,year+1);
        int rightProfit = wines[end]*year + maxProfitRecursive(wines,start,end-1,year+1);

        return  Math.max(leftProfit,rightProfit);
    }
    public static int maxProfitDP(int[] wines, int start, int end, int year, int[][] dp){

        if(dp[start][end]!=-1){
            return dp[start][end];
        }
        if(start==end){
            dp[start][end] = wines[start]*year;
            return dp[start][end];
        }
        int leftProfit = wines[start]*year + maxProfitRecursive(wines,start+1,end,year+1);
        int rightProfit = wines[end]*year + maxProfitRecursive(wines,start,end-1,year+1);
        dp[start][end] =  Math.max(leftProfit,rightProfit);
        return dp[start][end];
    }
}
