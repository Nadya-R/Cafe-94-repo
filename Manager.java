import javafx.fxml.FXML;

/**
 * The manager class contains methods providing behaviors to parts of the system
 * that the manager would interact with such as creating staff. It extends 
 * the Staff class
 * 
 * <p>
 * please note that this is not a complete system and some methods that
 * one would expect from a full system ay be missing
 * </p>
 * 
 * @author Nadya Roderick
 */

public class Manager extends Staff {

    private static Manager instance;

     /**
     * Private constructor to prevent direct instantiation of Manager objects.
     */
    private Manager() {

    }

   /**
     * Constructs a new Manager object with the specified details.
     *
     * @param firstName the first name of the manager
     * @param lastName  the last name of the manager
     * @param address   the address of the manager
     * @param postCode  the postal code of the manager's address
     */
    public Manager(String firstName, String lastName, String address, String postCode) {
        super(firstName, lastName, address, postCode);
    }

     /**
     * Retrieves the singleton instance of the Manager class.
     *
     * @return the singleton instance of Manager
     */

    @FXML
    public static Manager getInstance() {
        if (instance == null) {
            instance = new Manager();
        }
        return instance;
    }

     /**
     * Creates a new Chef staff member with the specified details.
     *
     * @param firstName the first name of the chef
     * @param lastName  the last name of the chef
     * @param address   the address of the chef
     * @param postCode  the postal code of the chef's address
     * @return the created Chef object
     */
    public Chef createChef(String firstName, String lastName, String address, String postCode) {
        Chef chef = new Chef(firstName, lastName, address, postCode);
        addStaffMember(chef);
        return chef;

    }

     /**
     * Creates a new Waiter staff member.
     *
     * @param firstName the first name of the waiter
     * @param lastName  the last name of the waiter
     * @param address   the address of the waiter
     * @param postCode  the postal code of the waiter's address
     * @return the created Waiter object
     */
    public Waiter createWaiter(String firstName, String lastName, String address, String postCode) {
        Waiter waiter = new Waiter(firstName, lastName, address, postCode);
        addStaffMember(waiter);
        return waiter;
    }

}
