package dev.kona.todo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ToDoController {
    @FXML
    private Label taskTitleLabel;

    @FXML
    public TextField taskTitle;

    @FXML
    protected void setTaskTitle() {
//        taskTitleLabel.setText(String.format("Added: %s", taskTitle.getText()));
        listView.getItems().add(taskTitle.getText());
        taskTitle.setText("");
    }

    @FXML
    final static ObservableList<String> tasks = FXCollections.observableArrayList();

    public ListView<String> listView = new ListView<>(tasks);

    @FXML
    protected void removeTask() {
        System.out.println("Removing task " + taskTitle.getText());
        listView.getItems().remove(taskTitle.getText());
    }

    final Label selectedItem = new Label();





}