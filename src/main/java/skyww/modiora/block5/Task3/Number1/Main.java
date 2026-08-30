package skyww.modiora.block5.Task3.Number1;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle("Red", 3),
                new Rectangle("Blue", 2, 1),
                new Triangle("Black", 2, 3, 2),
                new RightTriangle("Yellow", 2, 3),
                new Circle("Purple", 1),
                new RightTriangle("Green", 4, 4)
        };

        printAll(shapes);
        System.out.printf("%nОбщая площадь: %.2f%n", totalArea(shapes));
        System.out.println("\nПосле сортировки: ");

        sortByArea(shapes);
        printAll(shapes);

        /*
        Вывод:
        1) Circle { Цвет: Red; | Площадь: 28.27; | Периметр: 18.85 }
        2) Rectangle { Цвет: Blue; | Площадь: 2.00; | Периметр: 6.00 }
        3) Triangle { Цвет: Black; | Площадь: 1.98; | Периметр: 7.00 }
        4) RightTriangle { Цвет: Yellow; | Площадь: 3.00; | Периметр: 8.61 }
        5) Circle { Цвет: Purple; | Площадь: 3.14; | Периметр: 6.28 }
        6) RightTriangle { Цвет: Green; | Площадь: 8.00; | Периметр: 13.66 }

        Общая площадь: 46.40

        После сортировки:
        1) Triangle { Цвет: Black; | Площадь: 1.98; | Периметр: 7.00 }
        2) Rectangle { Цвет: Blue; | Площадь: 2.00; | Периметр: 6.00 }
        3) RightTriangle { Цвет: Yellow; | Площадь: 3.00; | Периметр: 8.61 }
        4) Circle { Цвет: Purple; | Площадь: 3.14; | Периметр: 6.28 }
        5) RightTriangle { Цвет: Green; | Площадь: 8.00; | Периметр: 13.66 }
        6) Circle { Цвет: Red; | Площадь: 28.27; | Периметр: 18.85 }
        */
    }

    public static void printAll(Shape[] mas) {
        int count = 0;
        for (Shape cur : mas) {
            System.out.print(++count + ") ");
            cur.printInfo();
        }
    }

    public static double totalArea(Shape[] mas) {
        double result = 0.0;
        for (Shape cur : mas) {
            result += cur.area();
        }

        return result;
    }

    public static void sortByArea(Shape[] mas) {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < mas.length - 1; i++) {
                if (mas[i].area() > mas[i+1].area()) {
                    Shape temp = mas[i];
                    mas[i] = mas[i+1];
                    mas[i+1] = temp;
                    flag = true;
                }
            }
        }
    }
}
