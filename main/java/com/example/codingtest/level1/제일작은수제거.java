package com.example.codingtest.level1;

import java.util.Arrays;
import java.util.OptionalInt;

public class 제일작은수제거 {

    public static void main(String[] args) {
            int[] data = {4,3,2,1};
            int[] data3 = {6,5,4,1,2,8};
            int[] data2 = {10};
            solution(data3);
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
        System.out.println(Arrays.toString(destination));
        System.arraycopy(arr, minIndex + 1, destination, minIndex, remainingElements);
        System.out.println(Arrays.toString(destination));

        if(arr.length == 1){
            return new int[]{-1};
        }
        return destination;
    }
}
