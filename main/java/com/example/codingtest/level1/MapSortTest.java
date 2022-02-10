package com.example.codingtest.level1;

import java.util.*;

public class MapSortTest {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("b", 4);
        map.put("z", 27);
        map.put("d", 1);
        map.put("a", 3);

        List<Map.Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());
        System.out.println(entries);
        Collections.sort(entries, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        System.out.println("entries = " + entries);
    }
}
