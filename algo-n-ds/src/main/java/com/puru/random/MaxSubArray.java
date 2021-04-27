package com.puru.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxSubArray {

    public int countSubstrings(String s) {

        if(s==null || s.length()==0){
            return 0;
        }

        int n = s.length();
        char[] str = s.toCharArray();

        boolean[][] p = new boolean[n][n];
        p[0][0] = true;

        int[][] d = new int[n][n];
        d[0][0] = 1;

        for(int i=1;i<n;i++){
            p[i][i] =true;
            d[i][i] =1;
        }


        for(int i=1;i<n-1;i++) {
            if (str[i] == str[i + 1]) {
                p[i][i + 1] = true;
                d[i][i + 1] = 1;
            }
        }
            for(int gap =2; gap<n;gap++){


                for(int j=0;j<n-gap-1;j++){

                    int k = j+gap-1;

                    if(str[j]==str[k] && p[j+1][k-1]){
                       p[j][k]=true;
                    }
                    if( p[j][k]){
                        d[j][k] = 1+d[j][k-1]+d[j+1][k]-d[j+1][k-1];
                    }else{
                        d[j][k] = d[j][k-1]+d[j+1][k]-d[j+1][k-1];
                    }

                }
            }
            return d[0][n-1];

    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] LIS = new int[nums.length];

        LIS[0] = 1;

        for (int i = 1; i < nums.length; i++) {

            for (int j = 0; j < i; j++) {

                if (nums[j] < nums[i] && LIS[j] > LIS[i]) {
                    LIS[i] = LIS[j];
                }

            }
            LIS[i] = LIS[i] + 1;

        }
        int maxLen = LIS[0];
        for (int k = 1; k < nums.length; k++) {
            if (maxLen < LIS[k]) {
                maxLen = LIS[k];
            }
        }
        return maxLen;
    }

    public List<Integer> maxSub(List<Integer> a, List<Integer> rotate) {
        if (a == null || a.size() == 0 || rotate == null || rotate.size() == 0) {
            return Collections.emptyList();
        }
        int aSize = a.size();

        final List<Integer> indicesList = new ArrayList<>(rotate.size());
        for (int i = 0; i < rotate.size(); i++) {
            int rotateNum = (rotate.get(i)) % aSize;
            List<Integer> rotatedList = rotateArrayNTimes(a, rotateNum);
            int maxIndex = findMaxNumIndex(rotatedList);
            indicesList.add(maxIndex);
        }
        return indicesList;
    }

    public List<Integer> maxSub2(List<Integer> a, List<Integer> rotate) {
        if (a == null || a.size() == 0 || rotate == null || rotate.size() == 0) {
            return Collections.emptyList();
        }
        int aSize = a.size();

        int maxNum = Collections.max(a);

        int maxIndex = a.indexOf(maxNum);

        final List<Integer> indicesList = new ArrayList<>(rotate.size());
        for (int i = 0; i < rotate.size(); i++) {
            int rotateNum = (rotate.get(i)) % aSize;
            int index = rotateArrayNTimes2(maxIndex,aSize, rotateNum);
            indicesList.add(index);
        }
        return indicesList;
    }

    private int rotateArrayNTimes2(int maxIndex, int aSize, int rotateNum) {

       return  1 + (aSize + maxIndex - rotateNum) % aSize;

    }


    private int getMaxElementIndices(List<Integer> a, int rotateNum, List<Integer> indicesList) {
        List<Integer> rotatedList = rotateArrayNTimes(a, rotateNum);
        int maxIndex = findMaxNumIndex(rotatedList);
        return maxIndex;
    }

    /**
     * find max element index in array
     *
     * @param rotatedList
     * @return
     */
    private int findMaxNumIndex(List<Integer> rotatedList) {
        int maxIndex = 0;
        int maxNum = rotatedList.get(0);
        for (int i = 1; i < rotatedList.size(); i++) {
            if (maxNum < rotatedList.get(i)) {
                maxNum = rotatedList.get(i);
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private int rotateArrayNTimes2(List<Integer> a, int rotateNum) {

        return 0;
    }

    /**
     * rotate the array by rotateNum
     *
     * @param a
     * @param rotateNum
     * @return
     */
    private List<Integer> rotateArrayNTimes(List<Integer> a, int rotateNum) {
        List<Integer> rotatedList = new ArrayList<>();

        //  Collections.rotate(a, rotateNum);

        // System.arraycopy(rotatedList,0,a,rotateNum,a.size()-rotateNum);

        rotatedList.addAll(a.subList(rotateNum, a.size()));

        /*for(int i=rotateNum;i<a.size();i++){
            System.out.println("1--->"+rotatedList);
            rotatedList.add(a.get(i));
        }*/
        System.out.println("1--->" + rotatedList);

       /* System.out.println("1--->"+rotatedList);
        for(int i=0;i<rotateNum;i++){
            rotatedList.add(a.get(i));
        }*/
        rotatedList.addAll(a.subList(0, rotateNum));

        System.out.println("1--->" + rotatedList);
        return rotatedList;
    }

    public static void main(String[] args) {
       /* List<Integer> strings = Arrays.asList(1, 2, 4, 3);

        List<Integer> rotate = Arrays.asList(1, 3);

        List<Integer> indices = new MaxSubArray().maxSub(strings, rotate);
        System.out.println("indices-->" + indices);*/


      /*  String str= "abc";
        int i = new MaxSubArray().countSubstrings(str);
        System.out.println("i-->" + i);*/


        String s="aaaaaaa";
        List<String> dict = Arrays.asList("aaaa","aaa");
       System.out.println("Result-->"+ wordBreak(dict, s, ""));


    }

    public static boolean wordBreak(List<String> dict, String str, String out) {
        // if we have reached the end of the String, print the output String
        if (str.length() == 0)  {
            System.out.println(out);
            return true;
        }
        for (int i = 1; i <= str.length(); i++) {
            // consider all prefixes of current String
            String prefix = str.substring(0, i);
            // if the prefix is present in the dictionary, add prefix to the
            // output String and recur for remaining String
            if (dict.contains(prefix)) {
               if(wordBreak(dict, str.substring(i), out + " " + prefix))
                   return true;
            }
        }
        return false;
    }

    public boolean wordBreak(String str, List<String> dict) {
        int n = str.length();
        boolean[] WB = new boolean[n + 1];
        WB[0] = true;
        for (int i = 1; i <= str.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (WB[j] && dict.contains(str.substring(j, i))) {
                    WB[i] = true;
                    break;
                }
            }
        }
        // return false if the String can't be segmented
        return WB[n];
    }


}

