package skyww.modiora.block5.Task5.entities;

import skyww.modiora.block5.Task5.abstracts.Reptile;
import skyww.modiora.block5.Task5.interfaces.Feedable;

public class Chameleon extends Reptile implements Feedable {
    private String currentColor;

    public Chameleon(String name, String species, int age, double weight,
                     boolean isPoisonous, String currentColor) {
        super(name, species, age, weight, isPoisonous);
        this.currentColor = currentColor;
    }

    @Override public String makeSound() { return getName() + ": Шшшшш"; }

    @Override
    public void feed(String foodType, double amount) {
        System.out.printf("%s хамелеон съедает %.1f кг %s%n", getName(), amount, foodType);
    }

    @Override public double getDailyFoodAmount() { return getWeight() * 0.015; }
    @Override public String getPreferredFood() { return "Сверчки"; }

    public String getCurrentColor() { return currentColor; }
    public void setCurrentColor(String newColor) { currentColor = newColor; }
}
