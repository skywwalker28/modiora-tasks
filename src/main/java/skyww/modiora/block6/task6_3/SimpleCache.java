package skyww.modiora.block6.task6_3;

import java.util.LinkedHashMap;
import java.util.Map;

public class SimpleCache<K, V> {
    private final int maxSize;
    private final Map<K, V> cache = new LinkedHashMap<>();

    public SimpleCache(int maxSize) {
        this.maxSize = maxSize;
    }

    public void put(K k, V v) {
        cache.put(k, v);

        if (cache.size() > maxSize) {
            K oldest = cache.keySet().iterator().next();
            cache.remove(oldest);
        }
    }

    public V get(K k) {
        return cache.get(k);
    }

    public boolean contains(K k) {
        return cache.containsKey(k);
    }

    public int size() {
        return cache.size();
    }

    public void clear() {
        cache.clear();
    }

    public void printAll() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        if (cache.isEmpty()) {
            return "Пусто";
        }
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<K, V> entry : cache.entrySet()) {
            sb.append(entry.getKey()).append(", ").append(entry.getValue()).append("\n");
        }

        return sb.toString();
    }

    private static final SimpleCache<Integer, Long> factorialCache = new SimpleCache<>(20);
    public static long factorial(int n) {
        if (factorialCache.contains(n)) {
            System.out.println(n + " взят из кэша!");
            return factorialCache.get(n);
        }

        long res = (n <= 1) ? 1 : n * factorial(n - 1);
        factorialCache.put(n, res);
        return res;
    }

    public static void main(String[] args) {
        SimpleCache<String, String> object = new SimpleCache<>(3);
        object.put("key1", "val");
        object.put("key2", "val");
        object.put("key3", "val");

        object.printAll();

        object.put("key4", "val");
        System.out.println("Элемент key1 вытеснился: " + object.get("key1"));

        object.printAll();
        object.clear();

        System.out.println("Кэш после чистки:");
        object.printAll();
        System.out.println();

        System.out.println(factorial(5));
        System.out.println(factorial(6));

        /*
        Вывод:
        key1, val
        key2, val
        key3, val

        Элемент key1 вытеснился: null
        key2, val
        key3, val
        key4, val

        Кэш после чистки:
        Пусто

        120
        5 взят из кэша!
        720
        */
    }
}
