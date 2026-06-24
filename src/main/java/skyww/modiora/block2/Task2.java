package skyww.modiora.block2;

public class Task2 {

//  №1
    public static class Calculator {
        public static void main(String[] args) {
            int a = 17, b = 5;
            System.out.println("Сложение: 17 + 5 = " + (a + b));
            System.out.println("Вычитание: 17 - 5 = " + (a - b));
            System.out.println("Умножение: 17 * 5 = " + (a * b));
            System.out.println("Целое деление: 17 / 5 = " + (a / b));
            System.out.println("Остаток: 17 % 5 = " + (a % b));
            System.out.println("Вещественное: 17 / 5 = " + ((double) a / b));

            /*
            Сложение: 17 + 5 = 22
            Вычитание: 17 - 5 = 12
            Умножение: 17 * 5 = 85
            Целое деление: 17 / 5 = 3
            Остаток: 17 % 5 = 2
            Вещественное: 17 / 5 = 3.4
            */
        }
    }

    public static void main(String[] args) {

        {
            /*
            №2
            оператор ++ это +1, оператор -- это -1. Когда мы пишем оператор перед переменой, то значение должно
            немедлено изменится. Когда оператор после переменной, то значение изменится после прочтения/присвоения
            */

                int a = 5; // 5
                int b = a++; // b = a = 5. После присвоиения a+1 = 6
                int c = ++a; // a = 6, оператор немедленного присовения c = a+1 = 7
                int d = a-- + --b; // a = 7, b = 5, оператор немедленно вычтет b-1 = 4. Результат d = 7 + 4 = 11.
                // a после вычисления результата станет 6

            /*Итог:
            a = 6
            b = 4
            c = 7
            d = 11
            */

                System.out.println(a + " " + b + " " + c + " " + d);
            /*
            Вывод: 6 4 7 11
            */
        }



        {
            // №3
            int a = 1, b = 2;

            // Вариант A (через temp)
            int temp = a;

            a = b;
            b = temp;
            System.out.println(a + " " + b); // Вывод: 2 1


            //Вариант B (без temp)
            a = 1;
            b = 2;

            a = a + b;
            b = a - b;
            a = a - b;
            System.out.println(a + " " + b); // Вывод 2 1
        }


        {
            //№4
            int x = 10, y = 20, z = 10;
            boolean r1 = x == z; // true, потом что условие верное (10 == 10)

            boolean r2 = x != y; // true, условие также верно (10 != 20)

            boolean r3 = x < y && y > z; // true, верно (10 < 20 и 20 > 10)

            boolean r4 = x > y || x == z; // true, условие (10 > 20 -> false), условие (10 == 10 -> true),
            // хотя бы одно true, поэтому результат true

            boolean r5 = !(x == y) && (y >= 20); // true, первое условие дает !false = true и
            // второе условие true (20>=20)

            boolean r6 = x == 10 || 1/0 > 0; // true, благодаря оператору || срабатывает первое условие true (10 == 10)
            // и сразу возвращается ответ true даже не проверяяя второе условие
        }
    }
}





