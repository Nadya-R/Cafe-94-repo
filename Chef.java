/**
 * The chef class provides a constructor for creating this type of staff.
 * This class is part of the User hierarchy and extends the Staff class
 * 
 * <p>
 * Chef objects inherit properties and methods from the Staff class.
 * These properties incldue first name, last name, address, and postcode
 * </p>
 * 
 * @author Nadya Roderick
 * @version 1.0
 */
public class Chef extends Staff {

    /**
     * Constructs a Chef object with the following attributes.
     * 
     * @param firstName the first name of the chef
     * @param lastName  the last name of the chef
     * @param address   the address of the chef
     * @param postCode  the postal code of the chef
     */

    public Chef(String firstName, String lastName, String address, String postCode) {
        super(firstName, lastName, address, postCode);
    }

}
