package LeetCode101_150;

import java.util.*;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-27 14:50
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 *
 *     The same word in the dictionary may be reused multiple times in the segmentation.
 *     You may assume the dictionary does not contain duplicate words.
 *
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 *
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 *
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 **/
public class Word_Break_139 {
    /*
    DP
     */
    public boolean wordBreakV2(String s, List<String> wordDict) {
        boolean [] dp = new boolean[s.length()+1]; //dp[i]表示前i个字段是否可以被组合出来
        dp[0] = true;
        for (int i = 0;i<s.length();i++){
            for (int j = 0;j<=i;j++){
                String substring = s.substring(j, i+1);
                if (wordDict.contains(substring) && dp[j]){
                    dp[i+1] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    /*
    BFS
    从字符串第一个字符开始，看哪几个位置为节点的子字符串在数组里，并把起点位置加入队里
     */
    public static boolean wordBreakBFS(String s, List<String> wordDict) {
        if (s == null || wordDict.size() == 0 || wordDict == null ){
            return true;
        }
        Queue queue = new LinkedList();
        ((LinkedList) queue).offer(-1);
        Set set = new HashSet(); // 去重避免重复计算

        while (!queue.isEmpty()){
            int index = (int) ((LinkedList) queue).pop();
            for(int i = index ;i<s.length();i++){
                if(set.contains(i)){
                    continue;
                }
                String substring = s.substring(index+1, i + 1);
                if (wordDict.contains(substring)){
                    if (i == s.length()-1){
                        return true;
                    }
                    ((LinkedList) queue).offer(i);
                    set.add(i);
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List list = new ArrayList();
        list.add("leet");
        list.add("code");
        System.out.println(wordBreakBFS(s,list));

    }
}



