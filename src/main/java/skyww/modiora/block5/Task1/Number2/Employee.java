package skyww.modiora.block5.Task1.Number2;

public class Employee {
    private static int idCount = 0;
    private final String name;
    private final int id;
    private final double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        id = ++idCount;
    }

    public double getSalary() { return salary; }
    public String getName() { return name; }

    public void getInfo() {
        System.out.printf("Сотрудник %s: %nЗарплата: %.2f%n%n", name, salary);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {"
                + "\n   Имя: " + name
                + "\n   Идентификатор: " + id
                + "\n   Зарплата: " + String.format("%.2f", getSalary()) + "\n}\n";
    }
}
