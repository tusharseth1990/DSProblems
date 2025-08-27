package oa;

public class MinimizeConsecutiveCharacters {
//Question 2: Minimize Consecutive Characters
//
//Problem:
//Given a string of 'a' and 'b', find the minimum number of changes required so no three consecutive same characters exist.
    public static int minMoves(String s) {
        int moves = 0;
        int count = 1; // count consecutive characters

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
                if (count == 3) {
                    moves++;
                    count = 1; // reset after a change
                }
            } else {
                count = 1; // reset if chars differ
            }
        }
        return moves;
    }
}
