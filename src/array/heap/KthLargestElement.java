package array.heap;

import java.util.PriorityQueue;

public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> q = new PriorityQueue<>(k);
        for (int i:nums){
            q.offer(i);
            if (q.size()>k) q.poll();

        }return q.peek();
    }

    int findKthLargestElement(int[] arr, int k)
    {
        PriorityQueue<Integer> heap= new PriorityQueue<>((n1,n2)->n1-n2);
        for(int i:arr)
        {
            heap.add(i);
            if(heap.size()>k)
            {
                heap.poll();
            }
        }
        return heap.poll();
    }



    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        KthLargestElement kthLargest= new KthLargestElement();
        int number= kthLargest.findKthLargestElement(nums,4);
        System.out.println(number);

        System.out.println(kthLargest.findKthLargest(nums,4));
    }
}
