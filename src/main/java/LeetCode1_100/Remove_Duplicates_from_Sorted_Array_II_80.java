package LeetCode1_100;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-03-11 17:49
 *
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 *
 * Given nums = [1,1,1,2,2,3],
 *
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 *
 * It doesn't matter what you leave beyond the returned length.
 *
 * Example 2:
 *
 * Given nums = [0,0,1,1,1,1,2,3,3],
 *
 * Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
 *
 * It doesn't matter what values are set beyond the returned length.
 **/
public class Remove_Duplicates_from_Sorted_Array_II_80 {

    public int removeDuplicates(int[] nums) {
        int result = 0;
        for (int i = 0;i<nums.length;i++){
            int j = i+1;
            int count = 1;
            nums[result] = nums[i];
            while (j<nums.length && nums[i] == nums[j]){
                count++;
                if (count <= 2){
                    nums[++result]= nums[j];
                }
                j++;
            }
            result++;
            i = j-1;

        }
        return result;
    }

}



