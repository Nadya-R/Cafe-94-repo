import javafx.application.Application;
import javafx.geometry.Insets;
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
    private Application previousApplication ;

    public EatInFunction() {
        this.previousApplication = previousApplication;
    }

    @Override
    public void start(Stage primaryStage) {
        tablestatus = new HashMap<>();
        for (int i = 1; i <= 27; i++) {
            tablestatus.put(i, false);
        }

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        // Creating labels and buttons for Eat In option
        Label eatInLabel = new Label("Eat In Option:");
        TextField tableNumberField = new TextField();
        tableNumberField.setPromptText("Table Number");

        // Create menu items
        MenuItem burger = new MenuItem("Burger", "Delicious beef burger", 5.99);
        MenuItem pizza = new MenuItem("Pizza", "Tasty pizza with various toppings", 8.99);
        MenuItem fries = new MenuItem("Fries", "Crispy french fries", 2.49);
        MenuItem special1 = new MenuItem("Special 1", "Special dish of the day", 10.99);
        MenuItem special2 = new MenuItem("Special 2", "Another special dish", 12.99);

        // Creating buttons for menu items
        Button burgerButton = new Button(burger.getItemName() + " - £" + burger.getPrice());
        Button pizzaButton = new Button(pizza.getItemName() + " - £" + pizza.getPrice());
        Button friesButton = new Button(fries.getItemName() + " - £" + fries.getPrice());
        Button special1Button = new Button(special1.getItemName() + " - £" + special1.getPrice());
        Button special2Button = new Button(special2.getItemName() + " - £" + special2.getPrice());

        // Event handlers for menu item buttons
        burgerButton.setOnAction(event -> {
            System.out.println("Burger added to order");
        });

        pizzaButton.setOnAction(event -> {
            System.out.println("Pizza added to order");
        });

        friesButton.setOnAction(event -> {
            System.out.println("Fries added to order");
        });

        special1Button.setOnAction(event -> {
            System.out.println("Special 1 added to order");
        });

        special2Button.setOnAction(event -> {
            System.out.println("Special 2 added to order");
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
            double totalCost = 0;

            // Calculate total cost based on selected items though it does work as it comes out £0.00
            if (burgerButton.isArmed()) {
                totalCost += burger.getPrice();
            }
            if (pizzaButton.isArmed()) {
                totalCost += pizza.getPrice();
            }
            if (friesButton.isArmed()) {
                totalCost += fries.getPrice();
            }
            if (special1Button.isArmed()) {
                totalCost += special1.getPrice();
            }
            if (special2Button.isArmed()) {
                totalCost += special2.getPrice();
            }

            System.out.println("Order placed for Eat In. Total cost: £" + totalCost);
            int tableNumber;
            try {
                tableNumber = Integer.parseInt(tableNumberField.getText());
                OrderPopupDone(tableNumber, totalCost);
            } catch (NumberFormatException e) {
                System.out.println("Invalid table number format.");
            }

        });



        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            // Close the current window (Stage)
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.close();
            // Go back to the previous application
            if (previousApplication != null) {
                try {
                    previousApplication.start(new Stage());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // Adding components to root
        root.getChildren().addAll(eatInLabel, special1Button, special2Button, burgerButton, pizzaButton, friesButton, tableNumberField, selectTableButton, orderButton, backButton);


        // Setting scene and stage
        Scene scene = new Scene(root, 300, 400);
        primaryStage.setTitle("Eat In Option");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void OrderPopupDone(int tableNumber, double totalCost) {
        Stage popupStage = new Stage();
        popupStage.setTitle("Order Done");
        VBox popupRoot = new VBox(10);
        popupRoot.setPadding(new Insets(10));
        Label orderDoneLabel = new Label("Order for Table " + tableNumber + " is completed.\nTotal cost: £" + totalCost);
        Button closeButton = new Button("Close");
        closeButton.setOnAction(event -> popupStage.close());
        popupRoot.getChildren().addAll(orderDoneLabel, closeButton);
        Scene popupScene = new Scene(popupRoot, 250, 200);
        popupStage.setScene(popupScene);
        popupStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}