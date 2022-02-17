package com.example.codingtest.cospro;

import java.util.Arrays;

public class 누가당선되나요 {
    public static void main(String[] args) {
        int N1 = 5;
        int[] votes1 = {1,5,4,3,2,5,2,5,5,4};
        int[] ret1 = solution(N1, votes1);

        System.out.println(Arrays.toString(ret1));

        int N2 = 4;
        int[] votes2 = {1, 3, 2, 3, 2};
        int[] ret2 = solution(N2, votes2);

        System.out.println(Arrays.toString(ret2));
    }

    public static int[] solution(int N, int[] votes){
        int[] voteCounter = new int[11];

        //후보 번호를 인덱스로 보고 해당 배열 index를 ++
        for (int i = 0; i < votes.length; i++) {
            voteCounter[votes[i]] += 1;
        }
        System.out.println(Arrays.toString(voteCounter));
        int maxVal = 0;
        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            if (maxVal < voteCounter[i]) {
                maxVal = voteCounter[i];
                cnt = 1;
            }
            else if(maxVal == voteCounter[i]){
                cnt += 1;
            }
        }

        int answer[] = new int[cnt];

        for (int i = 1, idx = 0; i <= N; i++){
            if (voteCounter[i] == maxVal) {
                answer[idx] = i;
                idx += 1;
            }
        }

        return answer;
    }
}
