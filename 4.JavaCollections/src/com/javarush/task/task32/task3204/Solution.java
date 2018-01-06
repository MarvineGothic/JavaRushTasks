package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;

/* 
Генератор паролей
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        return null;
    }
}
*/
public class Solution {          // solved

    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while (baos.size() == 0) {
            for (int i = 0; i < 8; i++) {
                int choice = randomWithRange(1, 3);
                switch (choice) {
                    case 1:
                        baos.write(randomWithRange(48, 57)); // digits 0-9
                        break;
                    case 2:
                        baos.write(randomWithRange(97, 122)); // small letters a-z
                        break;
                    case 3:
                        baos.write(randomWithRange(65, 90)); // capital letters A-Z
                        break;
                }
            }
            if (!baos.toString().matches(".*\\d+.*") || !baos.toString().matches(".*[a-z]+.*") || !baos.toString().matches(".*[A-Z]+.*"))
                baos.reset();
        }
        return baos;
    }

    static int randomWithRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }

    /*static void generator() {
        while (result.isEmpty()) {
            for (int i = 0; i < 8; i++) {
                int choice = randomWithRange(1, 3);
                int num = (int) (Math.random() * (10));
                int smallLetters = randomWithRange(97, 122);
                int capitalLetters = randomWithRange(65, 90);
                switch (choice) {
                    case 1:
                        result = result.concat(String.valueOf(num));
                        break;
                    case 2:
                        result = result.concat(String.valueOf((char) smallLetters));
                        break;
                    case 3:
                        result = result.concat(String.valueOf((char) capitalLetters));
                        break;
                }
            }
            if (passwords.contains(result) || !result.matches(".*\\d+.*") || !result.matches(".*[a-z]+.*") || !result.matches(".*[A-Z]+.*")) {
                result = "";
            }else {
                passwords.add(result);
            }
        }
    }*/
}