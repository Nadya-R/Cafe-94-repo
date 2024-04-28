import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import java.util.Objects;

public class CustomerApp extends Application {



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Cafe-94. Order selection");

        Label welcomeLabel = new Label("Welcome to Cafe- 94.");
        Label questionLabel = new Label("Which type of order would you like to make:");

        Button takeawayButton = new Button("Takeaway");
        Button deliveryButton = new Button("Delivery");
        //Button bookingButton = new Button ("Eat-in");// this will be added once we have the rest of the system working

        takeawayButton.setOnAction(event -> {
            FoodOrderingApp foodOrderingApp = new FoodOrderingApp();
            foodOrderingApp.start(new Stage());
        });
        deliveryButton.setOnAction(event -> {
            FoodOrderingApp foodOrderingApp = new FoodOrderingApp();
            foodOrderingApp.start(new Stage());
        });

        VBox customerView = new VBox(welcomeLabel, questionLabel, takeawayButton, deliveryButton);
        Scene custScene = new Scene(customerView, 300, 200);
        stage.setScene(custScene);
        stage.show();
        Image iconImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/shop.png")));

        // Set the icon for the primary stage
        stage.getIcons().add(iconImage);



    }
}

