// MenuItem class
public class MenuItem {
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
