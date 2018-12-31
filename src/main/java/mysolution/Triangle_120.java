package mysolution;

import java.util.List;

/**
 * @program: Code
 * @author: KDF
 * @create: 2018-11-07 15:00
 *
 * 动态规划，从最下层开始向上滑动
 **/
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



