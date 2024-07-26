package dev.kona.todo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseSetup {
    public static void setupDatabase() {
        try (Connection connection = ToDoApplication.connection()) {
            assert connection != null;
            try (Statement statement = connection.createStatement()) {
                String createTableSQL = "CREATE TABLE IF NOT EXISTS todo_items (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "description TEXT NOT NULL, " +
                        ")";
                statement.execute(createTableSQL);
            }
        } catch (SQLException e) {
            Logger.getAnonymousLogger().log(Level.SEVERE, LocalDateTime.now() + ": Could not create database schema", e);
        }
    }
}
