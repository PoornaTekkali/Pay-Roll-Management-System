public class RangePayVisitor implements EmployeeVisitor {
    private double minFullTimePay = Double.MAX_VALUE;
    private double maxFullTimePay = Double.MIN_VALUE;
    private double minPartTimePay = Double.MAX_VALUE;
    private double maxPartTimePay = Double.MIN_VALUE;
    private double minContractPay = Double.MAX_VALUE;
    private double maxContractPay = Double.MIN_VALUE;

    @Override
    public void visit(FullTimeEmployee employee) {
        double pay = employee.computePay();
        minFullTimePay = Math.min(minFullTimePay, pay);
        maxFullTimePay = Math.max(maxFullTimePay, pay);
    }

    @Override
    public void visit(PartTimeEmployee employee) {
        double pay = employee.computePay();
        minPartTimePay = Math.min(minPartTimePay, pay);
        maxPartTimePay = Math.max(maxPartTimePay, pay);
    }

    @Override
    public void visit(ContractEmployee employee) {
        double pay = employee.computePay();
        minContractPay = Math.min(minContractPay, pay);
        maxContractPay = Math.max(maxContractPay, pay);
    }

    public double getMinFullTimePay() {
        return minFullTimePay;
    }

    public double getMaxFullTimePay() {
        return maxFullTimePay;
    }

    public double getMinPartTimePay() {
        return minPartTimePay;
    }

    public double getMaxPartTimePay() {
        return maxPartTimePay;
    }

    public double getMinContractPay() {
        return minContractPay;
    }

    public double getMaxContractPay() {
        return maxContractPay;
    }
}
