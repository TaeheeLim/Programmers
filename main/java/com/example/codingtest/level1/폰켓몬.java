package com.example.codingtest.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class 폰켓몬 {
    public static void main(String[] args) {
        int[] num1 = {3,1,2,3};
        int[] num2 = {3,3,3,2,2,4};
        int[] num3 = {3,3,3,2,2,2};

        System.out.println(solution(num3));
    }

    //N마리의 포켓몬 중 N / 2 의 포켓몬을 가질 수 있다.
    public static int solution(int[] nums) {
        int answer = 0;
        int limit = nums.length / 2;
        Stack<Integer> pocketBalls = new Stack<>();
        Arrays.sort(nums);

        //1,2,3,3
        //2,2,3,3,3,4
        //2,2,2,3,3,3
        for (int i = 0; i < nums.length; i++) {
            if(!pocketBalls.isEmpty() && pocketBalls.peek() == nums[i]){
                continue;
            } else {
                pocketBalls.push(nums[i]);
            }
        }
        if(pocketBalls.size() <= limit){
            limit = pocketBalls.size();
        }
        return limit;
    }
}
