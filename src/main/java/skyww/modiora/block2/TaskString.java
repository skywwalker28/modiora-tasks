package skyww.modiora.block2;

public class TaskString {
    /// №1
    public static class StringAnalyzer {
        public static void main(String[] args) {
            String str = "Hello, World! 123";
            printResults(str);
        }

        public static String searchCount(String str) {
            int spaces = 0, digits = 0, letters = 0;
            for (int i = 0; i < str.length(); i++) {
                char current = str.charAt(i);

                if (current == ' ') {
                    spaces++;
                } else if (Character.isLetter(current)) {
                    letters++;
                } else if (Character.isDigit(current)) {
                    digits++;
                }
            }

            return """
                    Количество пробелов: %d
                    Количество цифр: %d
                    Количество букв: %d"""
                    .formatted(spaces, digits, letters);
        }

        public static String searchIndex(String str, String target) {
            return """
                    Первое вхождение "%s": индекс %s
                    Последнее вхождение "%s": индекс %s""".
                    formatted(target, str.indexOf(target), target, str.lastIndexOf(target));
        }

        public static String toUpperLowerCaseTrim(String str) {
            return """
                    В верхнем регистре: "%s"
                    В нижнем регистре: "%s"
                    Без пробелов по краям: "%s\"""".
                    formatted(str.toUpperCase(), str.toLowerCase(), str.trim());
        }

        public static void printResults(String str) {
            System.out.printf("""
                    Строка: "%s"
                    Длина: %d
                    %s
                    %s
                    Содержит "World": %s
                    %s
                    Подстрока [0, 5]: "%s"
                    После замены "World" на "Java": "%s"
                    """,
                    str, str.length(), toUpperLowerCaseTrim(str),
                    searchCount(str), str.contains("World") ? "да" : "нет",
                    searchIndex(str, "o"), str.substring(0, 5), str.replace("World", "Java"));
        }

        /*
        Вывод:
        Строка: "Hello, World! 123"
        Длина: 17
        В верхнем регистре: "HELLO, WORLD! 123"
        В нижнем регистре: "hello, world! 123"
        Без пробелов по краям: "Hello, World! 123"
        Количество пробелов: 2
        Количество цифр: 3
        Количество букв: 10
        Содержит "World": да
        Первое вхождение "o": индекс 4
        Последнее вхождение "o": индекс 8
        Подстрока [0, 5]: "Hello"
        После замены "World" на "Java": "Hello, Java! 123"
        */
    }

    /// №2
    public static class Palindrome{
        public static void main(String[] args) {
            String str = "A man a plan a canal Panama";
            System.out.println("\"" + str + "\" — " + isPalindrome(str));
        }

        public static String isPalindrome(String str) {
            str = str.replaceAll("[^a-zA-Zа-яА-Я]", "");
            str = str.toLowerCase();

            StringBuilder sb = new StringBuilder(str);
            return sb.reverse().toString().equals(str) ? "да" : "нет";
        }

        /*
        Вывод:
        "racecar" — да
        "Hello" — нет
        "A man a plan a canal Panama" — да
        "Was it a car or a cat I saw" — да
        */
    }

    /// №3
    public static class TextStats {
        public static void main(String[] args) {
            String str = "Hello, World! 123, 123";
            System.out.println("Строка: \"" + str + "\"\n" + stringStatistics(str));
        }

        public static String stringStatistics(String str) {
            str = str.replaceAll("[^a-zA-Zа-яА-Я0-9\\s]", "");
            String[] mas = str.split("\\s+");
            String longest = mas[0], shortest = mas[0];
            int chars = 0;

            for (String current : mas) {
                chars += current.length();
                if (longest.length() < current.length()) {
                    longest = current;
                }

                if (shortest.length() > current.length()) {
                    shortest = current;
                }
            }

            return """
                    Количество слов: %d
                    Количество символов без пробелов: %d
                    Самое длинное слово: %s
                    Самое короткое слово: %s
                    Средняя длина слов: %.2f""".
                    formatted(mas.length, chars, longest, shortest, (double) chars/mas.length);
        }
    }

    /// №4
    public static class FormattedTable {
        public record Student(String name, int age, double avg) {}

        public static void main(String[] args) {
            Student student1 = new Student("Иван Иванов", 20, 4.75);
            Student student2 = new Student("Мария Петрова", 21, 4.90);
            Student student3 = new Student("Алексей Смирнов", 19, 3.85);

            printTable(student1, student2, student3);
            /*
            +----+------------------+------+--------+
            | №  | Имя              | Воз. | Балл   |
            +----+------------------+------+--------+
            |  1 | Иван Иванов      |   20 |   4.75 |
            |  2 | Мария Петрова    |   21 |   4.90 |
            |  3 | Алексей Смирнов  |   19 |   3.85 |
            +----+------------------+------+--------+
            */

        }

        public static void printTable(Student student1, Student student2, Student student3) {
            String line = "+----+------------------+------+--------+";
            String header = "| №  | Имя              | Воз. | Балл   |";

            System.out.println(line);
            System.out.println(header);
            System.out.println(line);

            System.out.printf("| %2d | %-16s | %4d | %6.2f |%n",
                    1, student1.name(), student1.age(), student1.avg());
            System.out.printf("| %2d | %-16s | %4d | %6.2f |%n",
                    2, student2.name(), student2.age(), student2.avg());
            System.out.printf("| %2d | %-16s | %4d | %6.2f |%n",
                    3, student3.name(), student3.age(), student3.avg());

            System.out.println(line);
        }
    }
}
