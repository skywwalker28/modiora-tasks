package skyww.modiora.block5.Task5.entities;

import skyww.modiora.block5.Task5.abstracts.Bird;
import skyww.modiora.block5.Task5.interfaces.Feedable;

public class Nightingale extends Bird implements Feedable {
    public Nightingale(String name, String species, int age, double weight, double wingSpan, boolean canFly) {
        super(name, species, age, weight, wingSpan, canFly);
    }

    @Override public void layEggs() { System.out.println(getName() + ": откладывает яйца"); }
    @Override public String makeSound() { return getName() + ": Тю-тю-тю-тю..."; }

    @Override
    public void feed(String foodType, double amount) {
        System.out.printf("%s воробей съедает %.1f кг %s%n", getName(), amount, foodType);
    }

    @Override public double getDailyFoodAmount() { return getWeight() * 0.30; }
    @Override public String getPreferredFood() { return "Жуки"; }
}
