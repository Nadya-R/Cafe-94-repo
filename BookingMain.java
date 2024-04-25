import java.util.Date;

public class BookingMain {
    public static void main(String[] args) {
        // Example usage of the Booking class
        Date bookingDate = new Date(); // Example date initialization
        Date bookingTime = new Date(); // Example time initialization
        Booking booking = new Booking(4, bookingDate, bookingTime, "12345");

        System.out.println("Number of Guests: " + booking.getNumberOfGuests());
        System.out.println("Booking Date: " + booking.getDate());
        System.out.println("Booking Time: " + booking.getTime());
        System.out.println("Customer ID: " + booking.getCustomerID());
        System.out.println("Status: " + booking.getStatus());
        System.out.println("Total Cost: " + booking.getTotalCost());
        System.out.println("Service: " + booking.getService());

        // You can call other methods as well for demonstration
        System.out.println("Total Cost Calculation: " + booking.calculateTotalCost());
        System.out.println("Service Info: " + booking.provideServiceInfo());
        booking.handleBookingChanges();
    }
}
