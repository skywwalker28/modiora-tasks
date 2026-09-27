package skyww.modiora.block6.task6_1;

public class SafeParser {

    public static void main(String[] args) {
        System.out.println(parseIntSafe("  "));
        System.out.println(parseIntSafe(null));
        System.out.println(parseIntSafe("12a"));
        System.out.println(parseIntSafe("-123"));

        System.out.println();

        System.out.println(parseIntOrDefault("  ", 0));
        System.out.println(parseIntOrDefault(null, 0));
        System.out.println(parseIntOrDefault("12a", 0));
        System.out.println(parseIntOrDefault("-123", 0));

        /*
        Вывод:
        null
        null
        null
        -123

        0
        0
        0
        -123
        */
    }

    public static Integer parseIntSafe(String s) {
        if (s == null || s.isBlank()) {
            return null;
        }

        try {
            return Integer.parseInt(s.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static int parseIntOrDefault(String s, int defaultValue) {
        Integer result = parseIntSafe(s);
        return result != null ? result : defaultValue;
    }
}
