package skyww.modiora.block2;

import java.util.Scanner;

public class ProfileBuilder {

    private String name;
    private String lastName;
    private int age;
    private String city;
    
    public ProfileBuilder() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя: ");
        this.name = scanner.nextLine();

        System.out.print("Введите фамилию: ");
        this.lastName = scanner.nextLine();

        do {
            System.out.print("Введите возраст: ");
            this.age = scanner.nextInt();
        } while (this.age < 0 || this.age > 150);

        scanner.nextLine();

        System.out.print("Введите город: ");
        this.city = scanner.nextLine();
    }

    public void printInfo() {
        int birthYear = 2026 - age;
        int yearsToPension = 65 - age;

        System.out.printf("""
                === Профиль ===
                Имя: %s %s
                Возраст: %d
                Год рождения: %d
                Город: %s
                До пенсии (65 лет) осталось: %d
                """, name, lastName, age, birthYear, city, yearsToPension);
    }

    public static void main(String[] args) {
        ProfileBuilder profile = new ProfileBuilder();
        profile.printInfo();

        /*
        Вывод:
        Введите имя: Иван
        Введите фамилию: Петров
        Введите возраст: 25
        Введите город: Москва
        === Профиль ===
        Имя: Иван Петров
        Возраст: 25
        Год рождения: 2001
        Город: Москва
        До пенсии (65 лет) осталось: 40
        */
    }
}
