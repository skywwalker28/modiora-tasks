package skyww.modiora.block3;

public class Task3 {

    // №1
    public static class MatrixOps {
        public static void main(String[] args) {
            int[][] matrix = {
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {15, 14, 17, 13}
            };

            int sum = 0, sumSecDiagonal = 0, secondaryDiagonal = matrix[0].length - 1, sumMainDiagonal = 0;
            for (int i = 0; i < matrix.length; i++) {
                sumSecDiagonal += matrix[i][secondaryDiagonal--];
                sumMainDiagonal += matrix[i][i];

                int maxEl = Integer.MIN_VALUE;
                for (int j = 0; j < matrix[0].length; j++) {
                    sum += matrix[i][j];
                    maxEl = Math.max(maxEl, matrix[i][j]);
                }

                System.out.println("Максимальный элемент в строке " + (i + 1) + ": " + maxEl);
            }

            for (int i = 0; i < matrix[0].length; i++) {
                int sumColumn = 0;
                for (int[] col : matrix) sumColumn += col[i];


                System.out.println("Сумма столбца " + (i + 1) + ": " + sumColumn);
            }

            System.out.println("Сумма всей матрицы: " + sum);
            System.out.println("Сумма побочной диагонали: " + sumSecDiagonal);
            System.out.println("Сумма главной диагонали: " + sumMainDiagonal);
        }
    }

    // №2
    public static class MatrixTransform {
        public static void main(String[] args) {

            int[][] matrix = {
                    {1, 2, 3, 4},
                    {5, 6, 12, 8},
                    {9, 10, 11, 7}
            };

            // транспонирование матрицы
            int[][] transposition = new int[matrix[0].length][matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    transposition[j][i] = matrix[i][j];
                }
            }

            // Вывод матрицы
            System.out.println("Транспонированная матрица: ");
            for (int[] row : transposition) {
                for (int element : row) {
                    System.out.printf("%6d", element);
                }
                System.out.println();
            }


            // Поиск максимального элемента
            int maxEl = Integer.MIN_VALUE, columnIndex = 0, rowIndex = 0;
            for (int i = 0; i < transposition.length; i++) {
                for (int j = 0; j < transposition[0].length; j++) {
                    if (maxEl < transposition[i][j]) {
                        maxEl = transposition[i][j];
                        rowIndex = i;
                        columnIndex = j;
                    }
                }
            }

            System.out.println("Максимальный элемент: " + maxEl);

            // Вывод строки
            System.out.print("Вывод строки: ");
            for (int j = 0; j < transposition[0].length; j++) System.out.print(transposition[rowIndex][j] + " ");

            // Вывод столбца
            System.out.print("\nВывод столбца: ");
            for (int[] ints : transposition) System.out.print(ints[columnIndex] + " ");


            /*
            Вывод:
            Транспонированная матрица:
                 1     5     9
                 2     6    10
                 3    12    11
                 4     8     7
            Максимальный элемент: 12
            Вывод строки: 3 12 11
            Вывод столбца: 5 6 12 8
            */
        }
    }

    // №3
    public static class GameBoard {

        public static void main(String[] args) {
            char[][] chessBoard = new char[8][8];

            // Создание и вывод доски
            System.out.println("Шахматная доска: ");
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if ((i + j) % 2 == 0) chessBoard[i][j] = '.';
                    else chessBoard[i][j] = '#';

                    System.out.print(chessBoard[i][j] + " ");
                }

                System.out.println();
            }

            // Расстановка ферзей
            for (int col = 0; col < 8; col++) chessBoard[0][col] = 'Q';

            System.out.println("\nПосле расстановки: ");
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    System.out.print(chessBoard[i][j] + " ");
                }

                System.out.println();
            }

            // Проверка атак
            System.out.println("\nПроверка атак ферзей: ");
            boolean attack = false;
            for (int col = 0; col < 8; col++) {
                if (chessBoard[0][col] == 'Q') {
                    for (int nextCol = col + 1; nextCol < 8; nextCol++) {
                        if (chessBoard[0][nextCol] == 'Q') {
                            attack = true;
                            System.out.println("Ферзи, на позициях (0, " + col + ") и (0, " + nextCol + ")" +
                                    " бьют друга друга");
                        }
                    }
                }

            }

            if (attack) System.out.println("Ферзи бьют друг друга");
            else System.out.println("Ферзи не бьют друг друга");

            /*
            Результат:

            Шахматная доска:
            . # . # . # . #
            # . # . # . # .
            . # . # . # . #
            # . # . # . # .
            . # . # . # . #
            # . # . # . # .
            . # . # . # . #
            # . # . # . # .

            После расстановки:
            Q Q Q Q Q Q Q Q
            # . # . # . # .
            . # . # . # . #
            # . # . # . # .
            . # . # . # . #
            # . # . # . # .
            . # . # . # . #
            # . # . # . # .

            Проверка атак ферзей:
            Ферзи, на позициях (0, 0) и (0, 1) бьют друга друга
            Ферзи, на позициях (0, 0) и (0, 2) бьют друга друга
            Ферзи, на позициях (0, 0) и (0, 3) бьют друга друга
            ...

            Ферзи бьют друг друга
            */
        }
    }

    // №4
    public static class PascalTriangle {
        public static void main(String[] args) {
            int[][] triangle = new int[8][];

            // Создание треугольника Паскаля
            for (int i = 0; i < 8; i++) {
                triangle[i] = new int[i + 1];
                triangle[i][0] = 1;
                triangle[i][i] = 1;

                for (int j = 1; j < i; j++) {
                    triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
                }
            }

            // Вывод треугольника
            System.out.println("Треугольник Паскаля:");
            for (int i = 0; i < 8; i++) {
                int space = (8 - i - 1) * 4 / 2;
                System.out.print(" ".repeat(space));

                for (int j = 0; j <= i; j++) System.out.printf("%-4d", triangle[i][j]);
                System.out.println();
            }

            // Проверка
            System.out.println("\nПроверка сумм строк:");
            for (int i = 0; i < 8; i++) {
                int sum = 0;
                for (int j = 0; j <= i; j++) sum += triangle[i][j];

                int correctRes = (int) Math.pow(2, i);
                System.out.printf("""
                        Строка %d:
                        Сумма = %d
                        2^%d = %d
                        Правильно: %s%n
                        """, i, sum, i, correctRes, sum == correctRes ? "да" : "нет");
            }

            /*
            Результат:
            Треугольник Паскаля:
            1
            1   1
            1   2   1
            1   3   3   1
            1   4   6   4   1
            1   5   10  10  5   1
            1   6   15  20  15  6   1
            1   7   21  35  35  21  7   1

            Проверка сумм строк:
            Строка 0:
            Сумма = 1
            2^0 = 1
            Правильно: да

            Строка 1:
            Сумма = 2
            2^1 = 2
            Правильно: да

            Строка 2:
            Сумма = 4
            2^2 = 4
            Правильно: да

            Строка 3:
            Сумма = 8
            2^3 = 8
            Правильно: да

            Строка 4:
            Сумма = 16
            2^4 = 16
            Правильно: да

            Строка 5:
            Сумма = 32
            2^5 = 32
            Правильно: да

            Строка 6:
            Сумма = 64
            2^6 = 64
            Правильно: да

            Строка 7:
            Сумма = 128
            2^7 = 128
            Правильно: да
            */
        }
    }
}