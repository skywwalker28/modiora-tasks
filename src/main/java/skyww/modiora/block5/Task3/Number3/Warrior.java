package skyww.modiora.block5.Task3.Number3;

public class Warrior extends GameCharacter {
    public Warrior(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public void prepareAttack() {
        System.out.println("Воин поднимает меч");
    }

    @Override
    public int calculateDamage() {
        return getAttackPower() * 2;
    }
}
