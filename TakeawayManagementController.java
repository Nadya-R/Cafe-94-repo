package com.example.cafeo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class TakeawayManagementController {

    @FXML
    private ListView<String> takeawayListView;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField priceTextField;

    @FXML
    public void addTakeawayItem(ActionEvent event) {
        String name = nameTextField.getText().trim();
        String price = priceTextField.getText().trim();

        if (!name.isEmpty() && !price.isEmpty()) {
            takeawayListView.getItems().add(name + " - £" + price);
            clearFields();
        } else {
            showAlert("Please enter name and price.");
        }
    }

    @FXML
    public void editTakeawayItem(ActionEvent event) {
        System.out.println("Edit your takeaway?");
    }

    @FXML
    public void deleteTakeawayItem(ActionEvent event) {
        System.out.println("Deleted your takeaway");
    }

    private void clearFields() {
        nameTextField.clear();
        priceTextField.clear();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
