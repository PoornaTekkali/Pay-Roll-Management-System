import java.util.ArrayList;

public class PayrollApplication {

    public static void main(String[] args) {
        // Create a collection of 9 different employees
        ArrayList<Employee> employees = createEmployeeCollection();

        // Compute the payrolls for the collection of employees and show the computation
        // result
        for (Employee employee : employees) {
            System.out.println(employee.getFirstName() + " " + employee.getLastName() + ": $" + employee.computePay());
        }

        // Show Average Period Pay for full-time, part-time, and contract employees
        AveragePayVisitor averagePayVisitor = new AveragePayVisitor();
        for (Employee employee : employees) {
            employee.accept(averagePayVisitor);
        }
        System.out.println("Average Pay: ");
        System.out.println("Full Time: $" + averagePayVisitor.getAverageFullTimePay());
        System.out.println("Part Time: $" + averagePayVisitor.getAveragePartTimePay());
        System.out.println("Contract: $" + averagePayVisitor.getAverageContractPay());

        // Show Range of Period Pay for full-time, part-time, and contract employees
        RangePayVisitor rangePayVisitor = new RangePayVisitor();
        for (Employee employee : employees) {
            employee.accept(rangePayVisitor);
        }
        System.out.println("Range of Pay: ");
        System.out.println(
                "Full Time: $" + rangePayVisitor.getMinFullTimePay() + " - $" + rangePayVisitor.getMaxFullTimePay());
        System.out.println(
                "Part Time: $" + rangePayVisitor.getMinPartTimePay() + " - $" + rangePayVisitor.getMaxPartTimePay());
        System.out.println(
                "Contract: $" + rangePayVisitor.getMinContractPay() + " - $" + rangePayVisitor.getMaxContractPay());
    }

    // Create a collection of 9 different employees
    private static ArrayList<Employee> createEmployeeCollection() {
        ArrayList<Employee> employees = new ArrayList<>();

        // Full-time employees
        employees.add(new FullTimeEmployee("Peter", "Jack", 30, 24.0));
        employees.add(new FullTimeEmployee("Damon", "Leme", 35, 22.0));
        employees.add(new FullTimeEmployee("Olive", "smith", 72, 25.0));

        // Part-time employees
        employees.add(new PartTimeEmployee("Michel", "Thor", 40, 12.0));
        employees.add(new PartTimeEmployee("Bean", "Jackson", 8, 14.0));
        employees.add(new PartTimeEmployee("Rachel", "John", 12, 11.0));

        // Contract employees
        employees.add(new ContractEmployee("Ricky", "Bell", 36, 23.0));
        employees.add(new ContractEmployee("Amelia", "Sophie", 32, 42.0));
        employees.add(new ContractEmployee("Daisy", "Koia", 37, 48.0));

        return employees;
    }
}