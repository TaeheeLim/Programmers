package com.example.codingtest.cospro.second;

public class 경품당첨자 {
    public static void main(String[] args) {
        int num1 = 1;
        int ret1 = solution(num1);
        System.out.println(ret1);

//        int num2 = 235386;
//        int ret2 = solution(num2);
//        System.out.println(ret2);
    }

    public static int solution(int num){
        int nextNum = num;
        while(true){
            nextNum++;
            int length = func_b(nextNum);

            if(length % 2 != 0)
                continue;

            int divisor = func_a(length / 2);
            int front = nextNum / divisor;
            int back = nextNum % divisor;

            int frontSum = func_c(front);
            int backSum = func_c(back);

            if(frontSum == backSum)
                break;
        }
        return nextNum - num;
    }

    public static int func_a(int n){
        int ret = 1;
        while(n > 0){
            ret *= 10;
            n--;
        }
        return ret;
    }

    static int func_b(int n){
        int ret = 0;
        while(n > 0){
            ret++;
            n /= 10;
        }
        return ret;
    }

    static int func_c(int n){
        int ret = 0;
        while(n > 0){
            ret += n%10;
            n /= 10;
        }
        return ret;
    }
}
