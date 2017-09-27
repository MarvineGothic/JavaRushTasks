package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.*;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод
        String fileName;
        Scanner sc = new Scanner(System.in);
        fileName = sc.nextLine();
        sc.close();

        try {
            FileInputStream fIS= new FileInputStream(fileName);
            this.load(fIS);
            fIS.close();
        } catch (IOException e ) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties tmp_properties = new Properties();
        for (Map.Entry<String, String> stringStringEntry : properties.entrySet()) {
            tmp_properties.put(stringStringEntry.getKey(), stringStringEntry.getValue());
        }
        tmp_properties.save(outputStream, null);
        outputStream.flush();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties tmp_properties = new Properties();
        tmp_properties.load(inputStream);
        for (Map.Entry<Object, Object> objectObjectEntry : tmp_properties.entrySet()) {
            properties.put((String)objectObjectEntry.getKey(), (String)objectObjectEntry.getValue());
        }
    }

    public static void main(String[] args) {

    }
}
