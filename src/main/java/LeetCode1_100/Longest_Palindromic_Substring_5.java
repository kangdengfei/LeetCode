package LeetCode1_100;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-01-30 10:50
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 *
 *
 **/

/*
遍历数组，以i，i+1为中心,向前向后遍历
 */
public class Longest_Palindromic_Substring_5 {
    public static String longestPalindrome(String s) {
        if(s == null){
            return null;
        }
        if(s.length()==0){
            return s;
        }
        char[] array = s.toCharArray();
        String result = s.substring(0,1);
        int max = 0;
        for(int i = 0;i<array.length;i++){
            int left = i-1;
            int right = i+1;
            while(left>=0 && right<array.length && array[left]== array[right]){
                if(max < right -left+1){
                    max = right -left+1;
                    result = s.substring(left,right+1);

                }
                left--;
                right++;
            }

            left = i;
            right = i+1;
            while(left>=0 && right<array.length && array[left]== array[right]){
                if(max < right -left+1){
                    max = right -left+1;
                    result = s.substring(left,right+1);

                }
                left--;
                right++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String string = "ca";
        System.out.println(longestPalindrome(string));
    }
}



