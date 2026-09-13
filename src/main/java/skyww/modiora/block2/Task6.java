package skyww.modiora.block2;

public class Task6 {

    // №1
    public static int countWords(String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }

        int count = 0, result = 0;
        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);

            if (!Character.isLetter(current)) {
                count = 0;
            } else if (count++ == 0) {
                result++;
            }
        }

        return result;
    }

    // №2
    public static boolean isValidEmail(String email) {
        if (email == null || email.isBlank() || email.contains(" ")) {
            return false;
        }

        if (email.contains("..")) {
            return false;
        }

        int at = email.indexOf('@');
        if (at <= 0 || at != email.lastIndexOf('@')) {
            return false;
        }

        String local = email.substring(0, at);
        String domain = email.substring(at+1);

        for (int i = 0; i < local.length(); i++) {
            char c = local.charAt(i);
            boolean ok = Character.isLetterOrDigit(c) || c == '.' || c == '_' || c == '%' || c == '+' || c == '-';

            if (!ok) {
                return false;
            }
        }

        if (local.charAt(0) == '-' || local.charAt(local.length() - 1) == '-') {
            return false;
        }

        for (int i = 0; i < domain.length(); i++) {
            char c = domain.charAt(i);
            boolean ok = Character.isLetterOrDigit(c) || c == '.' || c == '-';

            if (!ok) {
                return false;
            }
        }

        if (domain.charAt(0) == '-' || domain.charAt(domain.length() - 1) == '-') {
            return false;
        }

        int firstDor = domain.indexOf('.');
        int lastDot = domain.lastIndexOf('.');

        return firstDor > 0 && lastDot < domain.length() - 2;
    }

    // №3
    public static boolean isPalindrome(String word) {
        if (word == null || word.isBlank()) {
            return false;
        }

        word = word.replace(" ", "");
        word = word.toLowerCase();

        int left = 0, right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left++) != word.charAt(right--)) {
                return false;
            }
        }

        return true;
    }

    // Тесты
    public static void main(String[] args) {

        // Тесты для 1 алгоритма
        System.out.println(countWords(null)); // Вывод: 0
        System.out.println(countWords("one two three")); // Вывод: 3
        System.out.println(countWords("one   two    three  ")); // Вывод: 3
        System.out.println(countWords("one,two")); // Вывод: 2
        System.out.println(countWords("one.... two")); // Вывод: 2

        System.out.println();

        // Тесты для 2 алгоритма
        System.out.println(isValidEmail(null));// Вывод: false
        System.out.println(isValidEmail(""));// Вывод: false
        System.out.println(isValidEmail("user@mail.com"));// Вывод: true
        System.out.println(isValidEmail("@mail.com"));// Вывод: false
        System.out.println(isValidEmail("user@@mail.com"));// Вывод: false
        System.out.println(isValidEmail("user@mail"));// Вывод: false
        System.out.println(isValidEmail("user@.com"));// Вывод: false
        System.out.println(isValidEmail("user@mail."));// Вывод: false
        System.out.println(isValidEmail("user @mail.com"));// Вывод: false

        System.out.println();

        // Тесты для 3 алгоритма
        System.out.println(isPalindrome(null)); // Вывод: false
        System.out.println(isPalindrome(" ")); // Вывод: false
        System.out.println(isPalindrome("А роза упала на лапу Азора")); // Вывод: true
        System.out.println(isPalindrome("казак")); // Вывод: true
        System.out.println(isPalindrome("КазАк")); // Вывод: true
        System.out.println(isPalindrome("hello")); // Вывод: false
    }
}
