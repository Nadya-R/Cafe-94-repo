import java.util.Date;

public class Booking {
    private int numberOfGuests;
    private Date bookingDate;
    private Date bookingTime;
    private String customerID;
    private String status;
    private double totalCost;
    private String service;

    public Booking(int numberOfGuests, Date bookingDate, Date bookingTime, String customerID) {
        this.numberOfGuests = numberOfGuests;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.customerID = customerID;
        this.status = "Pending";
        this.totalCost = 0.0;
        this.service = "";
    }
    
    // Getters and Setters
    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public Date getDate() {
        return bookingDate;
    }

    public void setDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getTime() {
        return bookingTime;
    }

    public void setTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    // Other Methods
    public double calculateTotalCost() {
        // Implement your calculation logic here
        return totalCost;
    }

    public String provideServiceInfo() {
        // Implement your service information logic here
        return "";
    }

    public void handleBookingChanges() {
        // Implement logic to handle booking changes
    }
}
