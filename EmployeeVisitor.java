// EmployeeVisitor.java
public interface EmployeeVisitor {
    void visit(ContractEmployee employee);

    void visit(PartTimeEmployee employee);

    void visit(FullTimeEmployee employee);
}
