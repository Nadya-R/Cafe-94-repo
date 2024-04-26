import java.util.*;
import java.util.stream.Collectors;

// Menu class 
public class Menu {
    private List<MenuItem> menuItems;
    private List<Order> allOrders;

    public Menu() {
        this.menuItems = new ArrayList<>();
    }

    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    public void removeMenuItem(MenuItem item) {
        menuItems.remove(item);
    }

    // To get daily speacial items 
    public List<MenuItem> getSpecials() {
        return menuItems.stream()
                .filter(MenuItem::isSpecial)
                .collect(Collectors.toList());
    }

    // To get popular Item of the cafe
    public Report generatePopularItemsReport() {
        Map<MenuItem, Integer> itemOrders = new HashMap<>();

        // Count the number of orders for each menu item
        for (Order order : allOrders) {
            for (MenuItem item : order.getItems()) {
                itemOrders.put(item, itemOrders.getOrDefault(item, 0) + 1);
            }
        }

        // Sort the menu items based on the number of orders
        List<MenuItem> popularItems = itemOrders.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return new Report(popularItems);
    }

    // Order class
    private class Order {
        private List<MenuItem> items;

        public Order(List<MenuItem> items) {
            this.items = items;
        }

        public List<MenuItem> getItems() {
            return items;
        }
    }

    // Report class
    private class Report {
        private List<MenuItem> popularItems;

        public Report(List<MenuItem> popularItems) {
            this.popularItems = popularItems;
        }

        public List<MenuItem> getPopularItems() {
            return popularItems;
        }
    }
}
