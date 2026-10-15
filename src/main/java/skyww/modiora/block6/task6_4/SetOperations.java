package skyww.modiora.block6.task6_4;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetOperations {

    public static Set<Integer> intersection(Set<Integer> a, Set<Integer> b) {
        Set<Integer> res = new HashSet<>();

        for (Integer val : a) {
            if (b.contains(val)) {
                res.add(val);
            }
        }

        return res;
    }

    public static Set<Integer> union(Set<Integer> a, Set<Integer> b) {
        Set<Integer> res = new HashSet<>(a);
        res.addAll(b);

        return res;
    }

    public static Set<Integer> difference(Set<Integer> a, Set<Integer> b) {
        Set<Integer> res = new HashSet<>(a);
        res.removeAll(b);
        
        return res;
    }

    public static Set<Integer> symmetricDifference(Set<Integer> a, Set<Integer> b) {
        Set<Integer> diffA = difference(a, b);
        Set<Integer> diffB = difference(b, a);
    
        return union(diffA, diffB);
    }

    public static boolean isSubset(Set<Integer> a, Set<Integer> b) {
        return a.containsAll(b);
    }

    public static Set<String> commonWords(String a, String b) {
        Set<String> res = new HashSet<>();

        String[] wordsA = a.toLowerCase().split("[^\\p{L}]+");
        String[] wordsB = b.toLowerCase().split("[^\\p{L}]+");

        Set<String> setA = new HashSet<>(List.of(wordsA));
        Set<String> setB = new HashSet<>(List.of(wordsB));

        for (String val : setA) {       
            if (!val.isEmpty() && setB.contains(val)) {
                res.add(val);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("Пересечение [1,2,3] [3,4,5]: " + intersection(Set.of(1,2,3), Set.of(3,4,5)));
        System.out.println("Пересечение [1,2,3] [4,5,6]: " + intersection(Set.of(1,2,3), Set.of(4,5,6)));
        System.out.println("Пересечение [] [1,2]: " + intersection(Set.of(), Set.of(1,2)));
        System.out.println();
        
        System.out.println("Объединение [1,2,3] [3,4,5]: " + union(Set.of(1,2,3), Set.of(3,4,5)));
        System.out.println("Объединение [1,2] []: " + union(Set.of(1,2), Set.of()));
        System.out.println();
        
        System.out.println("Разность [1,2,3,4] [3,4,5,6]: " + difference(Set.of(1,2,3,4), Set.of(3,4,5,6)));
        System.out.println("Разность [1,2] [1,4,5]: " + difference(Set.of(1,2), Set.of(1,4,5)));
        System.out.println();
        
        System.out.println("Симметричная разность [1,2,3] [3,4,5]: " + symmetricDifference(Set.of(1,2,3), Set.of(3,4,5)));
        System.out.println("Симметричная разность [1,2] [1,2]: " + symmetricDifference(Set.of(1,2), Set.of(1,2)));
        System.out.println("Симметричная разность [] [1,2]: " + symmetricDifference(Set.of(), Set.of(1,2)));
        System.out.println();
        
        System.out.println("Является ли b[1,2] подмножеством a[1,2,3,4]: " + isSubset(Set.of(1,2,3,4), Set.of(1,2)));
        System.out.println("Является ли b[1,2] подмножеством a[2,3]: " + isSubset(Set.of(2,3), Set.of(1,2)));
        System.out.println("Является ли b[] подмножеством a[1,2]: " + isSubset(Set.of(1,2), Set.of()));
        System.out.println();

        System.out.println("Общие слова: " + commonWords("Кот сидел на ковре.", "КОТ и собака были на улице"));
        System.out.println("Общие слова: " + commonWords(" «Кот» спит", "- кот ест"));

        /*
        Вывод:
        Пересечение [1,2,3] [3,4,5]: [3]
        Пересечение [1,2,3] [4,5,6]: []
        Пересечение [] [1,2]: []

        Объединение [1,2,3] [3,4,5]: [1, 2, 3, 4, 5]
        Объединение [1,2] []: [1, 2]

        Разность [1,2,3,4] [3,4,5,6]: [1, 2]
        Разность [1,2] [1,4,5]: [2]

        Симметричная разность [1,2,3] [3,4,5]: [1, 2, 4, 5]
        Симметричная разность [1,2] [1,2]: []
        Симметричная разность [] [1,2]: [1, 2]

        Является ли b[1,2] подмножеством a[1,2,3,4]: true
        Является ли b[1,2] подмножеством a[2,3]: false
        Является ли b[] подмножеством a[1,2]: true

        Общие слова: [на, кот]
        Общие слова: [кот]
        */
    }
}
