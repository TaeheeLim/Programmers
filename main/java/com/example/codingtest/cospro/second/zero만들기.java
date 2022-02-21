package com.example.codingtest.cospro.second;

public class zero만들기 {
    public static void main(String[] args) {
        String s = "101100011100";
        System.out.println(solution(s));
    }

    //"101101110"
    public static String solution(String s){
        s += '#';
        String answer = "";
        for(int i = 0; i < s.length(); ++i){
            if (s.charAt(i) == '0' && s.charAt(i+1) != '0')
                answer += "0";
            else if(s.charAt(i) == '1')
                answer += "1";
        }
        return answer;
    }
}
