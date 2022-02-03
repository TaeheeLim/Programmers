package com.example.codingtest.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class 괄호변환 {
    public static void main(String[] args) {
        String data1 = "(()())()";
        String data2 = ")(";
        String data3 = "()))((()";

        System.out.println(solution(data3));
    }
    // ( = 0
    // ) = 1
    // 01 0101 0011 0 0 01 1 01 1
    public static String solution(String p){
        System.out.println(p);
        String a  = "("; // push
        String b = ")"; // pop
        String[] split = p.split("");
        System.out.println(Arrays.toString(split));

        if(p.equals("")){
            return "";
        }

        Stack<String> all = new Stack<>();
        List<String> list = new ArrayList<>();

        String u = "";
        String v = "";
        int first = 0;
        int second = 0;

        Loop1:
        for(int i = 0; i < split.length; i++){
            if(split[i].equals("(")){
                first++;
                System.out.println("first");
                System.out.println(first);
                list.add(split[i]);
            } else {
                second++;
                System.out.println("second");
                System.out.println(second);
                list.add(split[i]);
            }

            if(first == second){
                System.out.println(first);
                System.out.println(second);
                for(int j = 0; j < list.size(); j++){
                    u += list.get(j);
                    if(j == list.size() - 1){
                        break Loop1;
                    }
                }
            }
        }
        System.out.println(u);


        return "";
    }
}
