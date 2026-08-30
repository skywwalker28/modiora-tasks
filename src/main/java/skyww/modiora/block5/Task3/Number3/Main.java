package skyww.modiora.block5.Task3.Number3;

public class Main {
    public static void main(String[] args) {
        Warrior warrior1 = new Warrior("Jake", 400, 20);
        Warrior warrior2 = new Warrior("Pol", 350, 27);

        Knight knight = new Knight("Arthur", 100, 35);

        Mage mage = new Mage("Gandalf", 90, 35);

        warrior1.attack(knight);
        knight.attack(warrior1);

        warrior2.attack(knight);
        mage.attack(warrior2);

        warrior2.attack(mage);
        mage.attack(warrior1);

        knight.attack(warrior1);
        knight.attack(warrior1);

        System.out.println("\nВсе персонажи: ");
        System.out.println(warrior1);
        System.out.println(warrior2);
        System.out.println(knight);
        System.out.println(mage);

        /*
        Вывод:
        Воин поднимает меч
        Рыцарь надевает щит
        Воин поднимает меч
        Маг произносит заклинание
        Воин поднимает меч
        Маг произносит заклинание
        Рыцарь надевает щит
        Рыцарь надевает щит

        Все персонажи:
        Warrior {
            Имя: Jake
            Здоровье: 139
            Аттака: 20
        }


        Warrior {
            Имя: Pol
            Здоровье: 245
            Аттака: 27
        }


        Knight {
            Имя: Arthur
            Здоровье: 21
            Аттака: 35
        }


        Mage {
            Имя: Gandalf
            Здоровье: 16
            Аттака: 35
        }
        */
    }
}
