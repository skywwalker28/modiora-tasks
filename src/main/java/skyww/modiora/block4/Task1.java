package skyww.modiora.block4;

public class Task1 {

    /// №1
    public static void main(String[] args) {
        int minimumAge = 21;
        Student student1 = new Student("Иван Иванов", 20, 4.5, "Группа 1");
        Student student2 = new Student("Мария Петровна", 19, 4.7, "Группа 1");
        Student student3 = new Student("Алексей Смирнов", 21, 3.85, "Группа 3");

        printStudent(student1, minimumAge);
        printStudent(student2, minimumAge);
        printStudent(student3, minimumAge);
        /*
        Вывод:
        Имя: Иван Иванов
        Возраст: 20
        Средний балл: 4.5
        Группа: Группа 1
        Студент отличник - true
        Студент может закончить обучение - false

        Имя: Мария Петровна
        Возраст: 19
        Средний балл: 4.7
        Группа: Группа 1
        Студент отличник - true
        Студент может закончить обучение - false

        Имя: Алексей Смирнов
        Возраст: 21
        Средний балл: 3.85
        Группа: Группа 3
        Студент отличник - false
        Студент может закончить обучение - true
        */
    }

    public static void printStudent(Student student, int minimumAge) {
        student.printInfo();
        System.out.println("Студент отличник - " + student.isExcellent());
        System.out.println("Студент может закончить обучение - " + student.canGraduate(minimumAge));
        System.out.println();
    }

    public static class Student {
        private final String name;
        private final int age;
        private final double gpa;
        private final String group;

        Student(String name, int age, double gpa, String group) {
            this.name = name;
            this.age = age;
            this.gpa = gpa;
            this.group = group;
        }

        public void printInfo() {
            System.out.println("Имя: " + name
                    + "\nВозраст: " + age
                    + "\nСредний балл: " + gpa
                    + "\nГруппа: " + group);
        }

        public boolean isExcellent() {
            return gpa >= 4.5;
        }

        public boolean canGraduate(int minimumAge) {
            return age >= minimumAge;
        }
    }


    /// №2
    public static class BankAccount {
        private static int totalAccount;
        private final String number;
        private final String owner;
        private double balance;

        BankAccount(String number, String owner, double balance) {
            this.number = number;
            this.owner = owner;
            this.balance = balance;
            totalAccount++;
        }

        public void deposit(double addition) {
            this.balance += addition;
        }

        public void withdraw(double substraction) {
            if (getBalance() < substraction) {
                System.out.println("Недостаточно средст");
            } else {
                this.balance -= substraction;
            }
        }

        public double getBalance() {
            return balance;
        }

        public void printStatement() {
            System.out.println("Номер счета: " + number + "\nВладелец: " + owner + "\nБаланс: " + balance);
            System.out.println();
        }

        public static void main(String[] args) {
            BankAccount account1 = new BankAccount("342429", "Иван", 0.0);
            BankAccount account2 = new BankAccount("945232", "Мария", 0.0);
            BankAccount account3 = new BankAccount("564683", "Алексей", 0.0);

            account1.deposit(1000);
            account1.withdraw(500);
            account1.printStatement();

            account2.deposit(10000);
            account2.withdraw(1000);
            account2.printStatement();

            account3.deposit(400);
            account3.withdraw(100);
            account3.printStatement();

            account3.withdraw(1000); // Демонстрация ошибки
            System.out.println("Всего счетов: " + totalAccount);

            /*
            Вывод:
            Номер счета: 342429
            Владелец: Иван
            Баланс: 500.0

            Номер счета: 945232
            Владелец: Мария
            Баланс: 9000.0

            Номер счета: 564683
            Владелец: Алексей
            Баланс: 300.0

            Недостаточно средст
            Всего счетов: 3
            */
        }
    }


    /// №3
    public static class Rectangle {
        public static void main(String[] args) {
            Rectangle rectangle1 = new Rectangle(12, 7);
            Rectangle rectangle2 = new Rectangle(5, 10);
            Rectangle rectangle3 = new Rectangle(13, 13);

            rectangle1.printInfo();
            rectangle2.printInfo();

            rectangle3.scale(2);
            rectangle3.printInfo();

            /*
            Вывод:
            Ширина 12.0
            Высота: 7.0
            Площадь: 84.0
            Периметр: 38.0
            Это квадрат - false

            Ширина 5.0
            Высота: 10.0
            Площадь: 50.0
            Периметр: 30.0
            Это квадрат - false

            Ширина 26.0
            Высота: 26.0
            Площадь: 676.0
            Периметр: 104.0
            Это квадрат - true
            */
        }

        private double width;
        private double height;

        Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        public double area() {
            return width * height;
        }

        public double perimeter() {
            return 2 * (width + height);
        }

        public boolean isSquare() {
            return width == height;
        }

        public void scale(double factor) {
            width *= factor;
            height *= factor;
        }

        public void printInfo() {
            System.out.println("Ширина " + width
                    + "\nВысота: " + height
                    + "\nПлощадь: " + area()
                    + "\nПериметр: " + perimeter()
                    + "\nЭто квадрат - " + isSquare()
                    + "\n");
        }
    }

    /// №4
    public static class Temperature {
        private final double value;

        private Temperature(double value) {
            this.value = value;
        }

        public static Temperature fromCelsius(double val) {
            return new Temperature(val);
        }

        public static Temperature fromFahrenheit(double fahrenheit) {
            double celsius = (fahrenheit - 32) * 5.0 / 9.0;
            return new Temperature(celsius);
        }

        public static Temperature fromKelvin(double kelvin) {
            double celsius = kelvin - 273.15;
            return new Temperature(celsius);
        }

        public double toCelsius() {
            return value;
        }

        public double toFahrenheit() {
            return value * 9.0 / 5.0 + 32;
        }

        public double toKelvin() {
            return value + 273.15;
        }

        public void printAll() {
            System.out.printf("""
                Температура:
                Цельсий: %.2f°C
                Фаренгейт: %.2f°F
                Кельвин: %.2fK
                %n""", toCelsius(), toFahrenheit(), toKelvin());
        }

        public static void main(String[] args) {
            Temperature temperature1 = Temperature.fromCelsius(25.0);
            Temperature temperature2 = Temperature.fromFahrenheit(77.0);
            Temperature temperature3 = Temperature.fromKelvin(298.15);

            temperature1.printAll();
            temperature2.printAll();
            temperature3.printAll();
        }
    }
}
