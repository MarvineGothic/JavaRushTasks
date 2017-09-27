package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    public String name;
    public int age;
    private List<Student> students = new ArrayList();

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {

        for (Student student : students) {
            if (student.getAverageGrade() == averageGrade) {
                return student;
            }
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {

        int ind = 0;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() > students.get(ind).getAverageGrade())
                ind = i;
        }return students.size() == 0 ? null : students.get(ind);
    }

    public Student getStudentWithMinAverageGrade(){
        int ind = 0;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() < students.get(ind).getAverageGrade())
                ind = i;
        }return students.size() == 0 ? null : students.get(ind);

    }
    public void expel(Student student){
        students.remove(student);
    }
}