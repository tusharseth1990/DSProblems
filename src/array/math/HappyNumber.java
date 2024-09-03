package array.math;

import java.util.HashSet;
import java.util.Set;

/*

Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

Example 1:

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1


 //algo : keep squaring & if a number visited twice put in hashset & that number is 1
 then return true else false
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        if (n == 1 || n == -1) {
            return true;
        }

        Set<Integer> visit = new HashSet<Integer>();

        // compute square until getting duplicate value
        while (!visit.contains(n)) {
            visit.add(n);
            // using helper function to compute the sum of squares
            n = sumOfSquare(n);

            if (n == 1) return true;
        }

        return false;
    }

    public int sumOfSquare(int n) {
        int output = 0;

        while (n != 0) {
            int digit = n % 10;
            digit = digit * digit;
            output += digit;
            n = n / 10;
        }

        return output;
    }

}
