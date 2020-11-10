package pack_2020_11_10_StreamAPI;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Country c = Country.RUSSIA;

        if(c == Country.RUSSIA) {

        }


        int[][] array = {
                {1, 2, 3, 4},
                {5, 6, 7, 8}
        };
//        IntStream stream = Arrays.stream(array);
//        System.out.println("тут создали поток");
//        stream = stream.map(ч -> ч + 3);
//        stream = stream.filter(x -> x%2==0);
//        System.out.println("тут прикрутили фильтр");
//        stream.forEach(System.out::println);
        int a = Arrays.stream(array)
                .flatMapToInt(Arrays::stream)
                .map(x -> x * (-1))
                .limit(3)
                .sum();
        System.out.println(a);
    }
}
