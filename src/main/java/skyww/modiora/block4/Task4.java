package skyww.modiora.block4;

import java.util.HashSet;
import java.util.Objects;

public class Task4 {
    /// №1
    public static class Student {
        private final String name;
        private final int age;
        private final String email;

        public Student(String name, int age, String email) {
            this.name = name;
            this.age = age;
            this.email = email;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }

            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Student other = (Student) o;
            return other.email.equals(this.email) && other.name.equals(this.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name,email);
        }

        @Override
        public String toString() {
            return "Имя: " + name + "\nВозраст: " + age + "\nПочта: " + email + "\n";
        }

        public static void main(String[] args) {
            Student student1 = new Student("Иван", 20, "vania@mail.ru");
            Student student2 = new Student("Иван", 20, "vania@mail.ru");
            Student student3 = new Student("Иван", 20, "vania@email.com");

            HashSet<Student> set = new HashSet<>();
            set.add(student1);
            set.add(student2);

            System.out.println(student1);
            System.out.println(student2);
            System.out.println(student3);

            System.out.println(student1.equals(student2));
            System.out.println(student1.equals(student3));
            System.out.println("Размер HashSet: " + set.size());

            /*
            Вывод:
            Имя: Иван
            Возраст: 20
            Почта: vania@mail.ru

            Имя: Иван
            Возраст: 20
            Почта: vania@mail.ru

            Имя: Иван
            Возраст: 20
            Почта: vania@email.com

            true
            false
            Размер HashSet: 1
            */


            ///  №2
            Student s1 = new Student("Иван", 20, "email.com");
            Student s2 = new Student("Иван", 20, "email.com");
            Student s3 = new Student("Петя", 21, "gmail.com");
            Student s4 = new Student("Петя", 21, "gmail.com");
            Student s5 = new Student("Женя", 19, "gmail.com");

            HashSet<Student> newSet = new HashSet<>();
            newSet.add(s1);
            newSet.add(s2);
            newSet.add(s3);
            newSet.add(s4);
            newSet.add(s5);



            ErrorStudent se1 = new ErrorStudent("Иван", 20, "email.com");
            ErrorStudent se2 = new ErrorStudent("Иван", 20, "email.com");
            ErrorStudent se3 = new ErrorStudent("Петя", 21, "gmail.com");
            ErrorStudent se4 = new ErrorStudent("Петя", 21, "gmail.com");
            ErrorStudent se5 = new ErrorStudent("Женя", 19, "gmail.com");

            HashSet<ErrorStudent> errorSet = new HashSet<>();
            errorSet.add(se1);
            errorSet.add(se2);
            errorSet.add(se3);
            errorSet.add(se4);
            errorSet.add(se5);

            System.out.println("Размер newSet: " + newSet.size());
            System.out.println("Размер errorSet: " + errorSet.size());
            /*
            Вывод:
            Размер newSet: 3
            Размер errorSet: 5 — все объекты попали в HashSet потому что коллекция сначало сравнивает их по hashCode,
            но так как у нас этот метод не переопределен, то используется hashCode от Object (основан на адресе памяти).
            HashSet сравнивает по адресу памяти, так как все наши объекты созданные через new, то у них разные адреса.
            Разные адреса, разные и hashCode.
            */
        }

        public static class ErrorStudent {

            private final String name;
            private final int age;
            private final String email;

            public ErrorStudent(String name, int age, String email) {
                this.name = name;
                this.age = age;
                this.email = email;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }

                if (o == null || getClass() != o.getClass()) {
                    return false;
                }

                ErrorStudent other = (ErrorStudent) o;
                return other.email.equals(this.email) && other.name.equals(this.name);
            }

            @Override
            public String toString() {
                return "Имя: " + name + "\nВозраст: " + age + "\nПочта: " + email + "\n";
            }
        }


        /// №3
        public static class AutomationStudent {
            private String name;
            private int age;
            private String email;

            public AutomationStudent(String name, int age, String email) {
                this.name = name;
                this.age = age;
                this.email = email;
            }

            @Override
            public boolean equals(Object o) {
                if (o == null || getClass() != o.getClass()) return false;
                AutomationStudent that = (AutomationStudent) o;
                return Objects.equals(name, that.name) && Objects.equals(email, that.email);
            }

            /*
            Отличие equals():
            1. Использование Object.equals, вместо equals
            2. В автосгенерированном нету проверки if (o == this) return true
            */

            @Override
            public int hashCode() {
                return Objects.hash(name, email);
            }

            // Одинаковый hashCode

            @Override
            public String toString() {
                return "AutomationStudent{" +
                        "name='" + name + '\'' +
                        ", age=" + age +
                        ", email='" + email + '\'' +
                        '}';
            }
        }
    }
}
