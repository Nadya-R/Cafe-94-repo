import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Food ordering app.
 */
public class FoodOrderingApp extends Application {
    /**
     * The Food ordering system.
     */
    FoodOrderingSystem foodOrderingSystem;
    private Order currentOrder;
    private List<Order> orderHistory;
    private Menu menu;
    private TextArea orderMessages;

    @Override
    public void start(Stage primaryStage) {
        // Create a food ordering system
        foodOrderingSystem = new FoodOrderingSystem();
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

        // Adding daily specials
        MenuItem special1 = new MenuItem("Special 1", "Special dish of the day", 10.99);
        MenuItem special2 = new MenuItem("Special 2", "Another special dish", 12.99);
        menu.addDailySpecial(special1);
        menu.addDailySpecial(special2);

        // GUI components
        //creating root
        VBox root = new VBox(10);
        Label menuLabel = new Label("Menu:");
        root.getChildren().add(menuLabel);

        //creating an area for text to show in the GUI instead of printing to terminal
        orderMessages = new TextArea();
        orderMessages.setEditable(false);
        root.getChildren().add(orderMessages);

        // Create buttons for each menu item
        for (MenuItem item : menu.getMenuItems()) {
            Button button = new Button(item.getItemName() + " - £" + item.getPrice());
            button.setOnAction(event -> {
                if (currentOrder == null) {
                    currentOrder = foodOrderingSystem.createOrder();
                }
                currentOrder.addItem(item);
                orderMessages.appendText("Added " + item.getItemName() + " to order\n");
            });
            root.getChildren().add(button);
        }

        //creating a seperate label and buttons for special items
        Label specialsLabel = new Label("Daily Specials:");
        root.getChildren().add(specialsLabel);
        for (MenuItem item : menu.getDailySpecials()) {
            Button button = new Button(item.getItemName() + " - £" + item.getPrice());
            button.setOnAction(event -> {
                if (currentOrder == null) {
                    currentOrder = foodOrderingSystem.createOrder();
                }
                currentOrder.addItem(item);
                orderMessages.appendText("Added " + item.getItemName() + " to order\n");
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
                orderMessages.appendText("Please add items to the order first.\n");
            }
        });

        //adding labels and order button to root
        root.getChildren().add(placeOrderButton);

        //setting stage
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Food Ordering App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        launch(args);
    }
}

