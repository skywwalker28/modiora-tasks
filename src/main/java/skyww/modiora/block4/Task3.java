package skyww.modiora.block4;

public class Task3 {
    /// №1
    public static class BankAccount {
        private static int totalAccount;
        private final String number;
        private String owner;
        private double balance;
        private final String[] transactionHistory;
        private int index;

        public BankAccount(String number, String owner) {
            this.number = number;
            this.owner = owner;
            balance = 0.0;
            totalAccount++;
            transactionHistory = new String[100];
            index = 0;
        }

        public void deposit(double addition) {
            if (addition <= 0) {
                throw new IllegalArgumentException("Сумма должна быть > 0");
            } else {
                this.balance += addition;
                transactionHistory[index++] = "Счет пополнили на сумму " + addition;
            }
        }

        public void withdraw(double substraction) {
            if (substraction <= 0) {
                throw new IllegalArgumentException("Сумма должна быть > 0");
            } else if (getBalance() < substraction) {
                throw new IllegalArgumentException("Недостаточно средств");
            } else {
                this.balance -= substraction;
                transactionHistory[index++] = "Со счета сняли " + substraction;
            }
        }

        public double getBalance() {
            return balance;
        }

        public String getOwner() {
            return owner;
        }

        public String getNumber() {
            return number;
        }

        public void setOwner(String newVal) {
            this.owner = newVal;
        }

        public String[] getTransactionHistory() {
            String[] result = new String[index];

            for (int i = 0; i < index; i++) {
                result[i] = transactionHistory[i];
            }

            return result;
        }


        public void printStatement() {
            System.out.println("Номер счета: " + number
                    + "\nВладелец: " + owner
                    + "\nБаланс: " + balance);

            System.out.println("История транзакций: ");
            String[] history = getTransactionHistory();
            for (String current : history) {
                System.out.println(" - " + current);
            }

            System.out.println();
        }


        public static void main(String[] args) {
            BankAccount account1 = new BankAccount("193422", "Иван");
            account1.deposit(10000);
            account1.withdraw(500);
            account1.withdraw(100);
            account1.withdraw(400);
            account1.withdraw(40000);
            account1.printStatement();

            BankAccount account2 = new BankAccount("32525", "Ирина");
            account2.deposit(-1000);
            account2.deposit(4000);
            account2.withdraw(4000);
            account2.withdraw(4000);
            account2.withdraw(4000);
            account2.printStatement();

            System.out.println("Всего счетов: " + totalAccount);
        }
    }

    ///  №2
    public static class Temperature {
        private double celsius;

        public Temperature(double celsius) {
            setCelsius(celsius);
        }

        public double getCelsius() {
            return celsius;
        }

        public double getFahrenheit() {
            return celsius * 9/5 + 32;
        }

        public double getKelvin() {
            return celsius + 273.15;
        }

        public void setCelsius(double value) {
            if (value < -273.15) {
                throw new IllegalArgumentException("Температура не может быть ниже абсолютного нуля");
            } else {
                celsius = value;
            }
        }

        public void setFahrenheit(double value) {
            if (value < -459.67) {
                throw new IllegalArgumentException("Температура не может быть ниже абсолютного нуля");
            } else {
                celsius = (value - 32) * 5.0/9.0;
            }
        }

        public void setKelvin(double value) {
            if (value < 0) {
                throw new IllegalArgumentException("Температура не может быть ниже абсолютного нуля");
            } else {
                celsius = value - 273.15;
            }
        }

        @Override
        public String toString() {
            return getCelsius() + "°C / " + getFahrenheit() + "°F / " + getKelvin() + "K";
        }


        public static void main(String[] args) {
            Temperature temp = new Temperature(10);
            System.out.println(temp);

            temp.setCelsius(15);
            System.out.println(temp);

            temp.setFahrenheit(65);
            System.out.println(temp);

            temp.setKelvin(300);
            System.out.println(temp);

            /*
            Вывод:
            10.0°C / 50.0°F / 283.15K
            15.0°C / 59.0°F / 288.15K
            18.333333333333332°C / 65.0°F / 291.4833333333333K
            26.850000000000023°C / 80.33000000000004°F / 300.0K
            */
        }
    }

