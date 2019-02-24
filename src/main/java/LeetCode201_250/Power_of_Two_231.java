package LeetCode201_250;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-23 15:57
 * Given an integer, write a function to determine if it is a power of two.
 *
 * Example 1:
 *
 * Input: 1
 * Output: true
 * Explanation: 20 = 1
 *
 * Example 2:
 *
 * Input: 16
 * Output: true
 * Explanation: 24 = 16
 *
 * Example 3:
 *
 * Input: 218
 * Output: false
 **/
/*
判断一个数是2 的幂次方
 */
public class Power_of_Two_231 {
    public boolean isPowerOfTwo(int x) {
//         if(n<=0){
//             return false;
//         }
//         int i = 1;
//         if(i == n)
//             return true;
//         while( i != n && i< n){
//             i = i << 1;
//             if(i == n)
//                 return true;
//         }
//         return false;

        return x > 0 && ((x & (x - 1)) == 0);


    }
}



