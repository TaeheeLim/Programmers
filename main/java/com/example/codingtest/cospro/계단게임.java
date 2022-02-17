package com.example.codingtest.cospro;

public class 계단게임 {
    public static void main(String[] args) {
        int[] recordA = {2,0,0,0,0,0,1,1,0,0};
        int[] recordB = {0,0,0,0,2,2,0,2,2,2};
        System.out.println(solution(recordA, recordB));
    }

    public static int solution(int[] recordA, int[] recordB){
        int cnt = 0;
        for(int i = 0; i < recordA.length; i++){
            if(recordA[i] == recordB[i])
                continue;
            else if(recordA[i] == func(recordB[i]))
                cnt = cnt + 3;
            else if(i != 0 && recordA[i] != func(recordB[i]))
                cnt = cnt - 1;
        }
        return cnt;
    }

    public static int func(int record){
        if(record == 0) return 1;
        else if(record == 1) return 2;
        return 0;
    }

}
