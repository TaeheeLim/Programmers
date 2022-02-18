package com.example.codingtest.cospro.second;

public class 도서대여점운영 {
    public static void main(String[] args) {
        String[] bookTypes = {"comic", "comic", "novel"};
        int day = 4;
        System.out.println(solution(bookTypes, 4));
    }
    interface Book{
        public int getRentalPrice(int day);
    }

    static class ComicBook implements Book {
        public int getRentalPrice(int day){
            int cost = 500;
            day -= 2;
            if(day > 0)
                cost += day * 200;
            return cost;
        }
    }

    static class Novel implements Book {
        public int getRentalPrice(int day){
            int cost = 1000;
            day -= 3;
            if(day > 0)
                cost += day * 300;
            return cost;
        }
    }

    public static int solution(String[] bookTypes, int day) {
        Book[] books = new Book[50];
        int length = bookTypes.length;
        for(int i = 0; i < length; ++i){
            if(bookTypes[i].equals("comic"))
                books[i] = new ComicBook();
            else if(bookTypes[i].equals("novel"))
                books[i] = new Novel();
        }
        int totalPrice = 0;
        for(int i = 0; i < length; ++i)
            totalPrice += books[i].getRentalPrice(day);
        return totalPrice;
    }

}
