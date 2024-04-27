import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Manager extends Staff {


        //constructor
    public Manager (String firstName, String lastName, String address, String postCode) {
        super(firstName, lastName, address, postCode);
    }

        //method to create new chef
    public Chef createChef(String firstName, String lastName, String address, String postCode) {
        return new Chef(firstName, lastName, address, postCode);
    }

    // Method to create a new Waiter
    public Waiter createWaiter(String firstName, String lastName, String address, String postCode) {
        return new Waiter(firstName, lastName, address, postCode);
    }

    }

