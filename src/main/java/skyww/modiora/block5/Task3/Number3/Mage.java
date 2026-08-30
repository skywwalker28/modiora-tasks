package skyww.modiora.block5.Task3.Number3;

public class Mage extends GameCharacter {
    public Mage(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public void prepareAttack() {
        System.out.println("Маг произносит заклинание");
    }


    /*
    * Вычисляет урон от заклинания Мага
    * ПОБОЧНЫЙ ЭФФЕКТ: уменьшает текущее здоровье мага на 10hp
    */
    @Override
    public int calculateDamage() {
        setHealth(getHealth() - 10);
        return getAttackPower() * 3;
    }
}
