package skyww.modiora.block6.task6_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListStats {
    public static void main(String[] args) {
        List<Integer> mixed = new ArrayList<>(List.of(3, 1, 4, -1, 1));
        List<Integer> negative = new ArrayList<>(List.of(-5, -2, -9, -2));
        List<Integer> withZeros = new ArrayList<>(List.of(0, 7, 2, 0, -3, 7, 2));
        List<Integer> single = new ArrayList<>(List.of(42));
        List<Integer> empty = new ArrayList<>();

        printStats("Обычный", mixed);
        printStats("Только отрицательные", negative);
        printStats("С нулями и дубликатами", withZeros);
        printStats("Один элемент", single);
        printStats("Пустой", empty);

        System.out.println("merge:");
        List<Integer> a = new ArrayList<>(List.of(5, 3, 1));
        List<Integer> b = new ArrayList<>(List.of(4, 2, 3));
        System.out.println(a + " + " + b + " -> " + merge(a, b));
        System.out.println("Исходные списки не изменились: " + a + " и " + b);
        System.out.println(negative + " + " + withZeros + " -> " + merge(negative, withZeros));
        System.out.println(single + " + " + empty + " -> " + merge(single, empty));
        System.out.println(empty + " + " + empty + " -> " + merge(empty, empty));
        System.out.println("[MAX, 1] + [MIN] -> "
                + merge(List.of(Integer.MAX_VALUE, 1), List.of(Integer.MIN_VALUE)));

        /*
        Вывод:
        Обычный: [3, 1, 4, -1, 1]
        Сумма: 8
        Среднее: 1.6
        Макс: 4
        Мин: -1
        Положительных: 4
        Отрицательных: 1
        Без дубликатов: [3, 1, 4, -1]

        Только отрицательные: [-5, -2, -9, -2]
        Сумма: -18
        Среднее: -4.5
        Макс: -2
        Мин: -9
        Положительных: 0
        Отрицательных: 4
        Без дубликатов: [-5, -2, -9]

        С нулями и дубликатами: [0, 7, 2, 0, -3, 7, 2]
        Сумма: 15
        Среднее: 2.142857142857143
        Макс: 7
        Мин: -3
        Положительных: 4
        Отрицательных: 1
        Без дубликатов: [0, 7, 2, -3]

        Один элемент: [42]
        Сумма: 42
        Среднее: 42.0
        Макс: 42
        Мин: 42
        Положительных: 1
        Отрицательных: 0
        Без дубликатов: [42]

        Пустой: []
        Сумма: 0
        Среднее: 0.0
        Макс: 0
        Мин: 0
        Положительных: 0
        Отрицательных: 0
        Без дубликатов: []

        merge:
        [5, 3, 1] + [4, 2, 3] -> [1, 2, 3, 3, 4, 5]
        Исходные списки не изменились: [5, 3, 1] и [4, 2, 3]
        [-5, -2, -9, -2] + [0, 7, 2, 0, -3, 7, 2] -> [-9, -5, -3, -2, -2, 0, 0, 2, 2, 7, 7]
        [42] + [] -> [42]
        [] + [] -> []
        [MAX, 1] + [MIN] -> [-2147483648, 1, 2147483647]
        */
    }

    // Выводит результаты всех методов для одного тестового списка
    private static void printStats(String title, List<Integer> list) {
        System.out.println(title + ": " + list);
        System.out.println("Сумма: " + sum(list));
        System.out.println("Среднее: " + average(list));
        System.out.println("Макс: " + max(list));
        System.out.println("Мин: " + min(list));
        System.out.println("Положительных: " + countPositive(list));
        System.out.println("Отрицательных: " + countNegative(list));
        System.out.println("Без дубликатов: " + removeDuplicates(list));
        System.out.println();
    }

    public static int sum(List<Integer> list) {
        int result = 0;

        for (int number : list) {
            result += number;
        }

        return result;
    }

    public static double average(List<Integer> list) {
        if (list.isEmpty()) return 0;

        return (double) sum(list) / list.size();
    }

    public static int max(List<Integer> list) {
        if (list.isEmpty()) return 0;
        int result = list.get(0);

        for (int number : list) {
            result = Math.max(result, number);
        }

        return result;
    }

    public static int min(List<Integer> list) {
        if (list.isEmpty()) return 0;
        int result = list.get(0);

        for (int number : list) {
            result = Math.min(result, number);
        }

        return result;
    }

    public static int countPositive(List<Integer> list) {
        int result = 0;

        for (int number : list) {
            if (number > 0) {
                result++;
            }
        }

        return result;
    }

    public static int countNegative(List<Integer> list) {
        int result = 0;

        for (int number : list) {
            if (number < 0) {
                result++;
            }
        }

        return result;
    }

    public static List<Integer> removeDuplicates(List<Integer> list) {
        List<Integer> result = new ArrayList<>();

        for (int number : list) {
            if (!result.contains(number)) {
                result.add(number);
            }
        }

        return result;
    }

    public static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        // копируем, чтобы не менять списки, которые нам передали
        List<Integer> result = new ArrayList<>(list1);
        result.addAll(list2);
        Collections.sort(result);
        return result;
    }
}
