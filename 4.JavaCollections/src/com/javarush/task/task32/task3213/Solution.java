package com.javarush.task.task32.task3213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/* 
Шифр Цезаря
public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor Dpljr");
        System.out.println(decode(reader, -3));  //Hello Amigo

    }

    public static String decode(StringReader reader, int key) throws IOException {

        return null;
    }

}

*/

public class Solution {   // solved
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor Dpljr");
        System.out.println(decode(reader, -3));  //Hello Amigo

    }

    public static String decode(StringReader reader, int key) throws IOException {
        String buf = "";
        StringBuilder sb = new StringBuilder();
        int a;
        try (BufferedReader bf = new BufferedReader(reader)) {
            while ((a = bf.read()) != -1) {
                buf = ((char) a) == ' ' ? sb.append((char) a).toString() : sb.append((char) (a + key)).toString();
            }
        } catch (NullPointerException e) {
            return buf;
        }
        return buf;
    }

}
