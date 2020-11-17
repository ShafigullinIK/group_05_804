package STREAM_IP_EXAMPLES;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        String s = Stream.iterate('a', x -> (char) (x + 1))
                .limit(26)
                .map(x -> x + "")
                .reduce("", (acc, x) -> acc + " " + x);

        System.out.println(s);

    }
}
