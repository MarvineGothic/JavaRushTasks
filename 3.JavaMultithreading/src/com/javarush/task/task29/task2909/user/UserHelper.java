package com.javarush.task.task29.task2909.user;

import java.util.concurrent.atomic.AtomicInteger;

public class UserHelper {
    private User userAnya = new User("Аня", "Смирнова", 10);
    private User userRoma = new User("Рома", "Виноградов", 30);
    private User userUra = new User("Юра", "Карп", 28);


    public void printUsers() {
        userAnya.printInfo();
        userAnya.printAdditionalInfo();
        userRoma.printInfo();
        userRoma.printAdditionalInfo();
    }


    public int calculateAverageAge() {

        return (userAnya.getAge() + userRoma.getAge() + userUra.getAge()) / 3;
    }

    public int calculateRate(AtomicInteger base, int age, boolean hasWork, boolean hasHouse) {
        int result = base.intValue();
        result += age / 100;
        result *= hasWork ? 1.1 : 0.9;
        result *= hasHouse ? 1.1 : 0.9;
        return result;
    }

    public String getBossName(User user) {
        Work work = user.getWork();
        return user.getBoss();
    }
}