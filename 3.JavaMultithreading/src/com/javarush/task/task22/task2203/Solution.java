package com.javarush.task.task22.task2203;

/* 
Между табуляциями

public class Solution {
    public static String getPartOfString(String string) {
        return null;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null || string.isEmpty()) throw new TooShortStringException();
        int firstTabIndex = string.indexOf('\t') + 1;
        char[] chars = string.toCharArray();
        int countTabs = 0;
        int lastTabIndex = 0; //
        for (int i = 0; i < string.length(); i++)
        {
            if (chars[i] == '\t')
            {
                countTabs++;
                if (countTabs == 2)
                {
                    lastTabIndex = i;
                } else if (countTabs == 3)
                {

                    break;
                }
            }
        }
        if (countTabs < 2)
        {
            throw new TooShortStringException();
        }
        return string.substring(firstTabIndex, lastTabIndex);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
