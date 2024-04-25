import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class FoodOrderingApp extends Application {
    FoodOrderingSystem foodOrderingSystem;
    private Order currentOrder;
    private List<Order> orderHistory;
    private Menu menu;

    @Override
    public void start(Stage primaryStage) {
        // Create a food ordering system
        foodOrderingSystem = new FoodOrderingSystem();
        orderHistory = new ArrayList<>();
        menu = new Menu();

        // Create some menu items
        MenuItem burger = new MenuItem("Burger", "Delicious beef burger", 5.99);
        MenuItem pizza = new MenuItem("Pizza", "Tasty pizza with various toppings", 8.99);
        MenuItem fries = new MenuItem("Fries", "Crispy french fries", 2.49);

        // Add menu items to the menu
        menu.addMenuItem(burger);
        menu.addMenuItem(pizza);
        menu.addMenuItem(fries);

        // Add daily specials
        MenuItem special1 = new MenuItem("Special 1", "Special dish of the day", 10.99);
        MenuItem special2 = new MenuItem("Special 2", "Another special dish", 12.99);
        menu.addDailySpecial(special1);
        menu.addDailySpecial(special2);

        // GUI components
        VBox root = new VBox(10);
        Label menuLabel = new Label("Menu:");

        // Create buttons for each menu item
        for (MenuItem item : menu.getMenuItems()) {
            Button button = new Button(item.getItemName() + " - £" + item.getPrice());
            button.setOnAction(event -> {
                if (currentOrder == null) {
                    currentOrder = foodOrderingSystem.createOrder();
                }
                currentOrder.addItem(item);
                System.out.println("Added " + item.getItemName() + " to order");
            });
            root.getChildren().add(button);
        }

        Label specialsLabel = new Label("Daily Specials:");
        for (MenuItem item : menu.getDailySpecials()) {
            Button button = new Button(item.getItemName() + " - £" + item.getPrice());
            button.setOnAction(event -> {
                if (currentOrder == null) {
                    currentOrder = foodOrderingSystem.createOrder();
                }
                currentOrder.addItem(item);
                System.out.println("Added " + item.getItemName() + " to order");
            });
            root.getChildren().add(button);
        }

        Button placeOrderButton = new Button("Place Order");
        placeOrderButton.setOnAction(event -> {
            if (currentOrder != null && !currentOrder.getItems().isEmpty()) {
                foodOrderingSystem.placeOrder(currentOrder);
                orderHistory.add(currentOrder);
                // Reset the current order after placing it
                currentOrder = null;
            } else {
                System.out.println("Please add items to the order first.");
            }
        });

        root.getChildren().addAll(menuLabel, specialsLabel, placeOrderButton);

        Scene scene = new Scene(root, 300, 400);
        primaryStage.setTitle("Food Ordering App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}

