import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EatInFunction extends Application {

    private Map<Integer, Boolean> tableStatus;
    private Image logoImage;
    private List<MenuItem> selectedItems;
    private double totalCost;

    @Override
    public void start(Stage primaryStage) {
        tableStatus = new HashMap<>();
        for (int i = 1; i <= 11; i++) {
            tableStatus.put(i, false);
        }
        selectedItems = new ArrayList<>();

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        // Load the logo image
        logoImage = new Image(getClass().getResourceAsStream("/shop.png"));

        // Creating labels and buttons for Eat In option
        Label eatInLabel = new Label("Menu:");
        TextField tableNumberField = new TextField();
        tableNumberField.setPromptText("Table Number");

        // Create menu items (Assuming MenuItem is a custom class defined elsewhere)
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
            selectedItems.add(burger);
        });

        pizzaButton.setOnAction(event -> {
            System.out.println("Pizza added to order");
            selectedItems.add(pizza);
        });

        friesButton.setOnAction(event -> {
            System.out.println("Fries added to order");
            selectedItems.add(fries);
        });

        special1Button.setOnAction(event -> {
            System.out.println("Special 1 added to order");
            selectedItems.add(special1);
        });

        special2Button.setOnAction(event -> {
            System.out.println("Special 2 added to order");
            selectedItems.add(special2);
        });

        Button selectTableButton = new Button("Select Table");
        selectTableButton.setOnAction(event -> {
            try {
                int tableNumber = Integer.parseInt(tableNumberField.getText());
                if (tableStatus.containsKey(tableNumber)) {
                    if (tableStatus.get(tableNumber)) {
                        System.out.println("Table " + tableNumber + " is already occupied.");
                    } else {
                        tableStatus.put(tableNumber, true);
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
            int tableNumber;
            try {
                tableNumber = Integer.parseInt(tableNumberField.getText());
                handleOrderPlacement(tableNumber);
            } catch (NumberFormatException e) {
                System.out.println("Invalid table number format.");
            }
        });

        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            try {
                Parent rootWelcome = FXMLLoader.load(getClass().getResource("CustomerScene.fxml"));
                Scene welcomeScene = new Scene(rootWelcome);
                primaryStage.setScene(welcomeScene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Adding components to root
        root.getChildren().addAll(eatInLabel, special1Button, special2Button, burgerButton, pizzaButton, friesButton, tableNumberField, selectTableButton, orderButton, backButton);

        // Setting scene and stage
        Scene scene = new Scene(root, 300, 400);
        scene.getStylesheets().add(getClass().getResource("W.css").toExternalForm()); //
        primaryStage.setTitle("Eat In Option");
        primaryStage.getIcons().add(logoImage); // Set the icon image
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    private void handleOrderPlacement(int tableNumber) {
        totalCost = calculateTotalCost(selectedItems);
        System.out.println("Order placed for Eat In. Total cost: £" + totalCost);
        OrderPopupDone(tableNumber, totalCost);
        selectedItems.clear(); // Reset selected items
    }

    private double calculateTotalCost(List<MenuItem> items) {
        double totalCost = 0;
        for (MenuItem item : items) {
            totalCost += item.getPrice();
        }
        return totalCost;
    }

    private void OrderPopupDone(int tableNumber, double totalCost) {

            Image logoImage = new Image(getClass().getResourceAsStream("/shop.png"));

            Stage popupStage = new Stage();
            popupStage.setTitle("Order Done");
            popupStage.getIcons().add(logoImage); // Set the icon image
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