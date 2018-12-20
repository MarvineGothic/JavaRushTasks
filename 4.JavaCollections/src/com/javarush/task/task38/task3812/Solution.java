package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

import java.util.Arrays;

public class Solution {                 // solved
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {
        if (c.isAnnotationPresent(PrepareMyTest.class)) {
            System.out.println(Arrays.toString(((PrepareMyTest) c.getAnnotation(PrepareMyTest.class)).fullyQualifiedNames()));
            return true;
        }
        return false;
    }

    public static boolean printValues(Class c) {
        if (c.isAnnotationPresent(PrepareMyTest.class)) {
            Class cl[] = ((PrepareMyTest) c.getAnnotation(PrepareMyTest.class)).value();
            for (int i = 0; i < cl.length; i++)
                System.out.println(cl[i].getSimpleName());
            return true;
        }
        return false;
    }
}
