package com.javarush.task.task19.task1914;

/* 
Решаем пример
public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {                  // solved
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();

        System.setOut(consoleStream);

        String result = outputStream.toString();
        String[] resultArray = result.split(" ");
        int firstNum = Integer.parseInt(resultArray[0]);
        int secondNum = Integer.parseInt(resultArray[2]);
        int arithmeticResult;

        if (resultArray[1].equals("+"))
            arithmeticResult = firstNum + secondNum;
        else if (resultArray[1].equals("-"))
            arithmeticResult = firstNum - secondNum;
        else
            arithmeticResult = firstNum * secondNum;

        System.out.println(firstNum+" "+resultArray[1]+" "+secondNum+" = "+arithmeticResult);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

