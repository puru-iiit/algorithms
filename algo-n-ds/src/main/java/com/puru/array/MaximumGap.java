package com.puru.array;

import java.util.Arrays;

/**
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * Return 0 if the array contains less than 2 elements.
 */
public class MaximumGap {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int maxDiff = new MaximumGap().arrangeLElements(arr);
        System.out.print("maxDiff-->"+maxDiff);
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]);
        }
    }
    public int arrangeLElements(int[] nums){
       if(nums==null || nums.length<2){
         return 0;
       }
        Arrays.sort(nums);
        int maxElement = nums[nums.length-1]+1;
        int start=0; int end=nums.length-1;
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                nums[i]+=(nums[end]%maxElement)*maxElement;
                end--;
            }else{
                nums[i]+=(nums[start]%maxElement)*maxElement;
                start++;
            }
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]/maxElement;
        }

        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length-1;i+=2){
            max =Math.max(max, (nums[i]-nums[i+1]));
        }
        return max;
    }
}
