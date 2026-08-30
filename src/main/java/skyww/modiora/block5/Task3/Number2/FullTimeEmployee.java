package skyww.modiora.block5.Task3.Number2;

public class FullTimeEmployee extends Employee {
    private final double monthlySalary;

    public FullTimeEmployee(String name, String department, double mouthlySalary) {
        super(name, department);
        this.monthlySalary = mouthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}
