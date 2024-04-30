import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

/**
 * The Main class serves as the entry point for the application and contains
 * methods to initialize the GUI and navigate between scenes.
 * 
 * <p>
 * This class extends the Application class provided by JavaFX and overrides its
 * start method to initialize the Welcome scene.
 * </p>
 * 
 * @author Nadya Roderick
 * @author Ty Bors
 * @version 1.0
 */
public class Main extends Application {

    /**
     * The starts method initializes the welcome.fxml file which is the entry point
     * to the system
     * This method also sets the icon image and applies CSS to the scene
     * 
     * @param stage is the primary stage of the application
     */
    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("W.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
            Image iconImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/shop.png")));
            stage.getIcons().add(iconImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The openCreateStaffScene is the method used to open the CreateStaffScene
     * 
     * @param role refers to the staff type being created
     */
    public static void openCreateStaffScene(String role) {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("CreateStaffScene.fxml"));
            Parent root = loader.load();

            // passes the role to the controller
            CreateStaffController controller = loader.getController();
            controller.setStaffRole(role);

            // creates scene adn stage
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);

            // show stage
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}