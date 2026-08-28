package skyww.modiora.block5.Task1;

public class ElectricCar extends Car {
    private double batteryLevel;

    public ElectricCar(String brand, String model, int year, double speed,
                       int doors, String fuelType, double batteryLevel) {
        super(brand, model, year, speed, doors, fuelType);
        this.batteryLevel = batteryLevel;
    }

    public void charge(double value) {
        batteryLevel += value;
        if (batteryLevel > 100) {
            batteryLevel = 100;
        }
    }

    @Override
    public void accelerate(double val) {
        double energyCost = val / 10;
        if (energyCost <= batteryLevel) {
            batteryLevel -= energyCost;
            setSpeed(getSpeed() + val);
        } else {
            System.out.println("Недостаточно энергии");
        }
    }

    @Override
    public String toString() {
        return "ElectricCar {"
                + "\n   Бренд: " + getBrand()
                + "\n   Модель: " + getModel()
                + "\n   Кол-во дверей: " + getDoors()
                + "\n   Тип топлива: " + getFuelType()
                + "\n   Уровень баттареи: " + batteryLevel;
    }
}
