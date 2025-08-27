package array.hashing;

import java.util.HashMap;
import java.util.Map;

public class PairSongsDurationDivisibleBy60 {

    public int numPairsDivisibleBy60(int[] time) {

        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < time.length; i++) {

            int key = time[i] % 60;
            int pairedKey = key == 0 ? key : 60 - key;

            count += map.getOrDefault(pairedKey, 0);

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return count;
    }

    public int numPairsDivisibleBy60Solution(int[] time){
        int[] seen = new int[60];
        int count = 0;
        for (int t :
                time) {
           count += seen[(60-(t % 60)) % 60];
           seen[t % 60]++;
        }
        return count;
    }


}
