package skyww.modiora.block5.Task1.Number3;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("Milk", 99.9);
        Product product2 = new Product("Apple", 59.9);
        Product product3 = new Product("bread", 55.0);

        DiscountedProduct product4 = new DiscountedProduct("Eggs", 150.0, 20);
        DiscountedProduct product5 = new DiscountedProduct("Cake", 699.99, 12);
        DiscountedProduct product6 = new DiscountedProduct("Meat", 399.99, 9);

        System.out.println(product1);
        System.out.println(product2);
        System.out.println(product3);
        System.out.println(product4);
        System.out.println(product5);
        System.out.println(product6);

        Product copyProduct1 = new Product(1, "Milk", 99.9);
        System.out.println("\nproduct1 == copyProduct1: " + product1.equals(copyProduct1));
        System.out.println("product1 == product2: " + product1.equals(product2));

        /*
        Вывод:
        Product#1: Milk - 99.90 руб
        Product#2: Apple - 59.90 руб
        Product#3: bread - 55.00 руб
        Product#4: Eggs - 150.00 (Скидка 20.0%), Итог: 120.00
        Product#5: Cake - 699.99 (Скидка 12.0%), Итог: 615.99
        Product#6: Meat - 399.99 (Скидка 9.0%), Итог: 363.99

        product1 == copyProduct1: true
        product1 == product2: false
        */
    }
}
