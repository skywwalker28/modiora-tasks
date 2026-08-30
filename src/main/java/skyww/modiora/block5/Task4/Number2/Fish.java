package skyww.modiora.block5.Task4.Number2;

public class Fish implements Swimmable {
    @Override
    public void swim() {
        System.out.println("Рыба плывет");
    }

    @Override
    public int getMaxDepth() {
        return 100;
    }
}
