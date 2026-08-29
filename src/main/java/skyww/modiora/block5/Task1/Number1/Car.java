package skyww.modiora.block5.Task1.Number1;

public class Car extends Vehicle {
    private final int doors;
    private final String fuelType;

    public Car(String brand, String model, int year, double speed, int doors, String fuelType) {
        super(brand, model, year, speed);
        this.doors = doors;
        this.fuelType = fuelType;
    }

    public int getDoors() { return doors; }
    public String getFuelType() { return fuelType; }

    @Override
    public String toString() {
        return  "Car {"
                + " Марка: " + getBrand()
                + "\n   Модель: " + getModel()
                + "\n   Год производства: " + getYear()
                + "\n   Скорость: " + getSpeed()
                + "\n   Кол-во дверей: " + doors
                + "\n   Тип топлива: " + fuelType + "\n}\n";
    }
}
