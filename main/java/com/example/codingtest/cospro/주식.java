package com.example.codingtest.cospro;

public class 주식 {
    public static void main(String[] args) {
        int[] prices1 = {1,2,3};
        int[] prices2 = {3,1};
        System.out.println("answer : " + solution(prices2));
    }

    public static int solution(int[] prices){
        int inf = 1000000001;
        int tmp = inf;
        System.out.println(tmp);
        int answer = -inf;
        System.out.println(answer);
        for(int price : prices){
            if(tmp != inf){
                answer = Math.max(answer, (tmp - price) * - 1);
                System.out.println("answer : " + answer);
            }
            tmp = Math.min(tmp, price);
            System.out.println("tmp : " + tmp);
        }
        return answer;
    }
}
