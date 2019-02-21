package LeetCode201_250;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-21 16:38
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 *
 * Example 1:
 *
 * Input: [5,7]
 * Output: 4
 *
 * Example 2:
 *
 * Input: [0,1]
 * Output: 0
 **/
public class Bitwise_AND_of_Numbers_Range_201 {
    public int rangeBitwiseAnd(int m, int n) {
        int offset = 0;
        while (m != n){
            m = m >> 1;
            n = n>> 1;
            offset++;
        }
        return m << offset;
    }
}



