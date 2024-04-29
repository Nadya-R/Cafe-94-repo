import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

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

    //method to open the Create Staff GUI
    public static void openCreateStaffScene(String role) {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("CreateStaffScene.fxml"));
            Parent root = loader.load();

            CreateStaffController controller = loader.getController();
            controller.setStaffRole(role); // Pass the role to the controller

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}