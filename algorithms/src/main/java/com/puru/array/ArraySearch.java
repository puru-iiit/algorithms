package com.puru.array;

import java.util.Arrays;

public class ArraySearch {

    public static void main(String[] args){
        int[] array =new int[]{1,2,3,4,6,7};
        int idx = Arrays.binarySearch(array, 5);
        System.out.println("idx:"+idx);
    }





}
