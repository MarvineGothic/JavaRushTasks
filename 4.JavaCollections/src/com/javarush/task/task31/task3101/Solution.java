package com.javarush.task.task31.task3101;

import java.io.File;

/*
Проход по дереву файлов
public class Solution {
    public static void main(String[] args) {

    }

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }
}

*/
public class Solution {          // not solved
    public static void main(String[] args) {
        File path = new File("c://filepath/");
        File resultFileAbsolutePath = new File("");
        for (File file: path.getParentFile().listFiles()){

        }

    }

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }
}
