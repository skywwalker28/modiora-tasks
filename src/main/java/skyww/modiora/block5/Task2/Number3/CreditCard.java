package skyww.modiora.block5.Task2.Number3;

public class CreditCard extends PaymentMethod {
    private final String cardNumber;
    private final String expiryDate;

    public CreditCard(String ownerName, double amount, String cardNumber, String expireDate) {
        super(ownerName, amount);
        this.expiryDate = expireDate;
        this.cardNumber = "*** *** " + getLastFourNumber(cardNumber);
    }

    public String getCardNumber() { return cardNumber; }
    public String getExpiryDate() { return expiryDate; }

    public String getLastFourNumber(String cardNumber) {
        if (cardNumber == null || cardNumber.length() < 4) {
            throw new IllegalArgumentException("Ошибка. Номер карты должен состояить из 7 цифр");
        }

        int len = cardNumber.length();
        return cardNumber.substring(len - 4, len);
    }

    @Override
    public void processPayment() {
        System.out.println("Для кредитной карты: \"" + cardNumber + "\" обрабатывается платеж на сумму " + getAmount());
    }
}
