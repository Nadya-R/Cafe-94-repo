public class Chef extends Staff {
    private double FoodPrepTime = 15.00;
    public void setFoodPrepTime(double foodPrepTime) {
        FoodPrepTime = foodPrepTime;
    }
    public double getFoodPrepTime() {
        return FoodPrepTime;
    }
    public void completeOrder(Order order) {
        // Logic to mark the order as completed
        order.setCompleted(true);
        System.out.println("Order completed by chef.");
    }
}
 