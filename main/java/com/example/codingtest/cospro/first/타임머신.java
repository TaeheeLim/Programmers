package com.example.codingtest.cospro.first;

public class 타임머신 {
    public static void main(String[] args) {
        long num = 9949999;
        System.out.println(solution(num));
    }

    public static long solution(long num){
        long answer = 0;
        answer = num + 1;
        String longToString = answer + "";

        String result = longToString.replaceAll("0", "1");

        return Long.parseLong(result);
    }
}
