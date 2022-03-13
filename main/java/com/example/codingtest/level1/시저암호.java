package com.example.codingtest.level1;

public class 시저암호 {
    public static void main(String[] args) {
        String s1 = "AB";
        String s2 = "z";
        String s3 = "a B z";

        int n1 = 1;
        int n2 = 1;
        int n3 = 4;

        System.out.println(solution(s3, n3));
    }

    public static String solution(String s, int n){
        String answer = "";
        //대문자 A는 아스키 코드로 65
        //소문자 a는 아스키 코드로 97
        //알파벳 개수는 26개
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLowerCase(ch)) {

            } else if (Character.isUpperCase(ch)) {

            }

            answer += ch;
        }
        return answer;
    }
}
