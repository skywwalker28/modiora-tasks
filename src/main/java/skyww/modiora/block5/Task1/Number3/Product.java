package skyww.modiora.block5.Task1.Number3;

import java.util.Objects;

public class Product {
    private static int countId = 0;
    private final int id;
    private final String name;
    private final double price;

    public Product(String name, double price) {
        id = ++countId;
        this.name = name;
        this.price = price;
    }

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public double getPrice() { return price; }
    public int getId() { return id; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return String.format("Product#%d: %s - %.2f руб", id, name, price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Product product)) {
            return false;
        }

        return this.id == product.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
