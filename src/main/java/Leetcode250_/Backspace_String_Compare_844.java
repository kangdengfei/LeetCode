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
    public static boolean backspaceCompare(String S, String T) {
        int s = S.length()-1;
        int t = T.length()-1;
        int a = 0;
        int b = 0;
        while (s>=0 || t>=0){

            while (s>= 0 && S.charAt(s) == '#'){
                s--;
                a++;
            }
            while (a>0 ){
                if (s>= 0 && S.charAt(s) == '#'){
                    s--;
                    a--;
                }else {
                    a++;
                    s--;
                }

            }
            if (t >= 0 && T.charAt(t) == '#'){
                t--;
                b++;
            }
            while (b>0 ){
                if (t >= 0 && T.charAt(t) != '#'){
                    b--;
                    t--;
                }else if (t >= 0 && T.charAt(t) == '#'){
                    b++;
                    t--;
                }

            }

            if (s < 0 || t < 0){
                if (s>0){
                    s--;
                }
                if (t>0){
                    t--;
                }
                break;
            }

            if (s>=0 && t>= 0 && S.charAt(s) != T.charAt(t)){
                return false;
            }else {
                s--;
                t--;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String S1 = "rh";
        String T1 = "#rh";

        String S2 = "a#c";
        String T2 =  "b";

        String S =  "bxj##tw";
        String T ="bxo#j##tw";

        System.out.println(backspaceCompare(S,T));

    }
}



