package skyww.modiora.block5.Task2;

public class Shape {

    public double area() {
        return 0.0;
    }

    public double perimeter() {
        return 0.0;
    }

    public void printInfo() {
        System.out.printf("%s {%n   Площадь: %.2f\n    Периметр: %.2f%n}%n%n",
                getClass().getSimpleName(), area(), perimeter());
    }
}
