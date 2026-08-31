package skyww.modiora.block5.Task5.abstracts;

public abstract class Reptile extends Animal {
    private final boolean isPoisonous;
    public Reptile(String name, String species, int age, double weight, boolean isPoisonous) {
        super(name, species, age, weight);
        this.isPoisonous = isPoisonous;
    }

    public boolean isPoisonous() { return isPoisonous; }

    @Override
    public String getHabitatType() { return "Наземный"; }
}
