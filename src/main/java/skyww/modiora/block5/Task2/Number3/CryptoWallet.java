package skyww.modiora.block5.Task2.Number3;

public class CryptoWallet extends PaymentMethod {
    private final String walletAddress;
    private final String currency;

    public CryptoWallet(String ownerName, double amount, String walletAddress, String currency) {
        super(ownerName, amount);
        this.walletAddress = walletAddress;
        this.currency = currency;
    }

    public String getWalletAddress() { return walletAddress; }
    public String getCurrency() { return currency; }

    @Override
    public void processPayment() {
        System.out.println("Для крипто кашелькя (адрес: " + walletAddress +
                ") обрабатываем платеж на сумму " + getAmount() + getCurrency());
    }
}
