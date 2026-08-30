package skyww.modiora.block5.Task4.Number4;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Student[] mas = {
                new Student("Игорь", 12.09, 25),
                new Student("Алексей", 21.00, 20),
                new Student("Михаил", 5.19, 21),
                new Student("Антон", 143.93, 22),
                new Student("Александр", 42.18, 21),
        };

        System.out.println("Сортировка обычная пузырькавая: ");
        sort(mas);
        printAll(mas);

        Comparator<Student> sortName = (s1, s2) -> s1.getName().compareTo(s2.getName());
        Comparator<Student> sortAge = (s1, s2) -> Integer.compare(s1.getAge(), s2.getAge());
        Comparator<Student> sortGPA = (s1, s2) -> Double.compare(s1.getGpa(), s2.getGpa());

        System.out.println("Сортировка по имени:");
        sortWith(mas, sortName);
        printAll(mas);

        System.out.println("Сортировка по возрасту:");
        sortWith(mas, sortAge);
        printAll(mas);

        System.out.println("Сортировка по gpa:");
        sortWith(mas, sortGPA);
        printAll(mas);


        /*
        Вывод:
        Сортировка обычная пузырькавая:
        Student { Имя: Антон | GPA: 143.93 | Возраст: 22 }
        Student { Имя: Алексаднр | GPA: 42.18 | Возраст: 21 }
        Student { Имя: Алексей | GPA: 21.0 | Возраст: 20 }
        Student { Имя: Игорь | GPA: 12.09 | Возраст: 25 }
        Student { Имя: Михаил | GPA: 5.19 | Возраст: 21 }

        Сортировка по имени:
        Student { Имя: Алексаднр | GPA: 42.18 | Возраст: 21 }
        Student { Имя: Алексей | GPA: 21.0 | Возраст: 20 }
        Student { Имя: Антон | GPA: 143.93 | Возраст: 22 }
        Student { Имя: Игорь | GPA: 12.09 | Возраст: 25 }
        Student { Имя: Михаил | GPA: 5.19 | Возраст: 21 }

        Сортировка по возрасту:
        Student { Имя: Алексей | GPA: 21.0 | Возраст: 20 }
        Student { Имя: Алексаднр | GPA: 42.18 | Возраст: 21 }
        Student { Имя: Михаил | GPA: 5.19 | Возраст: 21 }
        Student { Имя: Антон | GPA: 143.93 | Возраст: 22 }
        Student { Имя: Игорь | GPA: 12.09 | Возраст: 25 }

        Сортировка по gpa:
        Student { Имя: Михаил | GPA: 5.19 | Возраст: 21 }
        Student { Имя: Игорь | GPA: 12.09 | Возраст: 25 }
        Student { Имя: Алексей | GPA: 21.0 | Возраст: 20 }
        Student { Имя: Алексаднр | GPA: 42.18 | Возраст: 21 }
        Student { Имя: Антон | GPA: 143.93 | Возраст: 22 }
        */

    }

    public static void sort(Student[] mas) {
        boolean flag = true;

        while (flag) {
            flag = false;

            for (int i = 0; i < mas.length - 1; i++) {
                if (mas[i].compareTo(mas[i + 1]) > 0) {
                    Student temp = mas[i];
                    mas[i] = mas[i+1];
                    mas[i+1] = temp;
                    flag = true;
                }
            }
        }
    }

    public static void sortWith(Student[] mas, Comparator<Student> sortMas) {
        boolean flag = true;

        while (flag) {
            flag = false;

            for (int i = 0; i < mas.length - 1; i++) {
                if (sortMas.compare(mas[i], mas[i+1]) > 0) {
                    Student temp = mas[i];
                    mas[i] = mas[i+1];
                    mas[i+1] = temp;
                    flag = true;
                }
            }
        }
    }


    public static void printAll(Student[] mas) {
        for (Student cur : mas) {
            System.out.println(cur);
        }
        System.out.println();
    }
}
