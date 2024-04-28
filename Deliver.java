import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Deliver extends Application {
    private Delivery deliveryService;
    private Order currentOrder;
    private List<Order> orderHistory;
    private Menu menu;
    private TextArea orderMessages;
    private TextArea chefMessages;

    @Override
    public void start(Stage primaryStage) {
        // Create a delivery service
        deliveryService = new Delivery();
        orderHistory = new ArrayList<>();
        menu = new Menu();

        // Creating menu items
        MenuItem burger = new MenuItem("Burger", "Delicious beef burger", 5.99);
        MenuItem pizza = new MenuItem("Pizza", "Tasty pizza with various toppings", 8.99);
        MenuItem fries = new MenuItem("Fries", "Crispy french fries", 2.49);

        // Adding menu items to the menu
        menu.addMenuItem(burger);
        menu.addMenuItem(pizza);
        menu.addMenuItem(fries);


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
        Button processOrderButton = getProcessOrderButton();

        root.getChildren().addAll(placeOrderButton, chefLabel, chefMessages, processOrderButton);

        // Set the stage
        Scene scene = new Scene(root, 400, 600);
        primaryStage.setTitle("Delivery App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button getProcessOrderButton() {
        Button processOrderButton = new Button("Process Order");
        processOrderButton.setOnAction(event -> {
            if (!deliveryService.getPendingOrders().isEmpty()) {
                Order order = deliveryService.getPendingOrders().getFirst();
                deliveryService.processOrder(order);
                chefMessages.appendText("Order processed: " + order + "\n");
            } else {
                chefMessages.appendText("No pending orders to process.\n");
            }
        });
        return processOrderButton;
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
                    deliveryService.placeOrder(currentOrder);
                    orderHistory.add(currentOrder);
                    // Reset the current order after placing it
                    currentOrder = null;
                    orderMessages.appendText("Order placed successfully! Total price: £" + String.format("%.2f", totalPrice) + "\n");
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
