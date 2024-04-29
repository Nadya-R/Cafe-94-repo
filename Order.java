import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
public class Order {
    private List<MenuItem> items;
    public Order() {
        this.items = new ArrayList<>();
    }
    public void addItem(MenuItem item) {
        items.add(item);
    }
    public List<MenuItem> getItems() {
        return items;
    }
    public double getTotal() {
        double total = 0; //put a number format into this code, so it rounds correctly
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void setDeliveryAddress(String address) {
    }

    public void setEstimatedDeliveryTime(LocalTime localTime) {
    }

    public double getTotalPrice() {
        double total = 0; //put a number format into this code, so it rounds correctly
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }
}

