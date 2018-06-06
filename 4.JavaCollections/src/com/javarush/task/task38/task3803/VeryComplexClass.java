package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {  // solved
    public static void main(String[] args) {
        new VeryComplexClass().methodThrowsNullPointerException();
    }

    public void methodThrowsClassCastException(){
        Object a = 0;
        a = (String) a;
    }

    public void methodThrowsNullPointerException() {
        int a[] = null;
        System.out.println(a[2]);
    }
}
