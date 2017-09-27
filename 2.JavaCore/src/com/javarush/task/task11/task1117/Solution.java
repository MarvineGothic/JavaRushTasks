package com.javarush.task.task11.task1117;

/* 
Альтернативная цепочка наследования
public class Solution {
    public static void main(String[] args) {
    }

    public class Carnivore {

    }

    public class Cow {

    }

    public class Dog {

    }

    public class Pig {

    }

    public class Animal {

    }
}
*/

public class Solution {                // solved
    public static void main(String[] args) {
    }

    public class Carnivore {

    }

    public class Cow extends Animal{

    }

    public class Dog extends Carnivore{

    }

    public class Pig extends Animal{

    }

    public class Animal {

    }
}
