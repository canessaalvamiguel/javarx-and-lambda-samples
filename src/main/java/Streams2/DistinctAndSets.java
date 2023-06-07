package Streams2;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DistinctAndSets {

    public static void main(String[] args) throws Exception {
        distinct();
        distinctWithSet();
    }

    public static void distinct() throws Exception {
        List<Integer> numbers = List.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);
        List<Integer> integers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(integers);
    }

    public static void distinctWithSet() throws Exception {
        List<Integer> numbers = List.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);
        Set<Integer> integers = numbers.stream()
                .collect(Collectors.toSet());
        System.out.println(integers);

    }
}
