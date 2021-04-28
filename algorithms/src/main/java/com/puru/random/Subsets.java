package com.puru.random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 78. Subsets
 *
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * Time complexity : O(2^n) | Space complexity : O(n)
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums==null || nums.length==0){
            return Collections.emptyList();
        }
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(0,nums, new ArrayList<Integer>(), subsets);
        return  subsets;
    }

    private void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(current));
        for (int i=index;i<nums.length;i++){
            current.add(nums[i]);
            generateSubsets(i+1,nums, current, subsets);
            current.remove(current.size()-1);
        }
    }
}
