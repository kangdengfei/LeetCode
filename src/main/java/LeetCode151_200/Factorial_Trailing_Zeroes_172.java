package LeetCode151_200;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-20 23:41
 *
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Example 1:
 *
 * Input: 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 *
 * Example 2:
 *
 * Input: 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 **/
public class Factorial_Trailing_Zeroes_172 {
    public static int trailingZeroes(int n) {
        if(n <= 0)
            return 0;
        int count = 0;
        while(n>0){
            n = n / 5;
            count += n;
        }
        return count;
    }

    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZerosV2(long n) {
        // write your code here
        return n / 5 == 0 ? 0 : n /5 + trailingZerosV2(n / 5);
    }
    public static void main(String[] args) {
        System.out.println(trailingZeroes(25));
    }
}



