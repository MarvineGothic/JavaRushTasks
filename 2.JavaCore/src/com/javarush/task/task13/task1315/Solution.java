package com.javarush.task.task13.task1315;

/* 
Том, Джерри и Спайк


public class Solution {
    public static void main(String[] args) {

    }
    //может двигаться
    public interface Movable {
        void move();
    }

    //может быть съеден
    public interface Eatable {
        void eaten();
    }

    //может кого-нибудь съесть
    public interface Eat {
        void eat();
    }
}
*/

public class Solution {                            //  solved
    public interface Moveable //может двигаться
    {
        void move();
    }

    public interface Eatable  //может быть съеден
    {
        void eaten();
    }

    public interface Eat  //может кого-нибудь съесть
    {
        void eat();
    }
    public class Dog implements Moveable, Eat
    {

        @Override
        public void eat()
        {

        }

        @Override
        public void move()
        {

        }
    }
    public class Cat implements Eat, Moveable, Eatable
    {

        @Override
        public void eat()
        {

        }

        @Override
        public void eaten()
        {

        }

        @Override
        public void move()
        {

        }
    }
    public class Mouse implements Moveable, Eatable
    {

        @Override
        public void eaten()
        {

        }

        @Override
        public void move()
        {

        }
    }
}