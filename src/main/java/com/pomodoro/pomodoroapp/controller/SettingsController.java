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
        // Configure spinners to be editable with proper ranges
        workSpinner.setEditable(true);
        shortBreakSpinner.setEditable(true);
        longBreakSpinner.setEditable(true);

        workSpinner.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 120, 25));
        shortBreakSpinner.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 60, 5));
        longBreakSpinner.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(5, 120, 20));
    }

    public void setSettings(TimerSettings settings) {
        this.settings = settings;
        if (settings != null) {
            workSpinner.getValueFactory().setValue(settings.getWorkDuration());
            shortBreakSpinner.getValueFactory().setValue(settings.getShortBreakDuration());
            longBreakSpinner.getValueFactory().setValue(settings.getLongBreakDuration());
        }
    }

    public TimerSettings getUpdatedSettings() {
        if (settings == null) {
            settings = new TimerSettings(
                    workSpinner.getValue(),
                    shortBreakSpinner.getValue(),
                    longBreakSpinner.getValue()
            );
        } else {
            settings.setWorkDuration(workSpinner.getValue());
            settings.setShortBreakDuration(shortBreakSpinner.getValue());
            settings.setLongBreakDuration(longBreakSpinner.getValue());
        }
        return settings;
    }
}