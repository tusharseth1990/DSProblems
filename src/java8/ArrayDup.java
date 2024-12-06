package java8;

import java.util.*;
import java.util.stream.Collectors;
//https://javaconceptoftheday.com/java-8-interview-sample-coding-questions/
public class ArrayDup {

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(71, 21, 34, 89, 56, 28);

        List<Integer> list2 = Arrays.asList(12, 56, 17, 21, 94, 34);
//find the common elements.
        //list1.stream().filter(list2::contains).forEach(System.out::println);
        List<Integer> list3 = Arrays.asList(12, 94, 17, 21, 12, 21, 34, 12, 17, 21, 17, 56, 34);
// filter values from the list which have count equals 1
        System.out.println(list3.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting())).entrySet()
                .stream().filter(integerLongEntry -> integerLongEntry.getValue() == 1)
                .sorted(Map.Entry.comparingByKey()).collect(Collectors.toList()));



        list3.stream().collect(Collectors.groupingBy(value -> value, Collectors.counting())).entrySet().stream().filter(integerLongEntry -> integerLongEntry.getValue() == 1)
                  .map(Map.Entry::getKey).sorted().forEach(System.out::println);

        list3.stream().collect(Collectors.groupingBy(value -> value, HashMap::new, Collectors.counting())).entrySet().stream().filter(integerLongEntry -> integerLongEntry.getValue() == 1)
                .forEach(System.out::println);
    }
}
