import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class StaffProfilesController {
    @FXML
    private VBox staffVBox;


    //initialize method automatically evoked by java FX
    @FXML
    public void initialize() {

        populateStaffDetails();

        //creating a container to position the back button
        HBox buttonContainer = new HBox();
        buttonContainer.setAlignment(Pos.BOTTOM_RIGHT);

        // Creating a button
        Button placeBackButton = new Button("Back");


        // Add an action event handler to the button
        placeBackButton.setOnAction(event -> {
            // Handle button click event here
            try {
                switchToMangerView();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        // Adding the button to the HBox
        buttonContainer.getChildren().add(placeBackButton);

        // Adding the HBox to the VBox
        staffVBox.getChildren().add(buttonContainer);
    }

    private void populateStaffDetails() {
        staffVBox.getChildren().clear(); // Clear existing children

        // Get list of staff members
        List<Staff> staffList = Staff.getStaffList();

        // Iterate through the staff list and add details to the VBox
        for (Staff staffMember : staffList) {
            Label nameLabel = new Label("\nName: " + staffMember.getFirstName() + " " + staffMember.getLastName());
            Label addressLabel = new Label("Address: " + staffMember.getAddress());
            Label postCodeLabel = new Label("Post Code: " + staffMember.getPostCode() + "\n");

            // Add labels to the VBox
            staffVBox.getChildren().addAll(nameLabel, addressLabel, postCodeLabel);
        }
    }


    @FXML
    public void switchToMangerView() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("ManagerScene.fxml"));
        Stage stage = (Stage) staffVBox.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
