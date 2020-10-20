package pack_2020_09_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(            // читает блоками
                        new InputStreamReader( // читает символы из байтов
                                System.in      // читает байты
                        ));
        String line = reader.readLine();
        String s = "1 2 3 4 5";
        String[] items = s.split(" ");
        System.out.println("items[0] = " + items[0]);
        int a = Integer.parseInt(items[0]);
//        Double.parseDouble()
        System.out.println(a + 1);
        System.out.println("Вы ввели: " + line + " :)");
    }

    public static void lagrange() {
        double[] x = {-1, 0, 1};
        double[] y = {2, 1, 2};
        Polynom[] l = new Polynom[x.length];
        for (int i = 0; i < l.length; i++) {
            l[i] = new Polynom(new double[] {1.0});
            for (int j = 0; j < l.length; j++) {
                if(i != j){
                    l[i] = Polynom.multiplication(
                            l[i],
                            Polynom.multiplication(1/(x[i]-x[j]),
                                    new Polynom(new double[] {1, -1*x[j]})));
                }
            }
        }
        Polynom lagrange = new Polynom(new double[] {0});
        for (int i = 0; i < l.length; i++) {
            lagrange = Polynom.sum(lagrange,
                    Polynom.multiplication(y[i], l[i]));
        }
        System.out.println(lagrange);
    }

}
