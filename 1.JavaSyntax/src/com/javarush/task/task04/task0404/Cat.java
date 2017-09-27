package com.javarush.task.task04.task0404;

/* 
Реализовать метод addNewCat
*/

public class Cat {
    private static int catsCount = 0;

    public static void addNewCat() {
        new Cat();
        catsCount++;
        //напишите тут ваш код
    }

    public static void main(String[] args) {
addNewCat();
addNewCat();
        System.out.println(catsCount);
    }
}
