import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToWelcomeView(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
//only open food syste- seperate delivery system not set
    public void openFoodSystem (javafx.event.ActionEvent actionEvent) throws IOException {
        FoodOrderingApp foodOrderingApp = new FoodOrderingApp();
        Stage newStage = new Stage();
        foodOrderingApp.start(newStage);
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }

    public void Deliver(javafx.event.ActionEvent actionEvent) throws IOException {
        // Assuming you have a DeliveryApp class
        Deliver deliver = new Deliver();
        Stage newStage = new Stage();
        deliver.start(newStage);
        // Hide the current window
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }


    public void EatInFunction(ActionEvent actionEvent) throws IOException  {
        EatInFunction eatInFunction = new EatInFunction();
        Stage newStage = new Stage();
        eatInFunction.start(newStage);
        // Hide the current window
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }
}
