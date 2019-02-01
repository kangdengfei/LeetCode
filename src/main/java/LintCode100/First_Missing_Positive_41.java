package LintCode100;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-01-31 16:12
 *
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * Example 1:
 *
 * Input: [1,2,0]
 * Output: 3
 *
 * Example 2:
 *
 * Input: [3,4,-1,1]
 * Output: 2
 *
 * Example 3:
 *
 * Input: [7,8,9,11,12]
 * Output: 1
 **/

//第一个缺失的正数 ，交换后与下标对应。
public class First_Missing_Positive_41 {
    public int firstMissingPositive(int[] nums) {
        if(nums == null){
            return 0;
        }
        for(int i = 0 ;i<nums.length;i++){
            while(nums[i]<nums.length && nums[i] > 0 && nums[nums[i]-1] != nums[i]){
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }

        int temp = 1;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] != i+1){
                temp = i+1;
                break;
            }else{
                temp = i+2;
            }
        }
        return temp;
    }
}



