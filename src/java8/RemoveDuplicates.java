package java8;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicates {

    private List<String> removeDuplicates(List<String> list) {
        return list.stream().distinct().collect(Collectors.toList());

    }

    public static void main(String[] args) {
        RemoveDuplicates r= new RemoveDuplicates();
        System.out.println((r.removeDuplicates(List.of("Java", "Python", "C#", "Java", "Kotlin", "Python"))));

    }


}
