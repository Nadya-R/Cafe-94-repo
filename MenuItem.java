// MenuItem class
public class MenuItem {
    private String itemName;
    private String description;
    private double price;
    private boolean dailySpecials;

    public MenuItem(String itemName, String description, double price, boolean dailySpecials) {
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.dailySpecials = dailySpecials;
    }
    
    // getter and setter methods of the MenuItem class
    public boolean isSpecial() {
        return dailySpecials;
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
