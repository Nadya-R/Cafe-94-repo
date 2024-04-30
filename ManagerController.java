import javafx.fxml.FXML;
import javafx.scene.control.Label;

/*
 * The ManagerController displays manager details in the ManagerScene.fxml and 
 * ManagerProfiles
 */
public class ManagerController {

    @FXML
    private Label name;
    @FXML
    private Label address;
    @FXML
    private Label postCode;

    /**
     * Initializes the ManagerController, setting the labels with manager
     * information.
     */
    public void initialize() {

        // creates an instance of manager
        Manager manager = new Manager("Peter", "Parker", "20 Ingram St.", "NY");

        // Get manager's information from the User superclass
        String managerName = manager.getFirstName() + " " + manager.getLastName();
        String managerAddress = manager.getAddress();
        String managerPotCode = manager.getPostCode();

        // sets labels wih manager information
        name.setText(managerName);
        address.setText(managerAddress);
        postCode.setText(managerPotCode);
    }

}
