package com.javarush.task.task12.task1213;

/* 
«Исправь код», часть 2
public class Solution {
    public static void main(String[] args) {

    }

    public static class Pet {
        public String getName() {
            return "Я - котенок";
        }

        public Pet getChild();
    }

}
*/

public class Solution {               // solved
    public static void main(String[] args) {

    }

    public static abstract class Pet {
        public String getName() {
            return "Я - котенок";
        }

        public abstract Pet getChild();
    }

}

