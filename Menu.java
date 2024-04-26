
import java.util.*;
import java.util.stream.Collectors;


// Menu And MenuItems are in same file
// Menu class
public class Menu {
    private List<MenuItem> menuItems;
    private List<Order> allOrders;

    public Menu() {
        this.menuItems = new ArrayList<>();
        this.allOrders = new ArrayList<>();
    }

    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    public void removeMenuItem(MenuItem item) {
        menuItems.remove(item);
    }

    public void updateMenuItem(MenuItem item) {
        for (MenuItem menuItem : menuItems) {
            if (menuItem.getItemName().equals(item.getItemName())) {
                menuItem.setDescription(item.getDescription());
                menuItem.setPrice(item.getPrice());
                break;
            }
        }
    }

    // To get daily speacial items 
    public List<MenuItem> getDailySpecials() {
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

    // MenuItem class
    private class MenuItem {
        private String itemName;
        private String description;
        private double price;
        private boolean special;

        public MenuItem(String itemName, String description, double price, boolean special) {
            this.itemName = itemName;
            this.description = description;
            this.price = price;
            this.special = special;
        }
        
        // getter and setter methods of the MenuItem class
        public boolean isSpecial() {
            return special;
        }

        public String getItemName() {
            return itemName;
        }

        public String getDescription() {
            return description;
        }

        public double getPrice() {
            return price;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setPrice(double price) {
            this.price = price;
        }
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
