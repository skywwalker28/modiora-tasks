package skyww.modiora.block3;

import java.util.Arrays;

public class Task2 {
    // №1
    public static class ArrayStats {
        public static void main(String[] args) {
            int[] massive = {5, -3, 8, 1, -9, 2, 7, 4};

            int sum = 0, max = Integer.MIN_VALUE, indexMax = 0, min = Integer.MAX_VALUE, indexMin = 0;
            int even = 0, odd = 0, positive = 0, negative = 0;

            for (int i = 0; i < massive.length; i++) {
                int cur = massive[i];

                sum += cur;
                if (cur > max) {
                    max = cur;
                    indexMax = i;
                }

                if (cur < min) {
                    min = cur;
                    indexMin = i;
                }

                if (cur % 2 == 0) even++;
                else odd++;

                if (cur > 0) positive++;
                else if (cur < 0) negative++;
            }

            System.out.printf("""
                    Массив: %s
                    Сумма: %d
                    Среднее: %.2f
                    Максимум: %d (индекс %d)
                    Минимум: %d (индекс %d)
                    Чётных: %d, нечётных: %d
                    Положительных: %d, отрицательных: %d
                    """, Arrays.toString(massive), sum, (double) sum/massive.length, max, indexMax,
                    min, indexMin, even, odd, positive, negative);

            /*
            Результат:
            Массив: [5, -3, 8, 1, -9, 2, 7, 4]
            Сумма: 15
            Среднее: 1.88
            Максимум: 8 (индекс 2)
            Минимум: -9 (индекс 4)
            Чётных: 3, нечётных: 5
            Положительных: 6 (у вас тут ошибка, в задании на сайте указана 5), отрицательных: 2
            */
        }
    }

    // №2
    public static class ArrayOps {
        public static void main(String[] args) {
            int[] massive = {1, 2, 3, 4, 5, 6, 7};

            System.out.print("Прямой порядок: ");
            for (int current : massive) System.out.print(current + " ");


            System.out.print("\nОбратный порядок: ");
            for (int i = massive.length - 1; i >= 0; i--) System.out.print(massive[i] + " ");

            int left = 0, right = massive.length - 1;
            while (left < right) {
                int temp = massive[left];
                massive[left] = massive[right];
                massive[right] = temp;
                left++;
                right--;
            }

            System.out.println("\nПосле переворота: " + Arrays.toString(massive));

            int lastEl = massive[massive.length - 1];
            for (int i = massive.length - 1; i > 0; i--) massive[i] = massive[i - 1];
            massive[0] = lastEl;

            System.out.println("После сдвига вправо: " + Arrays.toString(massive));
            /*
            Результат:
            Прямой порядок: 1 2 3 4 5 6 7
            Обратный порядок: 7 6 5 4 3 2 1
            После переворота: [7, 6, 5, 4, 3, 2, 1]
            После сдвига вправо: [1, 7, 6, 5, 4, 3, 2]
            */
        }
    }

    // №3
    public static class ArraySearch {
        public static void main(String[] args) {
            int[] massive = new int[10];
            for (int i = 0; i < massive.length; i++) massive[i] = (int) (Math.random() * 10) + 1;
            int target = 5;

            System.out.println("Массив: " + Arrays.toString(massive));

            //Обычный поиск
            boolean find = false;
            for (int i = 0; i < massive.length; i++) {
                if (massive[i] == target) {
                    find = true;
                    System.out.println("Элемент найден, его индекс: " + i);
                    break;
                }
            }

            if (!find) System.out.println("Элемент не найден в массиве");

            find = false;
            Arrays.sort(massive);
            System.out.println("Отсортированный массив: " + Arrays.toString(massive));

            // Бинарный поиск
            int left = 0, right = massive.length - 1;
            while (left <= right) {
                int mid = (right + left)/2;
                System.out.println("Поиск в диапазоне [" + left + ".." + right + "], mid = " + mid);

                if (massive[mid] == target) {
                    System.out.println("Элемент найден, его индекс: " + mid + ". Бинарный поиск");
                    find = true;
                    break;
                }
                else if (massive[mid] > target) right = mid - 1;
                else left = mid + 1;
            }

            if (!find) System.out.println("Элемент не найден в массиве. Бинарный поиск");

            /*
            Массив: [4, 10, 1, 7, 2, 5, 3, 10, 3, 5]
            Элемент найден, его индекс: 5
            Отсортированный массив: [1, 2, 3, 3, 4, 5, 5, 7, 10, 10]
            Поиск в диапазоне [0..9], mid = 4
            Поиск в диапазоне [5..9], mid = 7
            Поиск в диапазоне [5..6], mid = 5
            Элемент найден, его индекс: 5. Бинарный поиск
            */
        }
    }

    // №4
    public static class ArrayMerge {
        public static void main(String[] args) {
            int[] first = {4,5,6};
            int[] second = {1,2,3,8};

            System.out.println("Первый массив: " + Arrays.toString(first));
            System.out.println("Второй массив: " + Arrays.toString(second));

            int[] merge = new int[first.length + second.length];
            int firstIndex = 0, secondIndex = 0, index = 0, even = 0;

            while (firstIndex < first.length || secondIndex < second.length) {
                int fNum = firstIndex >= first.length ? Integer.MAX_VALUE : first[firstIndex];
                int sNum = secondIndex >= second.length ? Integer.MAX_VALUE : second[secondIndex];

                if (fNum < sNum) {
                    merge[index] = fNum;
                    firstIndex++;
                } else {
                    merge[index] = sNum;
                    secondIndex++;
                }

                if (merge[index++] % 2 == 0) even++;
            }

            System.out.println("Объединенный массив: " + Arrays.toString(merge));

            int[] evenMas = new int[even];
            int idx = 0;

            for (int cur : merge) {
                if (cur % 2 == 0) evenMas[idx++] = cur;
            }

            System.out.println("Массив с четными элементами: " + Arrays.toString(evenMas));
            /*
            Резльтат:
            Первый массив: [4, 5, 6]
            Второй массив: [1, 2, 3, 8]
            Объеденный массив: [1, 2, 3, 4, 5, 6, 8]
            Массив с четными элементами: [2, 4, 6, 8]
            */
        }
    }
}
