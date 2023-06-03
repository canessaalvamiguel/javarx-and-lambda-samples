package Streams2;

import Streams2.MockData.MockData;
import Streams2.Beans.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filtering {

    public static void main(String[] args) throws Exception {
        filter();

        dropWhile();
        takeWhile();

        findFirst();
        findAny();

        allMatch();
        anyMatch();
    }

    public static void filter() throws Exception {
        List<Car> cars = MockData.getCars();
        List<Car> carsLessThan20K = cars.stream()
                .filter(car -> car.getPrice() < 20_000.00)
                .filter(car -> car.getColor().equals("Yellow"))
                .collect(Collectors.toList());

        carsLessThan20K.forEach(System.out::println);
        System.out.println();
    }

    public static void dropWhile() throws Exception {
        System.out.println("using dropWhile");
        Stream.of(2, 4, 6, 8, 9, 10, 12).dropWhile(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
    }

    public static void takeWhile() throws Exception {
        System.out.println("using take while");
        Stream.of(2, 4, 6, 8, 9, 10, 12).takeWhile(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
    }

    public static void findFirst() throws Exception {
        System.out.println("using findFirst");
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int result = Arrays.stream(numbers)
                .filter(x -> x % 2 == 0)
                .findFirst()
                .orElse(0);
        System.out.println(result);
    }

    public static void findAny() throws Exception {
        System.out.println("using findAny");
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10};
        int result = Arrays.stream(numbers)
                .filter(x -> x % 2 == 0)
                .findAny()
                .orElse(0);
        System.out.println(result);
    }

    public static void allMatch() throws Exception {
        System.out.println("using allMatch");
        int[] even = {2, 4, 6, 8, 10};
        boolean allMatch = Arrays.stream(even)
                .allMatch(x -> x % 2 == 0);
        System.out.println(allMatch);
    }

    public static void anyMatch() throws Exception {
        System.out.println("using anyMatch");
        int[] evenAndOneOdd = {2, 4, 6, 8, 10, 11};
        boolean anyMatch = Arrays.stream(evenAndOneOdd)
                .anyMatch(x -> x % 2 == 0);
        System.out.println(anyMatch);
    }
}
