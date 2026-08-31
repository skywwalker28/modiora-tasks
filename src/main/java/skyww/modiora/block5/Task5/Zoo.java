package skyww.modiora.block5.Task5;

import skyww.modiora.block5.Task5.abstracts.Animal;
import skyww.modiora.block5.Task5.interfaces.Feedable;
import skyww.modiora.block5.Task5.interfaces.Trainable;

public class Zoo {
    private final String name;
    private final ZooEnclosure[] enclosures;
    private int enclosureCount;


    public Zoo(String name, int maxEnclosures) {
        this.name = name;
        this.enclosures = new ZooEnclosure[maxEnclosures];
    }

    public void addEnclosure(ZooEnclosure enclosure) {
        if (enclosureCount >= enclosures.length) {
            System.out.println("Мест в зоопарке" + name +  " нет");
            return;
        }

        enclosures[enclosureCount++] = enclosure;
        System.out.println("Добавили новый вольер: " + enclosure.getName());
    }

    public void dailyRoutine() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Ежедневный распорядок зоопарка: " + name);
        System.out.println("=".repeat(50));

        for (int i = 0; i < enclosureCount; i++) {
            enclosures[i].feedAll();
            enclosures[i].trainAll();
        }
    }

    public void printFullReport() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("ОТЧЕТ ЗООПАРКА: " + name);
        System.out.println("=".repeat(50));
        int totalAnimals = 0;

        for (int i = 0; i < enclosureCount; i++) {
            enclosures[i].printStatus();
            totalAnimals += enclosures[i].getCountAnimals();
        }

        System.out.println("\nВсего вальеров: " + enclosureCount);
        System.out.println("Всего животных: " + totalAnimals);
    }

    public Animal findMaxTrainingLevel() {
        Animal result = null;
        int maxLevel = -1;

        for (int i = 0; i < enclosureCount; i++) {
            Animal cur = enclosures[i].getMostTrainedAnimal();

            if (cur instanceof Trainable trainable) {
                if (trainable.getTrainingLevel() > maxLevel) {
                    maxLevel = trainable.getTrainingLevel();
                    result = cur;
                }
            }
        }


        return result;
    }

    public double calculateTotalDailyFood() {
        double result = 0.0;

        for (int i = 0; i < enclosureCount; i++) {
            result += enclosures[i].getTotalFoodAmount();
        }

        return result;
    }
}
