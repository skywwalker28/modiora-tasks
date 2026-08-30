package skyww.modiora.block5.Task3.Number2;

public abstract class Employee {
    private static int countId = 0;

    private final String name;
    private final int id;
    private final String department;

    public Employee(String name, String department) {
        id = ++countId;
        this.name = name;
        this.department = department;
    }

    public abstract double calculateSalary();

    public void printPayslip() {
        System.out.printf("Имя: %s | Отдел: %s | Начисленная зарплата: %.2f%n", name, department, calculateSalary());
    }

    @Override
    public String toString() {
        return String.format("Сотрудник %d {%n  Имя: %s%n    Отдел: %s%n      Зарплата: %.2f%n}%n",
                id, name, department, calculateSalary());
    }
}
