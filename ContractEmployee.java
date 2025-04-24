// ContractEmployee.java
public class ContractEmployee extends Employee {

    private double contractPay;

    public ContractEmployee(String firstName, String lastName, int totalHours, double contractPay) {
        super(firstName, lastName, totalHours);
        this.contractPay = contractPay;
    }

    @Override
    public void accept(EmployeeVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public double computePay() {
        return contractPay;
    }
}
