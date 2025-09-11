package java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Employee {
    String name;
    int salary;
    Employee(String n, int s) { name=n; salary=s; }
}

public class PartitionByQuestions {


//partitioningBy is just a special groupingBy optimized for boolean conditions.
//
//Default collector → Map<Boolean, List<T>>.
//
//With downstream → Map<Boolean, X> (where X could be count, set, max, etc.).
    public static void main(String[] args) {
        List<Integer> numbers = IntStream.rangeClosed(1, 20).boxed().toList();

        Map<Boolean, List<Integer>> primes = numbers.stream()
                .collect(Collectors.partitioningBy(PartitionByQuestions::isPrime));

        System.out.println("Primes: " + primes.get(true));
        System.out.println("Non-primes: " + primes.get(false));

        List<String> words = Arrays.asList("hi", "java", "code", "go", "lambda");

        Map<Boolean, Set<String>> partitioned = words.stream()
                .collect(Collectors.partitioningBy(
                        w -> w.length() > 3,
                        Collectors.toSet()
                ));

        System.out.println("Length > 3: " + partitioned.get(true));
        System.out.println("Length <= 3: " + partitioned.get(false));


        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 60000),
                new Employee("Bob", 45000),
                new Employee("Charlie", 70000),
                new Employee("David", 40000)
        );

        Map<Boolean, Long> partitionedEmp = employees.stream()
                .collect(Collectors.partitioningBy(
                        e -> e.salary > 50000,
                        Collectors.counting()
                ));



        System.out.println("Salary > 50k: " + partitionedEmp.get(true));
        System.out.println("Salary <= 50k: " + partitionedEmp.get(false));

//How to get highest-paid employee in each partition?

        Map<Boolean, Optional<Employee>> maxSalary = employees.stream()
                .collect(Collectors.partitioningBy(
                        e -> e.salary > 50000,
                        Collectors.maxBy(Comparator.comparingInt(emp -> emp.salary))
                ));


   }

    static boolean isPrime(int n) {
        if (n <= 1) return false;
        return IntStream.rangeClosed(2, (int)Math.sqrt(n))
                .allMatch(x -> n % x != 0);
        }


}
