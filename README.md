# Payroll Management System in Java

## 📘 Description

This Java application is a payroll management system that models three types of employees — **Full-Time**, **Part-Time**, and **Contract** — and computes:

- 💵 **Average Pay**
- 📊 **Pay Range (Min & Max)**
- 🧾 **Individual Payroll**

It uses two fundamental **Object-Oriented Design Patterns**:
- **Visitor Pattern**: To separate pay computation logic from employee classes.
- **Iterator (via loops)**: To uniformly process a collection of employee types.

Includes both:
- A **console-based application** (`PayrollApplication.java`)
- A **GUI version** (`PayrollApplicationGUI.java`)

---

## 💡 Features

- Supports 3 types of employees with different pay computation methods.
- Uses `AveragePayVisitor` to calculate average salary per type.
- Uses `RangePayVisitor` to determine min and max salary per type.
- Displays payroll computations via console or GUI.

---

## 🧱 Technologies

- **Java** (SE)
- **Swing** (for GUI)
- **OOP Principles**
- **Design Patterns**: Visitor

---

## 🧩 Class Structure

├── Employee.java                   # Abstract base class for all employees
├── FullTimeEmployee.java          # Implements full-time employee and pay logic
├── PartTimeEmployee.java          # Implements part-time employee and pay logic
├── ContractEmployee.java          # Implements contract employee and pay logic

├── EmployeeVisitor.java           # Main visitor interface
├── Visitor.java                   # (Duplicate/redundant - can be merged with EmployeeVisitor)

├── AveragePayVisitor.java         # Calculates average pay for each employee type
├── RangePayVisitor.java           # Calculates min and max pay for each employee type
├── ComputePayroll.java            # Placeholder for extending custom payroll computations

├── PayrollApplication.java        # Console-based application (main logic)
├── PayrollApplicationGUI.java     # GUI version of payroll system using Java Swing


---

## 🧮 Pay Calculation Formulas

- **Full-Time**: `Pay = HourlyRate * TotalHours`
- **Part-Time**: `Pay = HourlyRate * TotalHours`
- **Contract**: `Pay = ContractPay` *(predefined amount)*

---

## 🖥️ How to Run

### 🧪 Console Version:
```bash
javac *.java
java PayrollApplication

🖼️ GUI Version:
javac *.java
java PayrollApplicationGUI

📊 Sample Output
Peter Jack: $720.0
...
Average Pay:
Full Time: $780.0
Part Time: $212.0
Contract: $37.67


