import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * CreateStaffController class provides functionality to the FXML file named
 * CreateStaffScene
 * It handles user input, creates the type of staff determined by user Input,
 * and navigates to mangerScene
 * 
 * <p>
 * This controller is responsible for setting the staff role label on the Staff
 * creation form, handling the action
 * that takes place when the Create button is clicked (create Chef/Waiter), and
 * navigates back to the ManagerScene.
 * </p>
 * 
 * @author Nadya Roderick
 * @version 1.0
 */

public class CreateStaffController {
    // local fields

    private Scene scene;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField postCodeField;
    @FXML
    private Label staffRoleLabel;

    /**
     * Sets the staff Role label on the CreateStaffScene
     * 
     * @param role This is the staff role that the user wishes to create.
     */
    public void setStaffRole(String role) {
        String labelText = "Staff Role: " + role;
        staffRoleLabel.setText(labelText);
    }

    /**
     * Handles the back button action to navigate to the manager view.
     * 
     * @param actionEvent the event triggered by the back button
     * @throws IOException if an I/O error occurs during navigation
     */
    @FXML
    public void switchToMangerView(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ManagerScene.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * provides navigation to the create button. Once pressed User is taken to the
     * ManagerScene.
     */
    @FXML
    public void switchToMangerView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ManagerScene.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) staffRoleLabel.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Handles which type of staff is created once the create button is pushed, and
     * exits to the
     * ManagerScene.
     * 
     * @param firstName determined by firstNameField
     * @param lastName  determined by lastNameField
     * @param address   determined by addressField
     * @param postCode  determined by postCodeField
     */

    @FXML
    public void handleCreateButton() {
        try {

            String role = staffRoleLabel.getText();
            if (role != null) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String address = addressField.getText();
                String postCode = postCodeField.getText();
                // create a new waiter if staff role is equal to waiter
                if (role.equals("Staff Role: Waiter")) {
                    Manager.getInstance().createWaiter(firstName, lastName, address, postCode);
                    System.out.println("Created Waiter");
                    Staff.showStaffList();
                    // creates a chef if staff role is equal to chef
                } else if (role.equals("Staff Role: Chef")) {
                    Manager.getInstance().createChef(firstName, lastName, address, postCode);
                    System.out.println("Created chef");
                    Staff.showStaffList();
                }
            } else {
                // fault checking
                System.out.println("Role is null");

            }
            // navigates to managerScene
            switchToMangerView();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
