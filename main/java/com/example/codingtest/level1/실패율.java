package com.example.codingtest.level1;

import java.security.KeyStore;
import java.util.*;

public class 실패율 {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

        int N2 = 4;
        int[] stages2 = {4, 4, 4, 4, 4};

        int N3 = 6;
        int[] stages3 = {6, 6, 6, 6, 6};

        System.out.println(Arrays.toString(solution(N, stages)));
    }

    public static int[] solution(int N, int[] stages) {
        List<Stage> stageList = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            int peopleStuckAtStage = 0;
            int peopleOverStage = 0;
            for(int j = 0; j < stages.length; j++){
                if(stages[j] >= i) peopleOverStage++;
                if(stages[j] == i) peopleStuckAtStage++;
            }
            double failureRate = 0.0;
            if(peopleOverStage > 0) {
                failureRate = (double)peopleStuckAtStage / peopleOverStage;
            }
            Stage stage = new Stage(i, failureRate);
            stageList.add(stage);
        }

        //??
        stageList.sort((o1, o2) -> Double.compare(o2.failureRate, o1.failureRate));

        int[] answer = new int[N];
        for(int i = 0; i < stageList.size(); i++){
            answer[i] = stageList.get(i).index;
        }
        return answer;
    }



    public static int[] solution2(int N, int[] stages) {

        Map<Integer, Double> stageList = new HashMap<>();

        for(int i = 1; i <= N; i++){
            int peopleStuckAtStage = 0;
            int peopleOverStage = 0;
            for(int j = 0; j < stages.length; j++){
                if(stages[j] >= i) peopleOverStage++;
                if(stages[j] == i) peopleStuckAtStage++;
            }
            double failureRate = 0.0;
            if(peopleOverStage > 0) {
                failureRate = (double)peopleStuckAtStage / peopleOverStage;
            }
            stageList.put(i, failureRate);
        }

        List<Map.Entry<Integer, Double>> entries = new LinkedList<>(stageList.entrySet());
        Collections.sort(entries, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));

        int[] answer = new int[N];
        int i = 0;
        for(Map.Entry<Integer, Double> item : entries){
            answer[i++] = item.getKey();
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
