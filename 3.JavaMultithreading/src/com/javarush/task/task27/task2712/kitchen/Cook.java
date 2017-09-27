package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Admin on 04.07.2017.
 */
public class Cook extends Observable implements Observer {
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(Observable observable, Object arg) {
        Order order = (Order) arg;
        Tablet tablet = (Tablet) observable;
        StatisticManager.getInstance().register(new CookedOrderEventDataRow(tablet.toString(), name, order.getTotalCookingTime()*60, order.getDishes()));

        ConsoleHelper.writeMessage(String.format("Start cooking - %s",
                arg + "of Tablet{number=" + tablet.getNumber() + "}, cooking time " + order.getTotalCookingTime() + "min"));

        setChanged();
        notifyObservers(arg);
    }

}
