package mysolution;

/**
 * @program: Code
 * @author: KDF
 * @create: 2018-12-10 18:11
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 **/
public class Minimum_Path_Sum_64 {
    public static int minPathSum(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int [][]dp = new int[M][N];
        dp[0][0]=grid[0][0];
        for(int i = 1;i<N;i++){
            dp[0][i]=grid[0][i]+dp[0][i-1];
        }
        for(int j = 1;j<M;j++){
            dp[j][0]=grid[j][0]+dp[j-1][0];
        }

        for(int i=1;i<M;i++){
            for(int j= 1;j<N;j++){
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[M-1][N-1];
    }

    public static void main(String[] args) {
        int [][] dp = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(dp));
    }
}



