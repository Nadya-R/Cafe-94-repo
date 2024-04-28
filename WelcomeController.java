import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.util.Objects;

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

public void switchToStaffView(javafx.event.ActionEvent actionEvent) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("StaffScene.fxml"));
    stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
    Image iconImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/shop.png")));

    // Set the icon for the primary stage
    stage.getIcons().add(iconImage);
}
}

