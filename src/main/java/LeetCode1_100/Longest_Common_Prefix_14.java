package LeetCode1_100;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-01-30 15:44
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 **/
public class Longest_Common_Prefix_14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null){
            return null;
        }
        if( strs.length == 0)
            return "";
        String temp = strs[0];
        for(int i = 1;i<strs.length;i++){
            StringBuilder str = new StringBuilder();
            for(int j = 0;j<strs[i].length();j++){
                if(j< temp.length() && temp.charAt(j) == strs[i].charAt(j)){
                    str.append(temp.charAt(j) );
                }else
                    break;
            }
            temp = str.toString();
        }
        return temp;
    }
}



