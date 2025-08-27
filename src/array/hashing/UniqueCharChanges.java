package array.hashing;

import java.util.HashMap;
import java.util.Map;

public class UniqueCharChanges {

    public static int minChangesToUnique(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        // Count frequencies
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int changes = 0;

        // For each character, reduce duplicates
        for (int count : freq.values()) {
            if (count > 1) {
                changes += (count - 1); // need to change duplicates
            }
        }

        return changes;
    }

    public static void main(String[] args) {
        System.out.println(minChangesToUnique("aab"));   // Output: 1
        System.out.println(minChangesToUnique("abc"));   // Output: 0
        System.out.println(minChangesToUnique("aaaa"));  // Output: 3
    }
}
