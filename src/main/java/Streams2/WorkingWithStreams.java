package Streams2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class WorkingWithStreams {
    public static void main(String[] args) {
        List<String> names = List.of("Amigoscode", "Alex", "Zara");
        Stream<String> stream = names.stream();

        Stream<String> namesStream = Stream.of("Amigoscode", "Alex", "Zara");

        long count = stream
                .limit(2).map(null).sorted(null).dropWhile(null)
                .count();

        String[] namesArray = {};
        Arrays.stream(namesArray);
    }
}
