// Visitor interface
public interface Visitor {
    void visit(FullTimeEmployee fullTimeEmployee);

    void visit(PartTimeEmployee partTimeEmployee);

    void visit(ContractEmployee contractEmployee);
}