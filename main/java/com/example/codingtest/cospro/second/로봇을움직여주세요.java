package com.example.codingtest.cospro.second;

import java.util.Arrays;

public class 로봇을움직여주세요 {
    public static void main(String[] args) {
        String commands = "URDDL";

        System.out.println(Arrays.toString(solution(commands)));
    }

    public static int[] solution(String commands){
        int[] answer = new int[2];

        for(int i = 0; i <commands.length(); i++){
            if(commands.charAt(i) == 'U'){
                answer[1]++;
            }
            if(commands.charAt(i) == 'D'){
                answer[1]--;
            }
            if(commands.charAt(i) == 'R'){
                answer[0]++;
            }
            if(commands.charAt(i) == 'L'){
                answer[0]--;
            }
        }

        return answer;
    }
}
