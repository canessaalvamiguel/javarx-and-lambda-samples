package Streams2;

import Streams2.Beans.Car;
import Streams2.Beans.Person;
import Streams2.Beans.PersonDTO;
import Streams2.MockData.MockData;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TransformationsMapAndReduce {
    public static void main(String[] args) throws IOException {
        yourFirstTransformationWithMap();
        mapToDoubleAndFindAverageCarPrice();
        reduce();
    }

     static List<PersonDTO> yourFirstTransformationWithMap() throws IOException {
        List<Person> people = MockData.getPeople();
        List<PersonDTO> personDTOS = people.stream()
                .filter(x -> x.getAge() > 20)
                .map(person -> new PersonDTO(person.getId(), person.getFirstName(), person.getAge()))
                .collect(Collectors.toList());
        personDTOS.forEach(System.out::println);
        return personDTOS;
    }

    static double mapToDoubleAndFindAverageCarPrice() throws IOException {
        List<Car> cars = MockData.getCars();
        double average = cars.stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);
        System.out.println(average);
        return average;
    }

    static void reduce() {
        int[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};

        int sum = Arrays.stream(integers)
                .reduce(0, (a, b) -> a + b);
        int sub = Arrays.stream(integers)
                .reduce(0, (a, b) -> a - b);
        System.out.println(sum);
        System.out.println(sub);
    }
}
