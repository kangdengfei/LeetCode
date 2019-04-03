package LeetCode151_200;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-19 09:40
 *
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 *
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 **/
/*
 简化点 1:元素都为整数 2:未考虑整数越界
 */
/*
还可以通过暴力方法，两次for循环求出其中的乘积最大值
 */
public class Maximum_Product_Subarray_152 {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        int len = nums.length;
        int [] mindp = new int[len];//mindp[i] 表示前i 个元素中乘积的最小值
        int [] maxdp = new int[len];//maxdp[i] 表示前i 个元素中乘积的最大值
        int max = nums[0];
        mindp[0] = nums[0];
        maxdp[0] = nums[0];

        for(int i = 1;i<nums.length;i++) {
            mindp[i] = Math.min(nums[i],Math.min(maxdp[i-1]*nums[i],mindp[i-1]*nums[i]));//3者的最小值
            maxdp[i] = Math.max(nums[i],Math.max(maxdp[i-1]*nums[i],mindp[i-1]*nums[i]));//3者的最大值
            max = Math.max(max,maxdp[i]);
        }

        return max;
    }

}



