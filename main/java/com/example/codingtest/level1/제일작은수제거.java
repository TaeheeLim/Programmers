package com.example.codingtest.level1;

import java.util.Arrays;
import java.util.OptionalInt;

public class 제일작은수제거 {

    public static void main(String[] args) {
            int[] data = {4,3,2,1};
            int[] data3 = {6,5,4,1,2,8};
            int[] data2 = {10};
            System.out.println(solution(data3).length);
    }

    public static int[] solution(int[] arr){
        int min = arr[0];
        int minIndex = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] < min){
                min  = arr[i];
                minIndex = i;
            }
        }
        int[] destination = new int[arr.length - 1];
        int remainingElements = arr.length - (minIndex + 1);

        System.arraycopy(arr, 0, destination, 0, minIndex);
        System.arraycopy(arr, minIndex + 1, destination, minIndex, remainingElements);

        if(arr.length == 1){
            return new int[]{-1};
        }
        System.out.println(Arrays.toString(destination));
        return destination;
    }
}
