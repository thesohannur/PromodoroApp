module com.pomodoro.pomodoroapp {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.pomodoro.pomodoroapp to javafx.fxml;
    opens com.pomodoro.pomodoroapp.controller to javafx.fxml;

    exports com.pomodoro.pomodoroapp;
    exports com.pomodoro.pomodoroapp.controller;
}