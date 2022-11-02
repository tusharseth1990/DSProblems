package array;

import java.util.*;

/*
Given an array of numbers, arrange them in a way that yields the largest value. For example,
if the given numbers are {54, 546, 548, 60}, the arrangement 6054854654 gives the largest value.
And if the given numbers are {1, 34, 3, 98, 9, 76, 45, 4}, then the arrangement 998764543431 gives the largest value.
 */
public class ArrangeBiggestNumberFromArray {

    static void printLargest(List<String> arr)
    {
//        Collections.sort(arr, new Comparator<String>() {
//            @Override
//            public int compare(String A, String B) {
//                String AB=A+B;
//                String BA=B+A;
//                return AB.compareTo(BA)>0 ? -1 : 1;
//            }
//        });
        arr.sort((A, B) -> {
             String AB=A+B;
             String BA=B+A;
             return AB.compareTo(BA)>0 ? -1 : 1;
         });
        Iterator it= arr.iterator();
        while(it.hasNext())
        {
            System.out.print(it.next());
        }
    }

    public static void main(String[] args) {
        List<String> arr=new ArrayList<>();
        arr.add("54");
        arr.add("546");
        arr.add("548");
        arr.add("60");
        printLargest(arr);
    }
}
