package LeetCode201_250;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-03-05 18:41
 *
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example:
 *
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 *
 * Note:
 *
 *     There may be more than one LIS combination, it is only necessary for you to return the length.
 *     Your algorithm should run in O(n2) complexity.
 *
 * Follow up: Could you improve it to O(n log n) time complexity?
 **/
public class Longest_Increasing_Subsequence_300 {
    public static int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int[] dp   = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for(int i = 1;i<nums.length;i++){
            dp[i] = 1;//当前元素的最小值
            for(int j = 0;j<i;j++){
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i],dp[j]+1);
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int [] array = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(array));
    }
}



