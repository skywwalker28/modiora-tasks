package skyww.modiora.block5.Task2.Number3;

public abstract class PaymentMethod {
    private final String ownerName;
    private final double amount;

    public PaymentMethod(String ownerName, double amount) {
        this.ownerName = ownerName;
        this.amount = amount;
    }

    public String getOwnerName() { return ownerName; }
    public double getAmount() { return amount; }

    public abstract void processPayment();
}
