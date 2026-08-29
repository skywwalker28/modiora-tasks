package skyww.modiora.block5.Task1.Number1;

public class Truck extends Vehicle {
    private final double maxLoad;
    private double currentLoad;

    public Truck(String brand, String model, int year, double speed, double maxLoad, double currentLoad) {
        super(brand, model, year, speed);
        this.maxLoad = maxLoad;
        this.currentLoad = currentLoad;
    }

    public boolean loadCargo(double value) {
        if ((currentLoad + value) <= maxLoad) {
            currentLoad += value;
            return true;
        }

        return false;
    }

    public boolean unloadCargo(double value) {
        if ((currentLoad - value) >= 0) {
            currentLoad -= value;
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Truck{"
                + "\n   Макс. Загрузка: " + maxLoad
                + "\n   Текущая загрузка: " + currentLoad
                + "\n   Модель: " + getModel()
                + "\n   Скорость: " + getSpeed()
                + "\n   Год производства: " + getYear() + "\n}\n";
    }
}
