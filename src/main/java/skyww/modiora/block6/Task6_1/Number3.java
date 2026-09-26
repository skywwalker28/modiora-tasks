package skyww.modiora.block6.Task6_1;

public class Number3 {
    public static void main(String[] args) {
        String a = "apples", b = "pears";
        System.out.println(nullSafeUpperCase(null));
        System.out.println(nullSafeUpperCase("this text in upperCase"));

        System.out.println(firstNonNull(a, b));
        System.out.println(firstNonNull(a, null));
        System.out.println(firstNonNull(null, b));

        try {
            firstNonNull(null, null);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        /*
        Вывод:
        N/A
        THIS TEXT IN UPPERCASE
        apples
        apples
        pears
        Ошибка: Both arguments are null
        */
    }

    public static String nullSafeUpperCase(String s) {
        if (s == null) {
            return "N/A";
        }

        return s.toUpperCase();
    }

    public static <T> T firstNonNull(T a, T b) {
        if (a == null && b == null) {
            throw new IllegalArgumentException("Both arguments are null");
        }

        return a == null ? b : a;
    }
}
