package LeetCode1_100;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-01-31 11:31
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero.
 *
 * Example 1:
 *
 * Input: dividend = 10, divisor = 3
 * Output: 3
 *
 * Example 2:
 *
 * Input: dividend = 7, divisor = -3
 * Output: -2
 **/
public class Divide_Two_Integers_29 {
    public static int divide(int dividend, int divisor) {
        int temp = dividend*divisor > 0 ? 1:-1;
        int count = 0;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while(dividend >= divisor){
            dividend -= divisor;
            count++;
        }
        return temp*count;
    }

    public static void main(String[] args) {
        int dividend = 7;
        int divisor = -3;
        System.out.println(divide(dividend,divisor));
    }
}



