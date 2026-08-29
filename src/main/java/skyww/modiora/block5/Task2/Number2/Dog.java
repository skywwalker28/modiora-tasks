package skyww.modiora.block5.Task2.Number2;

public class Dog extends Animal {
    public Dog(String name, String breed, int years) {
        super(name, breed, years);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " гавкает");
    }

    @Override
    public void eat() {
        System.out.println(getName() + " есть собачий корм");
    }
}
