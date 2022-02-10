package com.example.codingtest.level1;

import java.util.*;

public class 실패율 {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

        int N2 = 4;
        int[] stages2 = {4, 4, 4, 4, 4};

        System.out.println(Arrays.toString(solution(N, stages)));
    }


    //N 은 stage의 개수
    //stages는 현재 사용자가 위치해 있는 스테이지 번호
    //stages에는 N이상 N + 1 이하의 자연수가 담겨있다
    //N + 1은 마지막 스테이지(N번째 스테이지)까지 클리어한 사용자를 나타낸다.
    //실패율이 높은 스테이지부터 내림차순으로 스테이지 번호 return
    // 실패율 : 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수

    // N = 5;
    // stages = 2, 1, 2, 6, 2, 4, 3, 3
    public static int[] solution(int N, int[] stages) {
        int[] answer = {};
        Map<Integer, Double> eachStagesFailure = new HashMap<>();
        Map<Double, Integer> reverseMap = new HashMap<>();
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());

        int peopleStuckAtStage = 0;
        int peopleOverStage = 0;

        //1, 2, 3, 4, 5 -- 스테이지 번호
        //1 0.125
        //2 0.428
        //3 0.5
        //4 0.5
        //5 0
        for(int i = 1; i <= N; i++){
            for(int j = 0; j < stages.length; j++){
                if(stages[j] >= i){
                    peopleOverStage++;
                }
                if(stages[j] == i){
                    peopleStuckAtStage++;
                }
            }
            System.out.println(peopleStuckAtStage + " / " + peopleOverStage);
            double failureRate = (double)peopleStuckAtStage / peopleOverStage;

            eachStagesFailure.put(i, failureRate);
            peopleStuckAtStage = 0;
            peopleOverStage = 0;
        }
        System.out.println(eachStagesFailure.toString());
        Integer[] keys = eachStagesFailure.keySet().toArray(new Integer[0]);

        for(Integer key : keys){
            pq.add(eachStagesFailure.get(key));
        }
        System.out.println("pq = " + pq);
        

        return answer;
    }
}
