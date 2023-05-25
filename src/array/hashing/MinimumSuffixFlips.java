package array.hashing;

//Example:
//00000 -> 10101
//
//00000
//11111
//10000
//10111
//10100
//Result: 10101
public class MinimumSuffixFlips {
    public int minFlips(String target) {
        int flips = 0;
        char prev = target.charAt(0);
        if (prev == '1') flips++;

        for (int i = 1; i < target.length(); i++) {
            char c = target.charAt(i);
            if (c != prev) {
                flips++;
                prev = c;
            }
        }
        return flips;
    }
}


