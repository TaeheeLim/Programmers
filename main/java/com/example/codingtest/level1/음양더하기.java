package com.example.codingtest.level1;

public class 음양더하기 {
    public static void main(String[] args) {
        int[] absolutes1 = {4,7,12};
        boolean[] signs1 = {true,false,true};

        int[] absolutes2 = {1,2,3};
        boolean[] signs2 = {false,false,true};

        System.out.println(solution(absolutes2, signs2));
    }

    public static int solution(int[] absolutes, boolean[] signs) {
        int sum = 0;
        for(int i = 0; i < absolutes.length; i++){
            if(signs[i]) sum += absolutes[i];
            else sum -= absolutes[i];
        }
        return sum;
    }

}
