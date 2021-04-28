package com.puru.random;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MaxOccuringCharracter {
    public static char maximumOccuringCharacter(String text){
        char maxOccuringChar = (char)-1;
        if(text==null || text.trim().length()==0){
            return maxOccuringChar;
        }
       Map<Character,Integer> map = new LinkedHashMap<>();
       for(int i=0;i<text.length();i++){
           map.put(text.charAt(i),map.getOrDefault(text.charAt(i),0)+1);
       }
        int maxFreq = Integer.MIN_VALUE;
        for(Character tempChar:map.keySet()) {
            int freq = map.get(tempChar);
            if(maxFreq<freq){
                maxFreq = freq;
                maxOccuringChar = tempChar;
            }
        }
        return maxOccuringChar;
    }
}
