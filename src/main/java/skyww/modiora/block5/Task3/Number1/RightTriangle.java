package skyww.modiora.block5.Task3.Number1;

public class RightTriangle extends Shape {
    private final double a;
    private final double b;
    private final double c;

    public RightTriangle(String color, double a, double b) {
        super(color);
        this.a = a;
        this.b = b;
        c = Math.sqrt(a * a + b * b);
    }

    @Override
    public double area() {
        return (a * b)/2;
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }
}
