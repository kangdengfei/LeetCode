package Leetcode350_;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-04-30
 **/
public class Find_the_Difference_389 {
    public char findTheDifference(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] s2 = s.toCharArray();
        int i = 0;
        int j = 0;
        while(i<s1.length && j<s2.length){
            if(s1[i++] == s2[j++]){

            }else
                return s2[j];
        }
        return s2[s2.length-1];
    }
}



