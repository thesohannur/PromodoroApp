package com.pomodoro.pomodoroapp.util;

import javafx.scene.Scene;

public class DialogUtil {
    private static final String LIGHT_STYLE = "/com/pomodoro/pomodoroapp/styles.css";
    private static final String DARK_STYLE = "/com/pomodoro/pomodoroapp/darkstyles.css";

    public static void toggleTheme(Scene scene) {
        if (scene == null) return;

        if (isDarkMode(scene)) {
            setLightMode(scene);
        } else {
            setDarkMode(scene);
        }
    }

    public static boolean isDarkMode(Scene scene) {
        if (scene == null) return false;
        return scene.getStylesheets().contains(DialogUtil.class.getResource(DARK_STYLE).toExternalForm());
    }

    public static void setDarkMode(Scene scene) {
        if (scene == null) return;
        scene.getStylesheets().remove(DialogUtil.class.getResource(LIGHT_STYLE).toExternalForm());
        scene.getStylesheets().add(DialogUtil.class.getResource(DARK_STYLE).toExternalForm());
    }

    public static void setLightMode(Scene scene) {
        if (scene == null) return;
        scene.getStylesheets().remove(DialogUtil.class.getResource(DARK_STYLE).toExternalForm());
        scene.getStylesheets().add(DialogUtil.class.getResource(LIGHT_STYLE).toExternalForm());
    }
}