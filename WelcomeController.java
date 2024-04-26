import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class WelcomeController {
    private Stage stage;
    private Scene scene;
    private Parent root;

@FXML
public void switchToCusterView(javafx.event.ActionEvent actionEvent) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("CustomerScene.fxml"));
    stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}
//need to create Staf view


   /* public void switchToWelcomeView(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
        stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }*/
}

