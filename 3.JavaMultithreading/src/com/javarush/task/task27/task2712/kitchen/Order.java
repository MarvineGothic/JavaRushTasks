package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by Admin on 04.07.2017.
 */
public class Order {

    private List<Dish> dishes;
    private final Tablet tablet;
    private boolean empty;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public List<Dish> getDishes() {
        return dishes;
    }


    @Override
    public String toString() {
        if (dishes == null || dishes.isEmpty())
            return "";
        else return "Your order: " + dishes.toString() + " of " + tablet;
    }


    public int getTotalCookingTime() {
        int time = 0;
        for (Dish dish : dishes) {
            time += dish.getDuration();
        }
        return time;
    }

    public boolean isEmpty() {
        return dishes == null || dishes.isEmpty();
    }
}
