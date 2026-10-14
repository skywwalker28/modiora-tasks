package skyww.modiora.block6.task6_3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextAnalyzer {
    private Map<String, Integer> map;
    private String[] words;

    public Map<String, Integer> wordFrequency(String text) {
        map = new HashMap<>();

        words = text.toLowerCase().split("[^\\p{L}]+");
        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }

            map.merge(word, 1, Integer::sum);
        }

        return map;
    }

    public int totalWordCount() {
        int res = 0;
        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }

            res++;
        }

        return res;
    }

    public int countUniqueWords() {
        return map.size();
    }

    public String longestWord() {
        String res = "";
        int curLen = 0;

        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }

            if (curLen < word.length()) {
                curLen = word.length();
                res = word;
            }
        }

        return res;
    }

    public List<String> findTop3() {
        return map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public double avgWordLen() {
        int sum = 0;
        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }

            sum += word.length();
        }

        return (double) sum / totalWordCount();
    }

    public Map<Character, Integer> firstLetterFrq() {
        Map<Character, Integer> frq = new HashMap<>();

        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }

            frq.merge(word.charAt(0), 1, Integer::sum);
        }

        return frq;
    }

    public void printStats(String text) {
        wordFrequency(text);
        System.out.println("Количество слов всего: " + totalWordCount());
        System.out.println("Количество уникальных слов: " + countUniqueWords());
        System.out.println("Топ 3 самых частых слова: " + findTop3());
        System.out.println("Самое длинное слово: " + longestWord());
        System.out.println("Средняя длина слова: " + avgWordLen());
        System.out.println("Количество слов начинающихся с каждой буквой: " + firstLetterFrq());
    }


    public static void main(String[] args) {
        TextAnalyzer textAnalyzer = new TextAnalyzer();
        textAnalyzer.printStats("Осенний вечер медленно опускался на старый город. Теплый свет уличных " +
                "фонарей отражался в дождевых лужах, а легкий ветерок кружил опавшие золотые листья. " +
                "Вокруг царила тишина, прерываемая лишь редким шумом машин");

        System.out.println();
        textAnalyzer.printStats("Дождь, дождь, дождь шёл весь этот бесконечный день. Серый дождь, холодный" +
                " дождь стучал в окно. Ветер, сильный ветер, злой ветер кружил вокруг. Время тянулось очень," +
                " очень медленно, секунда за длинной секундой");

        System.out.println();
        textAnalyzer.printStats("Дождь, дождь, дождь, дождь! Этот бесконечный дождь шёл весь день." +
                " Серый дождь, холодный дождь, сильный дождь стучал в моё окно. Время тянулось очень, очень," +
                " очень медленно, секунда за секундой, секунда за секундой");
    }
}


