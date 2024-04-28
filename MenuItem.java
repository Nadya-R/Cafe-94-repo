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
    
    // getter and setter methods of the MenuItem class


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
