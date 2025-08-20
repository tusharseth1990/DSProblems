package array.twopointers;
//You are given a string s, return true if the s can be a palindrome after deleting at most one character from it.
//
//A palindrome is a string that reads the same forward and backward.
public class PalindromeII {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return isPalindrome(s, l + 1, r) ||
                        isPalindrome(s, l, r - 1);
            }
            l++;
            r--;
        }

        return true;
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                System.out.println(s.charAt(l));
                System.out.println(s.charAt(r));

                return false;
            }
            l++;
            r--;
        }
        return true;
    }


    public static void main(String[] args) {
        PalindromeII p =new PalindromeII();
        System.out.println(p.validPalindrome("abbadc"));
        System.out.println(p.validPalindrome("abba"));
        System.out.println(p.validPalindrome("cabddbac"));
        System.out.println(p.validPalindrome("abcdecbda"));
    }
}
