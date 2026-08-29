package skyww.modiora.block5.Task1.Number2;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = {
                new Developer("Артур", 300_000.0, "Java", 3),
                new Developer("Артем", 280_000.0, "C++", 2),

                new Manager("Иван", 120_000.0, 5_000),
                new Manager("Петя", 110_000.0, 15_000),

                new Intern("Екатерина", 72_000.0),
                new Intern("Алексей", 85_000.0),
        };

        System.out.println("ФОНД ОПЛАТЫ ТРУДА: " + getTotalSalaryFund(employees) + "\n");
        getInfo(employees);
        getPrint(employees);
        /*
        Вывод:
        ФОНД ОПЛАТЫ ТРУДА: 964900.0

        Имя разработчика: Артур
        Зарплата: 315000.00
        Язык программирования: Java
        Опыт: 3

        Имя разработчика: Артем
        Зарплата: 290000.00
        Язык программирования: C++
        Опыт: 2

        Имя: Иван
        Зарплата: 125000.00
        (Бонус: 5000.00)

        Имя: Петя
        Зарплата: 125000.00
        (Бонус: 15000.00)

        Имя стажера: Екатерина
        Зарплата: 50400.00

        Имя стажера: Алексей
        Зарплата: 59500.00

        Developer {
           Имя: Артур
           Идентификатор: 1
           Зарплата: 315000.00
        }

        Developer {
           Имя: Артем
           Идентификатор: 2
           Зарплата: 290000.00
        }

        Manager {
           Имя: Иван
           Идентификатор: 3
           Зарплата: 125000.00
        }

        Manager {
           Имя: Петя
           Идентификатор: 4
           Зарплата: 125000.00
        }

        Intern {
           Имя: Екатерина
           Идентификатор: 5
           Зарплата: 50400.00
        }

        Intern {
           Имя: Алексей
           Идентификатор: 6
           Зарплата: 59500.00
        }
        */
    }

    public static double getTotalSalaryFund(Employee[] mas) {
        double result = 0.0;
        for (Employee employee : mas) {
            result += employee.getSalary();
        }

        return result;
    }

    public static void getInfo(Employee[] mas) {
        for (Employee employee : mas) {
            employee.getInfo();
        }
    }

    public static void getPrint(Employee[] mas) {
        for (Employee employee : mas) {
            System.out.println(employee);
        }
    }
}
