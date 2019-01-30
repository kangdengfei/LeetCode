package mysolution;

import java.util.Arrays;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-01-29 10:49
 * 283. Move Zeroes
 * Easy
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Note:
 *
 *     You must do this in-place without making a copy of the array.
 *     Minimize the total number of operations.
 *
 *     遍历依次数组，把非零数与第一个0交换
 **/
public class Move_Zeroes_283 {
    public static void moveZeroes(int[] nums) {
        if(nums == null )
            return ;
        int index = 0;
        for(int i = 0;i<nums.length;i++ ){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index++;
            }
        }
    }
    public static void main(String[] args) {
        int [] array = {0,1,0,3,12};
        moveZeroes(array);
        System.out.println(Arrays.toString(array));
    }
}



