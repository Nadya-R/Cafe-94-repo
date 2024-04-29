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

public class ManagerTopController {
    private Scene scene;

    //controls for back button
    @FXML
    public void switchToWelcomeView(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //method that determines whether waiter or chef is created
    @FXML
    public void handleAddStaff(javafx.event.ActionEvent actionEvent) {
        Alert whichStaff = new Alert(Alert.AlertType.CONFIRMATION);
        whichStaff.setTitle("Add staff");
        whichStaff.setHeaderText("Select Staff Type");
        whichStaff.setContentText("Choose the type of staff you want to add:");

//create buttons for user to select
        ButtonType waiterButton = new ButtonType("Waiter");
        ButtonType chefButton = new ButtonType("Chef");

        whichStaff.getButtonTypes().setAll(waiterButton, chefButton);

        Stage stage = (Stage) whichStaff.getDialogPane().getScene().getWindow();
        stage.setAlwaysOnTop(true);

        //showAndWait() used to handle what happens when the button is pressed.
        Optional<ButtonType> result = whichStaff.showAndWait();
        if (result.isPresent()) {
            if (result.get() == waiterButton) {
                //opens the app and passes staff type to role
                Main.openCreateStaffScene("Waiter");
                //closes current window
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

    @FXML
    public void switchToStaffProfiles(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("StaffProfilesScene.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}