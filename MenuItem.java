
// MenuItem class
public class MenuItem {
    private String itemName;
    private String description;
    private double price;

    public MenuItem(String itemName, String description, double price) {
        this.itemName = itemName;
        this.description = description;
        this.price = price;
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
}