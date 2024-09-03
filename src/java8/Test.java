package java8;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {

        //covert or copy one map to another

        Map<String, String> map = new HashMap<>();
        copyMapMethod(map);
    }

    private static void copyMapMethod(Map<String, String> map) {
        Map<String, String> copyMap = new HashMap<>();
       //need to check this is correct or not
        map.entrySet().stream().map(stringStringEntry -> copyMap.put(stringStringEntry.getKey(), stringStringEntry.getValue()));

        Map<String, String> newCopyMap = map
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e2,
                        HashMap::new));

    }
}
