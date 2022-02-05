package com.example.codingtest.level1;

import java.util.HashMap;
import java.util.Map;

public class 문자열과영단어 {
    public static void main(String[] args) {
        String data1 = "one4seveneight";
        String data2 = "23four5six7";
        String data3 = "2three45sixseven";
        String data4 = "123";

        System.out.println(solution(data1));
    }

    public static int solution(String s){
        int answer = 0;
        StringBuilder builder = new StringBuilder();

        Map<String, Integer> map = new HashMap<>();
        for(int i = 1; i < 11; i++){
            map.put("data", i);
        }

        return answer;
    }
}
