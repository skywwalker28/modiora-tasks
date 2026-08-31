package skyww.modiora.block5.Task5.entities;

import skyww.modiora.block5.Task5.abstracts.Mammal;
import skyww.modiora.block5.Task5.interfaces.Feedable;
import skyww.modiora.block5.Task5.interfaces.Trainable;

public class Dog extends Mammal implements Feedable, Trainable {
    private final String[] learnedCommands;
    private int commandCount;
    private int trainingLevel;


    public Dog(String name, String species, int age, double weight, boolean isFurry) {
        super(name, species, age, weight, isFurry);
        learnedCommands = new String[20];
        commandCount = 0;
        trainingLevel = 0;
    }

    @Override
    public String makeSound() { return getName() + ": Гав-гав!"; }

    @Override
    public void feed(String foodType, double amount) {
        System.out.printf("%s съедает %.1f кг %s%n", getName(), amount, foodType);
    }

    @Override public double getDailyFoodAmount() { return getWeight() * 0.03; }
    @Override public String getPreferredFood() { return "Мясо"; }

    @Override
    public boolean train(String command) {
        for (int i = 0; i < commandCount; i++) {
            if (learnedCommands[i].equals(command)) {
                System.out.println(getName() + " уже знает команду: " + command);
                return false;
            }
        }

        if (commandCount < learnedCommands.length) {
            learnedCommands[commandCount++] = command;
            trainingLevel = Math.min(10, trainingLevel + 1);
            System.out.println(getName() + " освоил команду: " + command);
            return true;
        }

        return false;
    }

    @Override
    public String[] getLearnedCommands() {
        String[] result = new String[commandCount];
        System.arraycopy(learnedCommands, 0, result, 0, commandCount);
        return result;
    }

    @Override public int getTrainingLevel() { return trainingLevel; }
}
