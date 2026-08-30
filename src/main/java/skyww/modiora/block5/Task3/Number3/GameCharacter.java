package skyww.modiora.block5.Task3.Number3;

public abstract class GameCharacter {
    private final String name;
    private int health;
    private final int attackPower;

    public GameCharacter(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public int getAttackPower() { return attackPower; }

    public int getHealth() { return health; }
    public void setHealth(int newHealth) {
        health = Math.max(0, newHealth);
    }

    public abstract void prepareAttack();
    public abstract int calculateDamage();
    public  void afterAttack() {}

    public void takeDamage(int damage) {
        setHealth(this.health - damage);
    }

    public final void attack(GameCharacter target) {
        prepareAttack();

        target.takeDamage(calculateDamage());
        afterAttack();
    }

    @Override
    public String toString() {
        return String.format(
                """
                %s {
                    Имя: %s
                    Здоровье: %d
                    Аттака: %d
                }%n
                """, getClass().getSimpleName(), name, health, attackPower);
    }
}
