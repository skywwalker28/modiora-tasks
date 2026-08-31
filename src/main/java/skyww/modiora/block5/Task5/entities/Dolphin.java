package skyww.modiora.block5.Task5.entities;

import skyww.modiora.block5.Task5.abstracts.Mammal;
import skyww.modiora.block5.Task5.interfaces.Aquatic;
import skyww.modiora.block5.Task5.interfaces.Feedable;
import skyww.modiora.block5.Task5.interfaces.Trainable;

public class Dolphin extends Mammal implements Feedable, Trainable, Aquatic {
    private final String[] learnedCommands;
    private int commandsCount;
    private int trainingLevel;

    public Dolphin(String name, String species, int age, double weight, boolean isFurry) {
        super(name, species, age, weight, isFurry);
        learnedCommands = new String[20];
        commandsCount = 0;
        trainingLevel = 0;
    }

    @Override public String makeSound() { return getName() + " Кххх-кххх"; }
    @Override public void swim() { System.out.println(getName() + " дельфин плавает!"); }
    @Override public int getMaxDepth() { return 300; }
    @Override public boolean canBreathUnderwater() { return true; }

    @Override
    public void feed(String foodType, double amount) {
        System.out.printf("%s дельфин съедает %.1f кг %s%n", getName(), amount, foodType);
    }

    @Override public double getDailyFoodAmount() { return getWeight() * 0.05; }
    @Override public String getPreferredFood() { return "Кальмары"; }

    @Override
    public boolean train(String command) {
        for (int i = 0; i < commandsCount; i++) {
            if (learnedCommands[i].equals(command)) {
                System.out.println(getName() + " уже знает команду: " + command);
                return false;
            }
        }

        if (commandsCount < learnedCommands.length) {
            learnedCommands[commandsCount++] = command;
            trainingLevel = Math.min(10, trainingLevel + 1);
            return true;
        }

        return false;
    }

    @Override
    public String[] getLearnedCommands() {
        String[] copy = new String[commandsCount];
        System.arraycopy(learnedCommands, 0, copy, 0, commandsCount);
        return copy;
    }

    @Override public int getTrainingLevel() { return trainingLevel; }
}
