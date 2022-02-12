package com.example.codingtest.level1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 거리두기확인하기 {
    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                           {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}
                          ,{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}
                         , {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}
                          ,{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        System.out.println(Arrays.toString(solution(places)));
    }
    //X는 파티션
    //O비어있는자리
    //P는 응시자가 앉아있는 자리
    //각 대기실별로 거리두기가 지켜지고있으면 1, 한명이라도 지키고있지 않으면 0을 RETURN
    //맨하튼 거리 =  (r1, c1), (r2, c2)에 각각 위치하고 있다면, T1, T2 사이의 맨해튼 거리는 |r1 - r2| + |c1 - c2| 입니다.

    //맨하튼 거리가 2 초과여야 한다
    //맨하튼 거리가 2이하 일지라도 중간에 파티션(X)가 있으면 괜찮다.
    //맨하튼 거리가 0, 1, 2면 안되는데 파티션 이있으면 가능

//      No.	0	1	2	3	4
//      0	P	X	O	P	X
//      1	O	X	O	X	P
//      2	O	X	P	O	X
//      3	O	X	X	O	P
//      4	P	X	P	O	X

//    String[][] places = {{"P O O O P",
//                          "O X X O X",
//                          "O P X P X",
//                          "O O X O X",
//                          "P O X X P"},
//            {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}
//            ,{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}
//            , {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}
//            ,{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int i = 0; i < places.length; i++){
            char[][] room = new char[5][5];
            for(int j = 0; j < 5; j++){
                room[j] = places[i][j].toCharArray();
            }
            answer[i] = isComplied(room);
        }
        return answer;
    }

    public static int isComplied(char[][] room){
        for(int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                if(room[i][j] == 'P' && bfs(room, i, j) == 0) return 0;
            }
        }
        return 1;
    }

    public static int[][] compareXY = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int bfs(char[][] room, int i ,int j){
        boolean[][] taken = new boolean[5][5];

        Queue<Integer> queue = new LinkedList<>();
        taken[i][j] = true;
        queue.offer(i);
        queue.offer(j);
        queue.offer(0);

        while (!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();
            int count = queue.poll();
            for(int[] arr : compareXY){
                int sumX = x + arr[0];
                int sumY = y + arr[1];
                int sumCnt = count + 1;
                if(isOutOfRange(taken, room, sumX, sumY, sumCnt)){
                    if(room[sumX][sumY] == 'P') return 0;
                    taken[sumX][sumY] = true;
                    queue.offer(sumX);
                    queue.offer(sumY);
                    queue.offer(sumCnt);
                }
            }

        }
        return 1;
    }

    public static boolean isOutOfRange(boolean[][] taken, char[][] room, int x, int y, int count){
        if(x < 0 || y < 0 || x >= 5 || y >=5) return false;
        if(taken[x][y] || room[x][y] == 'X' || count == 3) return false;
        return true;
    }

}
