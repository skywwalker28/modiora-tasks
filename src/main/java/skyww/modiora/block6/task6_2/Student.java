package skyww.modiora.block6.task6_2;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private final String name;
    private final int age;
    private final double gpa;

    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return String.format("Имя: %s, Возраст: %d, GPA: %.2f", name, age, gpa);
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Петя", 20, 3.2));
        students.add(new Student("Игорь", 22, 4.8));
        students.add(new Student("Михаил", 19, 4.1));
        students.add(new Student("Анна", 21, 4.5));
        students.add(new Student("Екатерина", 23, 3.7));
        students.add(new Student("Олег", 18, 2.9));
        students.add(new Student("Дарья", 20, 4.9));

        students.sort((a, b) -> a.name.compareTo(b.name));
        System.out.println("Сортировка по имени (алфавит):");
        students.forEach(System.out::println);

        students.sort((a, b) -> Double.compare(b.gpa, a.gpa));
        System.out.println("\nСортировка по GPA (убывание):");
        students.forEach(System.out::println);

        students.sort((a, b) -> Integer.compare(a.age, b.age));
        System.out.println("\nСортировка по возрасту (возрастание):");
        students.forEach(System.out::println);

        students.sort((a, b) -> Integer.compare(a.name.length(), b.name.length()));
        System.out.println("\nСортировка по длине имени:");
        students.forEach(System.out::println);

        /*
        Вывод:
        Сортировка по имени (алфавит):
        Имя: Анна, Возраст: 21, GPA: 4.50
        Имя: Дарья, Возраст: 20, GPA: 4.90
        Имя: Екатерина, Возраст: 23, GPA: 3.70
        Имя: Игорь, Возраст: 22, GPA: 4.80
        Имя: Михаил, Возраст: 19, GPA: 4.10
        Имя: Олег, Возраст: 18, GPA: 2.90
        Имя: Петя, Возраст: 20, GPA: 3.20

        Сортировка по GPA (убывание):
        Имя: Дарья, Возраст: 20, GPA: 4.90
        Имя: Игорь, Возраст: 22, GPA: 4.80
        Имя: Анна, Возраст: 21, GPA: 4.50
        Имя: Михаил, Возраст: 19, GPA: 4.10
        Имя: Екатерина, Возраст: 23, GPA: 3.70
        Имя: Петя, Возраст: 20, GPA: 3.20
        Имя: Олег, Возраст: 18, GPA: 2.90

        Сортировка по возрасту (возрастание):
        Имя: Олег, Возраст: 18, GPA: 2.90
        Имя: Михаил, Возраст: 19, GPA: 4.10
        Имя: Дарья, Возраст: 20, GPA: 4.90
        Имя: Петя, Возраст: 20, GPA: 3.20
        Имя: Анна, Возраст: 21, GPA: 4.50
        Имя: Игорь, Возраст: 22, GPA: 4.80
        Имя: Екатерина, Возраст: 23, GPA: 3.70

        Сортировка по длине имени:
        Имя: Олег, Возраст: 18, GPA: 2.90
        Имя: Петя, Возраст: 20, GPA: 3.20
        Имя: Анна, Возраст: 21, GPA: 4.50
        Имя: Дарья, Возраст: 20, GPA: 4.90
        Имя: Игорь, Возраст: 22, GPA: 4.80
        Имя: Михаил, Возраст: 19, GPA: 4.10
        Имя: Екатерина, Возраст: 23, GPA: 3.70
        */
    }
}
