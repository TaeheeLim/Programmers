package com.example.codingtest.level1;

public class 이천십육년 {
    public static void main(String[] args) {
        int a = 5;
        int b = 24;

        System.out.println(solution(1, 10));
    }

    //1월 1일은 금요일
    public static String solution(int a, int b){
        String[] dayInWeek = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        int[] daysInMonth = {31,29,31,30,31,30,31,31,30,31,30,31};
        int num = 0;
        for(int i = 0; i  < a - 1; i++){
            num += daysInMonth[i];
        }
        System.out.println(num);
        num += b - 1;

        return dayInWeek[num % 7];
    }
}
