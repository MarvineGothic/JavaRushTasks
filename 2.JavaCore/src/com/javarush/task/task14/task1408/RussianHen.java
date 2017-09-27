package com.javarush.task.task14.task1408;

import static com.javarush.task.task14.task1408.Solution.*;

/**
 * Created by Admin on 13.02.2017.
 */
public class RussianHen extends Hen {
@Override
     public int getCountOfEggsPerMonth() {
        return 10;
    }
    @Override
   public String getDescription(){
        return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
