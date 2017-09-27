package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Парсер реквестов
public class Solution {
    public static void main(String[] args) {
        //add your code here
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}

*/

public class Solution {          // solved
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        int index = url.indexOf("?") + 1;
        String sub = url.substring(index);
        List<String> list = new ArrayList<String>();
        List<String> alertList = new ArrayList<>();
        String[] strings = sub.split("&");
        for (String s : strings) {
            if (s.contains("=")) {
                String[] splitS = s.split("=");
                String potentialAlert = splitS[0];
                list.add(potentialAlert);
                if (potentialAlert.equals("obj")) alertList.add(splitS[1]);
            } else list.add(s);
        }
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println("");
        for (String s : alertList) {
            try {
                alert(Double.parseDouble(s));
            } catch (Exception e) {
                alert(s);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
