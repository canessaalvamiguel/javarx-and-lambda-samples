package Streams2;

import java.util.Comparator;
import java.util.List;
public class MinMax {

    public static void main(String[] args) {
        System.out.println("min");
        min();

        System.out.println("max");
        max();
    }

    public static void min() {
        List<Integer> numbers = List.of(1, 2, 3, 100, 23, 93, 99);
        Integer min = numbers.stream().min(Comparator.naturalOrder()).get();
        System.out.println(min);
    }

    public static void max() {
        List<Integer> numbers = List.of(1, 2, 3, 100, 23, 93, 99);
        Integer max = numbers.stream().max(Comparator.naturalOrder()).get();
        System.out.println(max);
    }
}
