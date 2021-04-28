package com.puru.random;

import java.util.*;

public class CoinChange {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,5);
        //List<Integer> list = Arrays.asList(1,2,5);
        Set<List<Integer>> lists = new CoinChange().changeCoin(list, 10);
        for(List<Integer> l : lists){
           System.out.print(l);

        }
    }
    public Set<List<Integer>> changeCoin(List<Integer> nums, int sum) {
        Set<List<Integer>> result = new HashSet<>();
        changeCoin(nums,nums.size()-1,new ArrayList<>(),result, sum);
        return result;
    }

    public void changeCoin(List<Integer> nums, int index,
                                          List<Integer> currList,
                           Set<List<Integer>> result, int sum) {

        if(index<0 || sum<0){
            return;
        }
        if(sum==0){
            result.add(currList);
        }
        //include ele
        List<Integer> incl = new ArrayList<>(currList);
        incl.add(nums.get(index));
        changeCoin(nums,index,incl,result, sum-nums.get(index));

        //exclude ele
        List<Integer> excl = new ArrayList<>(currList);
        //incl.add(nums.get(index));
        changeCoin(nums,index-1,excl,result, sum);

    }
}
