package parallelAndNormalStream;

import scala.Char;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams {
    public static void main(String[] args) {
        Integer sum = IntStream
                .range(1, 10)
                .filter(x -> x % 2 == 0)
                .map(x -> x * 2)
                .sum();
        System.out.println("\nSample 1: "+sum);

        System.out.println("\nSample 2: ");
        IntStream
                .range(1, 10)
                .filter(x -> x % 2 == 0)
                .forEach(System.out::println);

        System.out.println("\nSample 3: ");
        IntStream
                .range(1, 10)
                .sorted()
                .forEach(System.out::println);

        System.out.println("\nSample 4: ");
        Stream.of("Ava", "Aneri", "Alberto")
                .sorted()
                .findFirst()
                .ifPresentOrElse(
                        value -> System.out.println(value),
                        () -> System.out.println("not found")
                );

        System.out.println("\nSample 5: ");
        String[] names = {"Miguel", "Jose", "Luis", "Marco", "Luis"};
        Arrays.stream(names)
                .filter(x -> x.startsWith("M"))
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        System.out.println("\nSample 6: ");
        Integer[] areas = {2, 4, 6, 8, 10};
        boolean exits5 = Arrays.stream(areas)
                .map(x -> x * 2)
                .anyMatch(x -> x > 10);
        System.out.println(exits5);

        System.out.println("\nSample 7: ");
        Arrays.stream(names)
                .map(String::toLowerCase)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("\nSample 8: ");
        String[] text8 = {"Holi,como,estas"};
        long c8 = Arrays.stream(text8)
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .count();
        System.out.println(c8);

        System.out.println("\nSample 9: ");
        Arrays.stream(text8)
                .map(x -> x.split(","))
                .forEach(x -> Arrays
                        .stream(x)
                        .forEach(System.out::println)
                );

        System.out.println("\nSample 10: ");
        Map<String, String> map9 = Arrays.stream(names)
                .map(String::toUpperCase)
                .filter(x -> x.startsWith("M"))
                .collect(Collectors.toMap(
                        x -> UUID.randomUUID().toString(),
                        x -> x.toLowerCase()
                ));
        for(String key : map9.keySet()){
            System.out.println(key + " -> " + map9.get(key));
        }

        System.out.println("\nSample 11: ");
        double total = Stream.of(7.3, 1.5, 4.8)
                .reduce(0.0, (Double a, Double b) -> a + b);
        System.out.println(total);

        System.out.println("\nSample 12: ");
        //return max number of occurrences of a letter - FUNCTIONAL
        String words11 = "hola como estas mi amigo de la vida";
        Map<String, Integer> map11 = new HashMap<>();
        words11
                .chars()
                .mapToObj(i -> (char) i)
                .forEach(x -> {
                    String element = x.toString();
                    if(!element.equals(" ")){
                        int value = map11.get(element) == null ? 0 : map11.get(element);
                        map11.put( element , value + 1);
                    }
                });
        Integer max12 = 0; String sMax12 = "";
        Integer min12 = Integer.MAX_VALUE; String sMin12 = "";
        for(String key : map11.keySet()){
            if(map11.get(key) > max12){
                max12 = map11.get(key);
                sMax12 = key;
            }
            if(map11.get(key) < min12){
                min12 = map11.get(key);
                sMin12 = key;
            }
            System.out.println(key + " -> "+map11.get(key));
        }

        System.out.println("Result max occurrences: "+sMax12 + " -> " + max12);
        System.out.println("Result less occurrences: "+sMin12 + " -> " + min12);

        //swap values
        String tempLetter = "&";
        String aux1 = words11.replaceAll(sMax12, tempLetter);
        aux1 = aux1.replaceAll(sMin12, sMax12);
        aux1 = aux1.replaceAll(tempLetter, sMin12);
        System.out.println("Swapped string: "+aux1);

        System.out.println("\nSample 13: ");
        //return max number of occurrences of a letter - NO FUNCTIONAL
        Map<String, Integer> map13 = new HashMap<>();
        for(int i = 0; i < words11.length(); i++){
            String letter = Character.toString(words11.charAt(i));
            if(!letter.equals(" ")){
                Integer cantAux = map13.get(letter) == null ? 0 : map13.get(letter);
                map13.put(letter, cantAux + 1);
            }
        }
        for(String key : map13.keySet()){
            System.out.println(key + " -> "+map13.get(key));
        }

        System.out.println("\nSample 14: ");
        List<Integer> list14 = new ArrayList<>();
        list14.add(2);list14.add(4);list14.add(6);list14.add(8);
        list14.stream().forEach(System.out::println);

        System.out.println("\nSample 15: ");
        List<String> newList14 = list14.stream().map(String::valueOf).collect(Collectors.toList());
        newList14.forEach(System.out::println);

        System.out.println("\nSample 16: ");
        List<Integer> newList16 = list14.stream().filter(x -> x > 4).map(x -> x + 1).collect(Collectors.toList());
        newList16.forEach(System.out::println);

        System.out.println("\nSample 17: ");
        Integer[] number17 = {2, 4, 6, 8, 10};
        Integer min17 = Arrays.stream(number17)
                .max((e1, e2) -> e1 - e2)
                .get();
        System.out.println(min17);

        System.out.println("\nSample 18: ");
        String words18 = "hola";
        String reversed = words18.chars()
                .mapToObj(c -> (char)c)
                .reduce("", (s,c) -> c+s, (s1,s2) -> s2+s1);
        System.out.println(reversed);
        //https://stackoverflow.com/questions/24308146/why-is-a-combiner-needed-for-reduce-method-that-converts-type-in-java-8

    }
}
