package array.twopointers;

import java.util.Objects;

public class Palindrome {
    /*
    https://leetcode.com/problems/valid-palindrome/
    A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

    Given a string s, return true if it is a palindrome, or false otherwise.

    Example 1:
    Input: s = "A man, a plan, a canal: Panama"
    Output: true
    Explanation: "amanaplanacanalpanama" is a palindrome.
     */
    public boolean isPalindromeEasy(String str) {

        if (Objects.equals(str, "") || str.isEmpty() || str.trim() == "") {
            return true;
        }
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if (str == "" || str.isEmpty() || str.trim() == "") {
            return true;
        }
        char ch[] = str.toCharArray();
        int left, right = ch.length - 1;
        char temp;
        for (left = 0; left < right; left++, right--) {
            temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;
        }
        return (str.equals(String.valueOf(ch)));
    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {

            Character start = s.charAt(i);
            Character end = s.charAt(j);

            if (!Character.isLetterOrDigit(start)) {
                i++;
                continue;
            }

            if (!Character.isLetterOrDigit(end)) {
                j--;
                continue;
            }

            if (Character.toLowerCase(start) != Character.toLowerCase(end)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
