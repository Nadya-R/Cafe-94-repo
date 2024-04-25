import java.util.Date;

public class Booking {
    private int numberOfGuests;
    private Date bookingDate;
    private Date bookingTime;
    private int customerID;
    private boolean approved;

    public Booking(int numberOfGuests, Date bookingDate, Date bookingTime, int customerID) {
        this.numberOfGuests = numberOfGuests;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.customerID = customerID;
        this.approved = false;
    }

    // Getters and Setters
    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
