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
        return 0;
    }

    public void setDeliveryAddress(String deliveryAddress) {
    }

    public void setCompleted(boolean b) {
    }
}
