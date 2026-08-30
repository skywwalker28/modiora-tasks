package skyww.modiora.block5.Task4.Number4;

public class Student implements Comparable<Student> {
    private final String name;
    private final double gpa;
    private final  int age;

    public Student(String name, double gpa, int age) {
        this.name = name;
        this.gpa = gpa;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public int getAge() {
        return age;
    }


    @Override
    public int compareTo(Student o) {
        return Double.compare(o.gpa, this.gpa);
    }

    @Override
    public String toString() {
        return "Student { " +
                "Имя: " + name +
                " | GPA: " + gpa +
                " | Возраст: " + age + " }";
    }
}
