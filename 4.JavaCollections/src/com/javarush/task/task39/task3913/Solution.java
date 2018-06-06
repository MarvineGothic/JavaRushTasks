package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.util.Date;

public class Solution {        // solved
    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get("c:/logs/"));
        System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));
        System.out.println(logParser.getNumberOfUserEvents("Eduard Petrovich Morozko", null, null));
        System.out.println(logParser.getLoggedUsers(null, null));
        System.out.println(logParser.getSolvedTaskUsers(null, null));

        System.out.println(logParser.getDateWhenUserLoggedFirstTime("Amgo", null, null));
        System.out.println(logParser.getAllSolvedTasksAndTheirNumber(null, null));
        /*for (Log log : logParser.getLogs())
            System.out.println(log);*/
        System.out.println(logParser.execute("get user"));
        System.out.println(logParser.execute("get event for date = \"30.01.2014 12:56:22\""));
        System.out.println(logParser.execute("get ip for event = \"WRITE_MESSAGE\" and date between \"11.12.2013 0:00:00\" and \"15.11.2015 23:59:59\""));
    }
}