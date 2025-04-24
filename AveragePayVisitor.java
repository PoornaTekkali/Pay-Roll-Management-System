// AveragePayVisitor.java

// This class implements the EmployeeVisitor interface to calculate the average pay of different types of employees
public class AveragePayVisitor implements EmployeeVisitor {

    // Variables to keep track of total pay for each employee type
    private double totalFullTimePay = 0;
    private double totalPartTimePay = 0;
    private double totalContractPay = 0;

    // Counters to keep track of the number of each employee type
    private int fullTimeCount = 0;
    private int partTimeCount = 0;
    private int contractCount = 0;

    // Visit method for FullTimeEmployee
    // Adds the computed pay to the total and increments the full-time counter
    @Override
    public void visit(FullTimeEmployee employee) {
        totalFullTimePay += employee.computePay();
        fullTimeCount++;
    }

    // Visit method for PartTimeEmployee
    // Adds the computed pay to the total and increments the part-time counter
    @Override
    public void visit(PartTimeEmployee employee) {
        totalPartTimePay += employee.computePay();
        partTimeCount++;
    }

    // Visit method for ContractEmployee
    // Adds the computed pay to the total and increments the contract counter
    @Override
    public void visit(ContractEmployee employee) {
        totalContractPay += employee.computePay();
        contractCount++;
    }

    // Returns the average pay for full-time employees
    // If no full-time employees have been visited, returns 0 to avoid division by zero
    public double getAverageFullTimePay() {
        return fullTimeCount > 0 ? totalFullTimePay / fullTimeCount : 0;
    }

    // Returns the average pay for part-time employees
    // If no part-time employees have been visited, returns 0
    public double getAveragePartTimePay() {
        return partTimeCount > 0 ? totalPartTimePay / partTimeCount : 0;
    }

    // Returns the average pay for contract employees
    // If no contract employees have been visited, returns 0
    public double getAverageContractPay() {
        return contractCount > 0 ? totalContractPay / contractCount : 0;
    }
}
