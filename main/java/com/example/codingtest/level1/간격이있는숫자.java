package com.example.codingtest.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 간격이있는숫자 {
    public static void main(String[] args) {
        int x = 4;
        int n = 3;

        System.out.println(Arrays.toString(solution(x, n)));
    }

    public static long[] solution(int x, int n){
        List<Long> list = new ArrayList<>();

        long count = 1;
        for(long i = 0; i < n; i++){
            list.add(x * count);
            count++;
        }
        long[] resultArray = new long[list.size()];

        int size = 0;
        for(long temp : list){
            resultArray[size++] = temp;
        }

        System.out.println(Arrays.toString(resultArray));

        return resultArray;
    }
}

//class Solution {
//    public long[] solution(int x, int n) {
//        long[] answer = new long[n];
//        int i = 0;
//        for(long j = 1; j <= n; j++) {
//            answer[i++] = x * j;
//        }
//
//        return answer;
//    }
//}
