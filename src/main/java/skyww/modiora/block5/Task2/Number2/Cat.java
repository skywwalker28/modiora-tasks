package skyww.modiora.block5.Task2.Number2;

public class Cat extends Animal {
    public Cat(String name, String breed, int years) {
        super(name, breed, years);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " мяукает");
    }

    @Override
    public void eat() {
        System.out.println(getName() + " есть кошачий корм");
    }
}
