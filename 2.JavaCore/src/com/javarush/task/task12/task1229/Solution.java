package com.javarush.task.task12.task1229;

/* 
Родитель класса CTO
*/

public class Solution {           // solved

    public static void main(String[] args) {
        CTO cto = new CTO();
        System.out.println(cto);
    }

    public static interface Businessman {
        public void workHard();
    }
    public static class T implements Businessman{

        @Override
        public void workHard() {

        }
    }

    public static class CTO extends T implements Businessman{

    }
}
