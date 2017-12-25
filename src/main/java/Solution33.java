import java.util.Set;


/**
 * created  by KDF on 2017/12/25.
 *

 给出一个字符串s和一个词典，判断字符串s是否可以被空格切分成一个或多个出现在字典中的单词。
 您在真实的面试中是否遇到过这个题？
 样例
 给出
 s = "lintcode"
 dict = ["lint","code"]
 返回 true 因为"lintcode"可以被空格切分成"lint code"
 *
 *
 *
 */
public class Solution33 {

    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        if((s==null ||s.length() ==0) && (dict == null || dict.size()==0))
            return true;
        return wordBreak(s,dict,0);
    }
    public boolean wordBreak(String s,Set<String> dict,int start){
        boolean dp[] = new boolean[s.length() + 1];
        dp[0] = true;//初始值
        for(int i = 0;i<s.length();i++){
            if(!dp[i])
                continue;
            for(String t:dict){
                int len = t.length();
                int end = i+ len;
                if(end > s.length())
                    continue;
                if(s.substring(i,end).equals(t)){
                    dp[end] = true;
                }
            }
        }
        return dp[s.length()];
    }

}