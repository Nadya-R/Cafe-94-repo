/*
 * references
 * https://www.digitalocean.com/community/tutorials/java-singleton-design-pattern-best-practices-examples
 * */

 import javafx.fxml.FXML;
 import javafx.fxml.FXMLLoader;
 import javafx.scene.Node;
 import javafx.scene.Parent;
 import javafx.scene.Scene;
 import javafx.stage.Stage;
 
 import java.util.List;
 
 public class Manager extends Staff {
 
     private static Manager instance;
 
     // Private constructor to prevent instantiation
     private Manager() {
 
     }
 
     //constructor
     public Manager(String firstName, String lastName, String address, String postCode) {
         super(firstName, lastName, address, postCode);
     }
 @FXML
     // Static method to obtain the singleton instance
     public static Manager getInstance() {
         if (instance == null) {
             instance = new Manager();
         }
         return instance;
     }
 
     //method to create new chef
     public Chef createChef(String firstName, String lastName, String address, String postCode) {
         Chef chef = new Chef(firstName, lastName, address, postCode);
         addStaffMember(chef);
         return chef;
 
     }
 
 
     // Method to create a new Waiter
     public Waiter createWaiter(String firstName, String lastName, String address, String postCode) {
         Waiter waiter = new Waiter(firstName, lastName, address, postCode);
         addStaffMember(waiter);
         return waiter;
     }
 
 }
 
 