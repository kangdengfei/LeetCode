package LeetCode1_100;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-15 14:15
 **/
public class Jump_Game_II_45 {
    public int jump(int[] nums) {
        // if (nums.length = =0 || nums == null)
        //     return 0;
        int len = nums.length;
        int []dp = new int [len];
        dp [0] = 0;
        int max = nums[0];
        int cur = 0;
        for (int i = 1;i<len ;i++){
            if(max<i)
                return -1;
            if(cur <i){
                dp[i] = dp[i-1]+1;
                cur = max;
            }else
                dp[i] = dp[i-1];

            max = Math.max(max,nums[i]+i);
        }
        return dp[len-1];
    }
}



