package com.puru.random;

/**
 * 75. Sort Colors
 *
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color
 * are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 */
public class SortColors {
    public void sortColors(int[] nums) {
        if(nums ==null || nums.length==0){
            return;
        }
        int k=0;
        int oneCount=0;
        int i =0;int j= nums.length-1;

        while (i<j){
            switch (nums[i]){
                case 0 :
                    nums[k++]=nums[i++];
                    break;
                case 1:
                   oneCount++;
                   i++;
                   break;
                case 2:
                    int temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                    j--;
            }
            while(oneCount>=0){
                nums[k++]=0;
            }
        }
    }
}
