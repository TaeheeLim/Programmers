package com.example.codingtest.level2;

import java.util.*;

public class 메뉴리뉴얼연습 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[] {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[] {2, 3, 5})));

    }

    public static class Solution {
        private Map<String, Integer> menu = new HashMap<>();

        public String[] solution(String[] orders, int[] course) {
            String[] answer = {};
            List<String> list = new ArrayList<>();

            for (int count : course) {
                for (String order : orders) {
                    boolean[] isVisited = new boolean[orders.length];
                    String[] arr = order.split("");
                    Arrays.sort(arr);
                    dfs(arr, isVisited, 0, count);
                }

                List<Map.Entry<String, Integer>> entries = new ArrayList<>(menu.entrySet());

                entries.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

                int max = 0;
                for (Map.Entry<String, Integer> entry : entries) {
                    if (entry.getValue() > 1 && entry.getValue() >= max) {
                        max = entry.getValue();
                        list.add(entry.getKey());
                    }
                }
                menu.clear();
            }
            String[] toArray = list.toArray(new String[1]);
            Arrays.sort(toArray);

            return toArray;
        }

        public void dfs(String[] arr, boolean[] isVisited, int index, int course) {

            if (course == 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arr.length; i++) {
                    if (isVisited[i]) {
                        sb.append(arr[i]);
                    }
                }
                if (menu.containsKey(sb.toString())) {
                    menu.put(sb.toString(), menu.get(sb.toString()) + 1);
                } else {
                    menu.put(sb.toString(), 1);
                }
            } else {
                for (int i = index; i < arr.length; i++) {
                    isVisited[i] = true;
                    dfs(arr, isVisited, i + 1, course - 1);
                    isVisited[i] = false;
                }
            }
        }
    }
}
