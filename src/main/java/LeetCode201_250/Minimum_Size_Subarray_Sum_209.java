package LeetCode201_250;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-23 15:05
 *
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * Example:
 *
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 **/
public class Minimum_Size_Subarray_Sum_209 {
    /*
     暴力求解o(n2)
     */
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null)
            return 0;
        int len = Integer.MAX_VALUE;
        for (int i = 0;i<nums.length;i++){
            int sum = 0;
            for (int j = i;j<nums.length;j++){
                sum += nums[j];
                if(sum >= s){
                    len = Math.min(len,j-i+1);
                    break;
                }
            }
        }
        return len==Integer.MAX_VALUE ? 0:len;
    }

    /*
    o(n)
     */
    public int minSubArrayLenV2(int s, int[] nums) {
        if (nums == null)
            return 0;
        int i = 0;
        int j = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE ;
        while (j<nums.length){
            sum += nums[j];
            while (sum>=s && i<= j){
                len = Math.min(len,j-i+1);
                sum -=nums[i++];
            }
            j++;

        }
        return len==Integer.MAX_VALUE ? 0:len;
    }

}



