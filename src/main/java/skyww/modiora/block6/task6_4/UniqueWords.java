package skyww.modiora.block6.task6_4;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class UniqueWords {

    public void analyze(String text) {
        String[] words = text.toLowerCase().split("(?U)\\W+");

        Set<String> unique = new HashSet<>();
        Set<String> duplicates = new HashSet<>();
        int total = 0;

        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }

            if (!unique.add(word)) {
                duplicates.add(word);
            }

            total++;
        }

        System.out.println("Всего слов: " + total);
        System.out.println("Уникальных слов: " + unique.size());
        System.out.println("Уникальные слова (по алфавиту): " + new TreeSet<>(unique));
        System.out.println("Слова, встречающиеся более одного раза: " + new TreeSet<>(duplicates));
    }


    public static void main(String[] args) {
        UniqueWords uniqueWords = new UniqueWords();

        String text = "Кот сидел на окне. Кот смотрел на улицу. " +
                "На улице бежала собака. Собака громко лаяла на кота. " +
                "Кот испугался и спрыгнул с окна. Собака убежала дальше по улице.";
        uniqueWords.analyze(text);
    }
}
