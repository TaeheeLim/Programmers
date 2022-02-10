package com.example.codingtest.level1;

import java.security.KeyStore;
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
        int peopleStuckAtStage = 0;
        int peopleOverStage = 0;

        List<Stage> stageList = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            for(int j = 0; j < stages.length; j++){
                if(stages[j] >= i) peopleOverStage++;
                if(stages[j] == i) peopleStuckAtStage++;
            }
            double failureRate = (double)peopleStuckAtStage / peopleOverStage;
            Stage stage = new Stage(i, failureRate);
            stageList.add(stage);
            peopleStuckAtStage = 0;
            peopleOverStage = 0;
        }
        Collections.sort(stageList, (o1, o2) -> Double.compare(o2.failureRate, o1.failureRate));
        for(int i = 0; i < stageList.size(); i++){
            System.out.println(stageList.get(i).index);
            System.out.println(stageList.get(i).failureRate);
            System.out.println("==================");
        }
        int[] answer = new int[N];
        for(int i = 0; i < stageList.size(); i++){
            answer[i] = stageList.get(i).index;
        }
        return answer;
    }
}
class Stage{
    int index;
    double failureRate;

    Stage(int index, double failureRate){
        this.index = index;
        this.failureRate = failureRate;
    }
}
