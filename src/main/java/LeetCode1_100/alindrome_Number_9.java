package LeetCode1_100;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-15 11:54
 *
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * Example 1:
 *
 * Input: 121
 * Output: true
 * Example 2:
 *
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 **/
public class alindrome_Number_9 {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        if(x == resver(x))
            return true;
        return false;
    }

    public int resver(int x){
        int res = 0;
        while(x != 0){
            res = res*10 + x%10;
            x = x/10;
        }
        return res;
    }
}



