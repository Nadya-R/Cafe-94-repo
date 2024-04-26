public class Table {
    private int tableNumber;
    private int capacity;
    private boolean isOccupied;
    private String customerName;
    private String reservationTime;
 
    public Table(int tableNumber, int capacity, boolean isOccupied, String customerName, String reservationTime) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.isOccupied = isOccupied;
        this.customerName = customerName;
        this.reservationTime = reservationTime;
    }
 
    // Getters and Setters
    public int getTableNumber() {
        return tableNumber;
    }
 
    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }
 
    public int getCapacity() {
        return capacity;
    }
 
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
 
    public boolean isOccupied() {
        return isOccupied;
    }
 
    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
 
    public String getCustomerName() {
        return customerName;
    }
 
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
 
    public String getReservationTime() {
        return reservationTime;
    }
 
    public void setReservationTime(String reservationTime) {
        this.reservationTime = reservationTime;
    }
}
