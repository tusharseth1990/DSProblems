package java8;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DecimalsListInReverseOrder {

    private void printDecimalListInReverse(List<Double> list) {
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    public static void main(String[] args) {
        DecimalsListInReverseOrder decimalsListInReverseOrder= new DecimalsListInReverseOrder();
        decimalsListInReverseOrder.printDecimalListInReverse(List.of(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12));
    }


}
