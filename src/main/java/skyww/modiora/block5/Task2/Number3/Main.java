package skyww.modiora.block5.Task2.Number3;

public class Main {
    public static void main(String[] args) {
        PaymentMethod[] paymentMethods = {
                new CreditCard("Иван", 1000, "1231234352", "09/28"),
                new BankTransfer("Алексей", 239, "#932"),
                new CryptoWallet("Георгий", 685, "31124-231@12", "$"),
                new CreditCard("Александра", 842, "1359535233", "07/32"),
                new CryptoWallet("Петр", 1032, "93343-332@34", "€")
        };

        processAll(paymentMethods);
        /*
        Вывод:
        Для кредитной карты: "*** *** 4352" обрабатывается платеж на сумму 1000.0
        [Доп.Инфо] Владелец: Иван | Карта: *** *** 4352 | Срок: 09/28

        Для банковского аккаунта: #932 обрабатываем платеж на сумму 239.0
        [Доп.Инфо] Владелец: Алексей | Счет: #932

        Для крипто кашелькя (адрес: 31124-231@12) обрабатываем платеж на сумму 685.0$
        [Доп.Инфо] Владелец: Георгий | Адрес: 31124-231@12 | Валюта: "$"

        Для кредитной карты: "*** *** 5233" обрабатывается платеж на сумму 842.0
        [Доп.Инфо] Владелец: Александра | Карта: *** *** 5233 | Срок: 07/32

        Для крипто кашелькя (адрес: 93343-332@34) обрабатываем платеж на сумму 1032.0€
        [Доп.Инфо] Владелец: Петр | Адрес: 93343-332@34 | Валюта: "€"
        */
    }

    public static void processAll(PaymentMethod[] mas) {
        for (PaymentMethod current : mas) {
            current.processPayment();

            System.out.print("[Доп.Инфо] ");
            if (current instanceof CreditCard creditCard) {
                System.out.println("Владелец: " + creditCard.getOwnerName()
                        + " | Карта: " + creditCard.getCardNumber()
                        + " | Срок: " + creditCard.getExpiryDate());
            } else if (current instanceof BankTransfer bankTransfer) {
                System.out.println("Владелец: " + bankTransfer.getOwnerName()
                        + " | Счет: " + bankTransfer.getBankAccount());
            } else if (current instanceof CryptoWallet cryptoWallet) {
                System.out.println("Владелец: " + cryptoWallet.getOwnerName() +
                        " | Адрес: " + cryptoWallet.getWalletAddress()
                        + " | Валюта: \"" + cryptoWallet.getCurrency() + "\"");
            }

            System.out.println();
        }
    }
}
