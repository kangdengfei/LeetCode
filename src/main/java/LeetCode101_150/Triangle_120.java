package LeetCode101_150;

import java.util.List;

/**
 * @program: Code
 * @author: KDF
 * @create: 2018-11-07 15:00
 *
 * 动态规划，从最下层开始向上滑动
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 *
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 **/

/*
上一层元素从它相邻的两个下层元素中选择较小的那个加到它本身。
 */
public class Triangle_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();

        int []dp = new int[size];
        for (int i = 0; i<size;i++){
            dp[i] = triangle.get(size-1).get(i);
        }
        for (int i = size -1;i>0;i--){
            for (int j= 0;j<i;j++){
                dp[j] = Math.min(dp[j],dp[j+1])+triangle.get(i-1).get(j);
            }
        }
        return dp[0];
    }
}



