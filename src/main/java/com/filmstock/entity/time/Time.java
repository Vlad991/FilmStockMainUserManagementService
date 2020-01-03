package com.filmstock.entity.time;

import java.io.Serializable;

public class Time implements Serializable {
    private int hours;
    private int minutes;
    private int seconds;

    public Time() {
        this(0, 0, 0);
    }

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Time(String time) {
        String[] timeParse = time.split(":");
        this.hours = Integer.parseInt(timeParse[0]);
        this.minutes = Integer.parseInt(timeParse[1]);
        this.seconds = Integer.parseInt(timeParse[2]);
    }

    @Override
    public String toString() {
        String hours = Integer.toString(this.hours);
        String minutes = Integer.toString(this.minutes);
        String seconds = Integer.toString(this.seconds);

        if (this.hours < 10) {
            hours = "0" + hours;
        }
        if (this.minutes < 10) {
            minutes = "0" + minutes;
        }
        if (this.seconds < 10) {
            seconds = "0" + seconds;
        }

        return hours + ":" + minutes + ":" + seconds;
    }
}
