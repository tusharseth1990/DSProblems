package java8;

import java.util.*;
import java.util.stream.Collectors;

public class PopularQuestion {

    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,10,20,30,15);

        list.stream().filter(integer -> integer %2 == 0).forEach(integer ->
        {
            integer = integer + 1;
            System.out.println(integer);
        });
        List<Integer> list1= list.stream().filter(integer -> integer %2 == 0).map(integer -> integer*2).collect(Collectors.toList());
        System.out.println(list1);

              Optional<Integer> sum= list.stream().reduce((a, b)-> (a+b));
        if(sum.isPresent()){
            System.out.println(sum.get());
        }
//        System.out.println("Sum is "+sum.get());
        var x = list.stream().mapToInt(e-> e).sum();
        list.stream().reduce(0,Integer::sum);
        double avg=list.stream().mapToInt(e->e).average().getAsDouble();
       System.out.println("average is "+ avg);
       System.out.println("Distinct elements are");
        list.stream().mapToInt(e-> e).distinct().forEach(System.out::println);
        System.out.println("Square elements are");
        list.stream().mapToInt(value -> value*value).forEach(System.out::println);
        //Filter more than 100 & average;
        double average= list.stream().mapToInt(value -> value*value).filter(value -> value>100).average().getAsDouble();
        System.out.println("average for the sum of squares greater than 100"+ average);
        System.out.println("all even numbers in array[11,2,3,3,45,67,9,90,87,2]");
        List<Integer> ls= Arrays.asList(11,2,3,3,45,67,9,90,87,2,11,67,9);
        ls.stream().filter(value -> value%2==0).forEach(System.out::println);
        System.out.println("all odd numbers in array[11,2,3,3,45,67,9,90,87,2]");
        ls.stream().filter(value -> value%2==1).forEach(System.out::println);
        List<Integer> evenList=ls.stream().filter(value->value%2==0).collect(Collectors.toList());
        System.out.println("all even numbers in array[11,2,3,3,45,67,9,90,87,2] are "+ evenList);
        List<Integer> numbers= Arrays.asList(22,2,32,23,245,627,29,920,827,2222);
        List<Integer> prefixList=numbers.stream().map(value-> String.valueOf(value)).filter(value-> value.startsWith("2")).map(value-> Integer.parseInt(value)).collect(Collectors.toList());
        System.out.println("all numbers with prefix 2 in array[22,2,32,23,245,627,29,920,827,2222] are "+ prefixList);
        Set<Integer> dupSet=ls.stream().filter(value-> Collections.frequency(ls,value)>1).collect(Collectors.toSet());
        System.out.println(dupSet);
    }
}
