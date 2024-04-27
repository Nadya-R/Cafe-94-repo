import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ManagerController {


    @FXML
    private Label name;  // Make sure to properly annotate the variables with @FXML
    @FXML
    private Label address;
    @FXML
    private Label postCode;

    public void initialize() {
        // Fetch manager's information using the constructor
        Manager manager = new Manager("Peter", "Parker", "20 Ingram St.", "NY");


        // Get manager's information from the User superclass
        String managerName = manager.getFirstName() + " " + manager.getLastName();
        String managerAddress = manager.getAddress();
        String managerPotCode = manager.getPostCode();

        name.setText(managerName);
        address.setText(managerAddress);
        postCode.setText(managerPotCode);
    }

}
