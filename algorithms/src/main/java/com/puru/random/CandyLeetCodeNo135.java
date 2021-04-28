package com.puru.random;

import java.util.Arrays;


public class CandyLeetCodeNo135 {
    public static void main(String[] args) {
        //Answer : 7
        int[] ratings = {1,3,2,2,1};
        System.out.println(new CandyLeetCodeNo135().candy(ratings));
    }
    public int candy(int[] ratings) {
        if(ratings==null || ratings.length==0){
            return 0;
        }
        if(ratings.length==1){
            return 1;
        }
        int[] candies = new int[ratings.length];
        Arrays.fill(candies,1);
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                candies[i]=candies[i-1]+1;
            }
        }
        int totalCandy =candies[ratings.length-1];
        int rightMaxCandy=1;
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                rightMaxCandy = rightMaxCandy+1;
            }else{
                rightMaxCandy =1;
            }
            totalCandy+= Math.max(candies[i],rightMaxCandy);
        }
        return totalCandy;
    }
}
