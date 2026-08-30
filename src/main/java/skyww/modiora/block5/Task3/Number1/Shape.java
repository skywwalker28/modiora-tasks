package skyww.modiora.block5.Task3.Number1;

public abstract class Shape {
    private final String color;

    public Shape(String color) {
        this.color = color;
    }

    public abstract double area();
    public abstract double perimeter();

    public void printInfo() {
        System.out.printf("%s { Цвет: %s; | Площадь: %.2f; | Периметр: %.2f }%n",
                getClass().getSimpleName(), color, area(), perimeter());
    }
}
