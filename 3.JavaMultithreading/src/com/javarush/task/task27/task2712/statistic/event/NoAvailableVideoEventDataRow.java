package com.javarush.task.task27.task2712.statistic.event;

import java.util.Date;

/**
 * Created by Admin on 06.07.2017.
 */
public class NoAvailableVideoEventDataRow implements EventDataRow{
    public int totalDuration;
    public Date currentDate;

    public NoAvailableVideoEventDataRow(int totalDuration) {
        this.totalDuration = totalDuration;
        this.currentDate = new Date();
    }

    @Override
    public EventType getType() {
        return EventType.NO_AVAILABLE_VIDEO;
    }
}
