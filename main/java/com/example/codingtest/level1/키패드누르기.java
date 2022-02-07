package com.example.codingtest.level1;

public class 키패드누르기 {
    public static void main(String[] args) {
        int[] numbers1 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        int[] numbers2 = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        int[] numbers3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        String hand1 = "right";
        String hand2 = "left";
        String hand3 = "right";

        System.out.println(solution(numbers1, hand1));
    }
    //    1   2   3
    //    4   5   6
    //    7   8   9
    //    *   0   #
    //한칸의 거리는 1
    //같은 거리일 경우 왼손잡이인지 오른손잡이인지 판단

    // 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5
    public static String solution(int[] numbers, String hand){
        String answer = "";

        Person person = new Person("*", "#", hand);

        for(int number : numbers){
            
        }

        return answer;
    }
}

class Person{
    String leftPosition;
    String rightPosition;
    String hand;

    Person(String left, String right, String hand){
        this.leftPosition = left;
        this.rightPosition = right;
        this.hand = hand;
    }

    public String getLeftPosition() {
        return leftPosition;
    }

    public void setLeftPosition(String leftPosition) {
        this.leftPosition = leftPosition;
    }

    public String getRightPosition() {
        return rightPosition;
    }

    public void setRightPosition(String rightPosition) {
        this.rightPosition = rightPosition;
    }

    public String getHand() {
        return hand;
    }

    public void setHand(String hand) {
        this.hand = hand;
    }

    @Override
    public String toString() {
        return "Person{" +
                "leftPosition=" + leftPosition +
                ", rightPosition=" + rightPosition +
                ", hand='" + hand + '\'' +
                '}';
    }
}
