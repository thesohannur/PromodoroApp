# Pomodoro Timer Application

A desktop Pomodoro Timer application built with JavaFX, designed to help users manage their time effectively using the Pomodoro Technique.

## Features

* **Pomodoro Timer**: Set dedicated time for focused work sessions (default 25 minutes).
* **Short and Long Breaks**: Configurable short (default 5 minutes) and long (default 20 minutes) break intervals.
* **Session Switching**: Automatically switches between Pomodoro, short break, and long break sessions. A long break is automatically triggered after every 4 Pomodoro cycles.
* **Timer Controls**: Start, Pause, and Reset functionality for the timer.
* **Progress Indicator**: A visual ring to show the progress of the current session.
* **Task List**: Add and manage tasks directly within the application. Checkboxes allow users to mark tasks as complete.
* **Customizable Settings**: Adjust the duration of Pomodoro, short break, and long break sessions via a dedicated settings dialog.
* **Intuitive UI**: A clean and user-friendly interface designed with JavaFX and styled using CSS.

## Technologies Used

* **Java 17+**: The core programming language.
* **JavaFX**: For building the graphical user interface.
* **FXML**: Declarative UI definition for JavaFX.
* **CSS**: For styling the application's appearance (including a base light theme and a dark theme).
* **Maven**: Project management and build automation tool.

## Getting Started

To run this application, you will need Java 17 (or newer) and Maven installed.

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/thesohannur/PromodoroApp.git](https://github.com/thesohannur/PromodoroApp.git)
    cd PromodoroApp
    ```
2.  **Build and run using Maven:**
    ```bash
    mvn clean javafx:run
    ```

This will compile the project and launch the Pomodoro Timer application.

## Usage

* **Start/Pause/Reset**: Use the respective buttons to control the timer.
* **Switch Sessions**: Click on "Pomodoro", "Short Break", or "Long Break" toggle buttons to manually switch between session types. The application also automatically switches after a session ends.
* **Add Tasks**: Type your task into the input field and click "Add" to add it to your task list.
* **Settings**: Click the "Settings" button to open a dialog where you can customize the duration of each session type.
* **Theme Toggle (Future Feature)**: A button to switch between light and dark themes will be implemented for improved user experience.

## Contributing

Feel free to fork the repository, make improvements, and submit pull requests.

## License

This project is open-source and available under the [MIT License](LICENSE).
