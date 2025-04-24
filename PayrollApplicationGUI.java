
// PayrollApplication.java
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PayrollApplicationGUI {
    private static JTextArea outputArea;

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Payroll Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        // Create a panel for the components
        JPanel panel = new JPanel();

        // Create buttons
        JButton computeButton = new JButton("Compute Payroll");
        JButton averagePayButton = new JButton("Average Pay");
        JButton rangePayButton = new JButton("Range Pay");

        // Create an output area
        outputArea = new JTextArea(15, 40);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Add action listeners to the buttons
        computeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                computePayroll();
            }
        });

        averagePayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                computeAveragePay();
            }
        });

        rangePayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                computeRangePay();
            }
        });

        // Add components to the panel
        panel.add(computeButton);
        panel.add(averagePayButton);
        panel.add(rangePayButton);
        panel.add(scrollPane);

        // Add the panel to the frame
        frame.getContentPane().add(panel);

        // Make the frame visible
        frame.setVisible(true);
    }

    private static void computePayroll() {
        // Compute and display payroll for all employees
        ArrayList<Employee> employees = createEmployeeCollection();

        StringBuilder result = new StringBuilder();
        result.append("Payroll for Full-Time Employees:\n");
        for (Employee employee : employees) {
            if (employee instanceof FullTimeEmployee) {
                result.append(employee.getFirstName()).append(" ").append(employee.getLastName())
                        .append(": $").append(employee.computePay()).append("\n");
            }
        }

        result.append("\nPayroll for Part-Time Employees:\n");
        for (Employee employee : employees) {
            if (employee instanceof PartTimeEmployee) {
                result.append(employee.getFirstName()).append(" ").append(employee.getLastName())
                        .append(": $").append(employee.computePay()).append("\n");
            }
        }

        result.append("\nPayroll for Contract Employees:\n");
        for (Employee employee : employees) {
            if (employee instanceof ContractEmployee) {
                result.append(employee.getFirstName()).append(" ").append(employee.getLastName())
                        .append(": $").append(employee.computePay()).append("\n");
            }
        }

        displayResults(result.toString());
    }

    private static void computeAveragePay() {
        // Compute and display average pay for all employees
        ArrayList<Employee> employees = createEmployeeCollection();
        AveragePayVisitor averagePayVisitor = new AveragePayVisitor();
        for (Employee employee : employees) {
            employee.accept(averagePayVisitor);
        }
        displayResults("Average Pay:\n" +
                "Full Time: $" + averagePayVisitor.getAverageFullTimePay() + "\n" +
                "Part Time: $" + averagePayVisitor.getAveragePartTimePay() + "\n" +
                "Contract: $" + averagePayVisitor.getAverageContractPay() + "\n");
    }

    private static void computeRangePay() {
        // Compute and display range pay for all employees
        ArrayList<Employee> employees = createEmployeeCollection();
        RangePayVisitor rangePayVisitor = new RangePayVisitor();
        for (Employee employee : employees) {
            employee.accept(rangePayVisitor);
        }
        displayResults("Range of Pay:\n" +
                "Full Time: $" + rangePayVisitor.getMinFullTimePay() + " - $" + rangePayVisitor.getMaxFullTimePay()
                + "\n" +
                "Part Time: $" + rangePayVisitor.getMinPartTimePay() + " - $" + rangePayVisitor.getMaxPartTimePay()
                + "\n" +
                "Contract: $" + rangePayVisitor.getMinContractPay() + " - $" + rangePayVisitor.getMaxContractPay()
                + "\n");
    }

    private static void displayResults(String results) {
        // Display the result in the output area
        outputArea.setText(results);
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
