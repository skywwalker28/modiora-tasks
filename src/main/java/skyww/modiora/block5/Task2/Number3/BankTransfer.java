package skyww.modiora.block5.Task2.Number3;

public class BankTransfer extends PaymentMethod {
    private final String bankAccount;

    public BankTransfer(String ownerName, double amount, String bankAccount) {
        super(ownerName, amount);
        this.bankAccount = bankAccount;
    }

    public String getBankAccount() { return bankAccount; }

    @Override
    public void processPayment() {
        System.out.println("Для банковского аккаунта: " + bankAccount
                + " обрабатываем платеж на сумму " + getAmount());
    }
}
