import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.HashMap;
import java.util.Map;

public class EatInFunction extends Application {

    private Map<Integer,Boolean> tablestatus;

    @Override
    public void start(Stage primaryStage) {
        tablestatus = new HashMap<Integer, Boolean>();
        for (int i = 1; i <= 10; i++) {
            tablestatus.put(i, false);
        }
        VBox root = new VBox(10);

        // Creating labels and buttons for Eat In option
        Label eatInLabel = new Label("Eat In Option:");
        TextField tableNumberField = new TextField();
        tableNumberField.setPromptText("Table Number");

        // Create menu items
        MenuItem burger = new MenuItem("Burger", "Delicious beef burger", 5.99);
        MenuItem pizza = new MenuItem("Pizza", "Tasty pizza with various toppings", 8.99);
        MenuItem fries = new MenuItem("Fries", "Crispy french fries", 2.49);


        Button burgerButton = new Button(burger.getItemName() + " - £" + burger.getPrice());
        Button pizzaButton = new Button(pizza.getItemName() + " - £" + pizza.getPrice());
        Button friesButton = new Button(fries.getItemName() + " - £" + fries.getPrice());


        burgerButton.setOnAction(event -> {

            System.out.println("Burger added to order");
        });

        pizzaButton.setOnAction(event -> {
            System.out.println("Pizza added to order");
        });

        friesButton.setOnAction(event -> {

            System.out.println("Fries added to order");
        });

        Button selectTableButton = new Button("Select Table");
        selectTableButton.setOnAction(event -> {
            try {
                int tableNumber = Integer.parseInt(tableNumberField.getText());
                if (tablestatus.containsKey(tableNumber)) {
                    if (tablestatus.get(tableNumber)) {
                        System.out.println("Table " + tableNumber + " is already occupied.");
                    } else {
                        tablestatus.put(tableNumber, true);
                        System.out.println("Table " + tableNumber + " selected for Eat In.");
                    }
                } else {
                    System.out.println("Table " + tableNumber + " does not exist.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid table number format.");
            }
        });
        Button orderButton = new Button("Place Order");
        orderButton.setOnAction(event -> {

            double totalCost = burger.getPrice() + pizza.getPrice() + fries.getPrice(); // Calculate total cost
            System.out.println("Order placed for Eat In. Total cost: £" + totalCost);
        });

        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {

            System.out.println("Back button clicked");
        });

        // Adding components to root
        root.getChildren().addAll(eatInLabel, burgerButton, pizzaButton, friesButton, tableNumberField, selectTableButton, orderButton, backButton);

        // Setting scene and stage
        Scene scene = new Scene(root, 300, 400);
        primaryStage.setTitle("Eat In Option");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
