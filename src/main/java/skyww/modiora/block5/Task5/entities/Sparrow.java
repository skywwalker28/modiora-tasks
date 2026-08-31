package skyww.modiora.block5.Task5.entities;

import skyww.modiora.block5.Task5.abstracts.Bird;
import skyww.modiora.block5.Task5.interfaces.Feedable;

public class Sparrow extends Bird implements Feedable {
    public Sparrow(String name, String species, int age, double weight,
                   double wingSpan, boolean canFly) {
        super(name, species, age, weight, wingSpan, canFly);
    }

    @Override public void layEggs() { System.out.println(getName() + ": откладывает яйца"); }
    @Override public String makeSound() { return getName() + ": чирик-чирик"; }

    @Override
    public void feed(String foodType, double amount) {
        System.out.printf("%s воробей съедает %.1f кг %s%n", getName(), amount, foodType);
    }

    @Override public double getDailyFoodAmount() { return getWeight() * 0.35; }
    @Override public String getPreferredFood() { return "Зерна"; }
}
