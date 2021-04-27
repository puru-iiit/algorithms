package com.puru.random;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums==null || nums.length==0){
            return;
        }
        int i = nums.length-1;
        while(i>0 && nums[i-1]>=nums[i]){
            i--;
        }

        if(i==0){
            Arrays.sort(nums);
            return;
        }
        int j= i-1;

        Arrays.sort(nums, i,  nums.length);

       /* while(i<nums.length && nums[i]<=nums[j]){
            i++;
        }*/
        int idx = Arrays.binarySearch(nums, i, nums.length, nums[j]);

        if(idx>0){
            idx++;
        }else{
            idx++;
            idx = -idx;
        }
        int temp = nums[j];
        nums[j] = nums[idx];
        nums[idx]=temp;
    }

    public static void main(String[] args) {

        int[] nums = {2,2,7,5,4,3,2,2,1};
        NextPermutation np = new NextPermutation();
        np.nextPermutation(nums);

        System.out.println(Arrays.toString(nums));
    }
}
