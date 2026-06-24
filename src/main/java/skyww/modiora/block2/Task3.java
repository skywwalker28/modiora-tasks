package skyww.modiora.block2;

import java.util.Scanner;

public class Task3 {
    public static class ProfileBuilder {

        // №1
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Ввелите имя: ");
            String name = scanner.nextLine();
            System.out.println(name);

            System.out.print("Введите фамилию: ");
            String lastname = scanner.nextLine();
            System.out.println(lastname);

            System.out.print("Ввелите возвраст: ");
            int age = scanner.nextInt();
            System.out.println(age);

            scanner.nextLine();

            System.out.print("Введите город: ");
            String town = scanner.nextLine();
            System.out.print(town);

            /*
            Вывод:
            Ввелите имя: Иван
            Иван
            Введите фамилию: Петров
            Петров
            Ввелите возвраст: 25
            25
            Введите город: Москва
            Москва
            */
        }
    }

    // №2
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя: ");
        String name = scanner.nextLine();

        // №3
        int age = -1;
        while (age < 0 || age > 150) {
            System.out.println("Введите возраст: ");
            age = scanner.nextInt();
        }

        System.out.println("Введите год рождения: ");
        int year = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Введите город: ");
        String town = scanner.nextLine();

        int pension = 65 - age;

        System.out.printf("""
                === Профиль ===
                Имя: %s
                Возвраст: %d
                Год рождения: %d
                Город: %s
                До пенсии (65 лет) осталось: %d
                """, name, age, year, town, pension);

        /*
        Вывод:
        Введите имя:
        Иван Петров
        Введите возраст:
        25
        Введите год рождения:
        2001
        Введите город:
        Москва
        === Профиль ===
        Имя: Иван Петров
        Возвраст: 25
        Год рождения: 2001
        Город: Москва
        До пенсии (65 лет) осталось: 40
        */
    }
}
