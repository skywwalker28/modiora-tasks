package skyww.modiora.block5.Task3.Number3;

public class Knight extends GameCharacter {
    public Knight(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public void prepareAttack() {
        System.out.println("Рыцарь надевает щит");
    }

    @Override
    public int calculateDamage() {
        return (int) (getAttackPower() * 1.5);
    }

    @Override
    public void afterAttack() {
        setHealth(getHealth() + 5);
    }
}
