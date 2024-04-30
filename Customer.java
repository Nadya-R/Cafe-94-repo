import java.util.List;

/**
 * The Customer class was intended to represent a registered customer using the
 * System and
 * provide methods for their interaction with the System, however this side of
 * the System was never built.
 * 
 * <p>
 * This class extends the User class to inherit methods that gather basic user
 * information.
 * This class includes methods designed for customers to interact with the
 * system, such as
 * creating orders and accessing order history
 * </p>
 * 
 * @author Nadya Roderick
 */
public class Customer extends User {

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

   // create order
   public Order createTakeAway() {
      return new TakeOut();
   }

   // add to previous orders list
   public void addPreviousOrder(Order order) {
      previousOrders.add(order);
   }

   // Show order history
   public List<Order> getOrderHistory() {
      return previousOrders;
   }

}
