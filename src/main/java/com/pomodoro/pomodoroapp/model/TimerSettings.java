package com.pomodoro.pomodoroapp.model;

public class TimerSettings {
    private int workDuration;
    private int shortBreakDuration;
    private int longBreakDuration;

    public TimerSettings(int work, int shortBreak, int longBreak) {
        this.workDuration = work;
        this.shortBreakDuration = shortBreak;
        this.longBreakDuration = longBreak;
    }

    public int getWorkDuration() { return workDuration; }
    public int getShortBreakDuration() { return shortBreakDuration; }
    public int getLongBreakDuration() { return longBreakDuration; }

    public void setWorkDuration(int minutes) {
        if (minutes > 0) workDuration = minutes;
    }

    public void setShortBreakDuration(int minutes) {
        if (minutes > 0) shortBreakDuration = minutes;
    }

    public void setLongBreakDuration(int minutes) {
        if (minutes > 0) longBreakDuration = minutes;
    }
}