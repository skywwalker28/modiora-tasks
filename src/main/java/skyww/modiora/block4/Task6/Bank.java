package skyww.modiora.block4.Task6;

public class Bank {
    private int index;
    private final BankAccount[] accounts;

    public Bank() {
        accounts = new BankAccount[10];
        index = 0;
    }

    public BankAccount createAccount(String name) {
        if (index >= accounts.length) {
            throw new IllegalArgumentException("Превышен лимит на открытие счетов");
        }

        accounts[index] = new BankAccount(name);
        return accounts[index++];
    }

    public BankAccount searchId(int accountId) {
        validation();

        for (int i = 0; i < index; i++) {
            if (accounts[i].getAccountId() == accountId) {
                return accounts[i];
            }
        }

        throw new IllegalArgumentException("Аккаунта с таким id не существует");
    }

    public void searchName(String name) {
        validation();
        boolean found = false;
        for (int i = 0; i < index; i++) {
            if (accounts[i].getName().equals(name)) {
                System.out.println(accounts[i]);
                found = true;
            }
        }

        if (!found) {
            throw new IllegalArgumentException("Аккаунта с таким именем не существует");
        }
    }

    public BankAccount searchMaxBalance() {
        validation();

        BankAccount result = null;
        double maxBalance = 0;

        for (int i = 0; i < index; i++) {
            double current = accounts[i].getBalance();
            if (current >= maxBalance) {
                result = accounts[i];
                maxBalance = current;
            }
        }

        return result;
    }

    public void validation() {
        if (index == 0) {
            throw new IllegalArgumentException("Сначала создайте аккаунт");
        }
    }

    public void printReport() {
        double totalBalance = 0;
        System.out.println("ВСЕ СЧЕТА:");
        for (int i = 0; i < index; i++) {
            System.out.println(accounts[i]);
            totalBalance += accounts[i].getBalance();
        }

        System.out.println("\nСуммарный баланс: " + totalBalance);
    }
}
