package com.javarush.task.task14.task1408;

/**
 * Created by Admin on 13.02.2017.
 */
public class UkrainianHen extends Hen {
    @Override
   public int getCountOfEggsPerMonth() {
        return 8;
    }
    @Override
   public String getDescription(){
        return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";    }
}
