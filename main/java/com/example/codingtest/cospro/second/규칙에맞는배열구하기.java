package com.example.codingtest.cospro.second;

import java.util.Arrays;

public class 규칙에맞는배열구하기 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(solution(arr)));
    }

    public static int[] solution(int[] arr){
        int left = 0, right = arr.length - 1;
        int idx = 0;
        int[] answer = new int[arr.length];
        // 1 2 3 4 5 6
        // 0 1
        // 5 4
        while(left <= right){
            if(Math.abs(left - arr.length / 2) > Math.abs(right - arr.length / 2)){
                answer[idx] = arr[left];
                left += 1;
            }
            else {
                answer[idx] = arr[right];
                right -= 1;
            }
            idx += 1;
        }
        return answer;
    }
}
