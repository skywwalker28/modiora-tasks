package skyww.modiora.block5.Task2.Number2;

public class AnimalShelter {
    private int index = 0;
    private final Animal[] animals = new Animal[100];

    public void addAnimal(Animal newAnimal) {
        if (index >= animals.length) {
            System.out.println("Приют переполнен");
            return;
        }

        animals[index++] = newAnimal;
    }

    public void removeAnimal(String name) {
        if (animals.length == 0 || index == 0) {
            System.out.println("В приюте нету животных");
            return;
        }

        for (int i = 0; i < index; i++) {
            if (animals[i].getName() != null && animals[i].getName().equals(name)) {
                for (int j = i; j < index - 1; j++) {
                    animals[j] = animals[j + 1];
                }

                animals[--index] = null;
                return;
            }
        }

        System.out.println("Животное с именем" + name + " не найдено");
    }

    public void makeAllSound() {
        for (int i = 0; i < index; i++) {
            animals[i].makeSound();
        }
    }

    public void feedAll() {
        for (int i = 0; i < index; i++) {
            animals[i].eat();
        }
    }

    public int countByType(String type) {
        int count = 0;

        for (int i = 0; i < index; i++) {
            if ("Dog".equalsIgnoreCase(type) && animals[i] instanceof Dog) {
                count++;
            } else if ("Cat".equalsIgnoreCase(type) && animals[i] instanceof Cat) {
                count++;
            }
        }

        return count;
    }

    public Animal findByName(String name) {
        for (int i = 0; i < index; i++) {
            if (animals[i].getName() != null && animals[i].getName().equals(name)) {
                return animals[i];
            }
        }

        return null;
    }
}
