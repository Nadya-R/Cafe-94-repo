import java.util.ArrayList;
import java.util.List;

// Class to represent a food ordering system
public class FoodOrderingSystem {
    private List<MenuItem> menu;

    public FoodOrderingSystem() {
        this.menu = new ArrayList<>();
    }

    public void addToMenu(MenuItem item) {
        menu.add(item);
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public Order createOrder() {
        return new Order();
    }

    public void placeOrder(Order order) {
        // In a real system, you would implement logic to process the order,
        // such as notifying the kitchen staff, deducting items from inventory, etc.
        System.out.println("Order placed successfully!");
        System.out.println("Total amount: $" + order.getTotal());
    }
}

