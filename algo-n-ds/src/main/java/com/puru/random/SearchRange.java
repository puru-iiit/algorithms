package com.puru.random;

import java.util.Arrays;

public class SearchRange {

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int[] ints = SearchRange.searchRange(nums,8);
        System.out.println("ints-->"+ Arrays.toString(ints));
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, 1};
        }
        int l = 0; int h = nums.length-1;
        int left =-1;
        while(l<h){
            int mid = l+(h-l)/2;
            if(nums[mid] == target){
                if(mid>l && nums[mid-1]==nums[mid]){
                    h = mid;
                }else{
                    left = mid;
                    break;
                }
            }else if(nums[mid] < target){
                l = mid+1;
            }else{
                h = mid-1;
            }
        }
        if(left==-1){
            return new int[]{-1, 1};
        }
        l = left ; h = nums.length-1;
        int right =-1;
        while(l<h){
            int mid = l+(h-l)/2;
            if(nums[mid] == target){
                if(mid<h && nums[mid+1]==nums[mid]){
                    l = mid;
                }else{
                    right = mid;
                    break;
                }
            }else if(nums[mid] < target){
                l = mid+1;
            }else{
                h = mid-1;
            }
        }

        return new int[]{left, right};
    }
}
