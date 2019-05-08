package LeetCode1_100;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-05-07
 *
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 * Example 1:
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 *
 * Example 2:
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 **/
public class Interleaving_String_97 {
    public static boolean isInterleave(String s1, String s2, String s3) {
        if("".equals(s1) && "".equals(s2) && "".equals(s3)){
            return true;
        }
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        if (l1 + l2 != l3)
            return false;
        return isInterleave(s1,0,s2,0,s3,0);

    }
    public static boolean isInterleave(String s1,int i1, String s2,int i2, String s3,int i3) {
        if (i3 == s3.length()){
            return true;
        }
        if (i1 <s1.length() && i2 <s2.length() && i3 <s3.length() &&
                s1.charAt(i1) != s3.charAt(i3) && s2.charAt(i2) != s3.charAt(i3)){
            return false;
        }
        boolean f1 = false;
        boolean f2 = false;
        if (i1+ i2 == i3 && i1< s1.length() && i3 <s3.length() && s1.charAt(i1) == s3.charAt(i3)){
            f1= isInterleave(s1,i1+1,s2,i2,s3,i3+1);
        }
        if (!f1 && i1+i2 == i3 && i2 <s2.length() && i3<s3.length() && s2.charAt(i2) == s3.charAt(i3)){
            f2 = isInterleave(s1,i1,s2,i2+1,s3,i3+1);
        }
        return (f1 || f2);
    }

        public static void main(String[] args) {
//            "aabcc"
//            "dbbca"
//            "aadbbbaccc"
//            "aadbbcbcac"
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(isInterleave(s1,s2,s3));
    }



    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            if(s1.length() + s2.length() != s3.length()){
                return false;
            }
            if("".equals(s1) && "".equals(s2) && "".equals(s3)){
                return true;
            }
            return isInterleave(s1, 0, s2, 0, s3, 0);
        }
        private boolean isInterleave(String s1, int up, String s2, int down, String s3, int combine) {

            if(up == s1.length() - 1 && combine == s3.length() - 1){
                return s1.charAt(up) == s3.charAt(combine);
            }

            if(down == s2.length() - 1 && combine == s3.length() - 1){
                return s2.charAt(down) == s3.charAt(combine);
            }

            if(up < s1.length()
                    && combine < s3.length()
                    && s1.charAt(up) == s3.charAt(combine)
                    && isInterleave(s1, up + 1, s2, down, s3, combine + 1)){
                return true;
            }

            if(down < s2.length()
                    && combine < s3.length()
                    && s2.charAt(down) == s3.charAt(combine)
                    && isInterleave(s1, up, s2, down + 1, s3, combine + 1)){
                return true;
            }

            return false;
        }
    }
}



