package testsolution;

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


    /**
     *优化二维数组为一维数组
     */
    public static int backPackV2(int [] array,int m){
        int []f = new int[m+1];
        for (int i = 0;i<f.length;i++){
            if(i>=array[0]){
                f[i] = array[0];
            }
        }
        for (int i=0;i<array.length;i++){
            for (int j=m;j>=array[i];j--){
               f[j] = Math.max(f[j],(f[j-array[i]]+array[i]));
            }
        }

        for (int i=0;i<f.length;i++){
            System.out.print(f[i]+" ");
        }
        System.out.println();
        return f[m];
    }


    public static void main(String[] args) {
        int [] a={2,3,5,7};
        int target = 15;
        System.out.println( backPack(target,a));
        System.out.println(backPackV2(a,target));

//0 0 2 3 3 5 5 7 8 9 10 10 12 12 14 15
    }
}
