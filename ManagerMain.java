import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

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

    public static void main(String[] args) {
        launch(args);
    }
}
