package skyww.modiora.block5.Task5;

import skyww.modiora.block5.Task5.entities.*;

public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo("My Zoo", 5);

        ZooEnclosure dogEnclosure = new ZooEnclosure("Собачий двор", "Наземный", 5);
        ZooEnclosure waterEnclosure = new ZooEnclosure("Аквариум", "Водный", 4);
        ZooEnclosure birdEnclosure = new ZooEnclosure("Птичник", "Воздушный", 8);
        ZooEnclosure terrariumEnclosure = new ZooEnclosure("Террариум", "Наземный", 3);

        zoo.addEnclosure(dogEnclosure);
        zoo.addEnclosure(waterEnclosure);
        zoo.addEnclosure(birdEnclosure);

        // === Собачий двор ===
        Dog rex = new Dog("Рекс", "Немецкая овчарка", 35, 30, true);
        rex.train("Сидеть");
        rex.train("Лежать");
        rex.train("Дай лапу");

        Dog buddy = new Dog("Бадди", "Лабрадор", 25, 24, false);
        buddy.train("Сидеть");

        Dog max = new Dog("Макс", "Золотой ретривер", 5, 30, true);
        max.train("Дай лапу");
        max.train("Лежать");

        Dog charlie = new Dog("Чарли", "Французкий булдог", 2, 12, true);
        charlie.train("Сидеть");
        charlie.train("Кувырок");

        dogEnclosure.addAnimal(rex);
        dogEnclosure.addAnimal(buddy);
        dogEnclosure.addAnimal(max);
        dogEnclosure.addAnimal(charlie);
        // === === === === === ===


        // === Аквариум ===
        Dolphin fred = new Dolphin("Фред", "Дельфин-белобочка", 2, 0.32, false);
        fred.train("Открыть рот");
        fred.train("Показать хвост");

        Dolphin goldie = new Dolphin("Голди", "Полосатый дельфин", 1, 0.25, false);
        goldie.train("Замереть на боку");

        Dolphin casper = new Dolphin("Каспер", "Ботия", 4, 4.45, false);
        casper.train("Вращение вокруг своей оси");
        casper.train("Игра с мячом");

        Dolphin bruce = new Dolphin("Брюс", "Афалина", 23, 159, false);
        bruce.train("Прыгнуть через обруч");

        waterEnclosure.addAnimal(fred);
        waterEnclosure.addAnimal(goldie);
        waterEnclosure.addAnimal(casper);
        waterEnclosure.addAnimal(bruce);
        // === === === ===


        // === Птичник ===
        Sparrow jack = new Sparrow("Джек", "Домовой воробей", 12,
                0.25, 27, true);
        Sparrow chip = new Sparrow("Чип", "Полевой воробей", 1,
                0.022,  21.0, true);
        Sparrow rusty = new Sparrow("Расти", "Черногрудый воробей", 3,
                0.028, 23.5, true);
        Nightingale philomela = new Nightingale("Филомела", "Обыкновенный соловей",
                2, 0.025, 24, true);
        Nightingale luscinius = new Nightingale("Люсциниус", "Южный соловей",
                4, 0.027, 25.2, true);
        Nightingale rufus = new Nightingale("Руфус", "Красношейный соловей", 1,
                0.022, 22.8, false);

        birdEnclosure.addAnimal(jack);
        birdEnclosure.addAnimal(chip);
        birdEnclosure.addAnimal(rusty);
        birdEnclosure.addAnimal(philomela);
        birdEnclosure.addAnimal(luscinius);
        birdEnclosure.addAnimal(rufus);
        // === === === ===


        // === Терариум ===
        Chameleon rango = new Chameleon("Ранго", "Пантеровый хамелеон",
                5, 0.12, false, "Зеленый");
        Chameleon pascal = new Chameleon("Паскаль", "Йеменский хамелеон",
                2, 0.15, false, "Зеленый с желтыми полосами");
        Chameleon brookesia = new Chameleon("Малыш Крош", "Малая брукезия",
                1, 0.005, false, "Коричневый под цвет листьев");

        terrariumEnclosure.addAnimal(rango);
        terrariumEnclosure.addAnimal(pascal);
        terrariumEnclosure.addAnimal(brookesia);
        // === === === ===


        zoo.dailyRoutine();
        zoo.printFullReport();

        System.out.println("Самый натренированный: " + zoo.findMaxTrainingLevel());
        System.out.printf("Ежедневно уходит корма: %.2f кг", zoo.calculateTotalDailyFood());
    }
}
