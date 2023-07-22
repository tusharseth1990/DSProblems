package tricky;

//https://leetcode.com/problems/palindrome-number/editorial/

/*
Given an integer x, return true if x is a palindrome, and false otherwise.

Example 1:
Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

Example 2:
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-.
Therefore, it is not a palindrome.

Logic
reverting the number itself, and then compare the number with original number,
if they are the same, then the number is a palindrome. However, if the reversed number is larger than
int.MAX, we will hit integer overflow problem, what if we only so revert half of the int number

After all, the reverse of the last half of the palindrome should be the same as the
first half of the number, if the number is a palindrome


 */

public class PalindromeNumber {

    boolean isPalindromeNumber(int num)
    {

        //when x < 0, x is not a palindrome ie -121 , 121- is not palindrome
        if(num<0 || (num%10==0 && num!=0))
        {
            return false;
        }
        int revertedNumber=0;
        while(num>revertedNumber)
        {
            revertedNumber= revertedNumber*10+num%10;
            num=num/10;
        }
        return num==revertedNumber || num==revertedNumber/10;
    }

    public static void main(String[] args) {
        int x= 1221;
        PalindromeNumber palindromeNumber= new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindromeNumber(x));
    }
}
