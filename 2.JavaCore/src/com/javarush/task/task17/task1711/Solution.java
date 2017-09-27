package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
    }
}
*/

public class Solution {               // solved
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        int n = args.length;
        if (n < 2) {
            return;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/y", Locale.ENGLISH);
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-y", Locale.ENGLISH);
        if (args[0].equals("-c")) {
            for (int i = 1; i < n; i += 3) {
                String name = args[i];
                try {
                    Date bd = sdf.parse(args[i + 2]);
                    if (args[i + 1].equals("м")) {
                        allPeople.add(Person.createMale(name, bd));
                        System.out.println(allPeople.size() - 1);
                    }else if (args[i + 1].equals("ж")) {
                        allPeople.add(Person.createFemale(name, bd));
                        System.out.println(allPeople.size() - 1);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        } else if (args[0].equals("-u")) {
            for (int i = 1; i < n; i += 4) {
                try {
                    int id = Integer.parseInt(args[i]);
                    if (id > allPeople.size()-1) {
                        break;
                    }
                    String name = args[i + 1];
                    Date bd = sdf.parse(args[i + 3]);
                    if (args[i + 2].equals("м")) {
                        Person p = Person.createMale(name, bd);
                        allPeople.set(id, p);
                    }else if (args[i + 2].equals("ж")) {
                        Person p = Person.createFemale(name, bd);
                        allPeople.set(id, p);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } else if (args[0].equals("-d")) {
            for (int i = 1; i < n; i ++) {
                try {
                    int id = Integer.parseInt(args[i]);
                    if (id > allPeople.size() - 1) {
                        break;
                    }
                    allPeople.get(id).setBirthDay(null);
                    allPeople.get(id).setName("");
                    allPeople.get(id).setSex(null);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }else if (args[0].equals("-i")) {
            for (int i = 1; i < n; i++) {
                try {
                    int id = Integer.parseInt(args[i]);
                    if (id > allPeople.size() - 1) {
                        break;
                    }
                    Person p = allPeople.get(id);
                    String sex;
                    if (p.getSex() == Sex.FEMALE) {
                        sex = "ж";
                    }else sex = "м";
                    System.out.println(p.getName() + " " + sex + " " + sdf1.format(p.getBirthDay()));
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
//        for (Person p : allPeople) {
//            System.out.println(p.getName() + " " + p.getSex() + " " + sdf1.format(p.getBirthDay()));
//        }
    }
}
