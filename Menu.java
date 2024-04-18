import java.util.ArrayList;
import java.util.List;

// Menu class
public class Menu {
    private List<MenuItem> menuItems;
    private List<MenuItem> dailySpecials;

    public Menu() {
        this.menuItems = new ArrayList<>();
        this.dailySpecials = new ArrayList<>();
    }

    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    public void removeMenuItem(MenuItem item) {
        menuItems.remove(item);
    }

    public void updateMenuItem(MenuItem item) {
       
    }

    public List<MenuItem> getDailySpecials() {
        return new ArrayList<>(dailySpecials);
    }

    public Report generatePopularItemsReport() {
        
        return new Report();
    }


}
