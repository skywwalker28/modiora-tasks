package skyww.modiora.block6.task6_1;

public class Number2 {
    public static void main(String[] args) {
        Integer a1 = 127;
        Integer a2 = 127;

        Integer b1 = 128;
        Integer b2 = 128;

        System.out.println(a1.equals(a2));
        System.out.println(a1 == a2);

        System.out.println(b1.equals(b2));
        System.out.println(b1 == b2);
    }
}

/*
Integer a1 = 127 компилируется в Integer.valueOf(127). valueOf() кэширует объекты для значений от -128 до 127
Поэтому a1 и a2 ссылаются на один и тот же объект

128 выходит за границы кэша, и valueOf() каждый раз создает новый объект
== сравнивает ссылки, а не значения, поэтому для b1 и b2 создаются два новых разных объекта. У них разные ссылки

equals() сравнивает значения, поэтому в обоих случаях true
*/
