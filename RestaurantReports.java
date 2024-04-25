import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RestaurantReports {

    public static void main(String[] args) {

        // Replace with actual data retrieval logic (example for most popular items)
        List<Item> popularItems = new ArrayList<>();
        popularItems.add(new Item(1, "Pizza", 100));
        popularItems.add(new Item(2, "Pasta", 80));
        popularItems.add(new Item(3, "Salad", 50));

        // Similarly, implement methods for other data retrieval (placeholders)
        List<Period> busyPeriods = retrieveBusiestPeriods();
        Customer mostActive = retrieveMostActiveCustomer();
        List<Staff> mostHoursWorked = retrieveStaffHours();

        ReportCard report = new ReportCard(
                "Restaurant Reports", "Generated on " + new Date(), "Your Name", "");

        report.generateMostPopularItemsReport(popularItems);
        report.generateBusiestPeriodsReport(busyPeriods);
        report.generateMostActiveCustomerReport(mostActive.getName()); // Use getName()
        report.printReport();
    }

    // Data structures (replace `String` with appropriate types if needed)
    static class Item {
        int id;
        String name;
        int salesCount;

        public Item(int id, String name, int salesCount) {
            this.id = id;
            this.name = name;
            this.salesCount = salesCount;
        }
    }

    static class Period {
        // Define properties for start time, end time, etc. (replace with your data)
        // For example:
        // Date startTime;
        // Date endTime;
    }

    static class Staff {
        int id;
        String name;
        int totalHoursWorked;

        public Staff(int id, String name, int totalHoursWorked) {
            this.id = id;
            this.name = name;
            this.totalHoursWorked = totalHoursWorked;
        }
    }

    static class Customer {
        int id;
        String name;
        int totalVisits;
        Date lastVisit;

        public Customer(int id, String name, int totalVisits, Date lastVisit) {
            this.id = id;
            this.name = name;
            this.totalVisits = totalVisits;
            this.lastVisit = lastVisit;
        }

        public String getName() {
            return name;
        }
    }

    static class ReportCard {

        private String reportTitle;
        private String reportTitle2;
        private String date;
        private String generatedBy;

        private List<String> mostPopularItems;
        private List<Period> busiestPeriods;
        private String mostActiveCustomer;

        public ReportCard(String reportTitle, String reportTitle2, String date, String generatedBy) {
            this.reportTitle = reportTitle;
            this.reportTitle2 = reportTitle2;
            this.date = date;
            this.generatedBy = generatedBy;
            mostPopularItems = new ArrayList<>();
            busiestPeriods = new ArrayList<>();
        }

        public void generateMostPopularItemsReport(List<Item> popularItems) {
            this.mostPopularItems = new ArrayList<>(); // Clear for each report
            for (Item item : popularItems) {
                this.mostPopularItems.add(item.name);
            }
        }

        public void generateBusiestPeriodsReport(List<Period> periods) {
            this.busiestPeriods = periods; // Assuming periods data is formatted correctly
        }

        public void generateMostActiveCustomerReport(String customerName) {
            this.mostActiveCustomer = customerName;
        }

        public void printReport() {
            System.out.println("Report Title: " + reportTitle);
            System.out.println("Report Title 2: " + reportTitle2);
            System.out.println("Date: " + date);
            System.out.println("Generated By: " + generatedBy);

            if (mostPopularItems != null) {
                System.out.println("Most Popular Items:");
                for (int i = 0; i < mostPopularItems.size(); i++) {
                    System.out.println((i + 1) + ". " + mostPopularItems.