package skyww.modiora.block2;

public class Task4 {

    // №1
    public static class GradeConverter {
        // Вариант 1 (через if / else if)

        public static String scaleIfElse(int score) {
            if (score >= 90 && score <= 100) return "Отлично";
            else if (score >= 70 && score <= 89) return "Хорошо";
            else if (score >= 50 && score <= 69) return "Удовлитворительно";
            else if (score >= 0 && score <= 49) return "Неудовлитворительно";
            else return "Недопустимая оценка";
        }

        // Вариант 2 (через switch)
        public static String scaleSwitchCase(int score) {
            if (score < 0 || score > 100) return "Недопустимая оценка";

            return switch (score/10) {
                case 10, 9 -> "Отлично";
                case 8, 7 -> "Хорошо";
                case 6, 5 -> "Удовлитворительно";
                case 4, 3, 2, 1, 0 -> "Неудовлитворительно";
                default -> "Недопустимая оценка";
            };
        }

        public static void main(String[] args) {
            System.out.println(scaleIfElse(95));
            System.out.println(scaleSwitchCase(95));

            System.out.println(scaleIfElse(80));
            System.out.println(scaleSwitchCase(80));

            System.out.println(scaleIfElse(65));
            System.out.println(scaleSwitchCase(65));

            System.out.println(scaleIfElse(45));
            System.out.println(scaleSwitchCase(45));

            System.out.println(scaleIfElse(100));
            System.out.println(scaleSwitchCase(100));

            System.out.println(scaleIfElse(0));
            System.out.println(scaleSwitchCase(0));

            System.out.println(scaleIfElse(-5));
            System.out.println(scaleSwitchCase(-5));

            System.out.println(scaleIfElse(101));
            System.out.println(scaleSwitchCase(101));

            /*
            Отлично
            Отлично
            Хорошо
            Хорошо
            Удовлитворительно
            Удовлитворительно
            Неудовлитворительно
            Неудовлитворительно
            Отлично
            Отлично
            Неудовлитворительно
            Неудовлитворительно
            Недопустимая оценка
            Недопустимая оценка
            Недопустимая оценка
            Недопустимая оценка
            */
        }
    }

    // №2
    public static class TimeOfDay {
        public static void timesOfDay(int time, int dayOfWeek) {
            System.out.print("Сейчас ");
            if (time >= 5 && time <= 11) System.out.println("Утро");
            else if (time >= 12 && time <= 17) System.out.println("День");
            else if (time >= 18 && time <= 22) System.out.println("Вечер");
            else if (time == 23 || (time >= 0 && time <= 4)) System.out.println("Ночь");
            else System.out.println("Неизвестно");

            System.out.println("Сейчас рабочее время? " + (dayOfWeek >= 1 && dayOfWeek <= 5 && time >= 9 && time <= 18));
        }


        public static void main(String[] args) {
            timesOfDay(10, 1);
            timesOfDay(23, 3);
            timesOfDay(14, 7);
            timesOfDay(18, 5);

            /*
            Сейчас Утро
            Сейчас рабочее время? true
            Сейчас Ночь
            Сейчас рабочее время? false
            Сейчас День
            Сейчас рабочее время? false
            Сейчас Вечер
            Сейчас рабочее время? true
            */
        }
    }


    // №3
    public static class SmartCalc {
        public static String calculate(int a, int b, char operation) {
            if ((operation == '/' || operation == '%') && b == 0) return "Ошибка деления на ноль";

            System.out.print(a + " " + operation + " " + b + " = ");
            return switch (operation) {
                case '+' -> String.valueOf(a + b);
                case '-' -> String.valueOf(a - b);
                case '*' -> String.valueOf(a * b);
                case '/' -> {
                    System.out.println((a/b) + " (целочисленное)");
                    System.out.print(a + ".0 / " + b + ".0 = ");
                    yield String.valueOf(((double) a/b));
                }
                case '%' -> String.valueOf((a%b));
                default -> "Неизвестно";
            };
        }

        public static void main(String[] args) {
            System.out.println(calculate(15, 4, '+'));
            System.out.println(calculate(15, 4, '/'));
            System.out.println(calculate(15, 4, '%'));
            System.out.println(calculate(15, 0, '/'));
            System.out.println(calculate(15, 0, '%'));

            /*
            15 + 4 = 19
            15 / 4 = 3 (целочисленное)
            15.0 / 4.0 = 3.75
            15 % 4 = 3
            */
        }
    }

    // №4
    public static class GuessGame {
        public static String isHit(int secret, int guess) {
            if (secret == guess) return "Угадал!";
            return guess > secret ? "Меньше" : "Больше";
        }

        public static void main(String[] args) {
            System.out.println(isHit(42, 10));
            System.out.println(isHit(42, 50));
            System.out.println(isHit(42, 42));

            /*
            Больше
            Меньше
            Угадал!
            */
        }
    }
}
