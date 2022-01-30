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
        //(int)이런식으로 강제캐스팅하면은 int로 변환 되는게 아니라 아스키코드로 변환되서 나옴.
        //1은 아스키코드로 41 3은 아스키코드로 51
        //그래서 Character.getNumericalValue라는 메소드롤 통해서 char를 int로 형 변환

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
