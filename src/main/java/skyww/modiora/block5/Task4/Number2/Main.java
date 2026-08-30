package skyww.modiora.block5.Task4.Number2;

public class Main {
    public static void main(String[] args) {
        Flyable[] ableToFly = {
                new Duck(),
                new Eagle()
        };

        Swimmable[] ableToSwim = {
                new Duck(),
                new Fish(),
                new Submarine()
        };

        Runnable[] ableToRun = {
                new Duck(),
                new Eagle()
        };

        makeAllFly(ableToFly);
        makeALlSwim(ableToSwim);
        makeAllRun(ableToRun);

        /*
        Вывод:
        Утка летит
        | Макс. высота: 100|

        Орел летит
        | Макс. высота: 4000|

        Утка плывет
        | Макс. глубина: 2|

        Рыба плывет
        | Макс. глубина: 100|

        Подводная лодка плывет
        | Макс. глубина: 500|

        Утка бежит
        | Макс. скорость: 5.5|

        Орел бежит
        | Макс. скорость: 15.0|

        */
    }

    public static void makeAllFly(Flyable[] mas) {
        for (Flyable cur : mas) {
            cur.fly();
            System.out.println("| Макс. высота: " + cur.getMaxAltitude() + "|\n");
        }
    }

    public static void makeALlSwim(Swimmable[] mas) {
        for (Swimmable cur : mas) {
            cur.swim();
            System.out.println("| Макс. глубина: " + cur.getMaxDepth() + "|\n");
        }
    }

    public static void makeAllRun(Runnable[] mas) {
        for (Runnable cur : mas) {
            cur.run();
            System.out.println("| Макс. скорость: " + cur.getMaxSpeed() + "|\n");
        }
    }
}
