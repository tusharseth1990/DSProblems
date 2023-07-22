package java8;

import java.io.BufferedReader;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Multiples {

    public static void main(String[] args) {
        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);

        listOfIntegers.stream().filter(i -> i % 5 == 0).forEach(System.out::println);
        List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");

        System.out.println("unique Strings");
        List<String> ls= listOfStrings.stream().distinct().collect(Collectors.toList());
        System.out.println(ls);
        String inputString = "Java Concept Of The Day";
        System.out.println("char map");
        Map<Character,Long> hm = inputString.toLowerCase().chars().mapToObj(c-> (char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(hm);
        Stream.of(inputString.toLowerCase().replaceAll("\\s",""))
                .collect(Collectors.groupingBy(val-> val, LinkedHashMap::new,Collectors.counting()))
                .entrySet().forEach(ch-> System.out.println(ch.getKey() + " : "+ ch.getValue()));
        List<Integer> listOfInts = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);

        System.out.println("Maximum element");
        System.out.println(listOfInts.stream().max(Comparator.naturalOrder()).get());
        System.out.println("Minimum element");
        System.out.println(listOfInts.stream().min(Comparator.naturalOrder()).get());
        int[] a = new int[] {4, 2, 7, 1};

        int[] b = new int[] {8, 3, 9, 5};
        System.out.println("Merge two unsorted arrays to sorted array");
        int[] c= IntStream.concat(Arrays.stream(a),Arrays.stream(b)).sorted().toArray();
        System.out.println(Arrays.toString(c));
        System.out.println("Merge two unsorted arrays to sorted array");
        int[] d= IntStream.concat(Arrays.stream(a),Arrays.stream(b)).sorted().distinct().toArray();
        System.out.println(Arrays.toString(d));
        List<Integer> list = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        System.out.println("Minimum 3 numbers");
        list.stream().sorted().limit(3).forEach(System.out::println);
        System.out.println("maximum 3 numbers");
        list.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);
        String s1 = "RaceCar";
        String s2 = "CarRace";

        s1= Stream.of(s1.split("")).map(String::toLowerCase ).sorted().collect(Collectors.joining());
        s2 = Stream.of(s2.split("")).map(String::toLowerCase ).sorted().collect(Collectors.joining());
        if (s1.equals(s2))
        {
            System.out.println("Two strings are anagrams");
        }
        else
        {
            System.out.println("Two strings are not anagrams");
        }

        int i = 15623;
        System.out.println("sumOfDigits");
        int k = Stream.of(String.valueOf(i).split("")).collect(Collectors.summingInt(Integer::parseInt));
        System.out.println(k);
        System.out.println("Second Largest");

        listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        System.out.println(listOfIntegers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get());

        listOfStrings = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
        listOfStrings.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
        int[] arr = new int[] {45, 12, 56, 15, 24, 75, 31, 89};

        int sum = Arrays.stream(arr).sum();

        System.out.println("Sum = "+sum);

        double average = Arrays.stream(arr).average().getAsDouble();

        System.out.println("Average = "+average);

        System.out.println("common elements between two arrays");
        List<Integer> list1 = Arrays.asList(71, 21, 34, 89, 56, 28);

        List<Integer> list2 = Arrays.asList(12, 56, 17, 21, 94, 34);

        list1.stream().filter(list2::contains).forEach(System.out::println);
        System.out.println("Reverse each word of the string");

        String str= "Java Concept Of The Day";

        String reversedString= Arrays.stream(str.split(" "))
                .map(word-> new StringBuffer(word).reverse()).collect(Collectors.joining(" "));

        System.out.println(reversedString);

        System.out.println("Sum of first 10 natural numbers");

         sum= IntStream.range(1, 11).sum();
        System.out.println(sum);
        

    }
}
