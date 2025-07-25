package com.pomodoro.pomodoroapp.util;

import javafx.scene.Scene;

public class DialogUtil {
    public static void toggleTheme(Scene scene) {
        if (scene.getStylesheets().contains(DialogUtil.class.getResource("/com/pomodoro/pomodoroapp/dark-styles.css").toExternalForm())) {
            // Switch to light mode
            scene.getStylesheets().remove(DialogUtil.class.getResource("/com/pomodoro/pomodoroapp/dark-styles.css").toExternalForm());
            scene.getStylesheets().add(DialogUtil.class.getResource("/com/pomodoro/pomodoroapp/styles.css").toExternalForm());
        } else {
            // Switch to dark mode
            scene.getStylesheets().remove(DialogUtil.class.getResource("/com/pomodoro/pomodoroapp/styles.css").toExternalForm());
            scene.getStylesheets().add(DialogUtil.class.getResource("/com/pomodoro/pomodoroapp/dark-styles.css").toExternalForm());
        }
    }
}