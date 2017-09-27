package com.javarush.task.task19.task1915;

/* 
Дублируем текст

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
*/

import java.io.*;

public class Solution {                    // solved
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();

        FileOutputStream fileOutputStream = new FileOutputStream(rd.readLine());
        String str = outputStream.toString();

        fileOutputStream.write(str.getBytes());

        System.setOut(consoleStream);

        System.out.println(str);
        rd.close();
        fileOutputStream.close();

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

