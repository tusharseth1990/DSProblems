package java8;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EvenOddListJava8 {

    public void findEvenOddList(List<Integer> list)
    {
        //sol1
        List<Integer> oddList = list.stream().filter(integer -> integer %2 != 0).collect(Collectors.toList());
        List<Integer> evenList = list.stream().filter(integer -> integer %2 == 0).collect(Collectors.toList());
        //sort & even numbers
//        System.out.println("Even sorted numbers ");
//        list.stream().filter(integer -> integer%2==0).sorted().forEach(System.out::println);

        //sol2
//  list.stream().collect(Collectors.partitioningBy(x -> x%2 == 0)).entrySet().stream().forEach(booleanListEntry -> {
//            if(booleanListEntry.getKey()){
//                System.out.println("even");
//            }
//            else{
//                System.out.println("odd");
//            }
//            booleanListEntry.getValue().forEach(System.out::println);
//        });

        System.out.println("test");
   list.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0)).forEach((key, value1) -> System.out.println("Key: "+ key + "value" + value1));
   list.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0)).get(Boolean.TRUE).forEach(System.out::println);

        list.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0)).forEach((aBoolean, integers) -> {
            if (aBoolean == Boolean.TRUE){
                System.out.println(integers);
            }
        });

    }

    public static void main(String[] args) {
        EvenOddListJava8 evenOddListJava8 = new EvenOddListJava8();
        evenOddListJava8.findEvenOddList(List.of(71, 18, 42, 21, 67, 32, 95, 14, 56, 87));
    }
}
