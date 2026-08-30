package skyww.modiora.block5.Task3.Number2;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = {
                new FullTimeEmployee("Иван", "Team-lead", 370_000),
                new PartTimeEmployee("Константин", "Developer", 690, 40),
                new CommissionEmployee("София", "It-Recruiter",
                        130_000, 3, 100_000),
                new FullTimeEmployee("Михаил", "Backend", 350_000),
                new PartTimeEmployee("Анна", "Frontend", 450, 38)
        };

        getCheckList(employees);
        System.out.printf("Общий фонд оплаты труда: %.2f", totalFund(employees));

        /*
        Вывод:
        Имя: Иван | Отдел: Team-lead | Начисленная зарплата: 370000.00
        Имя: Константин | Отдел: Developer | Начисленная зарплата: 27600.00
        Имя: София | Отдел: It-Recruiter | Начисленная зарплата: 133000.00
        Имя: Михаил | Отдел: Backend | Начисленная зарплата: 350000.00
        Имя: Анна | Отдел: Frontend | Начисленная зарплата: 17100.00
        Общий фонд оплаты труда: 897700.00
        */
    }

    public static double totalFund(Employee[] mas) {
        double res = 0;
        for (Employee cur : mas) {
            res += cur.calculateSalary();
        }

        return res;
    }

    public static void getCheckList(Employee[] mas) {
        for (Employee cur : mas) cur.printPayslip();
    }
}
