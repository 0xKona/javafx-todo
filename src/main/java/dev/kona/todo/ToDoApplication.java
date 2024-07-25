package dev.kona.todo;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ToDoApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        System.out.println("It hath begunneth!");
        FXMLLoader fxmlLoader = new FXMLLoader(ToDoApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 560);
        stage.setTitle("Test ToDo App! :)");
        stage.setScene(scene);
        stage.show();
        System.out.println("About to start the listener!");
    }

    public static void main(String[] args) {
        launch();
    }
}