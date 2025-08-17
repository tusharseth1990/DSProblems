package array.hashing;

import java.util.HashMap;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int res = 0, maxCount = 0;

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
            if (count.get(num) > maxCount) {
                res = num;
                maxCount = count.get(num);
            }
        }
        return res;
    }


    //Boyer-Moore Voting Algorithm
//more optimized
    public int majorityElementII(int[] nums) {
        int res = 0, count = 0;

        for (int num : nums) {
            if (count == 0) {
                res = num;
            }
            count += (num == res) ? 1 : -1;
        }
        return res;
    }

}
