package com.javarush.task.task29.task2909.human;

/**
 * Created by Admin on 10.06.2017.
 */
public class UniversityPerson extends Human{
    private University university;

    public UniversityPerson(String name, int age) {
        super(name, age);
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}
