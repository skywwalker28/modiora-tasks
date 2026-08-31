package skyww.modiora.block5.Task5;

import skyww.modiora.block5.Task5.abstracts.Animal;
import skyww.modiora.block5.Task5.interfaces.Feedable;
import skyww.modiora.block5.Task5.interfaces.Trainable;

public class ZooEnclosure {
    private final String name;
    private final String habitatType;
    private final Animal[] animals;
    private int countAnimals;

    public ZooEnclosure(String name, String habitatType, int capacity) {
        this.name = name;
        this.habitatType = habitatType;
        this.animals = new Animal[capacity];
        countAnimals = 0;
    }

    public boolean addAnimal(Animal animal) {
        if (countAnimals >= animals.length) {
            System.out.println("Вольер: " + name + " заполнен");
            return false;
        }

        animals[countAnimals++] = animal;
        System.out.println(animal.getName() + " помещен в вольер: " + name);
        return true;
    }

    public void feedAll() {
        System.out.println("\n--- Кормление в вольере: " + name + " ---");
        for (int i = 0; i < countAnimals; i++) {
            if (animals[i] instanceof Feedable feedable) {
                feedable.feed(feedable.getPreferredFood(), feedable.getDailyFoodAmount());
            }
        }
    }

    public void trainAll() {
        System.out.println("\n--- Тренировка в вольере: " + name + " ---");
        for (int i = 0; i < countAnimals; i++) {
            if (animals[i] instanceof Trainable trainable) {
                System.out.printf("%s | Уровень дрессировки: %d/10%n",
                        animals[i].getName(), trainable.getTrainingLevel());
            }
        }
    }

    public void printStatus() {
        System.out.println("\n=== Вольер: " + name + " (" + habitatType + ") ===");
        if (countAnimals == 0) {
            System.out.println("Пусто");
            return;
        }

        for (int i = 0; i < countAnimals; i++) {
            animals[i].printInfo();
            System.out.println("  Звук: " + animals[i].makeSound());
        }
    }

    public Animal getMostTrainedAnimal() {
        Animal result = null;
        int maxLevel = -1;

        for (int i = 0; i < countAnimals; i++) {
            if (animals[i] instanceof Trainable trainable) {
                if (maxLevel < trainable.getTrainingLevel()) {
                    maxLevel = trainable.getTrainingLevel();
                    result = animals[i];
                }
            }
        }

        return result;
    }

    public double getTotalFoodAmount() {
        double result = 0.0;

        for (int i = 0; i < countAnimals; i++) {
            if (animals[i] instanceof Feedable feedable) {
                result += feedable.getDailyFoodAmount();
            }
        }

        return result;
    }

    public int getCountAnimals() { return countAnimals; }
    public String getName() { return name; }
}
