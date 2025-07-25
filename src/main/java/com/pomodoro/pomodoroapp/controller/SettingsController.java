package com.pomodoro.pomodoroapp.controller;

import com.pomodoro.pomodoroapp.model.TimerSettings;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

public class SettingsController {
    @FXML private Spinner<Integer> workSpinner;
    @FXML private Spinner<Integer> shortBreakSpinner;
    @FXML private Spinner<Integer> longBreakSpinner;

    private TimerSettings settings;

    @FXML
    public void initialize() {
        workSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 60, 25));
        shortBreakSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 30, 5));
        longBreakSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(5, 60, 20));
    }

    public void setSettings(TimerSettings settings) {
        this.settings = settings;
        workSpinner.getValueFactory().setValue(settings.getWorkDuration());
        shortBreakSpinner.getValueFactory().setValue(settings.getShortBreakDuration());
        longBreakSpinner.getValueFactory().setValue(settings.getLongBreakDuration());
    }

    public TimerSettings getUpdatedSettings() {
        settings.setWorkDuration(workSpinner.getValue());
        settings.setShortBreakDuration(shortBreakSpinner.getValue());
        settings.setLongBreakDuration(longBreakSpinner.getValue());
        return settings;
    }
}