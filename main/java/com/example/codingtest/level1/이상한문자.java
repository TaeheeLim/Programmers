package com.example.codingtest.level1;

import java.util.Arrays;

public class 이상한문자 {

    public static void main(String[] args) {
        String s = "try hello world";

        System.out.println(solution(s));
    }

    public static String solution(String s) {
        String answer = "";

        int count = 0;
        for(int i = 0; i < s.length(); i++){
             if(Character.isWhitespace(s.charAt(i))){
                 count = 0;
                 answer += " ";
                 continue;
             }
            if(count % 2 == 0){
                char c = Character.toUpperCase(s.charAt(i));
                answer += c;
                count++;
            } else {
                answer += s.charAt(i);
                count++;
            }
        }
        return answer;
    }
}
