import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.lang.module.ModuleDescriptor.Opens;

/**
 * The CustomerController controls the bahavior of the CustomerScene which is
 * the main GUI for users to create orders
 * 
 * <p>
 * This class contains methods for navigating to different GUIS that make up the
 * System
 * </p>
 * 
 * @author Nadya Roderick and Ty Bors
 * @version 1.0
 */

public class CustomerController {

    // local variables
    private Scene scene;

    /**
     * Switches to the welcome view scene.
     * 
     * @param actionEvent Refers to the event triggering the method.
     * @throws IOException Responds if an error occurs while loading the FXML file.
     * @author Nadya Roderick
     */
    public void switchToWelcomeView(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        scene.getStylesheets().add(getClass().getResource("W.css").toExternalForm()); //
    }

    /**
     * Opens the food ordering system when Takeaway button is clicked
     * 
     * @param actionEvent Refers to the event triggering the method.
     * @throws IOException Response if an error occurs while loading the FXML file.
     * @author Nadya Roderick
     */
    public void openFoodSystem(javafx.event.ActionEvent actionEvent) throws IOException {
        FoodOrderingApp foodOrderingApp = new FoodOrderingApp();
        Stage newStage = new Stage();
        foodOrderingApp.start(newStage);
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }

    /**
     * Opens the delivery ordering app
     * 
     * @param actionEvent Refers to the event triggering the method.
     * @throws IOException Response if an error occurs while loading the FXML file.
     * @author Ty Bors
     */
    public void Deliver(javafx.event.ActionEvent actionEvent) throws IOException {
        Deliver deliver = new Deliver();
        Stage newStage = new Stage();
        deliver.start(newStage);
        // Hide the current window
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }

    /**
     * Opens the Eat In ordering app
     * 
     * @param actionEvent Refers to the event triggering the method.
     * @throws IOException Response if an error occurs while loading the FXML file.
     * @author Ty Bors
     */
    public void EatInFunction(ActionEvent actionEvent) throws IOException {
        EatInFunction eatInFunction = new EatInFunction();
        Stage newStage = new Stage();
        eatInFunction.start(newStage);
        // Hide the current window
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }

}
