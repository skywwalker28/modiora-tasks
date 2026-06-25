package skyww.modiora.block2;

public class Task5 {

    // №1
    public static class FizzBuzz {
        public static void main(String[] args) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= 100; i++) {
                if (i % 3 == 0 && i % 5 == 0) sb.append("FizzBuzz").append(", ");
                else if (i % 3 == 0) sb.append("Fizz").append(", ");
                else if (i % 5 == 0) sb.append("Buzz").append(", ");
                else sb.append(i).append(", ");
            }

            System.out.println(sb.substring(0, sb.length() - 2) + ".");
        }
    }

    // №2
    public static class DigitAnalyzer {
        public static void main(String[] args) {
            int num = 12344321, temp = num, countDigit = 0, sum = 0, maxDigit = Integer.MIN_VALUE;

            while (temp > 0) {
                int digit = temp % 10;
                sum += digit;
                maxDigit = Math.max(maxDigit, digit);
                countDigit++;
                temp /= 10;
            }

            int reversed = 0;
            temp = num;
            while (temp > 0) {
                int digit = temp % 10;
                reversed = reversed * 10 + digit;
                temp /= 10;
            }

            boolean isPalindrome = reversed == num;

            System.out.printf("""
                    Число: %d
                    Цифр: %d
                    Сумма цифр: %d
                    Максимальная цифра: %d,
                    Палиндром: %s
                    """, num, countDigit, sum, maxDigit, isPalindrome ? "да" : "нет");

            /*
            Вывод:
            Число: 12344321
            Цифр: 8
            Сумма цифр: 20
            Максимальная цифра: 4,
            Палиндром: да
            */
        }
    }

    // №3
    public static class Patterns {
        public static void main(String[] args) {
            int n = 5;

            // Квадрат 5 * 5
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }


            System.out.println();

            // Правый треугольник
            for (int i = 1; i <= n; i++) {

                for (int j = n - i; j > 0; j--) System.out.print("  ");
                for (int k = 0; k < i; k++) System.out.print("* ");
                System.out.println();
            }

            System.out.println();

            // Пирамида по центру
            for (int i = 1; i <= n; i++) {

                for (int j = n - i; j > 0; j--) System.out.print("  ");
                for (int k = 1; k <= 2 * i - 1; k++) System.out.print("* ");
                System.out.println();
            }

            System.out.println();
            /*
            Вывод:

            * * * * *
            * * * * *
            * * * * *
            * * * * *
            * * * * *

                    *
                  * *
                * * *
              * * * *
            * * * * *

                    *
                  * * *
                * * * * *
              * * * * * * *
            * * * * * * * * *

            */
        }
    }

    // №4
    public static class PrimeNumber {
        public static void main(String[] args) {
            int count = 0;

            for (int i = 2; i <= 100; i++) {
                boolean isPrime = true;

                for (int candidate = 2; candidate <= Math.sqrt(i); candidate++) {
                    if (i % candidate == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime){
                    count++;
                    System.out.print(i + " ");
                }
            }

            System.out.print("\nВсего простых чисел: " + count);
            /*
            Вывод:
            2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97
            Всего простых чисел: 25
            */
        }
    }
}
