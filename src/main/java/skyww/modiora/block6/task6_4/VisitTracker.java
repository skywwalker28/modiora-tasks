package skyww.modiora.block6.task6_4;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class VisitTracker {
    private final Set<String> tracker = new LinkedHashSet<>();

    public void visit(String url) {
        tracker.add(url);
    }

    public boolean hasVisited(String url) {
        return tracker.contains(url);
    }

    public int getVisitCount() {
        return tracker.size();
    }

    public List<String> getHistory() {
        return new ArrayList<>(tracker);
    }

    public List<String> getMostRecentVisits(int n) {
        List<String> list = new ArrayList<>(tracker);

        int from = Math.max(0, list.size() - Math.max(0, n));
        return list.subList(from, list.size());
    }

    public void clear() {
        tracker.clear();
    }

    public static Set<String> intersection(VisitTracker a, VisitTracker b) {
        Set<String> res = new LinkedHashSet<>();

        for (String val : a.tracker) {
            if (b.tracker.contains(val)) {
                res.add(val);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        VisitTracker tracker1 = new VisitTracker();
        VisitTracker tracker2 = new VisitTracker();

        tracker1.visit("https://url.wtf");
        tracker1.visit("https://qkx.io");
        tracker1.visit("https://lnk.dev");
        tracker1.visit("https://w3v.net");
        tracker1.visit("https://shrt.cx");
        tracker1.visit("https://qkx.io");
        tracker1.visit("https://lnk.dev");

        tracker2.visit("https://shrt.cx");
        tracker2.visit("https://zpr.to");
        tracker2.visit("https://vdx.is");
        tracker2.visit("https://btt.ly");
        tracker2.visit("https://tny.co");
        tracker2.visit("https://go.xyz");
        tracker2.visit("https://url.wtf");

        System.out.println("Трекер 1 посещал url 'https://qkx.io'?: " + tracker1.hasVisited("https://qkx.io"));
        System.out.println("Трекер 2 посещал url 'https://test'?: " + tracker2.hasVisited("https://test"));

        System.out.println();
        System.out.println("Количество посещенных url у Трекера 1: " + tracker1.getVisitCount());
        System.out.println("Количество посещенных url у Трекера 2: " + tracker2.getVisitCount());

        System.out.println("История посещения у Трекера 1: " + tracker1.getHistory());
        System.out.println("История посещения у Трекера 2: " + tracker2.getHistory());
        System.out.println();

        System.out.println("Последние 2 посещенных url у Трекера 1: " + tracker1.getMostRecentVisits(2));
        System.out.println("Последние 5 посещенных url у Трекера 2: " + tracker2.getMostRecentVisits(5));
        System.out.println("Последние -100 посещенных url у Трекера 2: " + tracker2.getMostRecentVisits(-100));
        System.out.println("Последние 0 посещенных url у Трекера 1: " + tracker1.getMostRecentVisits(0));
        System.out.println("Последние 100 посещенных url у Трекера 1: " + tracker1.getMostRecentVisits(100));
        System.out.println();

        System.out.println("Пересечение трекеров: " + intersection(tracker1, tracker2));
        System.out.println();

        tracker1.clear();
        System.out.println("Трекер 1 после очистки: " + tracker1.getHistory());

        /*
        Вывод:
        Трекер 1 посещал url 'https://qkx.io'?: true
        Трекер 2 посещал url 'https://test'?: false

        Количество посещенных url у Трекера 1: 5
        Количество посещенных url у Трекера 2: 7
        История посещения у Трекера 1: [https://url.wtf, https://qkx.io, https://lnk.dev, https://w3v.net, https://shrt.cx]
        История посещения у Трекера 2: [https://shrt.cx, https://zpr.to, https://vdx.is, https://btt.ly, https://tny.co, https://go.xyz, https://url.wtf]

        Последние 2 посещенных url у Трекера 1: [https://w3v.net, https://shrt.cx]
        Последние 5 посещенных url у Трекера 2: [https://vdx.is, https://btt.ly, https://tny.co, https://go.xyz, https://url.wtf]
        Последние -100 посещенных url у Трекера 2: []
        Последние 0 посещенных url у Трекера 1: []
        Последние 100 посещенных url у Трекера 1: [https://url.wtf, https://qkx.io, https://lnk.dev, https://w3v.net, https://shrt.cx]

        Пересечение трекеров: [https://url.wtf, https://shrt.cx]

        Трекер 1 после очистки: []
        */
    }
}
