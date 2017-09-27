package com.javarush.task.task13.task1313;

import java.awt.*;

/* 
Лисица — это такое животное


public class Solution {
    public static void main(String[] args) throws Exception {
    }

    public interface Animal {
        Color getColor();
    }

    public static class Fox {
        public String getName() {
            return "Fox";
        }
    }
}
*/

/* Интерфейс Animal
1. Унаследовать Fox от интерфейса Animal.
2. Поменяй код так, чтобы в классе Fox был только один метод - getName.
3. Создавать дополнительные классы и удалять методы нельзя!
*/

public class Solution                        //  solved
{
    public static void main(String[] args) throws Exception
    {
    }

    public interface Animal
    {
        Color getColor();
    }

    public static abstract class Fox implements Animal
    {
        public String getName()
        {
            return "Fox";
        }

    }
}