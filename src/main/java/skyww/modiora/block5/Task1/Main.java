package skyww.modiora.block5.Task1;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle("Audi", "Audi RS7", 2026, 100);
        Car car = new Car("Audi", "Audi RS7", 2026, 100, 4, "АИ-100 / АИ-95");
        Truck truck = new Truck("Volvo", "FH16 750", 2024, 40, 25000, 0);
        ElectricCar electricCar = new ElectricCar("Porsche", "Taycan Turbo S", 2026, 90, 4, "CCS Combo 2", 0);

        vehicle.accelerate(1000);
        vehicle.brake(400);
        System.out.println(vehicle);

        System.out.println(car);

        System.out.println("Загрузить 10 000: " + truck.loadCargo(10000));
        System.out.println("Загрузить 15 000: + " + truck.loadCargo(15000));
        System.out.println("Загрузить 100 :" + truck.loadCargo(100));

        System.out.println("Выгрузить 5 000: " + truck.unloadCargo(5000));
        System.out.println("Выгрузить 50 000: " + truck.unloadCargo(50000) + "\n");
        System.out.println(truck);

        electricCar.charge(140);
        electricCar.accelerate(500);
        System.out.println(electricCar);

        /*
        Вывод:
        Vehicle {
           Марка: Audi
           Модель: Audi RS7
           Год производства: 2026
           Скорость: 700.0
        }

        Car { Марка: Audi
           Модель: Audi RS7
           Год производства: 2026
           Скорость: 100.0
           Кол-во дверей: 4
           Тип топлива: АИ-100 / АИ-95
        }

        Загрузить 10 000: true
        Загрузить 15 000: + true
        Загрузить 100 :false
        Выгрузить 5 000: true
        Выгрузить 50 000: false

        Truck{
           Макс. Загрузка: 25000.0
           Текущая загрузка: 20000.0
           Модель: FH16 750
           Скорость: 40.0
           Год производства: 2024
        }

        ElectricCar {
           Бренд: Porsche
           Модель: Taycan Turbo S
           Кол-во дверей: 4
           Тип топлива: CCS Combo 2
           Уровень баттареи: 50.0
        */
    }
}
