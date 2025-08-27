package array.hashing;

import java.util.*;
//https://leetcode.com/problems/top-k-frequent-elements/
/*
Given an integer array nums and an integer k, return the k most frequent elements.
You may return the answer in any order.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
 */


public class TopK {


//i(count)  =  1, 2, 3
//Numbers   =  3 , 2, 1

    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res.subList(0,k);

//        int[] ans = new int[k];
//        int pos = 0;
//        for (int i = bucket.length - 1; i >= 0; i--) {
//            if (bucket[i] != null) {
//                for (int j = 0; j < bucket[i].size() && pos < k; j++) {
//                    ans[pos] = bucket[i].get(j);
//                    pos++;
//                }
//            }
//        }
//        return ans;
    }

    /**
     * Time Complexity: O(nlog(k))
     * Space Complexity: O(n + k)
     */
    public int[] topKFrequentSol1(int[] nums, int k) {
        // O(1) time
        if (k == nums.length) {
            return nums;
        }

        // 1. build hash map : character and how often it appears
        // O(N) time
        Map<Integer, Integer> count = new HashMap<>();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        Queue<Integer> heap = new PriorityQueue<>(
                Comparator.comparingInt(count::get));



        // 2. keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k) heap.poll();
        }
        System.out.println("after heap");
        heap.forEach(System.out::println);

        // 3. build an output array
        // O(k log k) time
        int[] top = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;
    }

    public int[] topKFrequentSol2(int[] nums, int k) {
        // O(1) time
        if (k == nums.length) {
            return nums;
        }

        // 1. build hash map : character and how often it appears
        // O(N) time
        Map<Integer, Integer> count = new HashMap<>();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // max heap
        Queue<Integer> heap = new PriorityQueue<>(
                Comparator.reverseOrder());

        // 2. keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k) heap.poll();
        }
        System.out.println("after heap");
        heap.forEach(System.out::println);

        // 3. build an output array
        // O(k log k) time
        int[] top = new int[k];
        for(int i = 0; i < k; i++) {
            top[i] = heap.poll();
        }
        return top;
    }


    public int[] topKFrequentII(int[] nums, int k) {

        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        int[] ans = new int[k];
        int pos = 0;
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (int j = 0; j < bucket[i].size() && pos < k; j++) {
                    ans[pos] = bucket[i].get(j);
                    pos++;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] arr= {1,1,1,2,2,2,2,3,3,4,5,6};
        TopK topK= new TopK();
        int[] ans= topK.topKFrequentSol2(arr,2);
        System.out.println("output");
//        Arrays.stream(ans).forEach(value -> System.out.println(value));
        System.out.println(topK.topKFrequent(arr, 2));

    }
}
