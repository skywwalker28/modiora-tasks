package skyww.modiora.block5.Task2;

public class Main {
    public static void main(String[] args) {
        Shape[] mas = {
                new Circle(3),
                new Rectangle(4, 5),
                new Triangle(6, 4, 9),
                new Circle(5),
                new Rectangle(2, 1),
                new Triangle(3, 3, 1)
        };

        printAll(mas);
        System.out.println("Суммарная площадь: " + totalArea(mas));

        System.out.println("Фигура с наибольшей площадью: ");
        findLargest(mas).printInfo();

        /*
        Вывод:
        Circle {
           Площадь: 28.27
            Периметр: 18.85
        }

        Rectangle {
           Площадь: 20.00
            Периметр: 18.00
        }

        Triangle {
           Площадь: 9.56
            Периметр: 19.00
        }

        Circle {
           Площадь: 78.54
            Периметр: 31.42
        }

        Rectangle {
           Площадь: 2.00
            Периметр: 6.00
        }

        Triangle {
           Площадь: 1.48
            Периметр: 7.00
        }

        Суммарная площадь: 139.8554659172805
        Фигура с наибольшей площадью:
        Circle {
           Площадь: 78.54
            Периметр: 31.42
        }
        */
    }

    public static void printAll(Shape[] mas) {
        for (Shape current : mas) {
            current.printInfo();
        }
    }

    public static double totalArea(Shape[] mas) {
        double result = 0.0;
        for (Shape current : mas) {
            result += current.area();
        }

        return result;
    }

    public static Shape findLargest(Shape[] mas) {
        Shape result = mas[0];

        for (Shape current : mas) {
            if (current.area() > result.area()) {
                result = current;
            }
        }

        return result;
    }
}
