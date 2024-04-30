/**
 * The Waiter class provides methods to create Staff members.
 * It extends the Staff class and inherits user information.
 * 
 * @author Nadya Roderick
 * @version 1.0
 */

public class Waiter extends Staff {

     /**
     * Constructs a new Waiter object with specified user information.
     * 
     * @param firstName The first name of the waiter.
     * @param lastName The last name of the waiter.
     * @param address The first line of the address of the waiter.
     * @param postCode The postal code of the waiter.
     */
    public Waiter(String firstName, String lastName, String address, String postCode) {
        super(firstName, lastName, address, postCode);


    }
}
