package com.example.codingtest.level1;

public class 하샤드수 {
    public static void main(String[] args) {
        int x = 13;

        System.out.println(solution(x));
    }

    public static boolean solution(int x){
        boolean answer = true;

        String result = x + "";
        char[] chars = result.toCharArray();
        int sum = 0;

        for (char aChar : chars) {
            sum += Character.getNumericValue(aChar);
        }
        if(x % sum == 0){
            answer = true;
        } else {
            answer = false;
        }

        return answer;
    }
}
