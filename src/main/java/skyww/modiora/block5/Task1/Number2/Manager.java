package skyww.modiora.block5.Task1.Number2;

public class Manager extends Employee {
    private final double bonus;

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + bonus;
    }

    @Override
    public void getInfo() {
        System.out.printf("Имя: %s%nЗарплата: %.2f%n(Бонус: %.2f)%n%n", getName(), getSalary(), bonus);
    }
}
