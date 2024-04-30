import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * The StaffController class controls the behaviours of buttons
 * found in the StaffScene.fxml, which is the Main GUI that staff
 * can interact with the System
 * 
 * <p>
 * Please note: the System has a chef and Waiter button which do not preform any actions
 * as these parts of the system were not built
 * </p>
 * @author Nadya Roderick
 */
public class StaffController {
    private Scene scene;

    /**
     * This method takes loads the Welcome.fxml file when the back button is pressed
     * @param actionEvent Action that takes the user to the welcome page
     * @throws IOException An error that occures if welcome.fxml page does not load
     */
    public void switchToWelcomeView(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * This method takes loads the ManagerScene.fxml file when the back button is pressed
     * @param actionEvent Action that takes the user to the Manager profile
     * @throws IOException An error that occures if ManagerScene.fxml page does not load
     */
    public void switchToMangerView(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ManagerScene.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
