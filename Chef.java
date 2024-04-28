public class Chef extends Staff {
    private double FoodPrepTime = 15.00;


        //constructor
    public Chef(String firstName, String lastName, String address, String postCode) {
        super(firstName, lastName, address, postCode);
    }

    public void setFoodPrepTime(double foodPrepTime) {
        FoodPrepTime = foodPrepTime;
    }

    public double getFoodPrepTime() {
        return FoodPrepTime;
    }

    //completed order
}
