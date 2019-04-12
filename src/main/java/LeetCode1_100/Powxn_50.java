package LeetCode1_100;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-03-12 15:24
 *
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 *
 * Example 1:
 *
 * Input: 2.00000, 10
 * Output: 1024.00000
 *
 * Example 2:
 *
 * Input: 2.10000, 3
 * Output: 9.26100
 *
 * Example 3:
 *
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 **/
public class Powxn_50 {
    /**
     * 一次遍历会超时
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n) {
        double result = 1;
        int count = 1;
        while(count <= Math.abs(n)){
            result = result * x;
            count++;
        }
        if (n<0){
            return 1/result;
        }
        return result;

    }

    public static double myPowV2(double x, int n) {
        if (n < 0 && n != Integer.MIN_VALUE){
            return 1/myPow(x,-1*n);//有问题最小值 n = -2147483648，最大值 n' = -n = 2147483648取不到,越界
        }
        if (n < 0 && n != Integer.MIN_VALUE)
            return 1/myPow(x,-1*(n+1));
        if (n == 0)
            return 0.0;
        if (n == 1)
            return x;
        if (x == 0.0)
            return 0.0;
        double res = myPow(x,n >>1);
        if (n % 2 == 0){
            return res * res;
        }else
            return res * res * x;
    }

    //递归  o(logn)
    public static double myPowV3(double x,int n){
        if (n == 0){
            return 1;
        }
        if (n<0){
            return 1/myPow(x,-n);
        }
        if (n % 2 == 1){
            return x*myPow(x,n-1);

        }
        return myPow(x*x,n/2);
    }


    //非递归
    public static double mypowV4(double x,int n){
        if (n < 0){
            n = -n;
            x = 1/x;
        }
        int res = 1;
        while (n >0){
            if ((n & 1) == 1){
                res *= x;
            }
            x *= x;
            n = n>>2;

        }
        return res;
    }
    public static void main(String[] args) {


        Double x =  2.00000;
        int n =  -2147483648;
        System.out.println(myPowV2(x,n));
    }
}



