package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 04.07.2017.
 */
public class ConsoleHelper extends IOException{
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public ConsoleHelper() {
    }

    public static void writeMessage(String message) {                     // — для вывода message в консоль
        System.out.println(message);
    }

    public static String readString() throws IOException {                            // — для чтения строки с консоли
        return reader.readLine();
    }


    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> dishes = new ArrayList<>();
        String str;
        writeMessage("Enter dish...(" + Dish.allDishesToString() + ")");
        while (true) {
            str = readString();
            if ("exit".equals(str)) {
                break;
            }

            try {
                dishes.add(Dish.valueOf(str));
            }
            catch (IllegalArgumentException e) {
                ConsoleHelper.writeMessage(str + " is not detected");
            }
        }
        return dishes;
    }

}
