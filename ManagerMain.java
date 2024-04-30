import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * The ManagerMain class is the entry point of the manager application.
 * largely used as a shortcut for testing the splitpane profile
 * 
 * @author Nadya Roderick
 */

/**
 * <p>
 * Starts the manager application, loading ManagerScene.fxml.
 *
 * @param primaryStage the primary stage for the application
 * @throws Exception if an error occurs while loading the FXML file
 *                   </p>
 */

public class ManagerMain extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ManagerScene.fxml")));
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setTitle("My Application");
        primaryStage.show();

        Image iconImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/shop.png")));

        // Set the icon for the primary stage
        primaryStage.getIcons().add(iconImage);

    }

    /**
     * The main method, launching the manager application.
     *
     * @param args the command-line arguments
     */

    public static void main(String[] args) {
        launch(args);
    }
}
