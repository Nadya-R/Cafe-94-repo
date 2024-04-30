import java.util.ArrayList;
import java.util.List;

/**
 * The staff class providesmethods required for creating and maintianing
 * staff members. It extends the user class and inherits methods for accessing
 * personal data from the User class
 * 
 * <p>
 * please note: the System is incomplete and lacks methods and variables
 * pertaining to working hours
 * </p>
 * @author Nadya Roderick
 */
public class Staff extends User {
    // declaring a list to store all instances of staff
    private static List<Staff> staffList = new ArrayList<>();

    /**
     * Constructs a new Staff object with default values.
     * This constructor is provided to extend to subclasses.
     */
    public Staff() {
    }

    /**
     * Constructs a new Staff object with specified details.
     *
     * @param firstName the first name of the staff member
     * @param lastName  the last name of the staff member
     * @param address   the address of the staff member
     * @param postCode  the postal code of the staff member's address
     */
    public Staff(String firstName, String lastName, String address, String postCode) {
        super(firstName, lastName, address, postCode);

    }

    public static void addStaffMember(Staff staffMember) {
        staffList.add(staffMember);
    }

    // Method to get the list of staff members
    public static List<Staff> getStaffList() {
        return staffList;
    }

    /**
     * Displays the list of staff members.
     */
    public static void showStaffList() {
        System.out.println("Staff List:");
        for (Staff staffMember : staffList) {
            System.out.println("Name: " + staffMember.getFirstName() + " " + staffMember.getLastName());
            System.out.println("Address: " + staffMember.getAddress());
            System.out.println("Post Code: " + staffMember.getPostCode());
            System.out.println();
        }

    }

}
