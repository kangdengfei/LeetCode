package LeetCode1_100;

/**
 * @program: Code
 * @author: KDF
 * @create: 2018-12-01 17:22
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 *
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Example 1:
 *
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 *
 * Example 2:
 *
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 **/
/*
DP
 */
public class Decode_Ways_91 {
    public static int numDecodings(String s) {
        int n = s.length();
        if (n==0)
            return 0;
        int []dp = new int [n+1];
        dp[0]=1;
        dp[1]=s.charAt(0) == '0' ? 0:1;
        for(int i = 2; i<=n ;i++){
            if(s.charAt(i-1) == '0')
                continue;
            else if (Integer.valueOf(s.substring(i-2,i)) <=26 && Integer.valueOf(s.substring(i-2,i)) >=10)
                dp[i]+= dp[i-1];
            else
                dp[i]+= dp[i-2];
        }
        return dp[n];
    }


    public static int numDecodings2(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int[] memo = new int[n+1];
        memo[n] = 1;
        memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') continue;
            else memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];
        } return memo[0];
    }


    public static int numDecodings3(String s) {
        if(s.length() == 0) return s.length();
        int[] dp = new int[s.length()];
        // 初始化第一种解码方式
        if (s.length() == 1){
            dp[0] = s.charAt(0) == '0' ? 0 : 1;
        }
        // 如果第一位是0，则无法解码
        if (Integer.parseInt(s.substring(1)) == 0){
            dp[1] = 0;
        }else if(Integer.parseInt(s.substring(0, 2)) <= 26 && Integer.parseInt(s.substring(0, 2)) >= 10){
            dp[1] = 2;
        }else
            dp[1] = 1;
        for(int i = 2; i <s.length(); i++){
            // 如果字符串的第i-1位和第i位能组成一个10到26的数字，说明我们可以在第i-2位的解码方法上继续解码
            if(Integer.parseInt(s.substring(i-2, i)) <= 26 && Integer.parseInt(s.substring(i-2, i)) >= 10){
                dp[i] += dp[i - 2];
            }
            // 如果字符串的第i-1位和第i位不能组成有效二位数字，在第i-1位的解码方法上继续解码
            if(Integer.parseInt(s.substring(i-1, i)) != 0){
                dp[i] += dp[i - 1];
            }
        }
        return dp[s.length()-1];
    }


    public static int numDecodings4(String s) {
        if(s.length() == 0 ) return s.length();

        int[] dp = new int[s.length()];
        // 第一位
        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        //
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i = 2; i <= s.length(); i++){
            // 如果字符串的第i-1位和第i位能组成一个10到26的数字，说明我们可以在第i-2位的解码方法上继续解码
            if(Integer.parseInt(s.substring(i-2, i)) <= 26 && Integer.parseInt(s.substring(i-2, i)) >= 10){
                dp[i] += dp[i - 2];
            }
            // 如果字符串的第i-1位和第i位不能组成有效二位数字，在第i-1位的解码方法上继续解码
            if(Integer.parseInt(s.substring(i-1, i)) != 0){
                dp[i] += dp[i - 1];
            }
        }
        return dp[s.length()];
    }

    public int[] searchRange(int[] nums, int target) {
        int [] array = {-1,1};
        return array;
    }



    public static void main(String[] args) {

        System.out.println(numDecodings3("0"));
    }
}



