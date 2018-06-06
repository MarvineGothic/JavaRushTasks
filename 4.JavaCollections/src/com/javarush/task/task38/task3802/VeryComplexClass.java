package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.io.FileReader;

public class VeryComplexClass {  // solved
    public static void main(String[] args) {
        try {
            new VeryComplexClass().veryComplexMethod();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void veryComplexMethod() throws Exception {
        //напишите тут ваш код
        FileReader fileReader = new FileReader("c:\\temp\\11111.txt");
    }
}
