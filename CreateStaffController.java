import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateStaffController {
    //local fields

    private Scene scene;

    @FXML
    private TextField staffRoleField;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField postCodeField;
    @FXML
    private Button createButton;
    @FXML
    private Label staffRoleLabel;

    //passes staff role to the staff creation form
    public void setStaffRole(String role) {
        String labelText = "Staff Role: " + role;
        staffRoleLabel.setText(labelText);
    }

    //method to control back button
    @FXML
    public void switchToMangerView(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ManagerScene.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void handleCreateButton() {
        String role = staffRoleLabel.getText();
        if (role != null) {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String address = addressField.getText();
            String postCode = postCodeField.getText();
//create a new waiter if staff role is equal to waiter
            if (role.equals("Staff Role: Waiter")) {
                Manager.getInstance().createWaiter(firstName, lastName, address, postCode);
                System.out.println("Created Waiter");
                Staff.showStaffList();
                //creates a chef if staff role is equal to chef
            } else if (role.equals("Staff Role: Chef")) {
                Manager.getInstance().createChef(firstName, lastName, address, postCode);
                System.out.println("Created chef");
                Staff.showStaffList();
            }
        } else {
            //fault checking
            System.out.println("Role is null");


        }
    }

}
