package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код

        return null;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}
*/

public class Solution {
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        ArrayList<String>[] list = new ArrayList[3];
        list[0] = new ArrayList<>();
        list[0].add("aaa");
        list[0].add("ffff");
        list[1] = new ArrayList<>();
        list[1].add("aaa");
        list[1].add("adf");
        list[2] = new ArrayList<>();
        list[2].add("fff");
        list[2].add("asdf");
        //напишите тут ваш код

        return list;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}