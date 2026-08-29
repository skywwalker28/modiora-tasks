package skyww.modiora.block5.Task2.Number2;

public class Main {

    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();

        shelter.addAnimal(new Dog("Собака1", "Порода1", 3));
        shelter.addAnimal(new Cat("Кошка1", "Порода2", 1));
        shelter.addAnimal(new Dog("Собака2", "Порода3", 5));

        shelter.makeAllSound();
        shelter.feedAll();

        System.out.println("Собак в приюте: " + shelter.countByType("Dog"));
        System.out.println("Кошек в приюте: " + shelter.countByType("Cat"));

        Animal found = shelter.findByName("Кошка1");
        if (found instanceof Cat) {
            System.out.println(found.getName() + " - это кошка");
        } else if (found instanceof Dog) {
            System.out.println(found.getName() + " - это собака");
        }

        shelter.removeAnimal("Собака2");
        System.out.println("После удаления собак в приюте: " + shelter.countByType("Dog"));

        /*
        Вывод:
        Собака1 гавкает
        Кошка1 мяукает
        Собака2 гавкает
        Собака1 есть собачий корм
        Кошка1 есть кошачий корм
        Собака2 есть собачий корм
        Собак в приюте: 2
        Кошек в приюте: 1
        Кошка1 - это кошка
        После удаления собак в приюте: 1
        */
    }
}
