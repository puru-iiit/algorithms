package com.puru.random;

import java.io.*;
import java.util.Arrays;

//https://www.hackerearth.com/problem/algorithm/last-ant-on-road/
public class LastAntOnRoadHackerEarth {
    public static void main(String[] args) throws IOException {
        String inputFile = "LastAntOnRoadHackerEarth.txt";
        BufferedReader br = new BufferedReader(new FileReader(new File(inputFile)));
        int totalTestCases = Integer.valueOf(br.readLine());

        while(totalTestCases>0){

            int totalAnts = Integer.valueOf(br.readLine());
            Integer[] antDirections = Arrays.stream(br.readLine().split(" ")).map(i->Integer.valueOf(i)).toArray(Integer[]::new);
            int posCount=0;
            int negCount =0;
            for(Integer dir : antDirections){
                if(dir.intValue()>0){
                    posCount++;
                }else{
                    negCount++;
                }
            }
            int rightIndex = -1;
            if(posCount>negCount){
                rightIndex = negCount+1;
            }else{
                rightIndex = negCount;
            }
            System.out.println(rightIndex);
            totalTestCases--;
        }

    }

}
