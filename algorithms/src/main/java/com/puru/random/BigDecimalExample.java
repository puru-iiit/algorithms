package com.puru.random;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class Person implements  Comparable{

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
public class BigDecimalExample {

    public static String rightPadZeros(String str, int num) {
        List<Person> list = new ArrayList<>();

        Collections.sort(list);

        String pattern = "%1$-" + num + "s";
        System.out.println("pattern : " + pattern);
        return String.format(pattern, str).replace(' ', '0');
    }

    public static void main(String[] args) throws ParseException {


        getDecimalNewWay();

    }

    private static void getDecimalNewWay() {
        String input = "-1233.1415";

        //Integer intVaue  = Integer.parseInt(input);
        // System.out.println("input : " + input);

        String[] split = input.split("\\.");

        long units = Long.parseLong(split[0]);

        String str = rightPadZeros(split[1],9);
        boolean negative =false;
        if(units<0){
            str = "-"+str;

      }
        ConcurrentMap map = new ConcurrentHashMap();
        Object o = map.get("key");



        int frac = Integer.parseInt(str);

        System.out.println("units : " + units);

        System.out.println("fraction : " + frac);
    }

}