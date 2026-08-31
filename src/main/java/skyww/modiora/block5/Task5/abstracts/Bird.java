package skyww.modiora.block5.Task5.abstracts;

public abstract class Bird extends Animal {
    private final double wingSpan;
    private final boolean canFly;

    public Bird(String name, String species, int age, double weight, double wingSpan, boolean canFly) {
        super(name, species, age, weight);
        this.wingSpan = wingSpan;
        this.canFly = canFly;
    }

    public double getWingSpan() { return wingSpan; }
    public boolean isCanFly() { return canFly; }

    @Override
    public String getHabitatType() { return canFly ? "Воздушный" : "Наземный"; }

    public abstract void layEggs();
}
