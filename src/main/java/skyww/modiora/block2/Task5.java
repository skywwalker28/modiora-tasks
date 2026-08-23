package skyww.modiora.block2;

import java.util.ArrayList;
import java.util.List;

public class Task5 {

    // №1
    public static class FizzBuzz {
        public static void main(String[] args) {
            fuzzBuzzPrinter(100);

            /*
            Вывод:
            1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz, ... , Buzz.
            */
        }

        private static void fuzzBuzzPrinter(int n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    sb.append("FizzBuzz").append(", ");
                } else if (i % 3 == 0) {
                    sb.append("Fizz").append(", ");
                } else if (i % 5 == 0) {
                    sb.append("Buzz").append(", ");
                } else {
                    sb.append(i).append(", ");
                }
            }

            System.out.println(sb.substring(0, sb.length() - 2) + ".");
        }
    }

    // №2
    public static class DigitAnalyzer {
        public static class AnalyzeNumber {
            private int digitCount;
            private int sum;
            private int maxInteger = Integer.MIN_VALUE;
        }

        public static void main(String[] args) {
            int num = 12344321;
            printResults(num, analyzeNumber(num), isPalindrome(num));

            /*
            Вывод:
            Число: 12344321
            Цифр: 8
            Сумма цифр: 20
            Максимальная цифра: 4
            Палиндром: да
            */
        }

        private static AnalyzeNumber analyzeNumber(int num) {
            AnalyzeNumber analyzeNumber = new AnalyzeNumber();
            int temp = num;

            while (temp > 0) {
                int digit = temp % 10;
                analyzeNumber.sum += digit;
                analyzeNumber.maxInteger = Math.max(analyzeNumber.maxInteger, digit);
                analyzeNumber.digitCount++;
                temp /= 10;
            }

            return analyzeNumber;
        }

        private static boolean isPalindrome(int num) {
            int reversed = 0, copy = num;
            while (copy > 0) {
                int digit = copy % 10;
                reversed = reversed * 10 + digit;
                copy /= 10;
            }

            return reversed == num;
        }

        public static void printResults(int num, AnalyzeNumber analyze, boolean isPalindrome) {

            System.out.printf("""
                    Число: %d
                    Цифр: %d
                    Сумма цифр: %d
                    Максимальная цифра: %d
                    Палиндром: %s
                    """, num, analyze.digitCount, analyze.sum, analyze.maxInteger, isPalindrome ? "да" : "нет");
        }
    }

    // №3
    public static class Patterns {
        public static void main(String[] args) {
            int n = 5;

            // Квадрат 5 * 5
            square(n);
            System.out.println();

            // Правый треугольник
            rightTriangle(n);
            System.out.println();

            // Пирамида по центру
            centerPyramid(n);
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
                * *
               * * *
              * * * *
             * * * * *

            */
        }

        private static void square(int n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
        }

        private static void rightTriangle(int n) {
            for (int i = 1; i <= n; i++) {

                for (int j = n - i; j > 0; j--) {
                    System.out.print("  ");
                }

                for (int k = 0; k < i; k++) {
                    System.out.print("* ");
                }

                System.out.println();
            }
        }

        private static void centerPyramid(int n) {
            for (int i = 1; i <= n; i++) {

                for (int j = n - i; j > 0; j--) {
                    System.out.print(" ");
                }

                for (int k = 1; k <= i; k++) {
                    System.out.print(" *");
                }

                System.out.println();
            }
        }
    }

    // №4
    public static class PrimeNumber {
        public static class PrimeResult {
            private final List<Integer> primes = new ArrayList<>();
            private int count;
        }

        public static void main(String[] args) {
            int limit = 100;
            printResults(searchPrimeNumbers(limit));

            /*
            Вывод:
            2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97
            Всего простых чисел: 25
            */
        }

        private static PrimeResult searchPrimeNumbers(int limit) {
            PrimeResult primeResult = new PrimeResult();

            for (int i = 2; i <= limit; i++) {
                boolean isPrime = true;

                for (int candidate = 2; candidate <= Math.sqrt(i); candidate++) {
                    if (i % candidate == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) {
                    primeResult.count++;
                    primeResult.primes.add(i);
                }
            }

            return primeResult;
        }

        public static void printResults(PrimeResult primeResult) {
            for (int i = 0; i < primeResult.primes.size(); i++) {
                System.out.print(primeResult.primes.get(i) + " ");
            }

            System.out.print("\nВсего простых чисел: " + primeResult.count);
        }
    }
}
