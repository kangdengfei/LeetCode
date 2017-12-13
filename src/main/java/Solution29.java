import java.util.Scanner;

/**
 * created  by KDF on 2017/12/13.
 * 给一个正整数 n, 找到若干个完全平方数(比如1, 4, 9, ... )使得他们的和等于 n。
 * 你需要让平方数的个数最少
 *  样例

 给出 n = 12, 返回 3 因为 12 = 4 + 4 + 4。
 给出 n = 13, 返回 2 因为 13 = 4 + 9。

 */


public class Solution29 {
    public static int numSquares(int n){
        int []dp = new int[n+1];
       for(int i=1;i<=n;i++)
           dp[i] =n;
        System.out.println(".."+dp[n]);
        for(int i =1;i<=n;i++)
            for(int j =1;j*j<=i;j++){
            dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        System.out.println(dp[n]);
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        while (scanner.hasNext()){
            int m = scanner.nextInt();
            numSquares(m);
        }
    }
}
