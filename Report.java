/**
 * The Report class provides methods intended for creating and maintaining
 * reports
 * however this part of the system was not built
 * 
 * @author SHARATH IPPAKAYALA
 */

public class Report {
    private String reportTitle;
    private String reportTitle2;
    private String date;
    private String generatedBy;
    private String mostPopularItems;
    private String busiestPeriods;
    private String mostActiveCustomer;
    private String highestHoursWorked;
    private String additionalNotes;
    private String endOfReportCard;

    public Report(String reportTitle, String reportTitle2, String date, String generatedBy,
            String mostPopularItems, String busiestPeriods, String mostActiveCustomer,
            String highestHoursWorked, String additionalNotes, String endOfReportCard) {
        this.reportTitle = reportTitle;
        this.reportTitle2 = reportTitle2;
        this.date = date;
        this.generatedBy = generatedBy;
        this.mostPopularItems = mostPopularItems;
        this.busiestPeriods = busiestPeriods;
        this.mostActiveCustomer = mostActiveCustomer;
        this.highestHoursWorked = highestHoursWorked;
        this.additionalNotes = additionalNotes;
        this.endOfReportCard = endOfReportCard;
    }

    // Getters and Setters
    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public String getReportTitle2() {
        return reportTitle2;
    }

    public void setReportTitle2(String reportTitle2) {
        this.reportTitle2 = reportTitle2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(String generatedBy) {
        this.generatedBy = generatedBy;
    }

    public String getMostPopularItems() {
        return mostPopularItems;
    }

    public void setMostPopularItems(String mostPopularItems) {
        this.mostPopularItems = mostPopularItems;
    }

    public String getBusiestPeriods() {
        return busiestPeriods;
    }

    public void setBusiestPeriods(String busiestPeriods) {
        this.busiestPeriods = busiestPeriods;
    }

    public String getMostActiveCustomer() {
        return mostActiveCustomer;
    }

    public void setMostActiveCustomer(String mostActiveCustomer) {
        this.mostActiveCustomer = mostActiveCustomer;
    }

    public String getHighestHoursWorked() {
        return highestHoursWorked;
    }

    public void setHighestHoursWorked(String highestHoursWorked) {
        this.highestHoursWorked = highestHoursWorked;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public String getEndOfReportCard() {
        return endOfReportCard;
    }

    public void setEndOfReportCard(String endOfReportCard) {
        this.endOfReportCard = endOfReportCard;
    }

}
