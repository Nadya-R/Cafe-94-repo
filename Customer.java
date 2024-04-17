public class Customer extends User {
   // I think this is an impliment instead

   private static int counter = 1;
   private int customerId;

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

   // view preious orders
}
