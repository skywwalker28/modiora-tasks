package skyww.modiora.block5.Task1.Number3;

public class DiscountedProduct extends Product {
    private final double discountPercent;

    public DiscountedProduct(String name, double price, double discountPercent) {
        super(name, price);
        this.discountPercent = discountPercent;
    }


    public double getFinalPrice() {
        return getPrice() * (1 - discountPercent/100);
    }

    @Override
    public String toString() {
        return String.format("Product#%d: %s - %.2f (Скидка %.1f%%), Итог: %.2f",
                getId(), getName(), getPrice(), discountPercent, getFinalPrice());
    }
}
