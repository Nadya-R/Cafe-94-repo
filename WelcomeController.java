import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.util.Objects;

/**
 * The WelcomeController class controls the welcome screen of the application.
 * It handles switching between customer and staff views.
 * 
 * @author Nadya Roderick
 * @version 1.0
 */
public class WelcomeController {
    //fields
    private Stage stage;
    private Scene scene;

    /**
     * This method switches to the customer view.
     * 
     * @param actionEvent The action of switching to the customer view when the button is pushed
     * @throws IOException Error that occurs if CustomerScene.fxml fails to load
     */
@FXML
public void switchToCusterView(javafx.event.ActionEvent actionEvent) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("CustomerScene.fxml"));
    stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}

/**
     * Switches to the staff view.
     * 
     * @param actionEvent The ActionEvent that triggers when the button is pushed
     * @throws IOException Error that occurs if StaffScene.fxml fails to load
     */
public void switchToStaffView(javafx.event.ActionEvent actionEvent) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("StaffScene.fxml"));
    stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
    Image iconImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/shop.png")));

    // Set the icon for the primary stage
    stage.getIcons().add(iconImage);
    scene.getStylesheets().add(getClass().getResource("W.css").toExternalForm()); 
}
}

