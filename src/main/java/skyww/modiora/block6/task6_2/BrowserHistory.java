package skyww.modiora.block6.task6_2;

import java.util.LinkedList;

public class BrowserHistory {
    /*
    Используем LinkedList, потому что вся работа идет с начала списка
    новая страница добавляется в начало, а при переходе на новую страницу
    после back() будущие страницы удаляются тоже из начала

    В LinkedList добавление и удаление в начале — O(1), а в ArrayList — O(N)
    так как при этом сдвигаются все элементы массива
    */

    private final LinkedList<String> history = new LinkedList<>();
    private int currentIndex = -1;

    public void visit(String url) {
        for (int i = 0; i < currentIndex; i++) {
            history.removeFirst();
        }

        history.addFirst(url);
        currentIndex = 0;
    }

    public String back() {
        if (currentIndex >= history.size() - 1) {
            System.out.println("Назад идти некуда");
            return getCurrentPage();
        }

        currentIndex++;
        return getCurrentPage();
    }

    public String forward() {
        if (currentIndex <= 0) {
            System.out.println("Вперед идти некуда");
            return getCurrentPage();
        }

        currentIndex--;
        return getCurrentPage();
    }

    public String getCurrentPage() {
        return history.isEmpty() ? null : history.get(currentIndex);
    }

    public void printHistory() {
        if (history.isEmpty()) {
            System.out.println("История пуста");
            return;
        }

        int index = 0;
        for (String url : history) {
            System.out.println((index == currentIndex ? "* " : "  ") + url);
            index++;
        }
    }

    public void clear() {
        history.clear();
        currentIndex = -1;
    }

    public static void main(String[] args) {
        BrowserHistory browser = new BrowserHistory();

        browser.visit("https://modiora");
        browser.visit("https://spotify");
        browser.visit("https://sdl");
        browser.visit("https://world-pl");
        browser.visit("https://java.ru");
        System.out.println("--- Посетили 5 страниц ---");
        browser.printHistory();

        System.out.println("back -> " + browser.back());
        System.out.println("back -> " + browser.back());
        System.out.println("back -> " + browser.back());
        System.out.println("--- После трёх back ---");
        browser.printHistory();

        browser.visit("https://github.com");
        System.out.println("--- Перешли на новую страницу ---");
        browser.printHistory();

        System.out.println("forward -> " + browser.forward());
        System.out.println("Текущая: " + browser.getCurrentPage());

        browser.clear();
        System.out.println("--- После clear ---");
        browser.printHistory();

        /*
        Вывод:
        --- Посетили 5 страниц ---
        * https://java.ru
          https://world-pl
          https://sdl
          https://spotify
          https://modiora
        back -> https://world-pl
        back -> https://sdl
        back -> https://spotify
        --- После трёх back ---
          https://java.ru
          https://world-pl
          https://sdl
        * https://spotify
          https://modiora
        --- Перешли на новую страницу ---
        * https://github.com
          https://spotify
          https://modiora
        Вперед идти некуда
        forward -> https://github.com
        Текущая: https://github.com
        --- После clear ---
        История пуста
        */
    }
}
