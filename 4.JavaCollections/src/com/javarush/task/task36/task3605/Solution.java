package com.javarush.task.task36.task3605;

import java.io.*;
import java.util.*;

/* 
Использование TreeSet
*/
public class Solution {          // solved
    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        //читаем строку
        String text = reader(file);

        //операции по удалению лишнего
        //text = textCutter(text);

        //добавляем посимвольно в arraylist
        List<String> stringList = Arrays.asList(text.toLowerCase().split(""));
        //создаем set
        TreeSet<String> treeSet = new TreeSet<>();

        //добавляем символы в set
        for (int i = 0; i < stringList.size(); i++) {
            String s = stringList.get(i);
            if((s.matches("\\w")) && (s.matches("[^0-9]")))
                treeSet.add(stringList.get(i));
        }

        //выводим
        Iterator iterator = treeSet.iterator();
        if (treeSet.size() >= 5) {

            int count = 0;
            while (iterator.hasNext() && count < 5) {
                System.out.print(iterator.next());
                count ++;
            }

        } else {
            while (iterator.hasNext()) {
                System.out.print(iterator.next());
            }
        }
    }
    public static String reader(File file) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        StringBuilder res = new StringBuilder();
        int b = raf.read();
        while(b != -1){
            res.append((char) b);
            b = raf.read();
        }
        raf.close();
        return res.toString();
    }
}
