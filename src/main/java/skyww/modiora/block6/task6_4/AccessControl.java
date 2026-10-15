package skyww.modiora.block6.task6_4;

import java.util.*;

public class AccessControl {
    private final Map<String, Set<String>> roles = new HashMap<>();

    public void addRole(String name, String role) {
        roles.computeIfAbsent(name, k -> new HashSet<>()).add(role);
    }

    public boolean removeRole(String name, String role) {
        Set<String> userRoles = roles.get(name);

        if (userRoles == null || !userRoles.remove(role)) {
            return false;
        }

        if (userRoles.isEmpty()) {
            roles.remove(name);
        }

        return true;
    }

    public boolean hasRole(String name, String role) {
        return roles.getOrDefault(name, Set.of()).contains(role);
    }

    public Set<String> getRoles(String name) {
        if (!roles.containsKey(name)) {
            return Set.of();
        }

        return Collections.unmodifiableSet(roles.get(name));
    }

    public Set<String> getUsersWithRole(String role) {
        Set<String> res = new TreeSet<>();

        for (Map.Entry<String, Set<String>> entry : roles.entrySet()) {
            if (entry.getValue().contains(role)) {
                res.add(entry.getKey());
            }
        }

        return res;
    }

    public void printAll() {
        for (Map.Entry<String, Set<String>> entry : new TreeMap<>(roles).entrySet()) {
            System.out.println(entry.getKey() + " -> " + new TreeSet<>(entry.getValue()));  
        }
    }

    public static void main(String[] args) {
        AccessControl accessControl = getAccessControl();

        System.out.println("Роли у Ольги: " + accessControl.getRoles("Ольга"));
        System.out.println("Роли у Неизвестно: " + accessControl.getRoles("Неизвестно"));

        System.out.println("Попытка добавить роль 'ADMIN' Игорю...");
        try {
            System.out.println(accessControl.getRoles("Игорь").add("ADMIN"));
        } catch (UnsupportedOperationException ignored) {}
        System.out.println("Роли Игоря: " + accessControl.getRoles("Игорь"));

        System.out.println();
        System.out.println("Удалить роль 'USER' у Алексея: " + accessControl.removeRole("Алексей", "USER"));
        System.out.println("Удалить роль 'TEST' у Алексея: " + accessControl.removeRole("Алексей", "TEST"));
        System.out.println("Удалить роль 'USER' у Неизвестно: " + accessControl.removeRole("Неизвестно", "USER"));
        System.out.println("Удаление последней роли у Игоря: " + accessControl.removeRole("Игорь", "USER"));

        System.out.println();
        System.out.println("У Дмитрия есть роль 'EDITOR'?: " + accessControl.hasRole("Дмитрий", "EDITOR"));
        System.out.println("У Дмитрия есть роль 'MODERATOR'?: " + accessControl.hasRole("Дмитрий", "MODERATOR"));

        System.out.println();
        System.out.println("Все пользователи с ролью 'USER': " + accessControl.getUsersWithRole("USER"));
        System.out.println("Все пользователи с ролью 'MODERATOR': " + accessControl.getUsersWithRole("MODERATOR"));

        System.out.println();
        System.out.println("Все пользователи и их роли: ");
        accessControl.printAll();

        /*
        Вывод:
        Роли у Ольги: [EDITOR, USER, MODERATOR]
        Роли у Неизвестно: []
        Попытка добавить роль 'ADMIN' Игорю...
        Роли Игоря: [USER]

        Удалить роль 'USER' у Алексея: true
        Удалить роль 'TEST' у Алексея: false
        Удалить роль 'USER' у Неизвестно: false
        Удаление последней роли у Игоря: true

        У Дмитрия есть роль 'EDITOR'?: true
        У Дмитрия есть роль 'MODERATOR'?: false

        Все пользователи с ролью 'USER': [Дмитрий, Ольга, Светлана]
        Все пользователи с ролью 'MODERATOR': [Алексей, Ольга, Светлана]

        Все пользователи и их роли:
        Алексей -> [ADMIN, EDITOR, MODERATOR]
        Дмитрий -> [EDITOR, USER]
        Ольга -> [EDITOR, MODERATOR, USER]
        Светлана -> [MODERATOR, USER]
        */
    }

    private static AccessControl getAccessControl() {
        AccessControl accessControl = new AccessControl();
        accessControl.addRole("Алексей", "ADMIN");
        accessControl.addRole("Алексей", "MODERATOR");
        accessControl.addRole("Алексей", "EDITOR");
        accessControl.addRole("Алексей", "USER");

        accessControl.addRole("Ольга", "MODERATOR");
        accessControl.addRole("Ольга", "EDITOR");
        accessControl.addRole("Ольга", "USER");

        accessControl.addRole("Дмитрий", "EDITOR");
        accessControl.addRole("Дмитрий", "USER");

        accessControl.addRole("Светлана", "MODERATOR");
        accessControl.addRole("Светлана", "USER");

        accessControl.addRole("Игорь", "USER");
        return accessControl;
    }
}
