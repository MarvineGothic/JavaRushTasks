package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.IPQuery;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class LogParser implements IPQuery {
    private List<Log> logs = new ArrayList<>();
    private String IPADDRESS_PATTERN =
            "((?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))";
    private String NAME_PATTERN = "([\\w+\\s*]+)";
    private String DATE_PATTERN = "(?:0?[1-9]|[12][0-9]|3[01]).(?:0?[1-9]|1[012]).(?:(?:19|20)\\d\\d)";
    private String TIME_PATTERN = "(?:\\d\\d?):(?:\\d\\d?):(?:\\d\\d?)";
    private String EVENT_PATTERN = "(LOGIN|DOWNLOAD_PLUGIN|WRITE_MESSAGE|SOLVE_TASK|DONE_TASK)(?:\\s+([0-9][0-9])?)?";
    private String STATUS_PATTERN = "(OK|FAILED|ERROR)";
    private String LOG_PATTERN = IPADDRESS_PATTERN + "\\s+" + NAME_PATTERN + "\\s+(" + DATE_PATTERN + "\\s+"
            + TIME_PATTERN + ")\\s+" + EVENT_PATTERN + "\\s+" + STATUS_PATTERN;

    private Pattern pattern = Pattern.compile(LOG_PATTERN);
    private Matcher m;

    public LogParser(Path logDir) {
        try (Stream<Path> paths = Files.walk(Paths.get(String.valueOf(logDir)))) {
            paths
                    .filter(Files::isRegularFile)
                    .forEach(path -> createLog(path, logs));
        } catch (IOException e) {
            System.out.println("Error reading directory");
        }
    }

    public void createLog(Path path, List<Log> logs) {
        try (BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(path)))) {
            String s;
            while ((s = reader.readLine()) != null) {
                if ((m = pattern.matcher(s)).matches())
                    logs.add(new Log(m.group(1), m.group(2), m.group(3), m.group(4), m.group(5), m.group(6)));
            }
        } catch (IOException e) {
            e.printStackTrace();
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
}

class Log {
    private DateFormat df = new SimpleDateFormat("DD.MM.yyyy HH:mm:ss");
    private String ip;
    private String user;
    private Date date;
    private Event event;
    private Integer taskNr;
    private Status status;


    public Log(String ip, String user, String date, String event, String taskNr, String status) {
        this.ip = ip;
        this.user = user;
        try {
            this.date = df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.event = Event.valueOf(event);

        if (taskNr == null) this.taskNr = null;
        else this.taskNr = Integer.valueOf(taskNr);

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

    public Integer getTaskNr() {
        return taskNr;
    }

    public Status getStatus() {
        return status;
    }

    public String toString() {
        return String.format("%s %s %s %s %s %s", ip, user, date, event, taskNr == null ? "" : taskNr.toString(), status);
    }
}