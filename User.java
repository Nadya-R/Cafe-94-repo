/**
 * The User class is provides methods for gathering data for all
 * classes within the User hierarchy.
 * 
 * @author Nadya Roderick
 * @version 1.0
 */
public class User {

    // fields
    private String firstName;
    private String lastName;
    private String addressFirstLine;
    private String postCode;

    // constructors

    /**
     * default User constructor
     */
    public User() {

    }

    /**
     * Constructs a new User object with specified user information.
     * Useful for customer creation.
     * 
     * @param firstName
     * @param lastName
     * @param address
     * @param postCode
     */

    public User(String firstName, String lastName, String address, String postCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        addressFirstLine = address;
        this.postCode = postCode;
    }

    // accessor methods
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return addressFirstLine;
    }

    public String getPostCode() {
        return postCode;
    }

}
