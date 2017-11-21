import java.util.Scanner;

/**
 * created  by KDF on 2017/10/10.
 * 给你六种面额1、5、10、20、50、100元的纸币，
 * 假设每种币值的数量都足够多，编写程序求组成N员（N为0-10000的非负整数）的不同组合的个数。
 */


public class Solution6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] moneys = {1,5,10,20,50,100};
            long[] dp = new long[n+1]; //dp[i]代表拼凑i元的方法数
            dp[0] = 1;
            for(int i=0;i<moneys.length;i++){
                for(int j=1;j<=n;j++){
                    if(j >= moneys[i]){
                        dp[j]+= dp[j-moneys[i]];
                    }
                }
            }
            System.out.println(dp[n]);

        }
    }


}
