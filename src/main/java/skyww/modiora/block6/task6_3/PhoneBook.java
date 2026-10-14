package skyww.modiora.block6.task6_3;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {
    private final Map<String, String> map = new HashMap<>();

    public void addContact(String name, String number) {
        map.put(name, number);
    }

    public boolean removeContact(String name) {
        return map.remove(name) != null;
    }

    public String findNumber(String name) {
        return map.getOrDefault(name, "Не найдено");
    }

    public String findByNumber(String number) {

        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals(number)) {
                return entry.getKey();
            }
        }

        return "Неизвестно";
    }

    public boolean updateNumber(String name, String newNumber) {
        if (!map.containsKey(name)) {
            return false;
        }

        map.put(name, newNumber);
        return true;
    }

    public void printAll() {
        for (Map.Entry<String, String> entry : new TreeMap<>(map).entrySet()) {
            System.out.println(entry.getKey() + " — " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("Иван", "+7 (966) 111-22-33");
        phoneBook.addContact("Константин", "+7 (912) 345-67-89");
        phoneBook.addContact("Игорь", "+7 (905) 444-55-66");
        phoneBook.addContact("Анна", "+7 (903) 555-11-22");
        phoneBook.addContact("Елена", "+7 (955) 777-88-99");
        phoneBook.addContact("Дмитрий", "+7 (922) 987-65-43");
        phoneBook.addContact("Алексей", "+7 (911) 123-45-67");
        phoneBook.addContact("Мария", "+7 (999) 222-33-44");


        System.out.println("Удаление контакта 'Анна': " + phoneBook.removeContact("Анна"));
        System.out.println("Удаление контакта 'Неизвестный': " + phoneBook.removeContact("Неизвестный"));

        System.out.println("Найти контакт 'Игорь': " + phoneBook.findNumber("Игорь"));
        System.out.println("Найти контакт 'Неизвестный': " + phoneBook.findNumber("Неизвестный"));

        System.out.println("Найти контакт по номеру '+7 (966) 111-22-33': " +
                phoneBook.findByNumber("+7 (966) 111-22-33"));
        System.out.println("Найти контакт по неизвестному номеру: " + phoneBook.findByNumber("+7 (777) 777-77-77"));

        System.out.println("Изменить номер у контакта 'Алексей': " +
                phoneBook.updateNumber("Алексей", "+7 (911) 777-77-77"));
        System.out.println("Изменить номер у неизвестного контакта: " +
                phoneBook.updateNumber("Неизвестный", "+7 (911) 888-88-88"));

        System.out.println("\nВывод всех контактов:");
        phoneBook.printAll();
    }
}
