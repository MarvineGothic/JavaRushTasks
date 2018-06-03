package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.IPQuery;
import com.javarush.task.task39.task3913.query.UserQuery;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LogParser implements IPQuery, UserQuery {

    private List<Log> logs = new ArrayList<>();

    public LogParser(Path logDir) {
        String event;
        String taskNumber = null;

        File[] logFiles = logDir.toFile().listFiles(pathname -> pathname.toString().endsWith(".log"));
        for (File file : Objects.requireNonNull(logFiles)) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String s;
                while ((s = reader.readLine()) != null) {
                    String[] parts = s.split("\t");
                    event = parts[3];
                    if (parts[3].contains("TASK")) {
                        String[] eventParts = parts[3].split(" ");
                        event = eventParts[0];
                        taskNumber = eventParts[1];
                    }
                    logs.add(new Log(parts[0], parts[1], parts[2], event, taskNumber, parts[4]));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return getIPsForUser(null, after, before);
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return getIP(user, null, null, after, before);
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return getIP(null, event, null, after, before);
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return getIP(null, null, status, after, before);
    }

    private Set<String> getIP(String user, Event event, Status status, Date after, Date before) {
        Set<String> uniqueIPs = new HashSet<>();
        for (Log log : logs)
            if ((user == null || log.getUser().equals(user)) &&
                    (event == null || log.getEvent().equals(event)) &&
                    (status == null || log.getStatus().equals(status)) &&
                    (after == null || log.getDate().compareTo(after) >= 0) &&
                    (before == null || log.getDate().compareTo(before) <= 0))
                uniqueIPs.add(log.getIp());
        return uniqueIPs;
    }

    @Override
    public Set<String> getAllUsers() {
        Set<String> users = new HashSet<>();
        for (Log log : logs)
            users.add(log.getUser());
        return users;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (Log log : logs)
            if ((after == null || log.getDate().compareTo(after) >= 0) &&
                    (before == null || log.getDate().compareTo(before) <= 0))
                users.add(log.getUser());
        return users.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        Set<String> events = new HashSet<>();
        for (Log log : logs)
            if ((log.getUser().equals(user)) && (after == null || log.getDate().compareTo(after) >= 0) &&
                    (before == null || log.getDate().compareTo(before) <= 0))
                events.add(log.getEvent().toString());
        return events.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (Log log : logs)
            if ((ip == null || log.getIp().equals(ip)) &&
                    (after == null || log.getDate().compareTo(after) >= 0) &&
                    (before == null || log.getDate().compareTo(before) <= 0))
                users.add(log.getUser());
        return users;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        return getUserByEvent(null, Status.OK, null, after, before);
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        return getUserByEvent(Event.DOWNLOAD_PLUGIN, Status.OK, null, after, before);
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        return getUserByEvent(Event.WRITE_MESSAGE, Status.OK, null, after, before);
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        return new HashSet<>(getUserByEvent(Event.SOLVE_TASK, null, null, after, before));
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        return getUserByEvent(Event.SOLVE_TASK, null, task, after, before);
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        return getUserByEvent(Event.DONE_TASK, null, null, after, before);
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        return getUserByEvent(Event.DONE_TASK, null, task, after, before);
    }

    private Set<String> getUserByEvent(Event event, Status status, Integer task, Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (Log log : logs)
            if (((event == null || log.getEvent().equals(event)) && (status == null || log.getStatus().equals(status))) &&
                    (task == null || log.getTaskNumber().equals(task)) &&
                    (after == null || log.getDate().compareTo(after) >= 0) &&
                    (before == null || log.getDate().compareTo(before) <= 0))
                users.add(log.getUser());
        return users;
    }
}

class Log {
    private DateFormat df = new SimpleDateFormat("d.M.y H:m:s");
    private String ip;
    private String user;
    private Date date;
    private Event event;
    private Integer taskNumber;
    private Status status;

    public Log(String ip, String user, String date, String event, String taskNumber, String status) {
        this.ip = ip;
        this.user = user;
        try {
            this.date = df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.event = Event.valueOf(event);
        if (taskNumber == null) this.taskNumber = null;
        else this.taskNumber = Integer.valueOf(taskNumber);
        this.status = Status.valueOf(status);
    }


    public DateFormat getDf() {
        return df;
    }

    public String getIp() {
        return ip;
    }

    public String getUser() {
        return user;
    }

    public Date getDate() {
        return date;
    }

    public Event getEvent() {
        return event;
    }

    public Integer getTaskNumber() {
        return taskNumber;
    }

    public Status getStatus() {
        return status;
    }

    public String toString() {
        return String.format("%s %s %s %s %s %s", ip, user, date, event, taskNumber == null ? "" : taskNumber.toString(), status);
    }
}