package Streams2;

import Streams2.Beans.Person;
import Streams2.MockData.MockData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GettingStarted {

    public static void main(String[] args) throws Exception {

        var result1 = imperativeApproach();
        System.out.println("-----------------------------------");
        System.out.println("Size : " + result1.size());
        System.out.println(result1);

        var result2 = declarativeApproachUsingStreams();
        System.out.println("-----------------------------------");
        System.out.println("Size : " + result2.size());
        System.out.println(result2);
    }

    public static List<Person> imperativeApproach() throws IOException {
        // 1. Find people aged less or equal 18
        // 2. Then change implementation to find first 10 people
        List<Person> people = MockData.getPeople();
        List<Person> result = new ArrayList<>();
        int limitAge = 18;
        int maxSizeResult = 10;

        for (int i = 0; i < people.size() && result.size() < maxSizeResult; i++) {
            if(people.get(i).getAge() <= limitAge){
                result.add(people.get(i));
            }
        }

        return result;
    }

    public static List<Person> declarativeApproachUsingStreams() throws Exception {
        List<Person> people = MockData.getPeople();
        return people.stream()
                .filter(person -> person.getAge() <= 18)
                .limit(3)
                .collect(Collectors.toList());
    }
}
