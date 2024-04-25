import java.util.List;
public class Customer extends User {
   // I think this is an impliment instead

   private static int counter = 1;
   private int customerId;
   private List<Order> previousOrders;

   // constructor
   public Customer(String firstName, String lastName, String address, String postCode) {
      super(firstName, lastName, address, postCode); // Call the constructor of the superclass to initialize fields
      customerId = generateId();
   }

   // set id
   private static int generateId() {
      // possibly needs to be synchronized
      return counter++;
   }

   // get id
   public int getCustomerId() {
      return customerId;
   }
   //create order, might be best to do 4 different order creation methods
   public  Order createOrder () {
      return new Order();
   }
   //add to previous orders list
   public void addPreviousOrder(Order order) {
      previousOrders.add(order);
  }
//Show order history
  public List<Order> getOrderHistory() {
      return previousOrders;
  }
}
