//this will provide a list of hours worked.
//a function to add hours worked 
//view of how many hours work out agreed hours
//to work

//each member of staff will be able to access use addHours function etc.
import java.util.ArrayList;

public class Staff extends User {
    private double hoursToWork;
    private double shiftHours; //may not be necessary

    //hours worked list
    private ArrayList<Double> hoursWorked;
    private ArrayList<Double> overTimeWorked;



    // basic constructor in order to use this class as a super
    Staff() {

    }

    //set hours to work 
public void setHours (double hours) {

    System.out.println("message here- will it be viewed though");
    hoursToWork = hours;
}

public void addHoursWorked (double hours) {
    double sum = 0;
    //tally total in 
    for (double num : hoursWorked) {
        sum += num;

        //if (sum > hoursToWork) (
           // add
        //)
    }

}
   
    //is it possible to change these or wipe these each month
    //set hours worked

}
