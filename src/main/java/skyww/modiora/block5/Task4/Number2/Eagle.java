package skyww.modiora.block5.Task4.Number2;

public class Eagle implements Flyable, Runnable {

    @Override
    public void fly() {
        System.out.println("Орел летит");
    }

    @Override
    public int getMaxAltitude() {
        return 4000;
    }

    @Override
    public void run() {
        System.out.println("Орел бежит");
    }

    @Override
    public double getMaxSpeed() {
        return 15.0;
    }
}
