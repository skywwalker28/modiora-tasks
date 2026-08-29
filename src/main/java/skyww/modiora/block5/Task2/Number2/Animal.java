package skyww.modiora.block5.Task2.Number2;

public abstract class Animal {
    private final String name;
    private final String breed;
    private final int years;

    public Animal(String name, String breed, int years) {
        this.name = name;
        this.breed = breed;
        this.years = years;
    }

    public String getName() { return name; }

    public abstract void makeSound();
    public abstract void eat();

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {"
                + "\n   Имя: " + name
                + "\n   Порода: " + breed
                + "\n   Возраст: " + years + "\n}";
    }
}
