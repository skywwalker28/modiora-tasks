package skyww.modiora.block5.Task3.Number2;

public class PartTimeEmployee extends Employee {
    private final double hourlyRate;
    private final double hoursWork;

    public PartTimeEmployee(String name, String department, double hourlyRate, double hoursWork) {
        super(name, department);
        this.hourlyRate = hourlyRate;
        this.hoursWork = hoursWork;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWork;
    }
}
