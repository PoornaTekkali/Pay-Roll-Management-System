// Employee.java
public abstract class Employee {
    private String firstName;
    private String lastName;
    protected int totalHours;

    // Constructor
    public Employee(String firstName, String lastName, int totalHours) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalHours = totalHours;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getTotalHours() {
        return totalHours;
    }

    // Abstract methods to be implemented by subclasses
    public abstract double computePay();

    public abstract void accept(EmployeeVisitor visitor);
}
