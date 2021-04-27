package com.puru.random;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CarParkingRoof {

    public static  long carParkingRoof(List<Long> cars, int k){
        long globalMin = Long.MAX_VALUE;
        if(cars ==null || cars.size()<k || k<0){
            return globalMin;
        }
        Collections.sort(cars);
        for(int i=0;i<=cars.size()-k;i++){
            long currDiff = cars.get(i+k-1)-cars.get(i)+1;
            globalMin = Math.min(globalMin,currDiff);
        }
        return globalMin;
    }

    public static void main(String[] args) {

        List<Long> cars = Arrays.asList(6L,2L,12L,7L);
       int k=3;

       // List<Long> cars = Arrays.asList(2L,10L,8L,17L);
      //  int k=3;

       // List<Long> cars = Arrays.asList(1L,2L,3L,10L);
       // int k=4;

        System.out.println(CarParkingRoof.carParkingRoof(cars,k));
    }
}
