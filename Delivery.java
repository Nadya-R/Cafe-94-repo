import javafx.scene.control.TextArea;
import java.util.ArrayList;
import java.util.List;

/**
 * The Delivery class provides methods required for managing delivery orders
 * 
 * <p>
 * This class maintains lists of pending and delivered orders and provides
 * methods for creating, placing,
 * and simulating delivery of orders. It also provides functionality for
 * updating order lists in GUI components
 * and processing individual orders.
 * </p>
 * 
 * <p>
 * Note: The delivery simulation in this class is for demonstration purposes
 * only and does not represent a realistic service
 * </p>
 * 
 * @author Ty Bors
 * @version 1.0
 */

public class Delivery {
    private List<Order> pendingOrders;
    private List<Order> deliveredOrders;

    public Delivery() {

        // llocal feilds
        pendingOrders = new ArrayList<>();
        deliveredOrders = new ArrayList<>();
    }

    // constructor
    public Order createOrder() {
        return new Order();
    }

    /**
     * method used to add orders to the pendingOrders list
     * 
     * @param order This is the order added to the pendingOrder list
     */
    public void placeOrder(Order order) {
        pendingOrders.add(order);
    }

    /**
     * method that simulates delivery by moving order from the pendingOrder list
     * to deliveredOrders list. It does this by creating a temporary ArrayList and
     * moving
     * items to the deliveredOrders list after a certain amount o time
     */
    public void simulateDelivery() {
        // creates temporary ArrayList
        List<Order> ordersToMove = new ArrayList<>();
        // Iterate through pending orders
        for (Order order : pendingOrders) {
            // Simulates a delivery time of 5 seconds
            try {
                Thread.sleep(5000); // 5000 milliseconds = 5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // add the order to temporary list
            ordersToMove.add(order);
        }
        // Remove pending orders that have been delivered and add them to delivered
        // orders list
        pendingOrders.removeAll(ordersToMove);
        deliveredOrders.addAll(ordersToMove);
    }

    // accessor methods
    public List<Order> getDeliveredOrders() {
        return deliveredOrders;
    }

    public List<Order> getPendingOrders() {
        return pendingOrders;
    }

    /**
     * Updates the displayed lists of pending and delivered orders in the GUI.
     * Clears the provided TextArea objects for pending and delivered orders,
     * then populates them with the string representations of orders in the
     * pendingOrders
     * and deliveredOrders lists respectively.
     * 
     * @param pendingTextArea   Displays pending orders
     * @param deliveredTextArea Displays Delivered orders
     */
    public void updateOrderLists(TextArea pendingTextArea, TextArea deliveredTextArea) {
        // ensures display is clean by clearing text areas
        pendingTextArea.clear();
        deliveredTextArea.clear();

        // Populate the pending orders TextArea with string representations of orders in
        // pendingOrders list
        for (Order order : pendingOrders) {
            pendingTextArea.appendText(order.toString() + "\n");
        }
        // populates the delivered orders text area
        for (Order order : deliveredOrders) {
            deliveredTextArea.appendText(order.toString() + "\n");
        }
    }

    /**
     * Provides logic representing processes such as preparing food
     * ince processed, message is displayed in terminal
     * 
     * @param order represents the order put through the system
     */
    public void processOrder(Order order) {

        System.out.println("Order processed: " + order);
        // After processing, move the order from pending to delivered
        pendingOrders.remove(order);
        deliveredOrders.add(order);
    }
}
