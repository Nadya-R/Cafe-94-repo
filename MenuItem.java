/**
 * The MenuItem represents a single item and is used to build the menu
 * 
 * @author HARI SAI AKHIL PAMARTHI
 */
public class MenuItem {
    private String itemName;
    private String description;
    private double price;
    private boolean dailyspecial;

    /**
     * Constructs a new MenuItem with the specified name, description, and price.
     *
     * @param itemName    the name of the menu item
     * @param description the description of the menu item
     * @param price       the price of the menu item
     */
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

    public boolean isDailyspecial() {
        return dailyspecial;
    }

    public boolean isPressed() {
        return true;
    }
}
