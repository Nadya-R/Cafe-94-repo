import java.util.*;
import java.util.stream.Collectors;

// Menu class 
public class Menu {
    private List<MenuItem> menuItems;
    private List<Order> allOrders;
    private List<MenuItem> dailySpecials;

    public Menu() {
        this.menuItems = new ArrayList<>();
    }

    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    public void removeMenuItem(MenuItem item) {
        menuItems.remove(item);
    }

    public void updateMenuItem(MenuItem item) {
        // Add logic to update menu item
    }

    public List<MenuItem> getMenuItems() {
        return new ArrayList<>(menuItems);
    }

    public void addDailySpecial(MenuItem item) {
        dailySpecials.add(item);
    }

    public void removeDailySpecial(MenuItem item) {
        dailySpecials.remove(item);
    }

    public List<MenuItem> getDailySpecials() {
        return new ArrayList<>(dailySpecials);
    }

    //public Report generatePopularItemsReport() { commented out because wouldn't complie
        
        //return new Report();
    //}

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
