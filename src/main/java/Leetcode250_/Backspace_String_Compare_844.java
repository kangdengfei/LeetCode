package Leetcode250_;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-04-03
 *
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 *
 * Example 1:
 *
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Example 2:
 *
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * Example 3:
 *
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * Example 4:
 *
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * Note:
 *
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 * Follow up:
 *
 * Can you solve it in O(N) time and O(1) space?
 **/
public class Backspace_String_Compare_844 {
    public boolean backspaceCompare(String S, String T) {
        int s = S.length()-1;
        int t = T.length()-1;
        int a = 0;
        int b = 0;
        while (s>=0 && t>=0){
            if (S.charAt(s) == '#'){
                s--;
                a++;
            }
            while (a>0){
                s--;
                a--;
            }
            if (T.charAt(t) == '#'){
                t--;
                b++;
            }
            while (b>0){
                b--;
                t--;
            }
            if (S.charAt(s) != T.charAt(t)){
                return false;
            }

        }
        if (s>=0){
            int count=0;
            for (int i = 0;i<=s;i++){
                if (S.charAt(i) == '#'){
                    count++;
                }
            }
            if (count >= s/2+1){
                return true;
            }else {
                return false;
            }
        }

        if (t>=0){
            int count=0;
            for (int i = 0;i<=t;i++){
                if (T.charAt(i) == '#'){
                    count++;
                }
            }
            if (count >= t/2+1){
                return true;
            }else {
                return false;
            }
        }
        return true;
    }
}



