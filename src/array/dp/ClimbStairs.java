package array.dp;
//You are climbing a staircase. It takes n steps to reach the top.
//
//        Each time you can either climb 1 or 2 steps.
//        In how many distinct ways can you climb to the top?
public class ClimbStairs {

    public int climbStairs(int n) {
        int a = 1;
        int b = 1;
        int c;

        for (int i = 0; i < n - 1; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {

    }
}
