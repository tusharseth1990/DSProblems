package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ArrayDup {

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(71, 21, 34, 89, 56, 28);

        List<Integer> list2 = Arrays.asList(12, 56, 17, 21, 94, 34);

        list1.stream().filter(list2::contains).forEach(System.out::println);

        List<Integer> list3 = Arrays.asList(12, 56, 17, 21, 12, 21, 34, 12, 17, 21, 17, 94, 34);

        System.out.println(list3.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting())).entrySet()
                .stream().filter(integerLongEntry -> integerLongEntry.getValue() == 1)
                .sorted(Map.Entry.comparingByKey()).collect(Collectors.toList()));

    }
}
