package skyww.modiora.Block1;

public class Task4 {
    /*
    public class student_calculator { -> ошибка 1, должно быть studentCalculator
        public static final double pi = 3.14; -> ошибка 2, должно быть PI

        public static double CalculateCircleArea(double R) { // ошибка 3, должно быть calculateCircleArea
            double S = pi * R * R; -> ошибка 4 и 5, должно быть double area = PI * radius * radius
            boolean result = true; -> ошибка 6, переменная не используется
            return S;
        }

        public static void main(String[] args) {
            double MyRadius = 5; -> ошибка 7, должно быть myRadius
            System.out.println(CalculateCircleArea(MyRadius)); -> 8, вызов с большой буквы
        }
    }
    */


    public static class StudentCalculator {
        public static final double PI = 3.14;

        public static double calculateCircleArea(double radius) {
            double area = PI * radius * radius;
            return area;
        }

        public static void main(String[] args) {
            double myRadius = 5;
            System.out.println(calculateCircleArea(myRadius));
        }
    }


    public static class TemperatureConverter {

        public static final double ABSOLUTE_ZERO_CELSIUS = -273.15;
        public static final double BOILING_POINT_CELSIUS = 100.0;

        public static double celsiusToFahrenheit(double celsius) {
            return (celsius * 1.8) + 32;
        }

        public static double fahrenheitToCelsius(double fahrenheit) {
            return (fahrenheit - 32) / 1.8;
        }

        public static void main(String[] args) {
            double tempCelsius = 25.0;
            double tempFahrenheit = celsiusToFahrenheit(tempCelsius);

            boolean isAboveBoiling = tempCelsius > BOILING_POINT_CELSIUS;

            if (tempCelsius < ABSOLUTE_ZERO_CELSIUS) {
                System.out.println("Температура ниже абсолютного нуля");
                return;
            }

            System.out.println(tempFahrenheit + "°F");
            System.out.println("Выше точки кипения? — " + isAboveBoiling);

            double backToCelsius = fahrenheitToCelsius(tempFahrenheit);
            System.out.println(backToCelsius + "°C");
        }
    }
}

/*
1. Имена классов с большой буквы
   Плохо: public class student
   Хорошо: public class Student

2. Имена методов и переменных с маленькой буквы и стиль CamelCase
   Плохо: public double CalculateCircleArea()
   Хорошо: public double calculateCircleArea()

3. Константы пишутся заглавными буквами через подсчеркивание
   Плохо: public static final double pi
   Хорошо: public static final PI

4. Переменная должна ясно передавать ее назначение
   Плохо: double r
   Хорошо: double radius

5. Не создавайте неиспользуемые переменные, это мусор
   Плохо: boolean result = true — нигде в коде не используется
   Хорошо: удалить или как-то использовать
*/
