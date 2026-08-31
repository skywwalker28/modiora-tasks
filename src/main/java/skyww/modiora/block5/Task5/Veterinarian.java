package skyww.modiora.block5.Task5;

import skyww.modiora.block5.Task5.abstracts.Animal;

public class Veterinarian {

    public void examine(Animal animal) {
        System.out.printf("Осмотр животного: %s (%s) | Текущий статус: %s%n",
                animal.getName(), animal.getSpecies(), animal.getHealthStatus());

        if (!animal.getHealthStatus().equals("Здоров")) {
            System.out.println("Обнаружены проблемы со здоровьем! Проводится лечение...");
            treat(animal);
        } else {
            System.out.println("Животное полностью здорово");
        }
    }

    public void treat(Animal animal) {
        animal.setHealthStatus("Здоров");
        System.out.println("Статус " + animal.getName() + " изменен на 'Здоров'");
    }
}
