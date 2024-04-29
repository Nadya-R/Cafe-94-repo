import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
    }

    private void populateStaffDetails() {
        staffVBox.getChildren().clear(); // Clear existing children

        // Get list of staff members
        List<Staff> staffList = Staff.getStaffList();

        // Iterate through the staff list and add details to the VBox
        for (Staff staffMember : staffList) {
            Label nameLabel = new Label("Name: " + staffMember.getFirstName() + " " + staffMember.getLastName());
            Label addressLabel = new Label("Address: " + staffMember.getAddress());
            Label postCodeLabel = new Label("Post Code: " + staffMember.getPostCode());

            // Add labels to the VBox
            staffVBox.getChildren().addAll(nameLabel, addressLabel, postCodeLabel);
        }
    }



    @FXML
    public void switchToMangerView(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ManagerScene.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

