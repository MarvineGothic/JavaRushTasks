package com.javarush.task.task12.task1211;

/* 
Абстрактный класс Pet
public class Solution {
    public static void main(String[] args) {

    }

    public static class Pet {
        public String getName() {
            return "Я - котенок";
        }
    }

}
*/

public class Solution {                          // solved
    public static void main(String[] args) {

    }

    public static abstract class Pet {
        public String getName() {
            return "Я - котенок";
        }
    }

}