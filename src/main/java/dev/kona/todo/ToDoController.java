package dev.kona.todo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;

public class ToDoController {
    @FXML
    private Label taskTitleLabel;

    @FXML
    public TextField taskTitle;

    @FXML
    protected void setTaskTitle() {
        listView.getItems().add(taskTitle.getText());
        taskTitle.setText("");
    }

    @FXML
    final static ObservableList<String> tasks = FXCollections.observableArrayList();

    public ListView<String> listView = new ListView<>(tasks);

    @FXML
    public String selectedTask;
    public void setSelectedTask(String selectedTask) {
        this.selectedTask = selectedTask;
    }

    @FXML
    protected void selectTask(MouseEvent event) {
        System.out.println("Selected task " + listView.getSelectionModel().getSelectedItem());
        setSelectedTask(listView.getSelectionModel().getSelectedItem());
    }

    @FXML
    protected void deleteTask() {
        listView.getItems().remove(selectedTask);
    }



    final Label selectedItem = new Label();





}