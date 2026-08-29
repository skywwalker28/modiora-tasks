package skyww.modiora.block5.Task1.Number2;

public class Developer extends Employee {
    private final String programmingLanguage;
    private final int experienceYears;

    public Developer(String name, double salary, String programmingLanguage, int experienceYears) {
        super(name, salary);
        this.programmingLanguage = programmingLanguage;
        this.experienceYears = experienceYears;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + (5000 * experienceYears);
    }

    @Override
    public void getInfo() {
        System.out.printf("Имя разработчика: %s%nЗарплата: %.2f%nЯзык программирования: %s%nОпыт: %s%n%n",
                getName(), getSalary(), programmingLanguage, experienceYears);
    }
}
