package skyww.modiora.Block2;

import java.math.BigDecimal;

public class Task1 {

    //№1
    public static class StudentProfile {
        private final byte grade;
        private final short studentNumber;
        private final int yearOfBirth;
        private final long phoneNumber;
        private final float averageGradeLastSem;
        private final double finalGrade;
        private final boolean isPaidSem;
        private final char firstLetterName;

        public StudentProfile(byte grade, short studentNumber, int yearOfBirth, long phoneNumber,
                              float averageGradeLastSem, double finalGrade, boolean isPaidSem, char firstLetterName) {
            this.grade = grade;
            this.studentNumber = studentNumber;
            this.yearOfBirth = yearOfBirth;
            this.phoneNumber = phoneNumber;
            this.averageGradeLastSem = averageGradeLastSem;
            this.finalGrade = finalGrade;
            this.isPaidSem = isPaidSem;
            this.firstLetterName = firstLetterName;
        }

        @Override
        public String toString() {
            return "Grade: " + grade +
                    "\nstudent number: " + studentNumber +
                    "\nyear of birth: " + yearOfBirth +
                    "\nphone number: " + phoneNumber +
                    "\naverage grade of last semester: " + averageGradeLastSem +
                    "\nfinal grade: " + finalGrade +
                    "\ndid the student pay for the semester: " + isPaidSem +
                    "\nfirst letter of name: " + firstLetterName;
        }

        public static void main(String[] args) {
            StudentProfile student = new StudentProfile((byte) 92, (short) 12913, 2005,
                    11122233L, 4.32f, 4.7957575,
                    true, 'A');
            System.out.println(student);
        /*
        Grade: 92
        student number: 12913
        year of birth: 2005
        phone number: 11122233
        average grade of last semester: 4.32
        final grade: 4.7957575
        did the student pay for the semester: true
        first letter of name: A
        */
        }
    }




    // №2
    public static class Overflow {
        public static void main(String[] args) {
            System.out.println("максимальное число int = " + Integer.MAX_VALUE);
            System.out.println("максимальное число int + 1 = " + (Integer.MAX_VALUE + 1));
            /*
            Вывод -2147483648, потому что в 32-битном int макс значение 0111...111 (31 единица).
            При +1 биты становятся 1000...000, что в коде = Integer.MIN_VALUE
            */

            int seconds100YearsInt = 60 * 60 * 24 * 365 * 100;
            System.out.println(seconds100YearsInt);

            long seconds100YearsLong = (long) 60 * 60 * 24 * 365 * 100;
            System.out.println(seconds100YearsLong);

            /*
            Вывод:
            максимальное число int = 2147483647
            максимально число int + 1 = -1141367296 потому что результат 3 миллиарда, в int помещается только
            2 миллиарда, происходит переполнение, значение зацикливается обратно в MIN_VALUE

            3153600000 правильный результат
            */
        }
    }



    // №3
    public static class Finance {
        public static void main(String[] args) {

            double error = 0.1 + 0.2;
            System.out.println(error);
            /*
            Результат 0.30000000000000004, потому что для вычисления компютер переводит в двоичную систему
            счисления дробные числа, а 0.1 и 0.2 являются бексконечными двоичными дробями, поэтому процессор вынужден
            огруглять их.
            */



            double error2 = 10.0 - 9.0 - 0.9;
            System.out.println(error2);
            /*
            Результат: 0.09999999999999998, потому что 0.9 также невозможно предсавить в двоичной системе счисления.
            Из-за чего появляются микроскопические погрешности при вычислениях
            */


            BigDecimal correct = new BigDecimal("0.1").add(new BigDecimal("0.2"));
            BigDecimal correct2 = new BigDecimal("10.0")
                    .subtract(new BigDecimal("9.0"))
                    .subtract(new BigDecimal("0.9"));

            System.out.println(correct);
            System.out.println(correct2);
            /*
            Результат:
            0.3
            0.1
            */
        }
    }


    // №4
    public static class TempConverter {
        public static double toFahrenheit(double celsius) {
            return celsius * 9.0/5.0 + 32;
        }

        public static double toKelvin(double celsius) {
            return celsius + 273.15;
        }

        public static void main(String[] args) {
            // 100
            System.out.println(toFahrenheit(100));
            System.out.println(toKelvin(100));

            //0
            System.out.println(toFahrenheit(0));
            System.out.println(toKelvin(0));

            //37
            System.out.println(toFahrenheit(37));
            System.out.println(toKelvin(37));

            //-40
            System.out.println(toFahrenheit(-40));
            System.out.println(toKelvin(-40));

            /*
            Вывод:
            212.0
            373.15
            32.0
            273.15
            98.6
            310.15
            -40.0 это температура, у которой Цельсия и Фаренгейты совпадают: -40 * 9/5 + 32 = -72 + 32 = -40
            233.14999999999998
            */
        }
    }
}