    /// №3
    public static class Range {
        private final double min;
        private final double max;

        public Range(double min, double max) {
            if (min > max) {
                throw new IllegalArgumentException("min должен быть <= max");
            }
            this.min = min;
            this.max = max;
        }

        public double getMin() {
            return min;
        }

        public double getMax() {
            return max;
        }

        public double getLength() {
            return max - min;
        }

        public boolean contains(double value) {
            return value <= max && value >= min;
        }

        public boolean overlaps(Range other) {
            return this.min <= other.max && other.min <= this.max;
        }

        public Range intersection(Range other) {
            if (!this.overlaps(other)) {
                return null;
            }

            double start = Math.max(min, other.min), end = Math.min(max, other.max);
            return new Range(start, end);
        }

        public Range union(Range other) {
            double start = Math.min(min, other.min), end = Math.max(max, other.max);
            return new Range(start, end);
        }

        @Override
        public String toString() {
            return String.format("[%.1f; %.1f]", min, max);
        }

        public static void main(String[] args) {
            Range range = new Range(1, 10);
            Range range1 = new Range(9, 11);
            Range range2 = new Range(0, 5);
            Range range3 = new Range(3, 4);
            Range range4 = new Range(11, 20);

            System.out.println(range.intersection(range1));
            System.out.println(range.intersection(range2));
            System.out.println(range.intersection(range3));
            System.out.println(range.intersection(range4));

            System.out.println();

            System.out.println(range.union(range1));
            System.out.println(range.union(range2));
            System.out.println(range.union(range3));
            System.out.println(range.union(range4));

            /*
            Вывод:
            [9.0; 10.0]
            [1.0; 5.0]
            [3.0; 4.0]
            null

            [1.0; 11.0]
            [0.0; 10.0]
            [1.0; 10.0]
            [1.0; 20.0]
            */
        }
    }

    public record Course(int id, String title, String instructor, int durationHours, double price) {
        public Course {
            if (title == null || title.isEmpty()) {
                throw new IllegalArgumentException("Название курса не может быть пустым");
            }

            if (durationHours <= 0) {
                throw new IllegalArgumentException("Длительность должна быть > 0");
            }

            if (instructor == null || instructor.isEmpty()) {
                throw new IllegalArgumentException("Преподователь не может быть пустым");
            }

            if (price < 0) {
                throw new IllegalArgumentException("Цена должна быть > 0");
            }
        }

        public boolean isPremium() {
            return price > 5000;
        }

        public String shortDescription() {
            return title + " для начинающих (" + durationHours + "ч) — " + instructor;
        }

        public static void main(String[] args) {
            Course course1 = new Course(1, "Java", "Иван Иванов", 40, 5000);
            Course copyCourse1 = new Course(1, "Java", "Иван Иванов", 40, 5000);

            Course course2 = new Course(2, "Python", "Иван Иванов", 37, 6000);
            Course course3 = new Course(3, "C++", "Иван Иванов", 42, 5500);
            System.out.println(course1);
            System.out.println(course2);
            System.out.println(course3);

            System.out.println();
            System.out.println(course1.shortDescription());
            System.out.println(course2.shortDescription());
            System.out.println(course3.shortDescription());

            System.out.println("course1 и copyCourse1 одинаковы? - " + course1.equals(copyCourse1));

            /*
            Course[id=1, title=Java, instructor=Иван Иванов, durationHours=40, price=5000.0]
            Course[id=2, title=Python, instructor=Иван Иванов, durationHours=37, price=6000.0]
            Course[id=3, title=C++, instructor=Иван Иванов, durationHours=42, price=5500.0]

            Java для начинающих (40ч) — Иван Иванов
            Python для начинающих (37ч) — Иван Иванов
            C++ для начинающих (42ч) — Иван Иванов
            course1 и copyCourse1 одинаковы? - true
            */
        }
    }
}
