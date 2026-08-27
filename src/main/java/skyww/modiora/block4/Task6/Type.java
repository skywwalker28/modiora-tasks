package skyww.modiora.block4.Task6;

public enum Type {
    DEPOSIT("Пополнение"),
    WITHDRAW("Снятие"),
    TRANSFER("Перевод"),
    SAVINGS("Проценты");

    private final String title;

    Type(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
