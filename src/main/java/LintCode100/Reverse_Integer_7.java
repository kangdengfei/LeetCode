package LintCode100;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-01-15 15:10
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 *
 * Example 2:
 *
 * Input: -123
 * Output: -321
 *
 * Example 3:
 *
 * Input: 120
 * Output: 21
 **/
public class Reverse_Integer_7 {
    public static int reverse(int x) {
        int i = x<0? -1:1;
        x = x>0?x:-x;
        int target = 0;

        List<Integer> list = new ArrayList<Integer>();
        while(x != 0){
            target = target*10 +x%10;
            x = x/10;
        }
        return target*i;
    }


    public static int reverseV2(int x) {
        int res = 0;
        while (x != 0) {
            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) {
                return 0;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }

        return res;
    }
    public static void main(String[] args) {
        int x = -12;
//        System.out.println(reverse(x));
        System.out.println(reverseV2(x));
    }
}



