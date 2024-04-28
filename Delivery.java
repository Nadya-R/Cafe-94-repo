import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Delivery {
    private List<Order> pendingOrders;
    private List<Order> deliveredOrders;

    public Delivery() {
        pendingOrders = new ArrayList<>();
        deliveredOrders = new ArrayList<>();
    }

    public Order createOrder() {
        return new Order();
    }

    public void placeOrder(Order order) {
        pendingOrders.add(order);
    }

    public void simulateDelivery() {
        // Simulate delivery by moving pending orders to delivered orders after some time
        List<Order> ordersToMove = new ArrayList<>();
        for (Order order : pendingOrders) {
            // Simulate delivery time
            // Here, let's assume delivery takes 5 seconds
            try {
                Thread.sleep(5000); // 5000 milliseconds = 5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ordersToMove.add(order);
        }
        pendingOrders.removeAll(ordersToMove);
        deliveredOrders.addAll(ordersToMove);
    }

    public List<Order> getDeliveredOrders() {
        return deliveredOrders;
    }

    public List<Order> getPendingOrders() {
        return pendingOrders;
    }

    public void updateOrderLists(TextArea pendingTextArea, TextArea deliveredTextArea) {
        pendingTextArea.clear();
        deliveredTextArea.clear();

        for (Order order : pendingOrders) {
            pendingTextArea.appendText(order.toString() + "\n");
        }

        for (Order order : deliveredOrders) {
            deliveredTextArea.appendText(order.toString() + "\n");
        }
    }

    public void processOrder(Order order) {
        // Logic to process the order (e.g., preparing food)
        // For demonstration purposes, let's just print a message
        System.out.println("Order processed: " + order);
        // After processing, move the order from pending to delivered
        pendingOrders.remove(order);
        deliveredOrders.add(order);
    }
}

