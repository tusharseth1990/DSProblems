package java8;

import java.util.*;
import java.util.stream.Collectors;
/*
Sort the Summary
Given an array of integers, create a 2-dimensional array where
the first element is a distinct value from the array and the
second element is that value's frequency within the array. Sort
the resulting array descending by frequency. If multiple values
have the same frequency, they should be sorted ascending.

Example
arr = [3, 3, 1, 2, 1]

• There are two values, 3 and 1, each with a frequency of 2, and one
value 2 with a frequency of 1: ([3, 2], [1, 2], [2, 1]
Sort the 2-dimensional array descending by frequency: [[3,2], [1,
2], [2, 1]]
• Sort the 2-dimensional array ascending by value for values with
matching frequencies: [[1,2], [3, 2], [2, 1]]

Function Description:
Complete the function groupSort in the editor below.

groupSort has the following parameter(s):
int arr[n}: an array of integers
Returns:
int[n][2]: a 2-d array of integers sorted as described

Constraints

1 <= n <= 10^5
1 ≤ arr[i] ≤ 10^5
› Input Format Format for Custom Testing
y Sample Case 0
Sample Input
STDTN
Eunction
*/
public class GroupSort {

    public static List<List<Integer>> groupSort(List<Integer> arr) {
        // This kind of map is keeping the order of the keys by their natural order.
        // in this case natural order is integer natural order
        Map<Integer, Integer> map = new TreeMap<>();
        // Run over the input arr and add to the map only if the key isn't their
        // already.
        // else, increase the value at map[key] by one
        for (Integer currInt : arr) {
            map.put(currInt, map.getOrDefault(currInt, 0) + 1);
        }
        // The next lines is for sorting the map by VALUE
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        // Now after the map is sorted, create 2-dimesional ArrayList and insert pairs
        // of key and values into it
        return list.stream().map(val -> List.of(val.getKey(), val.getValue())).collect(Collectors.toList());

    }

//    public static List<List<Integer>> groupSortII(List<Integer> arr) {
//
//       var x = arr.stream().collect(Collectors.groupingBy(val -> val, Collectors.counting())).entrySet();
//        var z=  x.stream().sorted(Comparator.comparing(Map.Entry::getValue))
//               .sorted(Comparator.comparing(Map.Entry::getKey)).collect(Collectors.toList());
//        System.out.println(z);
//        return z;
//    }


    public static void main(String[] args) {
        var helo = groupSort(List.of(3, 3, 1, 2, 1));
        System.out.println(helo);
    }
}
