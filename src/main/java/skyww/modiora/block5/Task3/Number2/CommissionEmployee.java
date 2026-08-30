package skyww.modiora.block5.Task3.Number2;

public class CommissionEmployee extends Employee {
    private final double baseSalary;
    private final double commissionPercent;
    private final double salesAmount;

    public CommissionEmployee(String name, String department, double baseSalary,
                              double commissionPercent, double salesAmount) {
        super(name, department);
        this.baseSalary = baseSalary;
        this.commissionPercent = commissionPercent;
        this.salesAmount = salesAmount;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + salesAmount * (commissionPercent / 100);
    }
}
