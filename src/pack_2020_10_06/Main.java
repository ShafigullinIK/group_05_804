package pack_2020_10_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        Integer[] array = (Integer[]) list.toArray();
        int[] arrayInt = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arrayInt[i] = array[i];
        }


//        Cat cat = new Cat("Пончик");
//        cat.makeSomeNoise();
//        System.out.println(cat);
//
//        Dog dog = new Dog("Шарик");
//        dog.makeSomeNoise();
//        System.out.println(dog);
//        double x1 = 200.0;
//        double x2 = 200.0;
//        System.out.println(x1 == x2);


    }

    public static void a() {
        System.out.println("a");
        try {
            b();
        } catch (NumberFormatException e) {
            System.out.println("Вот я его поймал");
        }

        System.out.println("-a");
    }

    public static void b() {
        System.out.println("b");
        c();
        System.out.println("-b");
    }

    public static void c() {
        System.out.println("c");
        throw new NumberFormatException();
//        System.out.println("-c");
    }

    private static double inputNegativeNumber() {
        boolean b = false;
        double d = 0;
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        while (!b) {
            System.out.println("Введите отрицательное число");

            try {
                String s = reader.readLine();
                d = Double.parseDouble(s);
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели какую-то ерунду :)");
            } catch (IOException e) {
                System.out.println("Я поймал IOException");
            }
            if (d < 0) {
                b = true;
            }
        }
        return d;
    }
}
