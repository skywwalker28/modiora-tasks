package skyww.modiora.block4;

public class Task5 {
    public static class User {
        private static int nextId = 0;
        private String name;
        private int id;

        public User(String name) {
            this.name = name;
            id = ++nextId;
        }

        public static int getTotalCreated() {
            return nextId;
        }

        @Override
        public String toString() {
            return "Имя: " + name + "\nИдентификатор: " + id + "\n";
        }


        public static void main(String[] args) {
            User user1 = new User("Иван");
            User user2 = new User("Петя");
            User user3 = new User("Михаил");
            User user4 = new User("Алексей");

            System.out.println(user1);
            System.out.println(user2);
            System.out.println(user3);
            System.out.println(user4);
            System.out.println("Всего создано: " + getTotalCreated());

            /*
            Вывод:
            Имя: Иван
            Идентификатор: 1

            Имя: Петя
            Идентификатор: 2

            Имя: Михаил
            Идентификатор: 3

            Имя: Алексей
            Идентификатор: 4

            Всего создано: 4
            */
        }
    }

    public static class AppConstants {
        public static final String APP_NAME = "Name";
        public static final int VERSION = 12;
        public static final int MAX_USERS = 4;
        public static final double PI = 3.14;

        /*
        public void setAppName() {
            APP_NAME = "ChangeName";

            Ошибка компиляции: "cannot assign a value to static final variable APP_NAME".
            Переменная с модификатором final может быть инициализированна только один раз.
        }
        */
    }

    public enum Day {
        MONDAY("Понедельник"),
        TUESDAY("Вторник"),
        WEDNESDAY("Среда"),
        THURSDAY("Четверг"),
        FRIDAY("Пятница"),
        SATURDAY("Суббота"),
        SUNDAY("Воскресенье");

        private final String rusName;

        Day(String rusName) {
            this.rusName = rusName;
        }

        public String getRusName() {
            return rusName;
        }

        public boolean isWeekend() {
            return this == SATURDAY || this == SUNDAY;
        }

        public boolean isWorkday() {
            return !isWeekend();
        }

        public static void main(String[] args) {
            for (Day day : Day.values()) {
                String type = day.isWeekend() ? "Выходной" : "Рабочий";
                System.out.println(day + " (" + day.getRusName() + ") - " + type);
            }

            /*
            Вывод:
            MONDAY (Понедельник) - Рабочий
            TUESDAY (Вторник) - Рабочий
            WEDNESDAY (Среда) - Рабочий
            THURSDAY (Четверг) - Рабочий
            FRIDAY (Пятница) - Рабочий
            SATURDAY (Суббота) - Выходной
            SUNDAY (Воскресенье) - Выходной
            */
        }
    }
}
