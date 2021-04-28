package com.puru.random;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * * aaabb -> ababa
 * char size --256
 */

public class ArrangeChars {

    public static void main(String[] args) {
        ArrangeChars arrangeChars = new ArrangeChars();


        //USecase-1 | +ve
        String str = "aaabb";
        String res = arrangeChars.arrangeChars(str);
        System.out.println("str-->"+res);

        //UseCase-2 | -ve
        String str2 = "aaaabb";
        String res2 = arrangeChars.arrangeChars(str2);
        System.out.println("str2-->"+res2);

        //UseCase-3 | -ve String null
        String str3 = null;
        String res3 = arrangeChars.arrangeChars(str3);
        System.out.println("str3-->"+res3);

        //UseCase-4 | -ve String is empty
        String str4 = "";
        String res4 = arrangeChars.arrangeChars(str4);
        System.out.println("str4-->"+res4);

        //UseCase-5 | -ve String is empty
        String str5 = "sssbbccc";
        String res5 = arrangeChars.arrangeChars(str5);
        System.out.println("str5-->"+res5);

    }
    public String arrangeChars(String str) {
        if (str == null || str.trim().length() == 0) {
            return "Soory";
        }
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        Pair dummp = new Pair('#',-1);
        Set<Character> characters = freqMap.keySet();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(Map.Entry<Character, Integer> entry : freqMap.entrySet()){
            pq.offer(new Pair(entry.getKey(),entry.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()){

            Pair ele = pq.poll();

            sb.append(ele.getCh());

            if(dummp.getFreq()>0){
                pq.offer(dummp);
            }
            ele.setFreq(ele.getFreq()-1);
            dummp = ele;
        }
        if(sb.toString().length()==str.length()){
            return  sb.toString();
        }else{
            return "Soory";
        }
    }

    class Pair implements Comparable<Pair> {
        private Character ch;
        private Integer freq;

        public Pair(Character ch, int freq) {
            this.ch=ch;
            this.freq=freq;
        }

        @Override
        public int compareTo(Pair o) {
            return o.getFreq().compareTo(this.getFreq());
        }

        public Character getCh() {
            return ch;
        }
        @Override
        public String toString() {
            return "Pair{" +
                    "ch=" + ch +
                    ", freq=" + freq +
                    '}';
        }

        public void setCh(Character ch) {
            this.ch = ch;
        }

        public Integer getFreq() {
            return freq;
        }

        public void setFreq(Integer freq) {
            this.freq = freq;
        }


    }
}
