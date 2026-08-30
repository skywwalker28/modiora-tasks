package skyww.modiora.block5.Task3.Number1;

public class Triangle extends Shape {
    private final double a;
    private final double b;
    private final double c;

    public Triangle(String color, double a, double b, double c) {
        super(color);
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Такого треугольника не сущ-ет");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        double p = perimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }
}
