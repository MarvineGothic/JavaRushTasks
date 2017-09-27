package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
    }
}
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private String name;
        private String surname;
        private int age;
        private String address;
        private String car;
        private int phone;

        public Human(String name)
        {
            this.name = name;
        }

        public Human(String name, String surname)
        {
            this.name = name;
            this.surname = surname;
        }

        public Human(String name, String surname, int age)
        {
            this.name = name;
            this.surname = surname;
            this.age = age;
        }

        public Human(String name, String surname, int age, String address)
        {
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.address = address;
        }

        public Human(String name, String surname, int age, String address, String car)
        {
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.address = address;
            this.car = car;
        }

        public Human(String name, String surname, int age, String address, String car, int phone)
        {
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.address = address;
            this.car = car;
            this.phone = phone;
        }

        public Human(String name, int age)
        {
            this.name = name;
            this.age = age;
        }

        public Human(String name, int age, String address)
        {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public Human(String name, int age, String address, String car)
        {
            this.name = name;
            this.age = age;
            this.address = address;
            this.car = car;
        }

        public Human(String name, int age, String address, String car, int phone)
        {
            this.name = name;
            this.age = age;
            this.address = address;
            this.car = car;
            this.phone = phone;
        }

    }
}
