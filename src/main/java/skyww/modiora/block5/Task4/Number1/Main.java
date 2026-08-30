package skyww.modiora.block5.Task4.Number1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        PluginManager manager = new PluginManager();
        manager.addPlugin(new ReversePlugin("Reverse1", "12", true));
        manager.addPlugin(new UpperCasePlugin("Upper1", "23", true));
        manager.addPlugin(new UpperCasePlugin("Upper1", "23", true));
        manager.addPlugin(new WordCountPlugin("WordCount1", "18", true));
        manager.addPlugin(new UpperCasePlugin("Upper2", "24", true));
        manager.addPlugin(new ReversePlugin("Reverse2", "12", false));

        System.out.println(Arrays.toString(manager.executeAll("Extract file")));
        System.out.println("Поиск по имени: " + manager.findByName("Reverse2") + "\n");
        manager.printAll();

        /*
        Вывод:
        [elif tcartxE, EXTRACT FILE, EXTRACT FILE, Слов: 11, EXTRACT FILE, elif tcartxE]
        Поиск по имени: Имя: Reverse2 | версия: 12 | Доступен: false

        Плагин: Reverse1v12
        Плагин: Upper1v23
        Плагин: Upper1v23
        Плагин: WordCount1v18
        Плагин: Upper2v24
        Плагин: Reverse2v12
        */
    }
}
