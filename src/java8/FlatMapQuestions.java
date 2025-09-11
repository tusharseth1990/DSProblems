package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatMapQuestions {

    public static void main(String[] args) {
        List<String> sentences = Arrays.asList(
                "Hello World",
                "world of Java",
                "Java Streams hello"
        );

        Set<String> uniqueWords = sentences.stream()
                        .flatMap(s -> Arrays.stream(s.split(" ")))
                .map(String::toLowerCase)
                .collect(Collectors.toSet());

             Map<String, Long> map = sentences.stream()
                      .flatMap(s -> Arrays.stream(s.split(" ")))
                      .map(String::toLowerCase)
                      .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        List<String> csvLines = Arrays.asList("1,2,3", "4,5", "6,7,8");

        List<Integer> numbers = csvLines.stream()
                .flatMap(line -> Arrays.stream(line.split(","))) // split each line
                .map(Integer::parseInt)                          // convert to int
                .collect(Collectors.toList());

        System.out.println(numbers);


    }


}
