import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * The Order class provides methods for creating and maintaining a list of menu
 * items which serves as an order.
 * 
 * @author Ty Bors
 * @author Naadya Roderick
 * @version 1.0
 */
public class Order {
    private List<MenuItem> items;

    /**
     * Constructs a new Order as an empty list of items.
     */
    public Order() {
        this.items = new ArrayList<>();
    }

    /**
     * Adds a menu item to the order.
     *
     * @param item the menu item to add
     */
    public void addItem(MenuItem item) {
        items.add(item);
    }

    // accessor methods
    public List<MenuItem> getItems() {
        return items;
    }

    /**
     * Calculates the total price of the order.
     *
     * @return the total price of the order
     * @author Ty Bors
     */
    public double getTotal() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void setDeliveryAddress(String address) {
    }

    public void setEstimatedDeliveryTime(LocalTime localTime) {
    }

    /**
     * Calculates the total price of the order.
     *
     * @return the total price of the order
     * @author Nadya Roderick
     */
    public double getTotalPrice() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }
}
