// PartTimeEmployee.java
public class PartTimeEmployee extends Employee {

    private double hourlyRate;

    public PartTimeEmployee(String firstName, String lastName, int totalHours, double hourlyRate) {
        super(firstName, lastName, totalHours);
        this.hourlyRate = hourlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    @Override
    public void accept(EmployeeVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public double computePay() {
        return getTotalHours() * getHourlyRate();
    }

    // Add the getHoursWorked() method
    public int getHoursWorked() {
        return getTotalHours();
    }
}
