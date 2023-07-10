package java8;

import java.util.List;
import java.util.stream.Collectors;

public class StringFrequencyMap {


    private void mapOfString(List<String> list) {
        list.stream().collect(Collectors.groupingBy(x -> x , Collectors.counting()))
                .entrySet().forEach(e-> System.out.println(e.getKey()+ "=" + e.getValue()));
    }

    public static void main(String[] args) {
        StringFrequencyMap stringFrequencyMap= new StringFrequencyMap();
        stringFrequencyMap.mapOfString(List.of("Pen", "Eraser", "Note Book",
                "Pen", "Pencil", "Stapler", "Note Book", "Pencil"));

    }


}
