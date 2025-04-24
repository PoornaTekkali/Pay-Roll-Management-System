// FullTimeEmployee.java
public class FullTimeEmployee extends Employee {
    private double hourlyRate;

    public FullTimeEmployee(String firstName, String lastName, int totalHours, double hourlyRate) {
        super(firstName, lastName, totalHours);
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double computePay() {
        return hourlyRate * totalHours;
    }

    @Override
    public void accept(EmployeeVisitor visitor) {
        visitor.visit(this);
    }
}
