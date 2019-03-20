package LeetCode201_250;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-23 14:41
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
 *              because they are adjacent houses.
 *
 * Example 2:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob
 **/
/*
房子是有环的
分两种情况打劫
动态规划
 */
public class House_Robber_II_213 {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1)
            return nums[0];
        if (nums.length==2)
            return Math.max(nums[0],nums[1]);
        return Math.max(rob(nums,1,nums.length-1),rob(nums,0,nums.length-2));//注意参数传递，防止数组下标越界
    }

    public int rob(int[] nums,int start,int end){
        int n = end - start +1;
        int [] dp = new int[n];//dp[i]表示打劫到第i个房子时最大的金额。
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start],nums[start+1]);

        for(int i = 2;i<end;i++){
            dp[i] = Math.max(dp[i-2]+nums[start+i],dp[i-1]);
        }
        return dp[n-1];
    }
}



