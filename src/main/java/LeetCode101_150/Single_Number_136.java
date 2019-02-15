package LeetCode101_150;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-13 15:13
 *
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,1]
 * Output: 1
 *
 * Example 2:
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 **/
//利用异或操作。异或的性质1：交换律a ^ b = b ^ a，性质2：0 ^ a = a。
public class Single_Number_136 {
    public int singleNumber(int[] nums) {
        if(nums == null){
            return 0;
        }
        int temp = nums[0];
        for(int i = 1;i<nums.length;i++){
            temp ^= nums[i];
        }
        return temp;
    }
}



