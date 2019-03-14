package LeetCode1_100;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-03-14 16:09
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 *
 * You are given a target value to search. If found in the array return true, otherwise return false.
 *
 * Example 1:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 *
 * Example 2:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 **/
public class Search_in_Rotated_Sorted_Array_II_81 {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        while (start < end){
            int mid = start + (end - start)/2;
            if (nums[mid] == target){
                return true;
            }
            if (nums[mid] > nums[start]){

            }
        }
        return false;
    }
}



