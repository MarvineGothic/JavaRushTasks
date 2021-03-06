package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.model.Strategy;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.ArrayList;
import java.util.List;

public class Aggregator {
    public static void main(String[] args) {
        Provider provider = new Provider(new Strategy() {
            @Override
            public List<Vacancy> getVacancies(String searchString) {
                return new ArrayList<>();
            }

            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        Controller controller = new Controller(provider);
        controller.scan();
    }
}
