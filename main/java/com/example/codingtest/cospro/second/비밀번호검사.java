package com.example.codingtest.cospro.second;

public class 비밀번호검사 {
    public static void main(String[] args) {
//        String password1 = "cospro890";
//        System.out.println(solution(password1));

        String password2 = "cba323";
        System.out.println(solution(password2));
    }

    public static boolean solution(String password){
        int length = password.length();
        for(int i = 0; i < length - 2; ++i){
            int firstCheck = password.charAt(i + 1) - password.charAt(i);
            int secondCheck = password.charAt(i) - password.charAt(i+1);
            System.out.println("first" + " : " + (password.charAt(i + 1) + " - " + password.charAt(i)) + " = " + firstCheck);
            System.out.println("second" + " : " + (password.charAt(i) + " - " + password.charAt(i + 1)) + " = " + secondCheck);
            if(firstCheck != secondCheck && (firstCheck == -1 || secondCheck == -1))
                return false;
        }
        return true;
    }
}
