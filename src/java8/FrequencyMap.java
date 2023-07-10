package java8;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FrequencyMap {

    private void characterCountMap(String str) {
        //frequency map with maintaining order
        Stream.of(str.toLowerCase().replaceAll("\\s", "").split(""))
                .collect(Collectors.groupingBy(val -> val, LinkedHashMap::new, Collectors.counting()))
                .entrySet().forEach(ch -> System.out.println(ch.getKey() + "=" + ch.getValue()));
    }

    private static void characterCountMapWithOrder(String str) {
        //frequency map with lexi order
        Stream.of(str.toLowerCase().replaceAll("\\s", "").split(""))
                .collect(Collectors.groupingBy(val -> val, Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach(ch -> System.out.println(ch.getKey() + "=" + ch.getValue()));
    }


    private static void characterCountMapWithMostFrequencyOrder(String str) {

        Stream.of(str.toLowerCase().replaceAll("\\s", "").split(""))
                .collect(Collectors.groupingBy(val -> val, Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByValue((o1, o2) -> o2.compareTo(o1)))
                .forEach(ch -> System.out.println(ch.getKey() + "=" + ch.getValue()));
    }


    public static void main(String[] args) {
        FrequencyMap frequencyMap = new FrequencyMap();
        //frequencyMap.characterCountMap("Java Concept Of The Day");
        //characterCountMapWithOrder("Java Concept Of The Day");
        characterCountMapWithMostFrequencyOrder("Java Concept Of The Day");
    }




}
