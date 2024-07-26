package dev.kona.todo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ToDoApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        System.out.println("It hath begunneth!");
        FXMLLoader fxmlLoader = new FXMLLoader(ToDoApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 560);
        stage.setTitle("Test ToDo App! :)");
        stage.setMinHeight(500);
        stage.setMinWidth(440);
        stage.setScene(scene);
        stage.show();
        System.out.println("About to start the listener!");
    }

    private static void checkDrivers() {
        try {
            Class.forName("org.sqlite.JDBC");
            DriverManager.registerDriver(new org.sqlite.JDBC());
        } catch (ClassNotFoundException | SQLException classNotFoundException) {
            Logger.getAnonymousLogger().log(Level.SEVERE, LocalDateTime.now() + ": Could not start SQLite Drivers");
        }
    }

    private static final String location = "jdbc:sqlite:" + Objects.requireNonNull(ToDoApplication.class.getResource("database.db")).toExternalForm();

    public static Connection connection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(location);
        } catch (SQLException sqlException) {
            Logger.getAnonymousLogger().log(Level.SEVERE, LocalDateTime.now() + ": Could not connect to database, located at: " + location);
            return null;
        }
        return connection;
    }

    public static void main(String[] args) {
        checkDrivers();
        setupDatabase();
        launch();
    }

    private static void setupDatabase() {
        DatabaseSetup.setupDatabase();
    }
}
