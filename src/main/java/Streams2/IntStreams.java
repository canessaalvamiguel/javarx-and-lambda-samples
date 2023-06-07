package Streams2;

import Streams2.Beans.Person;
import Streams2.MockData.MockData;

import java.util.List;
import java.util.stream.IntStream;

public class IntStreams {

    public static void main(String[] args) throws Exception {
        System.out.println("range");
        range();

        System.out.println("rangeIteratingLists");
        rangeIteratingLists();

        System.out.println("intStreamIterate");
        intStreamIterate();
    }

    public static void range() throws Exception {
        System.out.println("with fori");
        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
        }
        System.out.println("with int stream exclusive");
        IntStream.range(0, 10).forEach(System.out::println);

        System.out.println("with int stream inclusive");
        IntStream.rangeClosed(0, 10).forEach(System.out::println);
    }

    // Loop through people using IntStream
    public static void rangeIteratingLists() throws Exception {
        List<Person> people = MockData.getPeople();
        IntStream.range(0, people.size())
                .forEach(index -> {
                    System.out.println(people.get(index));
                });
    }

    public static void intStreamIterate()  {
        IntStream.iterate(0, value -> value + 1)
                .limit(11)
                .forEach(System.out::println);
    }
}
