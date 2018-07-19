package com.codility;

import java.util.*;

public class TheaterTickets {

    public static void main(String[] args) {
        TheaterTickets test = new TheaterTickets();
        int A[] = {1, 2};
        //int A[] = {1, 2, 3, 4};
        //int A[] = {1, 2, 2, 2};
        //int A[] = {1, 2, 1, 1};
        int s = test.theaterTickets(A);
        System.out.print(s);
    }

    public int theaterTickets(int[] A) {
        int length = A.length;
        if (length < 3) {
            return 0;
        } else if (length == 3) {
            return 1;
        }
        int result = 0;
        int day1 = 0;
        int day2 = 0;
        int day3 = 0;
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < length - 2; i++) {
            day1 = A[i];
            for (int j = 1 + i; j < length - 1; j++) {
                day2 = A[j];
                for (int k = 1 + j; k < length; k++) {
                    day3 = A[k];
                    list.add((day1 + "") + (day2 + "") + (day3 + ""));
                }
            }
        }
        Set<String> hs = new HashSet<>();
        hs.addAll(list);
        list.clear();
        list.addAll(hs);
        result = list.size();
        return result;
    }
    /*public String solution(String S) {
        // reverse a string
        String result="";
        char[] stringArray = S.toCharArray();
        for(int i=stringArray.length-1;i>=0;i--)
        {

            result = result+Character.toString(stringArray[i]);
        }

        return result;
    }*/
}