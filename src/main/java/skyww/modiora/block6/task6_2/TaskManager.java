package skyww.modiora.block6.task6_2;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        taskManager.addTask("Сходить в университет");
        taskManager.addTask("Сходить в зал");
        taskManager.addTask("Почитать книгу");
        taskManager.addTask("Пройти 3 км");
        taskManager.addTask("Погулять с другом");
        taskManager.addTask("Сделать зарядку");

        taskManager.addUrgentTask("Пройти онлайн-тестирование");
        taskManager.addUrgentTask("Погулять с собакой");

        System.out.println("Выполнено 'Почитать книгу'? " + taskManager.completeTask("Почитать книгу"));
        System.out.println("Выполнено 'Погулять с собакой'? " + taskManager.completeTask("Погулять с собакой"));
        System.out.println("Выполнено 'Несуществующая задача'? " + taskManager.completeTask("Попрыгать"));

        List<String> word1 = taskManager.findByKeyword("Сходить");
        List<String> word2 = taskManager.findByKeyword("Пройти");
        List<String> word3 = taskManager.findByKeyword("Ошибка");

        System.out.println("\nКоличество задач: " + taskManager.getTaskCount());

        System.out.println("Задачи со словом 'Сходить': " + word1);
        System.out.println("Задачи со словом 'Пройти': " + word2);
        System.out.println("Задачи со словом 'Ошибка': " + word3);

        System.out.println("Все задачи: ");
        taskManager.printAll();

        /*
        Вывод:
        Выполнено 'Почитать книгу'? true
        Выполнено 'Погулять с собакой'? true
        Выполнено 'Несуществующая задача'? false

        Количество задач: 6
        Задачи со словом 'Сходить': [Сходить в университет, Сходить в зал]
        Задачи со словом 'Пройти': [Пройти онлайн-тестирование, Пройти 3 км]
        Задачи со словом 'Ошибка': []
        Все задачи:
        1. Пройти онлайн-тестирование
        2. Сходить в университет
        3. Сходить в зал
        4. Пройти 3 км
        5. Погулять с другом
        6. Сделать зарядку
        */
    }

    private final List<String> list = new ArrayList<>();

    public void addTask(String task) {
        list.add(task);
    }

    public void addUrgentTask(String task) {
        list.add(0, task);
    }

    public boolean completeTask(String task) {
        return list.remove(task);
    }

    public void printAll() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i+1) + ". " + list.get(i));
        }
    }

    public int getTaskCount() {
        return list.size();
    }

    public List<String> findByKeyword(String word) {
        word = word.toLowerCase();
        List<String> newList = new ArrayList<>();

        for (String task : list) {
            if (task.toLowerCase().contains(word)) {
                newList.add(task);
            }
        }

        return newList;
    }
}
