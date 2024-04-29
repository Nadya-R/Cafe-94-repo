import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.time.format.DateTimeFormatter;

public class Deliver extends Application {
    private Delivery deliveryService;
    private Order currentOrder;
    private List<Order> orderHistory;
    private Menu menu;
    private TextArea orderMessages;
    private TextArea chefMessages;
    private static final int ESTIMATED_DELIVERY_15_MINUTES = 15;
    private static final int ESTIMATED_DELIVERY_30_MINUTES = 30;
    private static final int ESTIMATED_DELIVERY_45_MINUTES = 45;

    @Override
    public void start(Stage primaryStage) {
        // Create a delivery service
        deliveryService = new Delivery();
        orderHistory = new ArrayList<>();
        menu = new Menu();

        Image iconImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/shop.png")));

        // Set the icon for the primary stage
        primaryStage.getIcons().add(iconImage);

        // Creating menu items
        MenuItem burger = new MenuItem("Burger", "Delicious beef burger", 5.99);
        MenuItem pizza = new MenuItem("Pizza", "Tasty pizza with various toppings", 8.99);
        MenuItem fries = new MenuItem("Fries", "Crispy french fries", 2.49);

        // Adding menu items to the menu
        menu.addMenuItem(burger);
        menu.addMenuItem(pizza);
        menu.addMenuItem(fries);

        // Adding daily specials
        MenuItem special1 = new MenuItem("Special 1", "Special dish of the day", 9.99);
        MenuItem special2 = new MenuItem("Special 2", "Another special dish", 11.99);
        menu.addMenuItem(special1);
        menu.addMenuItem(special2);

        VBox root = new VBox(10);
        Label menuLabel = new Label("Menu:");
        root.getChildren().add(menuLabel);

        orderMessages = new TextArea();
        orderMessages.setEditable(false);
        root.getChildren().add(orderMessages);

        // Create buttons for each menu item
        for (MenuItem item : menu.getMenuItems()) {
            Button button = new Button(item.getItemName() + " - £" + item.getPrice());
            button.setOnAction(event -> {
                if (currentOrder == null) {
                    currentOrder = deliveryService.createOrder();
                }
                currentOrder.addItem(item);
                orderMessages.appendText("Added " + item.getItemName() + " to order\n");
            });
            root.getChildren().add(button);
        }

        // Adding addresses
        Label addressLabel = new Label("Enter Delivery Address:");
        TextArea addressTextArea = new TextArea();
        addressTextArea.setPrefRowCount(2);
        root.getChildren().addAll(addressLabel, addressTextArea);

        Button placeOrderButton = getPlaceOrderButton(addressTextArea);

        // Chef's section
        Label chefLabel = new Label("Chef's Panel:");
        chefMessages = new TextArea();
        chefMessages.setEditable(false);
        root.getChildren().add(chefLabel);
        root.getChildren().add(chefMessages);

        root.getChildren().addAll(placeOrderButton);

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
        root.getChildren().add(backButton); // Add the back button to the root

        // Set the stage
        Scene scene = new Scene(root, 400, 600);
        primaryStage.setTitle("Delivery App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button getPlaceOrderButton(TextArea addressTextArea) {
        Button placeOrderButton = new Button("Place Order");
        placeOrderButton.setOnAction(event -> {
            if (currentOrder != null && !currentOrder.getItems().isEmpty()) {
                double totalPrice = 0.0;
                for (MenuItem item : currentOrder.getItems()) {
                    totalPrice += item.getPrice();
                }
                String address = addressTextArea.getText();
                if (!address.isEmpty()) {
                    currentOrder.setDeliveryAddress(address);
                    // Set fixed estimated delivery times
                    LocalTime estimatedDeliveryTime;
                    if (currentOrder.getTotalPrice() <= 15.00) {
                        estimatedDeliveryTime = LocalTime.now().plusMinutes(ESTIMATED_DELIVERY_15_MINUTES);
                    } else if (currentOrder.getTotalPrice() <= 30.00) {
                        estimatedDeliveryTime = LocalTime.now().plusMinutes(ESTIMATED_DELIVERY_30_MINUTES);
                    } else {
                        estimatedDeliveryTime = LocalTime.now().plusMinutes(ESTIMATED_DELIVERY_45_MINUTES);
                    }
                    currentOrder.setEstimatedDeliveryTime(estimatedDeliveryTime);
                    deliveryService.placeOrder(currentOrder);
                    orderHistory.add(currentOrder);
                    // Reset the current order after placing it
                    currentOrder = null;
                    orderMessages.appendText("Order placed successfully! Total price: £" + String.format("%.2f", totalPrice) + "\n");
                    orderMessages.appendText("Estimated delivery time: " + estimatedDeliveryTime.format(DateTimeFormatter.ofPattern("HH:mm")) + "\n");
                } else {
                    orderMessages.appendText("Please enter the delivery address.\n");
                }
            } else {
                orderMessages.appendText("Please add items to the order first.\n");
            }
        });
        return placeOrderButton;
    }

    public static void main(String[] args) {
        launch(args);
    }
}