package skyww.modiora.block5.Task4.Number2;

public class Duck implements Flyable, Swimmable, Runnable {
    @Override
    public void fly() {
        System.out.println("Утка летит");
    }

    @Override
    public int getMaxAltitude() {
        return 100;
    }

    @Override
    public void run() {
        System.out.println("Утка бежит");
    }

    @Override
    public double getMaxSpeed() {
        return 5.5;
    }

    @Override
    public void swim() {
        System.out.println("Утка плывет");
    }

    @Override
    public int getMaxDepth() {
        return 2;
    }
}
