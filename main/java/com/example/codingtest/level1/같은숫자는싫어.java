package com.example.codingtest.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class 같은숫자는싫어 {
    public static void main(String[] args) {
        int[] arr1 = {1,1,3,3,0,1,1};
        int[] arr2 = {4,4,4,3,3};

        System.out.println(Arrays.toString(solution(arr2)));
    }

    // 답 1, 3, 0, 1 0 ~ 6인덱스
    //답 4, 3
    public static Integer[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < arr.length; i++){
            if(!stack.isEmpty() && (int)stack.peek() == arr[i]){
                continue;
            } else {
                stack.push(arr[i]);
            }
        }
        System.out.println(stack.toString());
        return stack.toArray(new Integer[0]);
    }
}
