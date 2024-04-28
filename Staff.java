//this will provide a list of hours worked.
//a function to add hours worked 
//view of how many hours work out agreed hours
//to work

//each member of staff will be able to access use addHours function etc.
import java.util.ArrayList;

public class Staff extends User {
    private double hoursToWork;
    // private double shiftHours; //may not be necessary

    // hours worked list
    private ArrayList<Double> hoursWorked;
    private ArrayList<Double> overTimeWorked;

        //default constructor in order to extend to subclasses
    public Staff() {
        // Default constructor
    }

    public Staff (String firstName, String lastName, String address, String postCode) {
        super(firstName, lastName, address, postCode);;
    }

    // constructor in order to use this class as a super
    //public Staff (String firstName, String lastName, String address, String postCode) {
       // super(firstName, lastName, address, postCode);;
        //hoursWorked = new ArrayList<>();
        //overTimeWorked = new ArrayList<>();
   // }


    // set hours to work for the month or whatever
    public void setHours(double hours) {

        System.out.println("message here- will it be viewed though");
        hoursToWork = hours;
    }

    // Staff would add their hours worked at the end of the shift
    public void addHoursWorked(double hours) {
        hoursWorked.add(hours);
        //double sum = 0.0;
        // tally total in
       // for (double num : hoursWorked) {
           // sum += num;

            //if (sum >= hoursToWork) {
              //  overTimeWorked.add(hours);
            //} else {
              //  hoursWorked.add(hours);
            //}
        //}
    }

    //methid to get total hours worked
    public double getTotalHoursWorked () {
        double totalHours = 0.0;
        for (double num : hoursWorked) {
            totalHours += num;
        }
        return totalHours;
    }

    //total hours worked 
    public String toString1(){
        String str = "total hours worked ";
        return str + getTotalHoursWorked();
    }


    // is it possible to change these or wipe these each month
    // set hours worked

}
