package skyww.modiora.block5.Task1;

public class Vehicle {
    private final String brand;
    private final String model;
    private final int year;
    private double speed;

    public Vehicle(String brand, String model, int year, double speed) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.speed = speed;
    }

    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public double getSpeed() { return speed; }
    public void setSpeed(double newSpeed) { speed = newSpeed; }


    public void accelerate(double value) {
        speed += value;
    }

    public void brake(double value) {
        speed -= value;
        if (speed < 0) {
            speed = 0;
        }
    }

    @Override
    public String toString() {
        return  "Vehicle {"
                + "\n   Марка: " + brand
                + "\n   Модель: " + model
                + "\n   Год производства: " + year
                + "\n   Скорость: " + speed + "\n}\n";
    }
}
