/* javac Delivery.java
 * java Delivery. java
 * Type Done to finish and get your bill to pay then.
 */


 import java.text.ParseException;
 import java.text.SimpleDateFormat;
 import java.util.ArrayList;
 import java.util.Date;
 import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.*;

 
 class DeliveryOrder {
    private String itemName;
    private String itemVersion;
    private Date orderDate;
    private double price;
    private double bill;
    private String customer;
    private String postcode;
    private boolean paid;

    public DeliveryOrder(String itemName, String itemVersion, Date orderDate, double price, String customer, String postcode, boolean paid) {
        this.itemName = itemName;
        this.itemVersion = itemVersion;
        this.orderDate = orderDate;
        this.price = price;
        this.bill = price;
        this.customer = customer;
        this.postcode = postcode;
        this.paid = paid;
    }

    // Getters and setters
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemVersion() {
        return itemVersion;
    }

    public void setItemVersion(String itemVersion) {
        this.itemVersion = itemVersion;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        this.bill = price;
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}

class DeliverySystem {
    private List<DeliveryOrder> orders;
    private Map<String, Double> predefinedPrices;

    public DeliverySystem() {
        this.orders = new ArrayList<>();
        this.predefinedPrices = new HashMap<>();
        // Initialize predefined prices for some items
        predefinedPrices.put("burger", 5.0);
        predefinedPrices.put("pizza", 10.0);
        predefinedPrices.put("sandwich", 7.0);
    }

    public void addDeliveryOrder(String itemName, String itemVersion, Date orderDate, String customer, String postcode, boolean paid) {
        // Look up the price for the given item name
        Double price = predefinedPrices.getOrDefault(itemName.toLowerCase(), 0.0);
        if (price == 0.0) {
            System.out.println("Item '" + itemName + "' is not available in the predefined list. Please enter the price manually.");
            return;
        }
        DeliveryOrder order = new DeliveryOrder(itemName, itemVersion, orderDate, price, customer, postcode, paid);
        orders.add(order);
    }

    public void deliverOrder(String itemName, String customer) {
        for (DeliveryOrder order : orders) {
            if (order.getItemName().equalsIgnoreCase(itemName)) {
                System.out.println("Delivery " + order.getItemName() + " " + order.getItemVersion() + " to " + customer + " on " + order.getOrderDate() + " for £" + order.getPrice());
                return;
            }
        }
        System.out.println("Delivery " + itemName + " not found");
    }

    public double TotalBill(String customer) {
        double total = 0;
        for (DeliveryOrder order : orders) {
            if (order.getBill() > 0 && order.getCustomer().equalsIgnoreCase(customer)) {
                total = total + order.getBill();
            }
        }
        return total;
    }

    // Getter for orders list
    public List<DeliveryOrder> getOrders() {
        return orders;
    }
}

public class Delivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a new delivery system
        DeliverySystem deliverySystem = new DeliverySystem();

        // Prompt the user to add delivery orders
        System.out.println("Add delivery orders (type 'done' to finish):");
        String itemName;
        String itemVersion;
        Date orderDate;
        String customer;
        String postcode;
        boolean paid;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        while (true) {
            System.out.print("Item name: ");
            itemName = scanner.nextLine();
            if (itemName.equalsIgnoreCase("done")) {
                break;
            }
            System.out.print("Item version: ");
            itemVersion = scanner.nextLine();
            System.out.print("Order date (YYYY-MM-DD): ");
            try {
                orderDate = dateFormat.parse(scanner.nextLine());
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format.");
                continue;
            }
            System.out.print("Customer: ");
            customer = scanner.nextLine();
            System.out.print("Postcode: ");
            postcode = scanner.nextLine();
            System.out.print("Paid? (true/false): ");
            paid = scanner.nextBoolean();
            // Add the delivery order to the system
            deliverySystem.addDeliveryOrder(itemName, itemVersion, orderDate, customer, postcode, paid);
        }

        // Deliver orders to recipients
        System.out.println("Delivering orders:");
        for (DeliveryOrder order : deliverySystem.getOrders()) {
            System.out.println("Delivery " + order.getItemName() + " " + order.getItemVersion() + " to " + order.getCustomer() + " on " + dateFormat.format(order.getOrderDate()) + " for £" + order.getPrice() + " to postcode " + order.getPostcode() + ", Paid: " + order.isPaid());
        }

        // Calculate the total bill for each customer
        System.out.println("Total bill for each customer:");
        List<String> customers = new ArrayList<>();
        for (DeliveryOrder order : deliverySystem.getOrders()) {
            String currentCustomer = order.getCustomer();
            if (!customers.contains(currentCustomer)) {
                customers.add(currentCustomer);
                double totalBill = deliverySystem.TotalBill(currentCustomer);
                System.out.println(currentCustomer + ": £" + totalBill);
            }
        }

        scanner.close();
    }
}