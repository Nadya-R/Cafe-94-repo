import java.util.Date;

public class BookingMain {
    public static void main(String[] args) {
        // Example usage of the Booking class
        Booking booking = new Booking(4, new Date(), new Date(), 12345);
        
        System.out.println("Number of Guests: " + booking.getNumberOfGuests());
        System.out.println("Booking Date: " + booking.getBookingDate());
        System.out.println("Booking Time: " + booking.getBookingTime());
        System.out.println("Customer ID: " + booking.getCustomerID());
        System.out.println("Approved: " + booking.isApproved());
    }
}
