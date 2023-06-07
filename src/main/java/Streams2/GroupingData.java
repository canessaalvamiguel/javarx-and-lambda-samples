package Streams2;

import Streams2.Beans.Car;
import Streams2.MockData.MockData;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingData {

    public static void main(String[] args) throws Exception {
        System.out.println("simpleGrouping");
        simpleGrouping();

        System.out.println("groupingAndCounting");
        groupingAndCounting();
    }

    public static void simpleGrouping() throws Exception {
        Map<String, List<Car>> map = MockData.getCars()
                .stream()
                .collect(Collectors.groupingBy(Car::getMake));

        map.forEach((make, cars) -> {
            System.out.println("Make: " + make);
            cars.forEach(System.out::println);
        });
    }

    public static void groupingAndCounting() throws Exception {
        List<String> names = List.of(
                "John",
                "John",
                "Mariam",
                "Alex",
                "Mohammado",
                "Mohammado",
                "Vincent",
                "Alex",
                "Alex"
        );

        Map<String, Long> map = names.stream()
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                );

        map.forEach((identity, count) -> {
            System.out.println(identity + " " + count);
        });
    }
}
