package bitwise;

public class SumTwoInteger {
    public int getSum(int a, int b) {
        while (b != 0) {
            int tmp = (a & b) << 1;
            a = (a ^ b);
            b = tmp;
        }
        return a;
    }

    //Time complexity: O(1).
    //
    //Space complexity: O(1).

}
