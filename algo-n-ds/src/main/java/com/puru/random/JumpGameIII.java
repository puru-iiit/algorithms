package com.puru.random;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameIII {
    public static boolean canReach(int[] arr, int start) {

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int ele = q.poll();
                if(arr[ele]==0){
                    return true;
                }
                if((ele-arr[ele])>=0){
                    if(arr[ele-arr[ele]]==0){
                        return true;
                    }else if(arr[ele-arr[ele]]>0){
                        q.add(ele-arr[ele]);
                    }
                }else  if((ele+arr[ele])<arr.length){
                    if(arr[ele+arr[ele]]==0){
                        return true;
                    }else if(arr[ele+arr[ele]]>0){
                        q.add(ele+arr[ele]);
                    }
                }
                arr[ele]=-1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {4,4,1,3,0,3};
        int target = 2;
        boolean b = canReach(nums, target);
        System.out.println("b-->"+b);
    }
}
