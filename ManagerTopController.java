import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Optional;

/**
 * The MangerTopController is the controller for the top portion of the
 * splitpane Manger profile display.
 * It provides navigational controls for the back, create staff and Staff
 * profiles buttons
 * 
 * @author Nadya Roderick
 * @version 1.0
 */
public class ManagerTopController {

    // local fields
    private Scene scene;

    /**
     * switchToWelcomeView controls the back button
     * 
     * @param actionEvent action taken when button is pushed
     * @throws IOException is an error that occures if Welcome.fmxl fails to load
     */
    @FXML
    public void switchToWelcomeView(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * handleAddStaff is a method that determines what happens when the add staff
     * button is clicked
     * by generating an alert prompting the manager to create either a waiter or
     * cheff member of staff by
     * clicking the relevent button.
     * 
     * @param actionEvent takes manager to staff creation form.
     */
    @FXML
    public void handleAddStaff(javafx.event.ActionEvent actionEvent) {

        // Alert created
        Alert whichStaff = new Alert(Alert.AlertType.CONFIRMATION);
        whichStaff.setTitle("Add staff");
        whichStaff.setHeaderText("Select Staff Type");
        whichStaff.setContentText("Choose the type of staff you want to add:");

        // create buttons for user to select
        ButtonType waiterButton = new ButtonType("Waiter");
        ButtonType chefButton = new ButtonType("Chef");

        whichStaff.getButtonTypes().setAll(waiterButton, chefButton);

        // stage created
        Stage stage = (Stage) whichStaff.getDialogPane().getScene().getWindow();
        stage.setAlwaysOnTop(true);

        // showAndWait() used to handle what happens when the button is pressed.
        Optional<ButtonType> result = whichStaff.showAndWait();
        if (result.isPresent()) {
            if (result.get() == waiterButton) {
                // opens the app and passes staff type to role
                Main.openCreateStaffScene("Waiter");
                // closes current window
                Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                currentStage.close();

            } else if (result.get() == chefButton) {
                // Handle Chef creation
                Main.openCreateStaffScene("Chef");
                Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                currentStage.close();

            }

        }

    }

    /**
     * switchToStaffProfile navigates to the StaffProfilesScene.fxml gui when the
     * connected button is pushed
     * 
     * @param actionEvent name of action that switches between GUI's
     * @throws IOException This is the error that occures if the
     *                     StaffProfilesScene.fxml fails to load
     */

    @FXML
    public void switchToStaffProfiles(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("StaffProfilesScene.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}