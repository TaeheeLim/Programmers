package com.example.codingtest.level2;

import java.util.Stack;

public class 괄호변환 {
    public static void main(String[] args) {
        String data1 = "(()())()";
        String data2 = ")(";
        String data3 = "()))((()";

        System.out.println(solution(data1));;
    }
    // ( = 0
    // ) = 1
    // 01 0101 0011 0 0 01 1 01 1
    public static String solution(String p){
        System.out.println(p);
        String a  = "(";
        String b = ")";

        if(p.equals("")){
            return "";
        }
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < p.length(); i++){
            stack.push(String.valueOf(p.charAt(i)));
        }

        

        return "";
    }
}
