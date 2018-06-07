package com.javarush.task.task38.task3804;

/* 
Фабрика исключений
*/

import static com.javarush.task.task38.task3804.ExceptionDBMessage.RESULT_HAS_NOT_GOTTEN_BECAUSE_OF_TIMEOUT;

public class Solution {        // solved
    public static Class getFactoryClass() {
        return ExceptionFactory.class;
    }

    public static void main(String[] args) {
        ExceptionFactory.getException(RESULT_HAS_NOT_GOTTEN_BECAUSE_OF_TIMEOUT);
    }
}

class ExceptionFactory {
    static Throwable getException(Enum e) {
        if (e==null)return new IllegalArgumentException();
        String message = e.name().charAt(0) + e.name().substring(1).replace("_", " ").toLowerCase();
        if (e.getClass().equals(ExceptionApplicationMessage.class))
            return new Exception(message);
        if (e.getClass().equals(ExceptionDBMessage.class)) return new RuntimeException(message);
        if (e.getClass().equals(ExceptionUserMessage.class)) return new Error(message);
        return new IllegalArgumentException();
    }
}