package skyww.modiora.block3;

public class Task1 {
    public static class MathUtils {

        /// №1
        public static int min(int a, int b) { return a > b ? b : a; }
        public static int max(int a, int b) { return a > b ? a : b; }
        public static int clamp(int value, int low, int high) { return max(low, min(value, high)); }

        /// №2
        public static boolean isLeapYear(int year) { return year % 400 == 0 || year % 4 == 0 && year % 100 != 0; }
        public static double celsiusToFahrenheit(double c) { return c * 1.8 + 32; }
        public static double fahrenheitToCelsius(double f) { return (f - 32) / 1.8; }

        /// №3
        public static long factorial(int n) {
            if (n < 0) throw new IllegalArgumentException();

            long res = 1L;
            for (int i = 1; i <= n; i++) res = res * i;

            return res;
        }

        /// №4
        public static long power(int base, int exp) {
            long res = 1;
            for (int i = 0; i < exp; i++) res = res * base;

            return res;
        }


        public static void main(String[] args) {
            /// min
            System.out.println(min(10, 20)); // Вывод: 10
            System.out.println(min(20, 10)); // Вывод: 10

            System.out.println();

            /// max
            System.out.println(max(10, 20)); // Вывод: 20
            System.out.println(max(20, 10)); // Вывод: 20

            System.out.println();

            /// clamp
            System.out.println(clamp(15, 10, 20)); // Вывод: 15
            System.out.println(clamp(16, 10, 15)); // Вывод: 15
            System.out.println(clamp(14, 15, 20)); // Вывод: 15

            System.out.println();

            /// leap year
            System.out.println(isLeapYear(2024)); // true
            System.out.println(isLeapYear(2028)); // true
            System.out.println(isLeapYear(2026)); // false
            System.out.println(isLeapYear(1900)); // false
            System.out.println(isLeapYear(2000)); // true

            System.out.println();

            /// fahrenheit <-> celsius
            System.out.println(celsiusToFahrenheit(30.0)); // Вывод: 86.0
            System.out.println(fahrenheitToCelsius(86.0)); // Вывод: 30.0

            System.out.println(celsiusToFahrenheit(25.0)); // Вывод: 77.0
            System.out.println(fahrenheitToCelsius(77.0)); // Вывод: 25.0

            System.out.println();

            /// factorial
            System.out.println(factorial(0)); // Вывод: 1
            System.out.println(factorial(1)); // Вывод: 1
            System.out.println(factorial(5)); // Вывод: 120
            System.out.println(factorial(7)); // Вывод: 5040

            System.out.println();

            /// power
            System.out.println(power(2, 2)); // Вывод: 4
            System.out.println(power(5, 2)); // Вывод: 25
            System.out.println(power(3, 3)); // Вывод: 27
            System.out.println(power(5, 3)); // Вывод: 125
        }
    }
}
