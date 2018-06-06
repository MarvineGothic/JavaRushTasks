package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {

    private List<Log> logs = new ArrayList<>();

    public LogParser(Path logDir) {


        File[] logFiles = logDir.toFile().listFiles(pathname -> pathname.toString().endsWith(".log"));
        for (File file : Objects.requireNonNull(logFiles)) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String s;
                while ((s = reader.readLine()) != null) {
                    String event;
                    String taskNumber = null;
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
        Collections.sort(logs);
    }

    private String getMethodName(String string) {
        char[] s = string.replace(" ", "").toCharArray();
        s[3] = Character.toUpperCase(s[3]);
        return new String(s);
    }

    public List<Log> getLogs() {
        return logs;
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

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        return getDates(user, event, null, null, after, before);
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        return getDates(null, null, Status.FAILED, null, after, before);
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        return getDates(null, null, Status.ERROR, null, after, before);
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        Set<Date> logs = this.getDates(user, Event.LOGIN, null, null, after, before);
        return logs.isEmpty() ? null : Collections.min(logs);
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        Set<Date> solve = this.getDates(user, Event.SOLVE_TASK, null, task, after, before);
        return solve.isEmpty() ? null : Collections.min(solve);
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        Set<Date> done = this.getDates(user, Event.DONE_TASK, null, task, after, before);
        return done.isEmpty() ? null : Collections.min(done);
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        return getDates(user, Event.WRITE_MESSAGE, null, null, after, before);
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        return getDates(user, Event.DOWNLOAD_PLUGIN, null, null, after, before);
    }

    private Set<Date> getDates(String user, Event event, Status status, Integer task, Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (Log log : logs)
            if ((user == null || log.getUser().equals(user)) &&
                    (event == null || log.getEvent().equals(event)) &&
                    (status == null || log.getStatus().equals(status)) &&
                    (task == null || log.getTaskNumber().equals(task)) &&
                    (after == null || log.getDate().compareTo(after) >= 0) &&
                    (before == null || log.getDate().compareTo(before) <= 0))
                dates.add(log.getDate());
        return dates;
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return new HashSet<>(getEvents(null, null, null, null, null, after, before)).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        return new HashSet<>(getEvents(null, null, null, null, null, after, before));
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        return new HashSet<>(getEvents(ip, null, null, null, null, after, before));
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        return new HashSet<>(getEvents(null, user, null, null, null, after, before));
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        return new HashSet<>(getEvents(null, null, null, Status.FAILED, null, after, before));
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        return new HashSet<>(getEvents(null, null, null, Status.ERROR, null, after, before));
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        return getEvents(null, null, Event.SOLVE_TASK, null, task, after, before).size();
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        return getEvents(null, null, Event.DONE_TASK, null, task, after, before).size();
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> solved = new HashMap<>();

        for (Integer task : getTasks(Event.SOLVE_TASK, after, before))
            solved.put(task, getEvents(null, null, Event.SOLVE_TASK, null, task, after, before).size());
        return solved;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> done = new HashMap<>();
        for (Integer task : getTasks(Event.DONE_TASK, after, before))
            done.put(task, getEvents(null, null, Event.DONE_TASK, null, task, after, before).size());
        return done;
    }

    private List<Event> getEvents(String ip, String user, Event event, Status status, Integer task, Date after, Date before) {
        List<Event> events = new ArrayList<>();
        for (Log log : logs)
            if ((ip == null || log.getIp().equals(ip)) &&
                    (user == null || log.getUser().equals(user)) &&
                    (event == null || log.getEvent().equals(event)) &&
                    (status == null || log.getStatus().equals(status)) &&
                    (task == null || task.equals(log.getTaskNumber())) &&
                    (after == null || log.getDate().compareTo(after) >= 0) &&
                    (before == null || log.getDate().compareTo(before) <= 0))
                events.add(log.getEvent());
        return events;
    }

    private Set<Integer> getTasks(Event event, Date after, Date before) {
        Set<Integer> tasks = new HashSet<>();
        for (Log log : logs)
            if ((event == null || log.getEvent().equals(event)) &&
                    (after == null || log.getDate().compareTo(after) >= 0) &&
                    (before == null || log.getDate().compareTo(before) <= 0) &&
                    log.getTaskNumber() != null)
                tasks.add(log.getTaskNumber());
        return tasks;
    }

    @Override
    public Set<Object> execute(String query) {
        String simpleQuery = "(get\\s+[a-z]+)";
        String fullQuery = simpleQuery + "\\s+for\\s+([a-z]+)\\s+=\\s+\"(.+)\"";
        String extendedQuery = fullQuery + "\\s+and\\s+date\\s+between\\s+\"(.+)\"\\s+and\\s+\"(.+)\"";

        Pattern pattern = Pattern.compile(extendedQuery);
        Matcher m = pattern.matcher(query);

        // check extended query
        if (m.matches())
            return getObjects(getMethodName(m.group(1)), m.group(2), m.group(3), m.group(4), m.group(5));
        // check full query
        pattern = Pattern.compile(fullQuery);
        m = pattern.matcher(query);
        if (m.matches())
            return getObjects(getMethodName(m.group(1)), m.group(2), m.group(3), null, null);
        else {
            // simple query
            pattern = Pattern.compile(simpleQuery);
            m = pattern.matcher(query);
            if (m.matches())
                return getObjects(getMethodName(query), "", null, null, null);
        }
        return new HashSet<>();
    }

    private Set<Object> getObjects(String method, String parameter, String value, String after, String before) {
        String ip = null;
        String user = null;
        String event = null;
        String status = null;
        String date = null;

        if (!parameter.isEmpty())
            switch (parameter) {
                case "ip":
                    ip = value;
                    break;
                case "user":
                    user = value;
                    break;
                case "event":
                    event = value;
                    break;
                case "status":
                    status = value;
                    break;
                case "date":
                    date = value;
                    break;
                default:
                    System.out.println("Wrong parameter");
                    break;
            }

        Set<Object> objects = new HashSet<>();
        try {
            Method m = Log.class.getMethod(method);
            for (Log log : logs)
                if ((ip == null || log.getIp().equals(ip)) &&
                        (user == null || log.getUser().equals(user)) &&
                        (event == null || log.getEvent().equals(Event.valueOf(event))) &&
                        (status == null || log.getStatus().equals(Status.valueOf(status))) &&
                        (date == null || log.getDate().compareTo(log.getDf().parse(date)) == 0) &&
                        (after == null || log.getDate().compareTo(log.getDf().parse(after)) > 0) &&
                        (before == null || log.getDate().compareTo(log.getDf().parse(before)) < 0))
                    objects.add(m.invoke(log));

        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | ParseException e) {
            System.out.println("No such method " + method);
        }
        return objects;
    }
}

class Log implements Comparable<Log> {
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

    @Override
    public int compareTo(Log o) {
        return this.date.compareTo(o.getDate());
    }
}