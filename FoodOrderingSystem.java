import java.util.ArrayList;
import java.util.List;

/**
 * The FoodOrderingSystem class provides methods to facilitate the
 * FoodOrderingApp
 * 
 * <p>
 * This class includes methods to add items to the menu, retrieve the current
 * menu,
 * create new orders, and place orders. It maintains a list of menu items and
 * provides functionality to interact with them.
 * </p>
 *
 * @author Nadya Roderick
 * @version 1.0
 */
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
        System.out.println("Order placed successfully!");
        System.out.println("Total amount: £" + order.getTotal());
    }
}
