package solution1_20;

/**
 * created  by KDF on 2017/10/25.
 * 给出n个物品的体积A[i]和其价值V[i]，将他们装入一个大小为m的背包，最多能装入的总价值有多大？
 *对于物品体积[2, 3, 5, 7]和对应的价值[1, 5, 2, 4], 假设背包大小为10的话，最大能够装入的价值为9。
 *
 *
 */


public class Solution15 {
    public static int backNum(int[] A,int[] C,int m){
        if(A.length==0||A==null||m==0)
            return 0;
        int len = A.length;
        int dp[][] = new int[len][m+1];
        for(int i =0;i<len;i++){
            dp[i][0] = 0;
        }
        for(int j=0;j<=m ;j++){
            if(j>=A[0])
            dp[0][j] = C[0];
        }
        for(int i= 1;i<len;i++){
            for(int j= 1;j<=m;j++){
                if(j<A[i])
                    dp[i][j] =dp[i-1][j];
                else
                    dp[i][j] = Math.max(dp[i-1][j-A[i]]+C[i] ,dp[i-1][j]);
            }
        }
        return dp[len-1][m];
    }


    public static void main(String[] args) {
        int[] A={2,3,5,7};
        int [] C={1,5,2,4};
        System.out.println( backNum(A,C,10));
    }

}
