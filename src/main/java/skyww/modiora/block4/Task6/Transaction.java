package skyww.modiora.block4.Task6;

import org.jspecify.annotations.NonNull;

public record Transaction(
        Type type,
        double sum,
        double balance,
        String description
) {

    @Override
    @NonNull
    public String toString() {
        return """
                {
                    Тип операции: %s
                    Сумма: %.2f
                    Баланс после: %.2f
                    Описание: %s
                }""".formatted(type, sum, balance, description);
    }
}