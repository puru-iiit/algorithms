package com.puru.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        ArrayList<Integer> ll1 = new ArrayList<>();
        ll1.add(2);
        ll1.add(3);
        ll1.add(4);
        ll1.add(5);
        ll1.add(6);
        ll1.add(8);


        ArrayList<Integer>  ll2 = new ArrayList<>();
        ll2.add(4);
        ll2.add(6);
        ll2.add(9);
        ll2.add(11);

        List<Integer> mergedList = new Solution().mergeList(ll1, ll2);

        System.out.println("mergedList-->"+mergedList);

    }

    public List<Integer> mergeList(List<Integer> ll1, List<Integer> ll2){

        if(ll1 ==null || ll1.isEmpty()){
            return reverseList(ll2);
        }

        if(ll2 ==null || ll2.isEmpty()){
            return reverseList(ll1);
        }

        Stack<Integer> s = new Stack<>();
        int i=0;int j=0;

        while (i<ll1.size() && j<ll2.size()) {

            int num1= ll1.get(i);
            int num2 = ll2.get(j);

            if(num1<num2){
               // s.push(num1);
               // System.out.println("num1->"+num1);
                i++;

            }else if(num1>num2){
               // s.push(num2);
                System.out.println("num1->"+num1);
                if(i==0){
                    ll1.add(0,num2);
                    i++;
                }else{
                    System.out.println("num2->"+num2);
                    ll1.add(i-1,num2);
                    i++;
                }
               j++;
            }else{
                ll1.add(i,num2);
                i++;
                j++;
            }

        }

        while(j<ll2.size()){
            ll1.add(ll2.get(j));
            j++;

        }
        return reverseList(ll1);
    }
    public List<Integer> reverseList(List<Integer> ll){
        if(ll==null || ll.isEmpty()){
            return ll;
        }
       int m = ll.size()/2;
        for(int i=0;i<m;i++){
           int num = ll.get(i);
           ll.set(i,ll.get(ll.size()-1-i));
           ll.set(ll.size()-1-i,num);
        }
        return ll;
    }
}