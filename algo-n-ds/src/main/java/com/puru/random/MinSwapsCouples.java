package com.puru.random;

import java.util.HashMap;
import java.util.Map;

public class MinSwapsCouples {
    public int minSwapsCouples(int[] nums) {

        Map<Integer,Integer> m = new HashMap<>();
        int s = nums.length;
        for(int i=0;i<s;i++){
            m.put(nums[i],i);
        }
        int swaps =0;
        for(int i=0;i<s;i+=2){
            int first = nums[i];
            int second = first +(first%2==0?1:-1);
            if(nums[i+1] != second){
                swaps++;
                swap(nums,m, i+1,m.get(second));
            }
        }
        return swaps;
    }
    public void swap(int[] nums, Map<Integer,Integer> m , int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
        m.put(nums[i],i);
        m.put(nums[j],j);
    }

    public static void main(String[] args) {
        int[] nums ={0,2,4,6,7,1,3,5};
        MinSwapsCouples m = new MinSwapsCouples();
        int swaps = m.minSwapsCouples(nums);
        System.out.println("swaps-->"+swaps);
    }
}
