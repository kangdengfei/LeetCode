package LeetCode151_200;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-21 13:43
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 *
 * Example 2:
 *
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 *              Total amount you can rob = 2 + 9 + 1 = 12.
 *
 * 假设你是一位专业的盗贼计划打劫沿一条街的房子，每个房子藏着一定数额的钱，你不能同时打劫相邻的两个房子，因为会报警，求一晚上能打劫到的最多钱。
 *
 * 解法：动态规划DP。本质相当于在一列数组中取出一个或多个不相邻数，使其和最大。
 **/
public class House_Robber_198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length==0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int [] dp = new int[nums.length];//打劫到第i个房子时最大的得到的最大金额
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2;i<nums.length;i++){
            dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[dp.length-1];
    }

    public int [] sum (){
        return new int[]{1,2};
    }
}



