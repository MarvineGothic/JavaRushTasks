package com.javarush.task.task32.task3201;

import java.io.*;

/*
Запись в существующий файл
public class Solution {
    public static void main(String... args) {

    }
}
*/
public class Solution {              // solved
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        long number = Integer.parseInt(args[1]);
        String text = args[2];
        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        number = number > raf.length() ? raf.length() : number;
        raf.seek(number);
        raf.write(text.getBytes());
        raf.close();
    }
}
