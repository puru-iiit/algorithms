package com.puru.random;

//https://www.youtube.com/watch?v=uG_MtaCJIrM&list=PLEJXowNB4kPxQIN2dCUAnQ_92HIziG4x6&index=56
public class BurstBalloonsLeetCode312 {
    public static void main(String[] args) {
        int[] nums = {3,1,5,8};
        System.out.println(maxCoins(nums));
    }
    public static int maxCoins(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int len = nums.length;
        int[][] dp = new int[len+2][len+2];
        for(int window =1; window<=len;window++){
            for(int left = 1;left<=(len-window+1);left++){
                int right = left+window-1;
                System.out.println("left:"+left+":right:"+right);
                for(int i=left;i<=right;i++){
                    int numsRight =(right+1==len)?1:nums[right];
                    int numsLeft =(left-1==0)?1:nums[left-2];
                    System.out.println("i:"+i+":numsLeft:"+numsLeft+":numsRight:"+numsRight);
                    System.out.println("Value:"+(numsLeft*nums[i-1]*numsRight+dp[left][i-1]+dp[i+1][right]));
                    dp[left][right] = Math.max( dp[left][right],numsLeft*nums[i-1]*numsRight+dp[left][i-1]+dp[i+1][right]);
                }

            }
        }
        return dp[1][len];
    }
}
