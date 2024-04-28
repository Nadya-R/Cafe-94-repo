import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

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