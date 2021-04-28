package com.puru.random;/*
 * Click `Run` to execute the snippet below!

 Given a string s, find the length of the longest substring without repeating characters.
  Input: s = "abcabcbb"
  Output: 3
  Explanation: The answer is "abc", with the length of 3.


 */

import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */


public class FindLongestSubstring {

        public static void main(String[] args) {

            //String str = "abcabcbb";

            String str = "abcabcdefabc";

            int index = new FindLongestSubstring().findLongestSubstr(str.toCharArray());

            System.out.println("Index-->"+index);
        }

        // abcde -- c
        public int findLongestSubstr(char[] str){

            if(str ==null || str.length==0){
                return 0;
            }

            int globalLen =0;

            Map<Character, Integer> map = new HashMap<>();

            int prevIndex=-1;

            int localLen =0;

            for(int i=0;i<str.length;i++){

                Integer index = map.get(str[i]);


                if(index ==null ){
                    localLen++;
                    map.put(str[i], i);

                }else {

                    if(prevIndex !=-1 && index<prevIndex){
                        localLen++;
                        map.put(str[i], i);
                    }else{

                        if(globalLen<localLen){
                            globalLen = localLen;
                        }
                        localLen=i-(int)index;
                        prevIndex = index+1;
                        map.put(str[i], i);
                    }

                }

            }

            if(globalLen<localLen){
                globalLen = localLen;
            }
            return globalLen;



        }

    }

