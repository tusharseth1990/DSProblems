package array.dp;

import java.util.Arrays;

public class Fibonacci {
    // Function to calculate the nth Fibonacci number using
    // recursion
//    Time Complexity: O(2n)
//    Auxiliary Space: O(n), due to recursion stack
    static int nthFibonacci(int n){
        // Base case: if n is 0 or 1, return n
        if (n <= 1) {
            return n;
        }
        // Recursive case: sum of the two preceding
        // Fibonacci numbers
        return nthFibonacci(n - 1) + nthFibonacci(n - 2);
    }

    //Top-Down Approach
    // Time Complexity: O(n), each fibonacci number is calculated only one times from 1 to n;
    //Auxiliary Space: O(n), due to memo table
    static int nthFibonacciMem(int n){
        int[] mem = new int[n+1];
        Arrays.fill(mem,-1);
        return nthFibonacciMemUtil(n,mem);
    }

    private static int nthFibonacciMemUtil(int n, int[] mem) {
        if(n<=1){
            return n;
        }
        if(mem[n] != -1){
            return mem[n];
        }

        mem[n] = nthFibonacciMemUtil(n-1,mem) + nthFibonacciMemUtil(n-2,mem);

        return mem[n];
    }

//Bottom-Up Approach
//Time Complexity: O(n), the loop runs from 2 to n, performing a constant amount of work per iteration.
//    Auxiliary Space: O(n), due to the use of an extra array to store Fibonacci numbers up to n.
    static int nthFibonacciTab(int n){
        if (n <= 1) return n;
        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;
        for (int i=2 ; i<=n ;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }


    //Space Optimized Approach
//    Time Complexity: O(n), The loop runs from 2 to n, performing constant time operations in each iteration.)
//    Auxiliary Space: O(1), Only a constant amount of extra space is used to store the current and two previous Fibonacci numbers.

    static int nthFibonacciTabSpaceOptimize(int n){
        if(n<=1) return n;
        int prev= 1, prev2 = 0;
        int curr = 0;
        for (int i = 2; i <= n ; i++) {
            curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return curr;
    }


    public static void main(String[] args){
        int n = 5;
        int result = nthFibonacciTab(n);
        System.out.println(result);
    }





}
