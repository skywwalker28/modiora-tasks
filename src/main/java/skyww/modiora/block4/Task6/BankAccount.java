package skyww.modiora.block4.Task6;

public class BankAccount {
    private static int countId = 0;
    private int index = 0;

    private double balance;
    private final Transaction[] history;
    private final int accountId;
    private final String name;

    public BankAccount(String name) {
        if (name.isEmpty() || name.matches(".*\\p{P}.*") || name.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Введите корректное имя");
        }

        history = new Transaction[100];
        accountId = ++countId;
        balance = 0.0;
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getName() {
        return name;
    }

    public void deposit(double sum) {
        isPositive(sum);

        balance += sum;
        history[index++] = new Transaction(
                Type.DEPOSIT, sum, balance, "Пополнили баланс на сумму " + sum);
    }

    public void withdraw(double sum) {
        isPositive(sum);
        validation(sum);

        balance -= sum;
        history[index++] = new Transaction(
                Type.WITHDRAW, sum, balance, "Сняли " + sum + " с баланса");
    }

    public void transfer(BankAccount other, double sum) {
        isPositive(sum);
        validation(sum);

        balance -= sum;
        other.balance += sum;

        history[index++] = new Transaction(
                Type.TRANSFER, sum, balance,
                "Перевел %.2f на счет \"%d\"".formatted(sum, other.accountId)
        );

        other.history[other.index++] = new Transaction(
                Type.TRANSFER, sum, other.balance,
                "Получен перевод %.2f от счета \"%d\"".formatted(sum, accountId)
        );
    }

    public void addInterest(double rate) {
        double sum = balance * rate/100;
        balance += sum;

        history[index++] = new Transaction(
                Type.SAVINGS, sum, balance,
                "Начисление %.2f (%.2f%%) на счет \"%d\"".formatted(sum, rate, accountId)
        );
    }

    private void isPositive(double sum) {
        if (sum <= 0) {
            throw new IllegalArgumentException("Сумма должна быть положительной");
        }
    }

    private void validation(double sum) {
        if (sum > balance) {
            throw new IllegalArgumentException("Недостаточно средств");
        }
    }

    public void printStatement() {
        System.out.println("Транзакции для счета " + accountId + ": ");
        for (int i = 0; i < index; i++) {
            System.out.println(history[i]);
        }

        System.out.println();
    }

    @Override
    public String toString() {
        return """
                    Владелец: %s
                    Номер счета: %d
                    Баланс: %.2f
                    Количество операций %d
                    """.formatted(name, accountId, balance, index);
    }
}
