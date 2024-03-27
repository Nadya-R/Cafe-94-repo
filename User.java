/*
 * Javadoc will go here?
 * comment for now- this class will provide user information functions
 * other classses will inherit from this
 */
//import java.util.ArrayList;
public class User {
    private String firstName;
    private String lastName;
    private String addressFirstLine;
    private String postCode;

    // constructors

    // default
    public User() {

    }

    // constructor that gathers all user information. Usful for customer creation
    public User(String firstName, String lastName, String address, String postCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        addressFirstLine = address;
        this.postCode = postCode;
    }
    //must check whetehr this type of constructor overloading is appropraite for different user types ********
    //constructor that gathers user names. usful for staff creation.
    public User (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // accessors
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

    // mutators ***possibly not needed if set during the constructor? Only necessary for changing details.
    //public void setFirstName(String firstName) {
       // this.firstName = firstName;
   // }

    //remove user, does this go here or in the manager? ********
    //read through the spec, to determine whther a customer can delete their account********
}
