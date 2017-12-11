package solution1_20;

/**
 * created  by KDF on 2017/10/24.
 *
 * 在n个物品中挑选若干物品装入背包，最多能装多满？假设背包的大小为m，每个物品的大小为A[i]
 *如果有4个物品[2, 3, 5, 7]
 如果背包的大小为11，可以选择[2, 3, 5]装入背包，最多可以装满10的空间。
 如果背包的大小为12，可以选择[2, 3, 7]装入背包，最多可以装满12的空间。
 函数需要返回最多能装满的空间大小。
 */


public class Solution14 {
    public static int backPack(int m,int[] A){
        if(m==0||A.length==0||A==null)
            return 0;
        int len = A.length;
        int [][] dp = new int [len][m+1];
        for(int i =0;i<len;i++){
            dp[i][0] = 0;
        }
        for(int j=1;j<=m;j++){
            if(j>A[0])
                dp[0][j] = A[0];
        }


        for(int i =1;i<len;i++){
            for(int j= 1;j<=m;j++){
                if(j<A[i])
                    dp [i][j]= dp[i-1][j];
                else
                    dp[i][j] = Math.max(dp[i-1][j-A[i]]+A[i],dp[i-1][j]);
            }
        }
        return  dp[len-1][m];

    }

    public static void main(String[] args) {
        int [] a={2,3,5,7};
        System.out.println( backPack(12,a));

    }
}
