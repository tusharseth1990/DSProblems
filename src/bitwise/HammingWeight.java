package bitwise;
//Write a function that takes an unsigned integer and returns the number of '1' bits
// it has (also known as the Hamming weight).
//
// Note:
//
//Note that in some languages, such as Java, there is no unsigned integer type.
// In this case, the input will be given as a signed integer type. It should not affect your
// implementation, as the integer's internal binary representation is the same, whether it is
// signed or unsigned.
//In Java, the compiler represents the signed integers using 2's complement notation.
// Therefore, in Example 3, the input represents the signed integer. -3.
public class HammingWeight {
    //smart way
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }


    // logic: number & 1
    //then shift right
    // you need to treat n as an unsigned value
    //Time complexity:
    //O(1)
    //Space complexity:
    //O(1)
    // Iterating over a 32 bit integer and then doing an & operation with 1
    // always returns the last set bit where we can count that
    // & then shifting the number by 1 digit
    //  1011 & 0001 then 101 & 001 and ....
    public int hammingWeightMethod2(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }
}
