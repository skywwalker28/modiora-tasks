package skyww.modiora.block6.task6_3;

import java.util.*;

public class GradeBook {
    private final Map<String, List<Integer>> students = new TreeMap<>();

    public void addGrade(String name, int grade) {
        students.computeIfAbsent(name, k -> new ArrayList<>()).add(grade);
    }

    public double getAverage(String name) {
        if (!students.containsKey(name)) {
            System.out.println("Такого студента не существует");
            return 0.0;
        }
        List<Integer> grades = students.get(name);

        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }

        return (double) sum / grades.size();
    }

    public String getBestStudent() {
        double bestAvg = -1;
        String name = "";
        for (Map.Entry<String, List<Integer>> entry : students.entrySet()) {
            double curAvg = getAverage(entry.getKey());
            if (bestAvg < curAvg) {
                bestAvg = curAvg;
                name = entry.getKey();
            }
        }

        return name;
    }

    public Map<Integer, Integer> getGradeDistribution() {
        Map<Integer, Integer> frq = new HashMap<>();

        for (List<Integer> grades : students.values()) {
            for (int grade : grades) {
                frq.merge(grade, 1, Integer::sum);
            }
        }

        return frq;
    }

    public void printReport() {
        System.out.printf("%-10s | %-20s | %s%n", "Студент", "Оценки", "Средний");
        for (Map.Entry<String, List<Integer>> entry : students.entrySet()) {
            System.out.printf("%-10s | %-20s | %.2f%n", entry.getKey(), entry.getValue(), getAverage(entry.getKey()));
        }
    }

    public static void main(String[] args) {
        GradeBook gradeBook = new GradeBook();
        gradeBook.addGrade("Петя", 2);
        gradeBook.addGrade("Петя", 3);
        gradeBook.addGrade("Петя", 1);
        gradeBook.addGrade("Петя", 1);
        gradeBook.addGrade("Петя", 5);

        gradeBook.addGrade("Иван", 4);
        gradeBook.addGrade("Иван", 5);
        gradeBook.addGrade("Иван", 4);
        gradeBook.addGrade("Иван", 3);
        gradeBook.addGrade("Иван", 5);

        gradeBook.addGrade("Мария", 5);
        gradeBook.addGrade("Мария", 5);
        gradeBook.addGrade("Мария", 4);
        gradeBook.addGrade("Мария", 5);
        gradeBook.addGrade("Мария", 5);
        gradeBook.addGrade("Мария", 4);

        gradeBook.addGrade("Алексей", 3);
        gradeBook.addGrade("Алексей", 2);
        gradeBook.addGrade("Алексей", 4);
        gradeBook.addGrade("Алексей", 3);
        gradeBook.addGrade("Алексей", 3);

        gradeBook.addGrade("Елена", 5);
        gradeBook.addGrade("Елена", 4);
        gradeBook.addGrade("Елена", 5);
        gradeBook.addGrade("Елена", 3);
        gradeBook.addGrade("Елена", 4);
        gradeBook.addGrade("Елена", 5);


        System.out.println("Лучший студент: " + gradeBook.getBestStudent());
        System.out.println("Сколько раз оценка встречается у студентов: " + gradeBook.getGradeDistribution());
        System.out.println("\nСписок всех студентов:");
        gradeBook.printReport();

        /*
        Вывод:
        Лучший студент: Мария
        Сколько раз оценка встречается у студентов: {1=2, 2=2, 3=6, 4=7, 5=10}

        Список всех студентов:
        Студент    | Оценки               | Средний
        Алексей    | [3, 2, 4, 3, 3]      | 3.00
        Елена      | [5, 4, 5, 3, 4, 5]   | 4.33
        Иван       | [4, 5, 4, 3, 5]      | 4.20
        Мария      | [5, 5, 4, 5, 5, 4]   | 4.67
        Петя       | [2, 3, 1, 1, 5]      | 2.40

        */
    }
}
