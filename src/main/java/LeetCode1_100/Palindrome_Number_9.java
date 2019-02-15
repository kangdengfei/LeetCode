package LeetCode1_100;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-15 11:58
 **/
public class Palindrome_Number_9 {
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



