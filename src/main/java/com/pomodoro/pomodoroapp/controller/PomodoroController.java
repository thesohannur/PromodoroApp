package com.pomodoro.pomodoroapp.controller;

import com.pomodoro.pomodoroapp.model.TimerSettings;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.util.Duration;

import java.io.IOException;

public class PomodoroController {
    @FXML private Label timerLabel;
    @FXML private Label cycleLabel;
    @FXML private Label statusLabel;
    @FXML private ProgressIndicator progressIndicator;
    @FXML private Button startButton;
    @FXML private Button pauseButton;
    @FXML private Button resetButton;
    @FXML private ToggleButton pomodoroBtn;
    @FXML private ToggleButton shortBreakBtn;
    @FXML private ToggleButton longBreakBtn;
    @FXML private VBox tasksContainer;
    @FXML private TextField taskInput;
    @FXML private Button settingsButton;

    private Timeline timeline;
    private int secondsRemaining;
    private int cyclesCompleted = 0;
    private boolean isRunning = false;
    private TimerSettings settings = new TimerSettings(25, 5, 20);

    @FXML
    public void initialize() {
        setupTimerButtons();
        resetTimer();
    }

    private void setupTimerButtons() {
        ToggleGroup timerGroup = new ToggleGroup();
        pomodoroBtn.setToggleGroup(timerGroup);
        shortBreakBtn.setToggleGroup(timerGroup);
        longBreakBtn.setToggleGroup(timerGroup);
        pomodoroBtn.setSelected(true);
    }

    @FXML
    private void handleSettings() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/pomodoro/pomodoroapp/settings-view.fxml"));
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setTitle("Timer Settings");
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.getDialogPane().setContent(loader.load());
            dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

            SettingsController controller = loader.getController();
            controller.setSettings(settings);

            final Button okButton = (Button) dialog.getDialogPane().lookupButton(ButtonType.OK);
            okButton.addEventFilter(ActionEvent.ACTION, event -> {
                settings = controller.getUpdatedSettings();
                resetTimer();
            });

            dialog.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleStart() {
        if (!isRunning) {
            startTimer();
            startButton.setDisable(true);
            pauseButton.setDisable(false);
            isRunning = true;
        }
    }

    @FXML
    private void handlePause() {
        if (isRunning) {
            timeline.stop();
            startButton.setDisable(false);
            pauseButton.setDisable(true);
            isRunning = false;
        }
    }

    @FXML
    private void handleReset() {
        timeline.stop();
        isRunning = false;
        resetTimer();
        startButton.setDisable(false);
        pauseButton.setDisable(true);
    }

    @FXML
    private void addTask() {
        if (!taskInput.getText().isEmpty()) {
            CheckBox task = new CheckBox(taskInput.getText());
            tasksContainer.getChildren().add(task);
            taskInput.clear();
        }
    }

    private void startTimer() {
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> updateTimer()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void updateTimer() {
        secondsRemaining--;
        updateDisplay();

        if (secondsRemaining <= 0) {
            timeline.stop();
            switchSession();
        }
    }

    private void switchSession() {
        if (pomodoroBtn.isSelected()) {
            cyclesCompleted++;
            if (cyclesCompleted % 4 == 0) {
                longBreakBtn.setSelected(true);
            } else {
                shortBreakBtn.setSelected(true);
            }
        } else {
            pomodoroBtn.setSelected(true);
        }
        resetTimer();
        if (isRunning) {
            startTimer();
        }
    }

    private void resetTimer() {
        if (pomodoroBtn.isSelected()) {
            secondsRemaining = settings.getWorkDuration() * 60;
            statusLabel.setText("Time to focus!");
        } else if (shortBreakBtn.isSelected()) {
            secondsRemaining = settings.getShortBreakDuration() * 60;
            statusLabel.setText("Time for a short break!");
        } else {
            secondsRemaining = settings.getLongBreakDuration() * 60;
            statusLabel.setText("Time for a long break!");
        }
        cycleLabel.setText("Cycle #" + (cyclesCompleted + 1));
        updateDisplay();
    }

    private void updateDisplay() {
        int minutes = secondsRemaining / 60;
        int seconds = secondsRemaining % 60;
        timerLabel.setText(String.format("%02d:%02d", minutes, seconds));

        double totalSeconds;
        if (pomodoroBtn.isSelected()) {
            totalSeconds = settings.getWorkDuration() * 60;
        } else if (shortBreakBtn.isSelected()) {
            totalSeconds = settings.getShortBreakDuration() * 60;
        } else {
            totalSeconds = settings.getLongBreakDuration() * 60;
        }

        progressIndicator.setProgress(1.0 - (secondsRemaining / totalSeconds));
    }
}