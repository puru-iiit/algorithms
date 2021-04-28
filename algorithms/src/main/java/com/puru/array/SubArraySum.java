package com.puru.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Number of subarrays having sum exactly equal to k
 */
public class SubArraySum {
    public static void main(String[] args){
        List<Integer> numsList = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        int count = new SubArraySum().subarraySum(numsList,0);
        System.out.println(count);
        //Answer : 55
    }
    public int subarraySum(List<Integer> nums, int k) {
        //curSum to keep track of cumulative sum till that point
        int curSum = 0;
        int start = 0;
        int end = -1;
        Map<Integer, Integer> map = new HashMap<>();
        int count=0;
        for (int i = 0; i < nums.size(); i++) {
            curSum = curSum + nums.get(i);
            //check whether curSum - sum = 0, if 0 it means the sub array is starting from index 0- so stop
            if (curSum - k == 0) {
                count++;
            }
            //if map already has the value, means we already have subarray with the sum - so stop
            if (map.containsKey(curSum - k)) {
                count+=map.get(curSum-k);
                map.put(curSum,map.get(curSum-k)+1);
            }else{
                map.put(curSum, 1);
            }
            //if value is not present then add to hashmap

        }
        return count;

    }
}