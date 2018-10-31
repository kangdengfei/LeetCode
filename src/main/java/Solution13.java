import java.util.ArrayList;

/**
 * created  by KDF on 2017/10/24.
 *
 * 给出两个字符串，找到最长公共子串，并返回其长度。

 给出A=“ABCD”，B=“CBCE”，返回 2

 思路：

 定义二维数组dp[i][j]记录最大公共子串的长度,

 若要返回字符串可以用s1.substring(i-dp[i][j]+1, i+1)
 当s[i]==s[j]时，dp[i][j]=dp[i-1][j-1]+1;
 当s[i]!=s[j]时，dp[i][j]=0;

 有点类似于数学归纳法

 方案：

 首先考虑空或者长度为0的情况，直接返回""；
 然后进入双重循环：
 1.利用charAt(int index)方法来比较两个字符串相等的时机
 2.考虑边界情况，两个字符串中有一个是起始为0就相等，则dp[i][j]=1
 3.除了边界情况，其他最大字符串长度为dp[i][j]=dp[i-1][j-1]+1;
 4.不断的替换掉最大的长度并返回公共子串
 最后循环结束后，返回最大的公共子串

 */


public class Solution13 {
    public static String maxCommonString(String s1, String s2){
        int n= s1.length();
        int m = s2.length();
        int [][] dp  = new int[n][m];
        String re = "";
        if(s1 == null || s1.length()==0 ||s1 == null || s1.length()==0){
           return null;
        }
        int max = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    if(i==0||j==0){
                        dp[i][j]=1;
                    }else{
                        dp[i][j] = dp[i-1][j-1] +1;
                    }
                    max = Math.max(max,dp[i][j]);
                    re = s1.substring(i-dp[i][j]+1,i+1) ;

                }
            }
        }
       return re;
    }

    public static void main(String[] args) {
        String s1 = "qwe";
        String s2 = "qwe";
        String s3 ="lwer";
        String s4 = new String("qwe");
        String s5 = new String("qwe");
       boolean b=(s1 == s4);
       int max ;
       String re = null;
       re = maxCommonString(s1,s3);
        System.out.println(re);
        ArrayList arrayList = new ArrayList();

    }

}
