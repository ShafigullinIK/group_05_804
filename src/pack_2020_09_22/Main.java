package pack_2020_09_22;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Complex c1 = new Complex(5, 2);
        Complex c2 = new Complex(-5, 1);
        Complex c3 = Complex.sub(c1, c2);
        System.out.println(c3);
        System.out.println(c3.arg());
        System.out.println(c3.module());
        System.out.println(Complex.prod(c1, c2));
    }

    public static void firstExample() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        System.out.println(arrayList.isEmpty());
        arrayList.add(10);
        arrayList.add(15);
        arrayList.add(5);
        arrayList.add(15);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
        for (Integer item : arrayList) {
            System.out.println(item);
        }
        System.out.println(arrayList);
        System.out.println(arrayList.size());
        System.out.println(arrayList.get(1));
        System.out.println(arrayList.contains(5));
        System.out.println(arrayList.indexOf(15));
        System.out.println(arrayList.isEmpty());
        System.out.println(arrayList.remove(1));
        System.out.println(arrayList.remove(new Integer(10)));
        System.out.println(arrayList.set(0, -1));
        System.out.println(arrayList);
    }

    public static void names() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Vasya");
        list.add("Petya");
        list.add("Lyuda");
        for (String name : list) {
            System.out.println(name);
        }
        System.out.println(list);
    }

}
