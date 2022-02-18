package com.example.codingtest.cospro.first;

import java.util.Arrays;

public class 병합and정렬 {
    public static void main(String[] args) {
        int[] arrA = {-2, 3, 5, 9};
        int[] arrB = {0, 1, 5};
        int[] ret = solution(arrA, arrB);

        System.out.println(Arrays.toString(ret));
    }

    public static int[] solution(int[] arrA, int[] arrB){
        int arrA_idx = 0, arrB_idx = 0;

        int arrA_len = arrA.length;
        int arrB_len = arrB.length;

        int[] answer = new int[arrA_len + arrB_len];

        int answer_idx = 0;

//        int[] arrA = {-2, 3, 5, 9};
//        int[] arrB = {0, 1, 5};
//answer  -2 0 1 3 5
//arrA_idx 0 1 1 2 2
//arrB_idx 0 1 2 2 3
        while(arrA_idx < arrA_len && arrB_idx < arrB_len){
            if(arrA[arrA_idx] < arrB[arrB_idx])
                answer[answer_idx++] = arrA[arrA_idx++];
            else
                answer[answer_idx++] = arrB[arrB_idx++];
        }

        while(arrA_len - arrA_idx != 0)
            answer[answer_idx++] = arrA[arrA_idx++];

        while(arrB_len - arrB_idx != 0)
            answer[answer_idx++] = arrB[arrB_idx++];
        return answer;
    }


}
