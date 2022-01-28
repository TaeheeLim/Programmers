package com.example.codingtest;

import java.util.*;

public class 완주하지못한선수 {
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        System.out.println(solutions(participant, completion));
    }

//    1 2 3 3 4 5 6 7
//    1 2 3 4 5 6 7

    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i = 0; i < completion.length; i++){
            if (!participant[i].equals(completion[i])){
                answer = participant[i];
                break;
            }
        }
        if(answer.equals("")){
            int length = participant.length;
            answer = participant[length - 1];
        }
        return answer;
    }



    public static String solutions(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        System.out.println(hm);
        for (String player : participant) {
            hm.put(player, hm.getOrDefault(player, 0) + 1);
        }

        System.out.println(hm);
        for (String player : completion) {
            hm.put(player, hm.get(player) - 1);
        }

        System.out.println(hm);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
                break;
            }
        }
        return answer;
    }
}
