import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import java.io.IOException;
import java.util.*;

/**
 *  The FoodOrderingApp is the main application for the TakeAway ordering system.
 * Users can view the menu, select items, place orders, and navigate back to the customer scene.
 * 
 * @author Nadya Roderick
 * @version 1.0
 */
public class FoodOrderingApp extends Application {
    //local feild

    FoodOrderingSystem foodOrderingSystem;
    private Order currentOrder;
    private List<Order> orderHistory;
    private Menu menu;
    private TextArea orderMessages;

/** 
    <p>
 * The GUI provides buttons for each menu item and daily specials, a text area to display order messages,
 * a button to place orders and a back button to navigate to the Customer View. 
 * Addionally there are labels to indicate menu sections.
 * </p>
 */
    @Override
    public void start(Stage primaryStage) {
        // Create a food ordering system
        foodOrderingSystem = new FoodOrderingSystem();
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
        root.getChildren().add(backButton);

        //setting stage
        Scene scene = new Scene(root, 400, 400);
        scene.getStylesheets().add(getClass().getResource("W.css").toExternalForm()); //
        primaryStage.setTitle("Food Ordering App");
        primaryStage.getIcons().add(iconImage);
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    /**
     * <p>
     * The entry point of application.
     *
     * @param args the input arguments
     * </p>
     */
    public static void main(String[] args) {

        launch(args);
    }
}

