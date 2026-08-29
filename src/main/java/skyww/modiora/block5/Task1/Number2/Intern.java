package skyww.modiora.block5.Task1.Number2;

public class Intern extends Employee {
    public Intern(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double getSalary() {
        return super.getSalary() * 0.7;
    }

    @Override
    public void getInfo() {
        System.out.printf("Имя стажера: %s%nЗарплата: %.2f%n%n", getName(), getSalary());
    }
}
