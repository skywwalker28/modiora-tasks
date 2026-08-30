package skyww.modiora.block5.Task4.Number3;

public class Main {
    public static void main(String[] args) {
        StringTransformer trim = val -> val.trim();
        StringTransformer toUpperCase = val -> val.toUpperCase();
        StringTransformer addExclamation = val -> val + "!";
        StringTransformer replaceSpace = val -> val.replace(" ", "_");
        StringTransformer truncate = val -> val.length() <= 10 ? val : val.substring(0, 10);

        String text = " Hello Java World  ";
        StringTransformer[] chain1 = {trim, toUpperCase, replaceSpace, truncate, addExclamation};
        StringTransformer[] chain2 = {trim, addExclamation, truncate};
        StringTransformer[] chain3 = {trim, addExclamation, replaceSpace};

        String res1 = applyAll(text, chain1);
        System.out.println("Комбинация 1: " + res1);

        String res2 = applyAll(text, chain2);
        System.out.println("Комбинация 2: " + res2);

        String res3 = applyAll(text, chain3);
        System.out.println("Комбинация 3: " + res3);

        /*
        Комбинация 1: HELLO_JAVA!
        Комбинация 2: Hello Java
        Комбинация 3: Hello_Java_World!
        */
    }

    public static String applyAll(String text, StringTransformer[] mas) {
        for (StringTransformer cur : mas) {
            text = cur.transform(text);
        }

        return text;
    }
}
