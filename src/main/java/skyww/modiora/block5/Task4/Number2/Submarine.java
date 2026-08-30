package skyww.modiora.block5.Task4.Number2;

public class Submarine implements Swimmable {
    @Override
    public void swim() {
        System.out.println("Подводная лодка плывет");
    }

    @Override
    public int getMaxDepth() {
        return 500;
    }
}
